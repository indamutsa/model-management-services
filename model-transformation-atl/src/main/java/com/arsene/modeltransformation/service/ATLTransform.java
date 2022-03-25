package com.arsene.modeltransformation.service;

import com.arsene.modeltransformation.DTO.ATLTransformationInfo;
import com.arsene.modeltransformation.DTO.AggregateMetric;
import com.arsene.modeltransformation.DTO.Metric;
import com.arsene.modeltransformation.DTO.ModelInfo;
import com.arsene.modeltransformation.DTO.SimpleMetric;
import com.arsene.modeltransformation.utililties.ServiceUtil;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.common.OCL.OclModel;
import org.eclipse.m2m.atl.core.*;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceImpl;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ATLTransform {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private FilePersistance filePersistance;

    // IN THE END THE METHOD SHOULD TAKE LIST OF IN MMs, OUT MMs, IN Ms.
    public org.springframework.core.io.Resource execute(MultipartFile sourceModel, MultipartFile sourceMetaModel,
                                                        MultipartFile targetMetaModel, MultipartFile transformation)
            throws ATLExecutionException, ATLCoreException, IOException {
        IInjector injector = new EMFInjector();
        ModelFactory modelFactory = new EMFModelFactory();
        ILauncher transformationLauncher = new EMFVMLauncher();
        Map<String, Object> launcherOptions = getOptions();
        transformationLauncher.initialize(launcherOptions);

        List<EObject> info = getResources(transformation);
        String inMMName = "";
        String inMName = "";
        Module k = (Module) info.get(0);

        // HERE ITERATE
        for (OclModel i : k.getInModels()) {
            inMName = i.getName();
            inMMName = i.getMetamodel().getName();
            break;
        }
        String outMMName = "";
        String outMName = "";
        for (OclModel i : k.getOutModels()) {
            outMName = i.getName();
            outMMName = i.getMetamodel().getName();
            break;
        }
        IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
        injector.inject(inputMetamodel, sourceMetaModel.getInputStream(), null);
        IModel inputModel = modelFactory.newModel(inputMetamodel);
        injector.inject(inputModel, sourceModel.getInputStream(), null);
        transformationLauncher.addInModel(inputModel, inMName, inMMName);

        IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
        injector.inject(outputMetamodel, targetMetaModel.getInputStream(), null);
        IModel outputModel = modelFactory.newModel(outputMetamodel);
        transformationLauncher.addOutModel(outputModel, outMName, outMMName);

        String asmFileString = compileAsmAndGetPath(transformation);
        FileInputStream asmFile = new FileInputStream(asmFileString);
        IExtractor extractor = new EMFExtractor();
        @SuppressWarnings("unused")
        Object result = transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), launcherOptions,
                asmFile);
        asmFile.close();

        Path targetModelPath = serviceUtil.handleFileName("temp.xmi");
        extractor.extract(outputModel, targetModelPath.toString());
        org.springframework.core.io.Resource targetModel = filePersistance.loadFile(targetModelPath);

        return targetModel;
    }

    public EList<EObject> getResources(MultipartFile atlTransformation) throws IOException {
        AtlResourceImpl ri = new AtlResourceImpl();
        ResourceSet rs = new ResourceSetImpl();
        rs.getResources().add(ri);
        ri.load(atlTransformation.getInputStream(), null);
        return ri.getContents();
    }
    public ATLTransformationInfo getAtlInfo(MultipartFile atlTransformation) throws IOException {
        ATLTransformationInfo resutl = new ATLTransformationInfo();
    	IInjector injector = new EMFInjector();
        ModelFactory modelFactory = new EMFModelFactory();
        ILauncher transformationLauncher = new EMFVMLauncher();
        Map<String, Object> launcherOptions = getOptions();
        transformationLauncher.initialize(launcherOptions);
        AtlResourceImpl ri = new AtlResourceImpl();
        ResourceSet rs = new ResourceSetImpl();
        rs.getResources().add(ri);
        ri.load(atlTransformation.getInputStream(), null);
        List<EObject> info = ri.getContents();
        
        Module k = (Module) info.get(0);

        // HERE ITERATE
        
        for (OclModel i : k.getInModels()) {
        	ModelInfo in = new ModelInfo(i.getName(),i.getMetamodel().getName());
            resutl.getInputModels().add(in);
        }
        for (OclModel i : k.getOutModels()) {
        	ModelInfo out = new ModelInfo(i.getName(),i.getMetamodel().getName());
        	resutl.getOutputModels().add(out);
        }
        return resutl;
    }
    

    public String storeModel(MultipartFile atlTransformation) throws IOException {
        String outputFilePath = atlTransformation.getName() + ".xmi";
        EList<EObject> ri = getResources(atlTransformation);
        ResourceSet rs = new ResourceSetImpl();
        Resource xmiRes = rs.createResource(URI.createURI(outputFilePath));
        xmiRes.getContents().addAll(ri);
        xmiRes.save(null);
        return outputFilePath;

    }

    public String compileAsmAndGetPath(MultipartFile atlPath) throws IOException {

        String asmModulePath = "src/main/resources/artifacts/scripts/"
                + atlPath.getOriginalFilename().replace(".atl", ".asm");
        Atl2006Compiler compiler = new Atl2006Compiler();
        File fle = new File("src/main/resources/artifacts/scripts/" + atlPath.getOriginalFilename());
        atlPath.transferTo(fle);
        compiler.compile(new FileInputStream(fle), asmModulePath);
        return asmModulePath;
    }

    private Map<String, Object> getOptions() {

        Map<String, Object> options;
        options = new HashMap<String, Object>();
        options.put("supportUML2Stereotypes", "false");
        options.put("printExecutionTime", "true");
        options.put("OPTION_CONTENT_TYPE", "false");
        options.put("allowInterModelReferences", "false");
        options.put("step", "false");
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

        return options;
    }

    public List<Metric> calculateMetrics(MultipartFile atlTransformation) throws ATLCoreException, IOException {
        ILauncher transformationLauncher = new EMFVMLauncher();
        ModelFactory modelFactory = new EMFModelFactory();
        IInjector injector = new EMFInjector();
        IExtractor extractor = new EMFExtractor();
        /*
         * Load metamodels
         */

        IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
        injector.inject(outputMetamodel, "src/main/resources/util/Metric.ecore");
        IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
        injector.inject(inputMetamodel, "src/main/resources/util/ATL.ecore");

        String xmiFileString = storeModel(atlTransformation);
        IModel inputModel = modelFactory.newModel(inputMetamodel);
        IModel outModel = modelFactory.newModel(outputMetamodel);

        InputStream fis = new FileInputStream(new File(xmiFileString));

        injector.inject(inputModel, fis, null);

        transformationLauncher.initialize(new HashMap<String, Object>());
        transformationLauncher.addInModel(inputModel, "IN", "ATL");
        transformationLauncher.addOutModel(outModel, "OUT", "Metric");

        FileInputStream asmFile = new FileInputStream("src/main/resources/util/ATLMetric.asm");
        transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String, Object>(),
                asmFile);
        asmFile.close();

        extractor.extract(outModel, "src/main/resources/sampleCompany_Cut.xmi");
        EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
        emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
        emfModelFactory.unload((EMFReferenceModel) outputMetamodel);

        return extractMetrics("src/main/resources/sampleCompany_Cut.xmi");

    }

    private List<Metric> extractMetrics(String path) {
        List<Metric> result = new ArrayList();
        registerMetamodel("src/main/resources/util/Metric.ecore");
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());
        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();
        // Create a resource

        Resource resource = resSet.createResource(URI.createURI(path));
        try {
            resource.load(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EObject muforge = resource.getContents().get(0);
        List<Object> list = (List<Object>) muforge.eGet(muforge.eClass().getEStructuralFeature("metrics"));
        for (Object element : list) {
            String metricName = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("name"))
                    .toString();
            if (((EObject) element).eClass().getName().equals("SimpleMetric")) {
                String value = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("value")).toString();

                result.add(new SimpleMetric(metricName, value));
            }
            if (((EObject) element).eClass().getName().equals("AggregatedRealMetric")) {
                String minimum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("minimum")).toString();
                String maximum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("maximum")).toString();
                String median = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("median")).toString();
                String average = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("average")).toString();
                String standardDeviation = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("standardDeviation")).toString();
                result.add(new AggregateMetric(metricName, minimum, maximum, median, average, standardDeviation));
            }
            if (((EObject) element).eClass().getName().equals("AggregatedIntegerMetric")) {
                String minimum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("minimum")).toString();
                String maximum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("maximum")).toString();
                String median = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("median")).toString();
                String average = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("average")).toString();
                String standardDeviation = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("standardDeviation")).toString();
                result.add(new AggregateMetric(metricName, minimum, maximum, median, average, standardDeviation));
            }
        }

        return result;
    }

    public Resource registerMetamodel(String ecoreMetamodel) {
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        ResourceSet rs = new ResourceSetImpl();
        // enable extended metadata
        final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
        rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
        Resource r = rs.getResource(URI.createFileURI(ecoreMetamodel), true);
        for (EObject eObject : r.getContents()) {
            if (eObject instanceof EPackage) {
                EPackage p = (EPackage) eObject;
                registerSubPackage(p);
            }
        }
        return r;
    }

    private void registerSubPackage(EPackage p) {
        EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
        for (EPackage pack : p.getESubpackages()) {
            registerSubPackage(pack);
        }
    }

}
