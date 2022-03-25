package com.arsene.metamodel.metric.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.arsene.metamodel.metric.DTO.Metric;
import com.arsene.metamodel.metric.DTO.QualityAttribute;
import com.arsene.metamodel.metric.utililties.ServiceUtil;

@AutoConfigureMockMvc
@SpringBootTest
public class EcoreMetamodelTest {

	/*
	 * We are performing UNIT Test We are testing the function decoupled with other
	 * functionalities
	 *
	 */
	String testNumber = "";

	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private EcoreMetamodelService ecoreService;

	/*
	 * This function will run before everything runs
	 */
	@BeforeEach
	void setUp() {
		System.out.println(String.format("Starting testing..."));
	}

	/*
	 * This function will run when we are done performing a single function
	 */
	@AfterEach
	void tearDown() {
		System.out.println(String.format("Finished testing TEST %S", testNumber));
	}
	
	

	@Test
	void computeMetricsTest() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "TWO";
		MockMultipartFile script = handleFiles(2);
		List<Metric> resource = ecoreService.calculateMetrics(script);
		resource.forEach(s -> System.out.println(s));
		System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
	}
	
	@Test
	void computeQualityAttributesTest() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "THREE";
		MockMultipartFile script = handleFiles(2);
		List<QualityAttribute> resource = ecoreService.calculateQualityAttributes(script);
		resource.forEach(s -> System.out.println(s));
		System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
	}

	

	public static MockMultipartFile handleFiles(int num) {

		MockMultipartFile multipartFile = null;

		switch (num) {
		case 1:

			try {
				Path sourceModel = Paths.get("src/test/TestResources/artifacts/models/sample-Families.xmi");
				File file = new File(sourceModel.toString());
				InputStream inputStreamScriptFile = new FileInputStream(file);

				multipartFile = new MockMultipartFile("sourceModel", "sample-Families.xmi", "application/xmi",
						inputStreamScriptFile);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case 2:

			try {
				Path metaModel = Paths.get("src/test/TestResources/artifacts/metamodels/Families.ecore");
				File file = new File(metaModel.toString());
				InputStream inputStreamSourceMetaModel = new FileInputStream(file);

				multipartFile = new MockMultipartFile("sourceMetaModel", "Families.ecore", "application/octet-stream",
						inputStreamSourceMetaModel);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case 3:

			try {
				Path targetMetaModel = Paths.get("src/test/TestResources/artifacts/metamodels/Persons.ecore");
				File file = new File(targetMetaModel.toString());
				InputStream inputStreamTargetMetaModel = new FileInputStream(file);

				multipartFile = new MockMultipartFile("targetMetaModel", "Person.ecore", "application/octet-stream",
						inputStreamTargetMetaModel);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case 4:

			try {
				Path script = Paths.get("src/test/TestResources/artifacts/script/Families2Persons.atl");
				File file = new File(script.toString());
				InputStream inputStreamScript = new FileInputStream(file);
//				FIXME WHEN compileAsm is fixed please use atl extension
//				multipartFile = new MockMultipartFile("etlScript", "Families2Persons.atl", "application/octet-stream",
//						inputStreamScript);

				multipartFile = new MockMultipartFile("etlScript", "Families2Persons.atl", "application/octet-stream",
						inputStreamScript);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		return multipartFile;
	}
}