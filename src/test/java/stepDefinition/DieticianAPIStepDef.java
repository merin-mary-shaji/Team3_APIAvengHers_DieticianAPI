package stepDefinition;

import Utilities.BaseUtils;
import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import request.DieticianRequest;
import requestBody.DieticianRequestBody;

public class DieticianAPIStepDef extends BaseUtils {

	@Given("User creates  Request")
	public void user_creates_request() {
		baseURI = BaseURI;
	}

	@When("User sends HTTPS POST Request with login endpoint and request Body")
	public void user_sends_https_post_request_with_login_endpoint_and_request_body() throws IOException {
		dieticianpayload = DieticianRequestBody.credentialBody();
		DieticianRequest.dieticianlogin(dieticianpayload);
	}

	@Then("User receives {int} Status Code")
	public void user_receives_status_Code(Integer statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@When("User sends HTTPS POST Request with login endpoint and with invalid credentials in request Body")
	public void user_sends_https_post_request_with_login_endpoint_and_with_invalid_credentials_in_request_body()
			throws IOException {
		dieticianpayload = DieticianRequestBody.invalidCredentialBody();
		DieticianRequest.dieticianInValidlogin(dieticianpayload);
	}

	@When("User sends HTTPS POST Request with login endpoint and with missing mandatory fields in request body")
	public void user_sends_https_post_request_with_login_endpoint_and_with_missing_mandatory_fields_in_request_body()
			throws IOException {
		dieticianpayload = DieticianRequestBody.missingMandatoryFieldBody();
		DieticianRequest.dieticianInValidlogin(dieticianpayload);
	}

	@When("User sends HTTPS POST Request and with valid request body and authentication token")
	public void user_sends_https_post_request_and_with_valid_request_body_and_authentication_token()
			throws IOException {
		newpatientpayload = DieticianRequestBody.createNewPatient();
		DieticianRequest.createNewPatient(newpatientpayload);
	}

	@When("User sends HTTPS POST Request when mandatory field not included and with authentication token")
	public void user_sends_https_post_request_when_mandatory_field_not_included_and_with_authentication_token()
			throws IOException {
		payload = DieticianRequestBody.createNewPatientWithoutAMandatoryField();
		DieticianRequest.createNewPatientWithoutMandatoryField(payload);
	}

	@When("User sends HTTPS Request to Get all Patients with authentication token")
	public void user_sends_https_request_to_get_all_patients_with_authentication_token() {
		DieticianRequest.getAllPatient();
	}

	@When("User sends HTTPS POST Request where uniques fields are matching with existing patient and with authentication token")
	public void user_sends_https_post_request_where_uniques_fields_are_matching_with_existing_patient_and_with_authentication_token()
			throws IOException {
		newpatientpayload = DieticianRequestBody.createNewPatient();
		DieticianRequest.createNewPatient(newpatientpayload);
	}

	@When("User sends HTTPS PUT Request with valid PatientId Queryparam PatientInfo Request body and with authentication token")
	public void user_sends_https_put_request_with_valid_patient_id_queryparam_patient_info_request_body_and_with_authentication_token()
			throws IOException {
		newpatientpayload = DieticianRequestBody.updatePatient();
		DieticianRequest.UpdatePatientByPatientID(newpatientpayload);
	}

	@When("User sends HTTPS PUT Request with Invalid PatientId Queryparam PatientInfo Request body and with authentication token")
	public void user_sends_https_put_request_with_invalid_patient_id_queryparam_patient_info_request_body_and_with_authentication_token()
			throws IOException {
		newpatientpayload = DieticianRequestBody.updatePatient();
		DieticianRequest.UpdatePatientByInvalidPatientID(newpatientpayload);
	}

	@When("User sends HTTPS PUT Request with valid PatientId missing mandatory field in Queryparam PatientInfo Request body and with authentication token")
	public void user_sends_https_put_request_with_valid_patient_id_missing_mandatory_field_in_queryparam_patient_info_request_body_and_with_authentication_token()
			throws IOException {
		payload = DieticianRequestBody.createNewPatientWithoutAMandatoryField();
		DieticianRequest.UpdatePatientByPatientIDWithoutMandatoryFields(payload);
	}

	@When("User sends HTTPS GET Request for Morbidity Details with valid PatientId and with authentication token")
	public void user_sends_https_get_request_with_valid_patient_id_and_with_authentication_token() {
		DieticianRequest.GetPatientMorbidityDetails();
	}

	@When("User sends HTTPS GET Request for Morbidity Details with Invalid PatientId and with authentication token")
	public void user_sends_https_get_request_with_invalid_patient_id_and_with_authentication_token() {
		DieticianRequest.GetPatientMorbidityDetailsInValidID();
	}

	@When("User sends HTTPS GET Request to view File with valid FileId and with authentication token")
	public void user_sends_https_get_request_to_view_file_with_valid_file_id_and_with_authentication_token() {
		DieticianRequest.ViewPatientFile();
	}

	@When("User sends HTTPS GET Request to view File with Invalid FileId and with authentication token")
	public void user_sends_https_get_request_to_view_file_with_invalid_file_id_and_with_authentication_token() {
		DieticianRequest.ViewPatientFileInvalidFileID();
	}

}
