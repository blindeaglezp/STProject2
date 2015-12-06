package uno.allen.entity;

public class CountyRfcSubject {
	private String County_Rfc;
	private String Subject_ID;
	private String Subject_Name;
	public String getCounty_Rfc() {
		return County_Rfc;
	}
	public void setCounty_Rfc(String county_Rfc) {
		County_Rfc = county_Rfc;
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
		return "CountyRfcSubject [County_Rfc=" + County_Rfc + ", Subject_ID=" + Subject_ID + ", Subject_Name="
				+ Subject_Name + "]";
	}
	
}
