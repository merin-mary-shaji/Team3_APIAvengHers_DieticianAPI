package requestBody;

import java.io.IOException;

import Utilities.BaseUtils;
import pojoPayload.DieticianPayload;
import pojoPayload.MandatoryFieldMissingPatientPayload;
import pojoPayload.NewPatientPayload;

public class DieticianRequestBody extends BaseUtils {

	public static DieticianPayload credentialBody() throws IOException {
		dieticianpayload.setPassword(excelutils.getCellData("Credential", 0, 1));
		dieticianpayload.setUserLoginEmail(excelutils.getCellData("Credential", 1, 1));
		return dieticianpayload;
	}

	public static DieticianPayload invalidCredentialBody() throws IOException {
		dieticianpayload.setPassword(excelutils.getCellData("Credential", 2, 1));
		dieticianpayload.setUserLoginEmail(excelutils.getCellData("Credential", 1, 1));
		return dieticianpayload;
	}

	public static DieticianPayload missingMandatoryFieldBody() throws IOException {
		dieticianpayload.setUserLoginEmail(excelutils.getCellData("Credential", 1, 2));
		return dieticianpayload;
	}

	public static NewPatientPayload createNewPatient() throws IOException {

		newpatientpayload.setFirstName(excelutils.getCellData("PatientInfo", 0, 1));
		newpatientpayload.setLastName(excelutils.getCellData("PatientInfo", 1, 1));
		newpatientpayload.setContactNumber(excelutils.getCellData("PatientInfo", 2, 1));
		newpatientpayload.setEmail(excelutils.getCellData("PatientInfo", 3, 1));
		newpatientpayload.setAllergy(excelutils.getCellData("PatientInfo", 4, 1));
		newpatientpayload.setFoodCategory(excelutils.getCellData("PatientInfo", 5, 1));
		newpatientpayload.setDateOfBirth(excelutils.getCellData("PatientInfo", 6, 1));
		return newpatientpayload;
	}

	public static MandatoryFieldMissingPatientPayload createNewPatientWithoutAMandatoryField() throws IOException {

		payload.setLastName(faker.name().lastName());
		payload.setContactNumber(faker.number().digits(10));
		payload.setEmail(faker.internet().emailAddress());
		payload.setAllergy(excelutils.getCellData("PatientInfo", 4, 1));
		payload.setFoodCategory(excelutils.getCellData("PatientInfo", 5, 1));
		payload.setDateOfBirth(excelutils.getCellData("PatientInfo", 6, 1));
		return payload;
	}

	public static NewPatientPayload updatePatient() throws IOException {
		newpatientpayload.setFirstName(excelutils.getCellData("PatientInfo", 0, 1));
		newpatientpayload.setLastName(faker.name().lastName());
		newpatientpayload.setContactNumber(faker.number().digits(10));
		newpatientpayload.setEmail(faker.internet().emailAddress());
		newpatientpayload.setAllergy(excelutils.getCellData("PatientInfo", 4, 1));
		newpatientpayload.setFoodCategory(excelutils.getCellData("PatientInfo", 5, 1));
		newpatientpayload.setDateOfBirth(excelutils.getCellData("PatientInfo", 6, 1));
		return newpatientpayload;
	}
}
