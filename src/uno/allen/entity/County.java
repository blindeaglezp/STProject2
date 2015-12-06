package uno.allen.entity;

public class County {
	private int City_FK;
	private int County_ID;
	private String County_Name;
	
	public int getCity_FK() {
		return City_FK;
	}
	public void setCity_FK(int city_FK) {
		City_FK = city_FK;
	}
	public int getCounty_ID() {
		return County_ID;
	}
	public void setCounty_ID(int county_ID) {
		County_ID = county_ID;
	}
	public String getCounty_Name() {
		return County_Name;
	}
	public void setCounty_Name(String county_Name) {
		County_Name = county_Name;
	}
	
	public String toString(){
		String reString = "CountyName"+County_Name+"CountyID"+County_ID;
		return reString;
	}
	
	
	
}
