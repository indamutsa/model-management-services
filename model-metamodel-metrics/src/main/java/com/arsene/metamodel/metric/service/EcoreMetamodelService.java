package com.arsene.metamodel.metric.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import com.arsene.metamodel.metric.DTO.QualitiesAndMetrics;
import com.arsene.metamodel.metric.DTO.QualityAttribute;
import com.arsene.metamodel.metric.DTO.SimpleMetric;

import io.micrometer.core.instrument.Metrics;

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
		
		return extractMetrics("src/main/resources/sampleCompany_Cut.xmi", false);

	}

	private List<Metric> extractMetrics(String path, boolean deleteMe) {
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
			String metricCode = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("code"))
					.toString();
			if (((EObject) element).eClass().getName().equals("SimpleMetric")) {
				String value = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("value")).toString();
				
				result.add(new SimpleMetric(metricName, metricCode, value));
			}
			if (((EObject) element).eClass().getName().equals("AggregatedRealMetric")) {
				String minimum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("minimum")).toString();
				String maximum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("maximum")).toString();
				String median = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("median")).toString();
				String average = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("average")).toString();
				String standardDeviation = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("standardDeviation")).toString();
				result.add(new AggregateMetric(metricName, metricCode, minimum, maximum, median, average, standardDeviation));
			}
			if (((EObject) element).eClass().getName().equals("AggregatedIntegerMetric")) {
				String minimum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("minimum")).toString();
				String maximum = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("maximum")).toString();
				String median = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("median")).toString();
				String average = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("average")).toString();
				String standardDeviation = ((EObject) element).eGet(((EObject) element).eClass().getEStructuralFeature("standardDeviation")).toString();
				result.add(new AggregateMetric(metricName, metricCode, minimum, maximum, median, average, standardDeviation));
			}
		}
		if (deleteMe)
			try {
				Files.delete(Paths.get(path));
			} catch (IOException e) {
				System.err.println("Cannot delete " + path);
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

	public List<QualityAttribute> calculateQualityAttributes(MultipartFile ecoreMetamodel) {
		// TODO Auto-generated method stub
		
		List<QualityAttribute> results = new ArrayList<QualityAttribute>();
		
		QualityAttribute maintainability = new QualityAttribute();
		try {
			List<Metric> metrics = calculateMetrics(ecoreMetamodel);
			
			//TODO PLEASE HERE CHANGE THE LOGIC TO QUATIC
			SimpleMetric MC = metrics.stream().filter(z -> z.getName().equals("Number of MetaClass")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric TA = metrics.stream().filter(z -> z.getName().equals("Number of Total Attribute")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric TR = metrics.stream().filter(z -> z.getName().equals("Number of TotalReference")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric MAHL = metrics.stream().filter(z -> z.getName().equals("Max generalizzation hierarchical level")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric MHS = metrics.stream().filter(z -> z.getName().equals("Max Hierarchy Sibiling")).map(z-> (SimpleMetric) z).findAny().get();
			double value = (Integer.parseInt(MC.getValue()) + Integer.parseInt(TA.getValue()) + Integer.parseInt(TR.getValue()) + Integer.parseInt(MAHL.getValue()) + Integer.parseInt(MHS.getValue())* 1.0) / 5;
			maintainability.setName("maintainability");
			maintainability.setValue(value);
			maintainability.getMetrics().add(MHS);
			maintainability.getMetrics().add(TA);
			maintainability.getMetrics().add(MC);
			maintainability.getMetrics().add(TR);
			maintainability.getMetrics().add(MAHL);
			results.add(maintainability);	
			
		} catch (ATLCoreException | IOException e) {
			System.err.println("Error computing metrics");
		}
		return results;
		
	
		

//		– DITMax : it is the maximum between the DIT value obtained for each class
//		of the metamodel. The DIT value for a class within a generalization hierarchy
//		is the longest path from the class to the root of the hierarchy;
//		– HAggMax : it is the maximum between the HAgg value obtained for each
//		class of the metamodel. The HAgg value for a class within an relation chain
//		is the longest path from the class to others
		
		
		
	}
	
	public QualitiesAndMetrics calculateQualitiesAndMetrics(MultipartFile ecoreMetamodel) {
		// TODO Auto-generated method stub
		
		
		
		QualitiesAndMetrics qem = new QualitiesAndMetrics();
		try {
			QualityAttribute maintainability = new QualityAttribute();
			List<Metric> metrics = calculateMetrics(ecoreMetamodel);
			//TODO PLEASE HERE CHANGE THE LOGIC TO QUATIC
			SimpleMetric MC = metrics.stream().filter(z -> z.getName().equals("Number of MetaClass")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric TA = metrics.stream().filter(z -> z.getName().equals("Number of Total Attribute")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric TR = metrics.stream().filter(z -> z.getName().equals("Number of TotalReference")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric MAHL = metrics.stream().filter(z -> z.getName().equals("Max generalizzation hierarchical level")).map(z-> (SimpleMetric) z).findAny().get();
			SimpleMetric MHS = metrics.stream().filter(z -> z.getName().equals("Max Hierarchy Sibiling")).map(z-> (SimpleMetric) z).findAny().get();
			double value = (Integer.parseInt(MC.getValue()) + Integer.parseInt(TA.getValue()) + Integer.parseInt(TR.getValue()) + Integer.parseInt(MAHL.getValue()) + Integer.parseInt(MHS.getValue())* 1.0) / 5;
			maintainability.setName("maintainability");
			maintainability.setValue(value);
			maintainability.getMetrics().add(MHS);
			maintainability.getMetrics().add(TA);
			maintainability.getMetrics().add(MC);
			maintainability.getMetrics().add(TR);
			maintainability.getMetrics().add(MAHL);
			
			qem.getQualityAttributes().add(maintainability);
			qem.getMetrics().addAll(metrics);
			
		} catch (ATLCoreException | IOException e) {
			System.err.println("Error computing metrics");
		}
		return qem;
		
	
		

//		– DITMax : it is the maximum between the DIT value obtained for each class
//		of the metamodel. The DIT value for a class within a generalization hierarchy
//		is the longest path from the class to the root of the hierarchy;
//		– HAggMax : it is the maximum between the HAgg value obtained for each
//		class of the metamodel. The HAgg value for a class within an relation chain
//		is the longest path from the class to others
		
		
		
	}

}
