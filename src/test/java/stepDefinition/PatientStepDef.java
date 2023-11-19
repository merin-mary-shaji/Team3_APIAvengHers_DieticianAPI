package stepDefinition;

import java.io.IOException;

import Utilities.BaseUtils;
import io.cucumber.java.en.When;
import request.DieticianRequest;
import request.PatientRequest;
import requestBody.PatientRequestBody;

public class PatientStepDef extends BaseUtils {

	@When("User sends HTTPS POST Request with patient login endpoint and request Body")
	public void user_sends_https_post_request_with_patient_login_endpoint_and_request_body() throws IOException {
		patientpayload = PatientRequestBody.credentialBodyOfPatient();
		PatientRequest.Patientlogin(patientpayload);
	}

	@When("User sends HTTPS GET Request login as patient for Morbidity Details with  PatientId and with authentication token")
	public void user_sends_https_get_request_login_as_patient_for_morbidity_details_with_patient_id_and_with_authentication_token() {
		PatientRequest.PatientTestReport();
	}

	@When("User sends HTTPS GET Request login as patient to view File with FileId and with authentication token")
	public void user_sends_https_get_request_login_as_patient_to_view_file_with_file_id_and_with_authentication_token() {
		PatientRequest.ViewPatientFile();
	}

	@When("User sends HTTPS Delete Patient Request and with valid PatientId and authentication token")
	public void user_sends_https_request_and_with_valid_patient_id_and_authentication_token() {
		DieticianRequest.DeletePatient();

	}

	@When("User sends HTTPS Delete Patient Request and with Invalid PatientId and authentication token")
	public void user_sends_https_request_and_with_invalid_patient_id_and_authentication_token() {
		DieticianRequest.DeletePatientWithInValidId();
	}

	@When("User sends HTTPS GET Request to logout as a Dietician and authentication token")
	public void user_sends_https_get_request_to_logout_as_a_dietician_and_authentication_token() {
		DieticianRequest.DieticianLogout();
	}
}
