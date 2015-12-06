package uno.allen.entity;

public class ProvinceRfc {
	private String Province_RFC;
	private String SBJ_ID_CITYFK;
	private String SBJ_Name_CITYFK;
	private String City_Name;
	
	public String getProvince_RFC() {
		return Province_RFC;
	}
	public void setProvince_RFC(String province_RFC) {
		Province_RFC = province_RFC;
	}
	public String getSBJ_ID_CITYFK() {
		return SBJ_ID_CITYFK;
	}
	public void setSBJ_ID_CITYFK(String sBJ_ID_CITYFK) {
		SBJ_ID_CITYFK = sBJ_ID_CITYFK;
	}
	public String getSBJ_Name_CITYFK() {
		return SBJ_Name_CITYFK;
	}
	public void setSBJ_Name_CITYFK(String sBJ_Name_CITYFK) {
		SBJ_Name_CITYFK = sBJ_Name_CITYFK;
	}
	public String getCity_Name() {
		return City_Name;
	}
	public void setCity_Name(String city_Name) {
		City_Name = city_Name;
	}
	@Override
	public String toString() {
		return "ProvinceRfc [Province_RFC=" + Province_RFC + ", SBJ_ID_CITYFK=" + SBJ_ID_CITYFK + ", SBJ_Name_CITYFK="
				+ SBJ_Name_CITYFK + ", City_Name=" + City_Name + "]";
	}
	
	
	
}
