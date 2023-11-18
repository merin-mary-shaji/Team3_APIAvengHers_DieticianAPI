package pojoPayload;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class NewPatientPayload {

	private String FirstName;
	private String LastName;
	private String ContactNumber;
	private String Email;
	private String Allergy;
	private String FoodCategory;
	private String DateOfBirth;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
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
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("FirstName", FirstName);
        map.put("LastName", LastName);
        map.put("ContactNumber", ContactNumber);
        map.put("Email", Email);
        map.put("Allergy", Allergy);
        map.put("FoodCategory", FoodCategory);
        map.put("DateOfBirth", DateOfBirth);
        return map;
    }
}
