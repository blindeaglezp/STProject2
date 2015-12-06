package uno.allen.fun;

import java.util.List;

import uno.allen.db.CityDb;
import uno.allen.entity.City;

public class CityOp {
	public static void insertCity(City city){
		CityDb.insertCity(city);
	}
	public static List<City> getAllCity(){
		return CityDb.getAllCity();
	}
	public static City getCityByName(String name){
		return CityDb.getCityByName(name);
	}
	public static City getCityByID(int ID){
		return CityDb.getCityByID(ID);
	}
	public static void deleteCity(String cityName){
		CityDb.deleteCity(cityName);
	}
}
