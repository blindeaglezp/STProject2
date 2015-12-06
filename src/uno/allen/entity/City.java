package uno.allen.entity;

public class City {
	private int City_ID;
	private String City_Name;
	public int getCityID() {
		return City_ID;
	}
	public void setCityID(int city_ID) {
		City_ID = city_ID;
	}
	public String getCityName() {
		return City_Name;
	}
	public void setCityName(String city_Name) {
		City_Name = city_Name;
	}
	public String toString(){
		String reString = "CityID="+City_ID+"CityName"+City_Name;
		return reString;
	}
}
