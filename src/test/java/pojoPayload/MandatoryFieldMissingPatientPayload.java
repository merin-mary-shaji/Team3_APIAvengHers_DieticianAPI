package pojoPayload;

import java.util.LinkedHashMap;
import java.util.Map;

public class MandatoryFieldMissingPatientPayload {

	private String LastName;
	private String ContactNumber;
	private String Email;
	private String Allergy;
	private String FoodCategory;
	private String DateOfBirth;
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAllergy() {
		return Allergy;
	}
	public void setAllergy(String allergy) {
		Allergy = allergy;
	}
	public String getFoodCategory() {
		return FoodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		FoodCategory = foodCategory;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public Map<String, Object> toMap() {
        Map<String, Object> map1 = new LinkedHashMap<>();
        
        map1.put("LastName", LastName);
        map1.put("ContactNumber", ContactNumber);
        map1.put("Email", Email);
        map1.put("Allergy", Allergy);
        map1.put("FoodCategory", FoodCategory);
        map1.put("DateOfBirth", DateOfBirth);
        return map1;
    }
}
