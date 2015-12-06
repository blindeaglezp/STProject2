package uno.allen.fun;

import java.util.List;

import uno.allen.db.CityRfcDb;
import uno.allen.entity.CityRfc;

public class CityRfcOp {
	public static void insertCityRfc(CityRfc cityRfc){
		CityRfcDb.insertCityRfc(cityRfc);
	}
	public static List<CityRfc> getCityRfcByCityID(int ID){
		return CityRfcDb.getCityRfcByCityID(ID);
	}
	public static List<CityRfc> getCityRfcByCityRfc(String cityRfc){
		return CityRfcDb.getCityRfcByCityRfc(cityRfc);
	}
	public static List<CityRfc> getCityRfcByCountyName(String countyName){
		return CityRfcDb.getCityRfcByCountyName(countyName);
	}
	public static List<CityRfc> getCityRfcBySbjID(String sbjID){
		return CityRfcDb.getCityRfcBySbjID(sbjID);
	}
	public static List<CityRfc> getCityRfcBySbjName(String sbjName){
		return CityRfcDb.getCityRfcBySbjName(sbjName);
	}
	public static void deleteCityRFC(String cityRfc){
		CityRfcDb.deleteCityRFC(cityRfc);
	}
}
