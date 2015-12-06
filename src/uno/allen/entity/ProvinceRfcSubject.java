package uno.allen.entity;

public class ProvinceRfcSubject {
	private String Province_Rfc;
	private String Subject_ID;
	private String Subject_Name;
	public String getProvince_Rfc() {
		return Province_Rfc;
	}
	public void setProvince_Rfc(String province_Rfc) {
		Province_Rfc = province_Rfc;
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
		return "ProvinceRfcSubject [Province_Rfc=" + Province_Rfc + ", Subject_ID=" + Subject_ID + ", Subject_Name="
				+ Subject_Name + "]";
	}
	
	
}
