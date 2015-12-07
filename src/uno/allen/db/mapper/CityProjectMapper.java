package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.CityProject;

public interface CityProjectMapper {
	void insertCityProject(CityProject cityProject);
	void deleteCityProject(String cityRfc,String projectName,String countyName);
	void updateCityProject(CityProject cityProject);
	List<CityProject> getAllCityProject();
	List<CityProject> getCityProjectByCityRfc(String cityRfc);
	List<CityProject> getCityProjectByCountyName(String countyName);
	List<CityProject> getCityProjectBySubjectName(String subjectName);
	List<CityProject> getCityProjectByProjectName(String projectName);
	
	List<CityProject> getCityProjectByRfcSubject(String rfc,String subjectName);
	List<CityProject> getCityProjectByRfcCounty(String rfc,String countyName);
	List<CityProject> getCityProjectByCountySubject(String countyName,String subjectName);
	List<CityProject> getCityProjectByRfcCountySubject(String rfc,String countyName,String subjectName);
}
