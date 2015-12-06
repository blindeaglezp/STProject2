package uno.allen.fun;

import java.util.List;

import uno.allen.db.CountyRfcDb;
import uno.allen.entity.CountyRfc;

public class CountyRfcOp {
	public static void insertCityRfc(CountyRfc countyRfc){
		CountyRfcDb.insertCountyRfc(countyRfc);
		
	}
	public static List<CountyRfc> getCountyRfcByRfc(String countyRfc){
		return CountyRfcDb.getCountyRfcByRfc(countyRfc);
	}
	public static List<CountyRfc> getCountyRfcByCountyID(int countyID){
		return CountyRfcDb.getCountyRfcByCountyID(countyID);
	}
	public static List<CountyRfc> getCountyRfcBySubjectID(String subjectID){
		return CountyRfcDb.getCountyRfcBySubjectID(subjectID);
	}
	public static List<CountyRfc> getCountyRfcBySubjectName(String subjectName){
		return CountyRfcDb.getCountyRfcBySubjectName(subjectName);
	}
	public static void deleteCountyRfc(String countyRfc){
		CountyRfcDb.deleteCountyRfc(countyRfc);
	}
}
