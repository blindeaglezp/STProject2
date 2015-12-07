package uno.allen.fun;

import java.util.List;

import uno.allen.db.CityProjectDb;
import uno.allen.entity.CityProject;

public class CityProjectOp {
	public static void insertCityProject(CityProject cityProject){
		CityProjectDb.insertCityProject(cityProject);
	}
	public static void updateCityProject(CityProject cityProject){
		CityProjectDb.updateCityProject(cityProject);
	}
	public static List<CityProject> getAllCityProject(){
		return CityProjectDb.getAllCityProject();
	}
	public static List<CityProject> getCityProjectByCityRfc(String cityRfc){
		return CityProjectDb.getCityProjectByCityRfc(cityRfc);
	}
	public static List<CityProject> getCityProjectByCountyName(String countyName){
		return CityProjectDb.getCityProjectByCountyName(countyName);
	}
	public static List<CityProject> getCityProjectBySubjectName(String subjectName){
		return CityProjectDb.getCityProjectBySubjectName(subjectName);
	}
	public static List<CityProject> getCityProjectByProjectName(String projectName){
		return CityProjectDb.getCityProjectByProjectName(projectName);
	}
	public static void deleteCityProject(String cityRfc,String projectName,String countyName){
		CityProjectDb.deleteCityProject( cityRfc, projectName, countyName);
	}
	public static List<CityProject> getCityProjectByRfcSubject(String rfc,String subjectName){
		return CityProjectDb.getCityProjectByRfcSubject(rfc, subjectName);
	}
	public static List<CityProject> getCityProjectByRfcCounty(String rfc,String countyName){
		return CityProjectDb.getCityProjectByRfcCounty(rfc, countyName);
	}
	public static List<CityProject> getCityProjectByCountySubject(String countyName,String subjectName){
		return CityProjectDb.getCityProjectByCountySubject(countyName, subjectName);
	}
	public static List<CityProject> getCityProjectByRfcCountySubject(String rfc,String countyName,String subjectName){
		return CityProjectDb.getCityProjectByRfcCountySubject(rfc, countyName, subjectName);
	}
}
