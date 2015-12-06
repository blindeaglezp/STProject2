package uno.allen.entity;

public class CityRfc {
	private int City_FK_RFC;
	private String City_RFC;
	private String SBJ_ID_PFK;
	private String SBJ_Name_PFK;
	private String County_Name;
	public int getCity_FK_RFC() {
		return City_FK_RFC;
	}
	public void setCity_FK_RFC(int city_FK_RFC) {
		City_FK_RFC = city_FK_RFC;
	}
	public String getCity_RFC() {
		return City_RFC;
	}
	public void setCity_RFC(String city_RFC) {
		City_RFC = city_RFC;
	}
	public String getSBJ_ID_PFK() {
		return SBJ_ID_PFK;
	}
	public void setSBJ_ID_PFK(String sBJ_ID_PFK) {
		SBJ_ID_PFK = sBJ_ID_PFK;
	}
	public String getSBJ_Name_PFK() {
		return SBJ_Name_PFK;
	}
	public void setSBJ_Name_PFK(String sBJ_Name_PFK) {
		SBJ_Name_PFK = sBJ_Name_PFK;
	}
	public String getCounty_Name() {
		return County_Name;
	}
	public void setCounty_Name(String county_Name) {
		County_Name = county_Name;
	}
	@Override
	public String toString() {
		return "CityRfc [City_FK_RFC=" + City_FK_RFC + ", City_RFC=" + City_RFC + ", SBJ_ID_PFK=" + SBJ_ID_PFK
				+ ", SBJ_Name_PFK=" + SBJ_Name_PFK + ", County_Name=" + County_Name + "]";
	}
	
	
}
