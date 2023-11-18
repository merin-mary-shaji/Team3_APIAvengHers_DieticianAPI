package requestBody;

import java.io.IOException;

import Utilities.BaseUtils;
import pojoPayload.DieticianPayload;
import pojoPayload.NewPatientPayload;

public class DieticianRequestBody extends BaseUtils{
	
	
	public static DieticianPayload credentialBody() throws IOException
	{
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
	
	public static NewPatientPayload createNewPatient() throws IOException
	{
		
		newpatientpayload.setFirstName(faker.name().firstName());
		newpatientpayload.setLastName(faker.name().lastName());
		newpatientpayload.setContactNumber(faker.number().digits(10));
		newpatientpayload.setEmail(faker.internet().emailAddress());
		newpatientpayload.setAllergy(excelutils.getCellData("PatientInfo", 4, 1));
		newpatientpayload.setFoodCategory(excelutils.getCellData("PatientInfo", 5, 1));
		newpatientpayload.setDateOfBirth(excelutils.getCellData("PatientInfo", 6, 1));
		return newpatientpayload;
	}
}

