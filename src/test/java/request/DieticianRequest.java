package request;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import pojoPayload.DieticianPayload;
import pojoPayload.MandatoryFieldMissingPatientPayload;
import pojoPayload.NewPatientPayload;
import Utilities.BaseUtils;

public class DieticianRequest extends BaseUtils {

	public static Response dieticianlogin(DieticianPayload dieticianpayload) {
		try {
			response = given().contentType(ContentType.JSON).body(dieticianpayload).when()
					.post(config.getString("UserLogin_URL"));
			dieticianpayload.setToken(response.jsonPath().getString("token"));
			response.jsonPath().getString("token");
			response.then().assertThat().body(matchesJsonSchema(loginSchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response dieticianInValidlogin(DieticianPayload dieticianpayload) {
		try {
			response = given().contentType(ContentType.JSON).body(dieticianpayload).when()
					.post(config.getString("UserLogin_URL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response getAllPatient() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).when()
					.get(config.getString("GetAllPatient_URL"));
			response.then().assertThat().body(matchesJsonSchema(patientDetailSchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response createNewPatient(NewPatientPayload newpatientpayload) {
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> payloadMap = newpatientpayload.toMap();
			String payloadAsString = objectMapper.writeValueAsString(payloadMap);
			// System.out.println(payloadAsString);

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).header("Accept", "*/*")
					// .header("Content-type", "multipart/form-data")
					.queryParam("patientInfo", payloadAsString)
					// .multiPart("file", new
					// File("./src/test/resources/hyperThyroid_report_final.pdf"))
					.log().all()

					.when().post(config.getString("GetAllPatient_URL"));
			response.then().log().all();
			dieticianpayload.setPatientId(response.jsonPath().getInt("patientId"));
			patientpayload.setUserLoginEmail(response.jsonPath().getString("Email"));
			response.then().assertThat().body(matchesJsonSchema(createPatientSchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response createNewPatientWithoutMandatoryField(MandatoryFieldMissingPatientPayload payload) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> payloadMap = payload.toMap();
			String payloadAsString = objectMapper.writeValueAsString(payloadMap);

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).header("Accept", "*/*")
					.header("Content-type", "multipart/form-data").queryParam("patientInfo", payloadAsString)
					.multiPart("file", new File(config.getString("Report_Path"))).log().all()

					.when().post(config.getString("GetAllPatient_URL"));
			response.then().log().all();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response UpdatePatientByPatientID(NewPatientPayload newpatientpayload) {
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> payloadMap = newpatientpayload.toMap();
			String payloadAsString = objectMapper.writeValueAsString(payloadMap);
			// System.out.println(payloadAsString);

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).header("Accept", "*/*")
					.header("Content-type", "multipart/form-data").queryParam("patientInfo", payloadAsString)
					.pathParam("patientId", dieticianpayload.getPatientId())
					.multiPart("file", new File(config.getString("Report_Path"))).log().all()

					.when().put(config.getString("UpdatePatient_URL") + "{patientId}");
			response.then().log().all();
			patientpayload.setUserLoginEmail(response.jsonPath().getString("Email"));
			response.then().assertThat().body(matchesJsonSchema(updatePatientSchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response UpdatePatientByInvalidPatientID(NewPatientPayload newpatientpayload) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> payloadMap = newpatientpayload.toMap();
			String payloadAsString = objectMapper.writeValueAsString(payloadMap);
			// System.out.println(payloadAsString);

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).header("Accept", "*/*")
					.header("Content-type", "multipart/form-data").queryParam("patientInfo", payloadAsString)
					.pathParam("patientId", dieticianpayload.getPatientId() + RandomStringUtils.randomNumeric(2))
					.multiPart("file", new File(config.getString("Report_Path"))).log().all()

					.when().put(config.getString("UpdatePatient_URL") + "{patientId}");
			response.then().log().all();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response UpdatePatientByPatientIDWithoutMandatoryFields(MandatoryFieldMissingPatientPayload payload) {
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> payloadMap = payload.toMap();
			String payloadAsString = objectMapper.writeValueAsString(payloadMap);
			// System.out.println(payloadAsString);

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).header("Accept", "*/*")
					.header("Content-type", "multipart/form-data").queryParam("patientInfo", payloadAsString)
					.pathParam("patientId", dieticianpayload.getPatientId())
					.multiPart("file", new File(config.getString("Report_Path"))).log().all()

					.when().put(config.getString("UpdatePatient_URL") + "{patientId}");
			response.then().log().all();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response GetPatientMorbidityDetails() {

		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("patientId", dieticianpayload.getPatientId()).log().all().when()
					.get(config.getString("GetPatientMorbidities_URL") + "{patientId}");

			System.out.println("The File ID is  " + response.jsonPath().getString("[0].fileId"));
			String fileID = response.jsonPath().getString("[0].fileId");
			dieticianpayload.setFileId(fileID);
			response.then().log().all();
			response.then().assertThat().body(matchesJsonSchema(PatientMorbiditySchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response GetPatientMorbidityDetailsInValidID() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("patientId", dieticianpayload.getPatientId() + RandomStringUtils.randomNumeric(2)).log()
					.all().when().get(config.getString("GetPatientMorbidities_URL") + "{patientId}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static void ViewPatientFile() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("fileId", dieticianpayload.getFileId()).log().all().when()
					.get(config.getString("TestReportByFileId") + "{fileId}");
			if (response.getStatusCode() == 200) {
				// Extract the PDF content as bytes
				byte[] pdfContent = response.asByteArray();
				FileOutputStream outputStream = new FileOutputStream("Dieticians_PatientReport.pdf");
				outputStream.write(pdfContent);
				System.out.println("PDF saved to Dieticians_PatientReport.pdf");
			} else {
				System.out.println("Failed to retrieve PDF. Status code: " + response.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ViewPatientFileInvalidFileID() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("fileId", dieticianpayload.getFileId() + RandomStringUtils.randomAlphanumeric(4)).log()
					.all().when().get(config.getString("TestReportByFileId") + "{fileId}");
			if (response.getStatusCode() == 200) {
				// Extract the PDF content as bytes
				byte[] pdfContent = response.asByteArray();
				FileOutputStream outputStream = new FileOutputStream("output.pdf");
				outputStream.write(pdfContent);
				System.out.println("PDF saved to output.pdf");
			} else {
				System.out.println("Failed to retrieve PDF. Status code: " + response.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Response DeletePatient() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("patientId", dieticianpayload.getPatientId()).log().all().when()
					.delete(config.getString("DeletePatient_URL") + "{patientId}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response DeletePatientWithInValidId() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("patientId", dieticianpayload.getPatientId() + RandomStringUtils.randomNumeric(2)).log()
					.all().when().delete(config.getString("DeletePatient_URL") + "{patientId}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response DieticianLogout() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).when()
					.get(config.getString("LogoutDietician_URL"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response getAllMorbidityDetails() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).when()
					.get(config.getString("GetAllMorbidityDetails_URL"));
			// = response.jsonPath().getString("[0].morbidityTestName");
			dieticianpayload.setMorbidityTestName(response.jsonPath().getString("[0].morbidityTestName"));
			System.out.println(response.jsonPath().getString("[0].morbidityTestName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response getAllMorbidityDetailsInvalidEndpoint() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken()).when()
					.get(config.getString("GetAllMorbidityDetailsInvalidEndpoint_URL"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response getAllMorbidityConditionByTestName() {
		try {

			response = given().header("Authorization", "Bearer " + dieticianpayload.getToken())
					.pathParam("morbidityTestName", dieticianpayload.getMorbidityTestName()).log().all().when()
					.get(config.getString("GetAllMorbidityConditionTestName_URL") + "{morbidityTestName}");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
