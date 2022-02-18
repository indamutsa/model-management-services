package com.arsene.metamodel.metric.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceImpl;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arsene.metamodel.metric.DTO.AggregateMetric;
import com.arsene.metamodel.metric.DTO.Metric;
import com.arsene.metamodel.metric.DTO.SimpleMetric;



@Service
public class EcoreMetamodelService {





	public List<Metric> calculateMetrics(MultipartFile ecoreMetamodel) throws ATLCoreException, IOException {
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
		injector.inject(inputMetamodel, org.eclipse.emf.ecore.EcorePackage.eNS_URI);

		IModel inputModel = modelFactory.newModel(inputMetamodel);
		IModel outModel = modelFactory.newModel(outputMetamodel);

		InputStream fis = ecoreMetamodel.getInputStream();

		injector.inject(inputModel, fis, null);

		transformationLauncher.initialize(new HashMap<String, Object>());
		transformationLauncher.addInModel(inputModel, "IN", "Ecore");
		transformationLauncher.addOutModel(outModel, "OUT", "Metric");

		FileInputStream asmFile = new FileInputStream("src/main/resources/util/EcoreMetric.asm");
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
