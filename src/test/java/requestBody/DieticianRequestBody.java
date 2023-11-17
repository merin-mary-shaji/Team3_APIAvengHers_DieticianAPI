package requestBody;

import java.io.IOException;

import Utilities.BaseUtils;
import pojoPayload.DieticianPayload;

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
	
	public static DieticianPayload createNewPatient() throws IOException
	{
		dieticianpayload.setFirstName(excelutils.getCellData("PatientInfo", 0, 1));
		dieticianpayload.setLastName(excelutils.getCellData("PatientInfo", 1, 1));
		dieticianpayload.setContactNumber(excelutils.getCellData("PatientInfo", 2, 1));
		dieticianpayload.setEmail(excelutils.getCellData("PatientInfo", 3, 1));
		dieticianpayload.setAllergy(excelutils.getCellData("PatientInfo", 4, 1));
		dieticianpayload.setFoodCategory(excelutils.getCellData("PatientInfo", 5, 1));
		dieticianpayload.setDateOfBirth(excelutils.getCellData("PatientInfo", 6, 1));
		return dieticianpayload;
	}
}

