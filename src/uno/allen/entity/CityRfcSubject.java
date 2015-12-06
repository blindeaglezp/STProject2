package uno.allen.entity;

public class CityRfcSubject {
	private String City_Rfc;
	private String Subject_ID;
	private String Subject_Name;
	public String getCity_Rfc() {
		return City_Rfc;
	}
	public void setCity_Rfc(String city_Rfc) {
		City_Rfc = city_Rfc;
	}
	public String getSubject_ID() {
		return Subject_ID;
	}
	public void setSubject_ID(String subject_ID) {
		Subject_ID = subject_ID;
	}
	public String getSubject_Name() {
		return Subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		Subject_Name = subject_Name;
	}
	@Override
	public String toString() {
		return "CityRfcSubject [City_Rfc=" + City_Rfc + ", Subject_ID=" + Subject_ID + ", Subject_Name=" + Subject_Name
				+ "]";
	}
}
