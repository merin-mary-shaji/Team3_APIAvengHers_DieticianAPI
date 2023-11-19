package requestBody;

import java.io.IOException;

import Utilities.BaseUtils;
import pojoPayload.PatientLoginPayLoad;

public class PatientRequestBody extends BaseUtils {

	public static PatientLoginPayLoad credentialBodyOfPatient() throws IOException {
		patientpayload.setPassword(excelutils.getCellData("PatientInfo", 7, 1));
		patientpayload.getUserLoginEmail();
		return patientpayload;
	}
}
