package uno.allen.fun;

import java.util.List;

import uno.allen.db.CountyDb;
import uno.allen.entity.County;

public class CountyOp {
	public static void insertCounty(County county){
		CountyDb.insertCounty(county);
	}
	public static List<County> getCountyByCityID(int cityID){
		return CountyDb.getAllCountyByCityID(cityID);
	}
	public static List<County> getAllCountyByCountyID(int countyID){
		return CountyDb.getAllCountyByCountyID(countyID);
	}
	public static List<County> getAllCountyByCountyName(String countyName){
		return CountyDb.getAllCountyByCountyName(countyName);
	}
	public static List<County> getAllCounty(){
		return CountyDb.getAllCounty();
	}
	public static void deleteCounty(String countyName){
		CountyDb.deleteCounty(countyName);
	}
}
