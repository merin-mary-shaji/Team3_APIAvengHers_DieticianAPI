package stepDefinition;

import Utilities.BaseUtils;
import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import request.DieticianRequest;
import requestBody.DieticianRequestBody;

public class DieticianAPIStepDef extends BaseUtils{

	
	@Given("User creates  Request")
	public void user_creates_request() {
		baseURI = BaseURI;
	}
	@When("User sends HTTPS POST Request with login endpoint and request Body")
	public void user_sends_https_post_request_with_login_endpoint_and_request_body() throws IOException {
		dieticianpayload =DieticianRequestBody.credentialBody();
		DieticianRequest.dieticianlogin(dieticianpayload);
	}
	@Then("User receives {int} Status with response body")
	public void user_receives_status_with_response_body(Integer statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}
	@When("User sends HTTPS POST Request with login endpoint and with invalid credentials in request Body")
	public void user_sends_https_post_request_with_login_endpoint_and_with_invalid_credentials_in_request_body() throws IOException {
		dieticianpayload =DieticianRequestBody.invalidCredentialBody();
		DieticianRequest.dieticianInValidlogin(dieticianpayload);
	}
	@When("User sends HTTPS POST Request with login endpoint and with missing mandatory fields in request body")
	public void user_sends_https_post_request_with_login_endpoint_and_with_missing_mandatory_fields_in_request_body() throws IOException {
		dieticianpayload=DieticianRequestBody.missingMandatoryFieldBody();
		DieticianRequest.dieticianInValidlogin(dieticianpayload);
	}
	
	@When("User sends HTTPS Request to Get all Patients with authentication token")
	public void user_sends_https_request_to_get_all_patients_with_authentication_token() {
		DieticianRequest.getAllPatient();
	}
	@When("User sends HTTPS Request and with valid request body in Form Data and authentication token")
	public void user_sends_https_request_and_with_valid_request_body_in_form_data_and_authentication_token() throws IOException {
		newpatientpayload =DieticianRequestBody.createNewPatient();
		DieticianRequest.createNewPatient(newpatientpayload);
	}
	@When("User sends HTTPS Request and with valid PatientId and authentication token")
	public void user_sends_https_request_and_with_valid_patient_id_and_authentication_token() {
		DieticianRequest.DeletePatient();

	}
}
