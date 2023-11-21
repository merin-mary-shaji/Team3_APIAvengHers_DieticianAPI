package stepDefinition;

import Utilities.BaseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import request.DieticianRequest;

public class MorbidityModuleDieticianAPI extends BaseUtils {
	@When("User sends HTTPS Request to get all morbidity details with authentication token")
	public void user_sends_https_request_to_get_all_morbidity_details_with_authentication_token() {
		DieticianRequest.getAllMorbidityDetails();
	}

	@When("User sends HTTPS Request to get all morbidity details with invalid endpoints authentication token")
	public void user_sends_https_request_to_get_all_morbidity_details_with_invalid_endpoints_authentication_token() {
		DieticianRequest.getAllMorbidityDetailsInvalidEndpoint();
	}

	@Then("User receives {int} Status with error message")
	public void user_receives_status_with_error_message(Integer statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	@When("User sends HTTPS  GET Request to get all morbidity deatials with passing test name and authentication token")
	public void user_sends_https_get_request_to_get_all_morbidity_deatials_with_passing_test_name_and_authentication_token() {
		DieticianRequest.getAllMorbidityConditionByTestName();
	}

}
