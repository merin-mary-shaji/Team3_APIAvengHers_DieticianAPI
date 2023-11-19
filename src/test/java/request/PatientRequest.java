package request;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.FileOutputStream;

import org.apache.commons.lang3.RandomStringUtils;

import Utilities.BaseUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoPayload.DieticianPayload;
import pojoPayload.PatientLoginPayLoad;

public class PatientRequest extends BaseUtils {

	public static Response Patientlogin(PatientLoginPayLoad patientpayload) {
		try {
			response = given().contentType(ContentType.JSON).body(patientpayload).log().all().when()
					.post(config.getString("UserLogin_URL"));
			patientpayload.setToken(response.jsonPath().getString("token"));
			response.then().log().all();
			response.then().assertThat().body(matchesJsonSchema(loginSchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	public static Response PatientTestReport() {
		try {

			response = given().header("Authorization", "Bearer " + patientpayload.getToken())
					.pathParam("patientId", dieticianpayload.getPatientId()).log().all().when()
					.get(config.getString("GetPatientMorbidities_URL") + "{patientId}");

			System.out.println("The File ID is  " + response.jsonPath().getString("[0].fileId"));
			String fileID = response.jsonPath().getString("[0].fileId");
			patientpayload.setFileId(fileID);
			response.then().log().all();
			response.then().assertThat().body(matchesJsonSchema(PatientMorbiditySchemaf));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static void ViewPatientFile() {
		try {

			response = given().header("Authorization", "Bearer " + patientpayload.getToken())
					.pathParam("fileId", patientpayload.getFileId()).log().all().when()
					.get(config.getString("TestReportByFileId") + "{fileId}");
			if (response.getStatusCode() == 200) {
				// Extract the PDF content as bytes
				byte[] pdfContent = response.asByteArray();
				FileOutputStream outputStream = new FileOutputStream("PatientReport.pdf");
				outputStream.write(pdfContent);
				System.out.println("PDF saved to output.pdf");
			} else {
				System.out.println("Failed to retrieve PDF. Status code: " + response.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
