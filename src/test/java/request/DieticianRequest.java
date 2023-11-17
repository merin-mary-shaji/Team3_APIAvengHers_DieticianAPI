package request;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.net.URLEncoder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoPayload.DieticianPayload;
import Utilities.BaseUtils;

public class DieticianRequest extends BaseUtils {

	public static Response dieticianlogin(DieticianPayload dieticianpayload) {
		try {
			response = given().contentType(ContentType.JSON).body(dieticianpayload).when()
					.post(config.getString("UserLogin_URL"));
			dieticianpayload.setToken(response.jsonPath().getString("token"));
			String accessToken=response.jsonPath().getString("token");
			System.out.println("The set token is  "+accessToken);

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
			System.out.println("the token it gets  "+dieticianpayload.getToken());
			response = given().header("Authorization","Bearer "+dieticianpayload.getToken())
					.when()
					.get(config.getString("GetAllPatient_URL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
