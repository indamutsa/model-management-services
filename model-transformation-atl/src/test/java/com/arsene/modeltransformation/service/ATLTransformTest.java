package com.arsene.modeltransformation.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;

import com.arsene.modeltransformation.DTO.ATLTransformationInfo;
import com.arsene.modeltransformation.DTO.Metric;
import com.arsene.modeltransformation.utililties.ServiceUtil;

@AutoConfigureMockMvc
@SpringBootTest
public class ATLTransformTest {

	/*
	 * We are performing UNIT Test We are testing the function decoupled with other
	 * functionalities
	 *
	 */
	String testNumber = "";

	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private ATLTransform atlTransform;

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
	void compileTest() throws IOException {
		atlTransform.compileAsmAndGetPath(handleFiles(4));
	}
	
	@Test
	void runEngine() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "ONE";
		MockMultipartFile sourceModel = handleFiles(1);
		MockMultipartFile sourceMetaModel = handleFiles(2);
		MockMultipartFile targetMetaModel = handleFiles(3);
		MockMultipartFile script = handleFiles(4);

		Resource resource = atlTransform.execute(sourceModel, sourceMetaModel, targetMetaModel, script);
		boolean isFile = resource.isFile();
		boolean isReadable = resource.isReadable();
		boolean contentLength = resource.contentLength() > 0;

		boolean[] testTrue = { true, true, true };
		boolean[] status = { isFile, isReadable, contentLength };

		assertArrayEquals(status, testTrue);

		System.out.println(String.format("Test ---> %s passed successfully!", testNumber));

	}
	@Test
	void getModelInfoTest() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "TWO";
		MockMultipartFile script = handleFiles(4);
		EList<EObject> resource = atlTransform.getResources(script);
		System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
	}
	
	@Test
	void computeMetricsTest() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "THREE";
		MockMultipartFile script = handleFiles(4);
		List<Metric> resource = atlTransform.calculateMetrics(script);
		resource.forEach(s -> System.out.println(s));
		System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
	}
	
	@Test
	void computeATLTransformationInfoTest() throws IOException, ATLExecutionException, ATLCoreException {
		testNumber = "FOUR";
		MockMultipartFile script = handleFiles(4);
		ATLTransformationInfo trafoInfo = atlTransform.getAtlInfo(script);
		System.out.println(trafoInfo);
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