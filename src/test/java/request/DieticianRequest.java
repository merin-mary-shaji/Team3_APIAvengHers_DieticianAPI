package request;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import pojoPayload.DieticianPayload;
import pojoPayload.NewPatientPayload;
import Utilities.BaseUtils;

public class DieticianRequest extends BaseUtils {

	public static Response dieticianlogin(DieticianPayload dieticianpayload) {
		try {
			response = given().contentType(ContentType.JSON).body(dieticianpayload).when()
					.post(config.getString("UserLogin_URL"));
			dieticianpayload.setToken(response.jsonPath().getString("token"));
			response.jsonPath().getString("token");

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
					.header("Content-type", "multipart/form-data").queryParam("patientInfo", payloadAsString)
					.multiPart("file", new File("./src/test/resources/hyperThyroid_report_final.pdf"))

					.when().post(config.getString("GetAllPatient_URL"));

			dieticianpayload.setPatientId(response.jsonPath().getInt("patientId"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

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
}
