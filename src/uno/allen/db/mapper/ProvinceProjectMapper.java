package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.ProvinceProject;

public interface ProvinceProjectMapper {
	void insertProvinceProject(ProvinceProject provinceProject);
	void deleteProvinceProject(String projectName,String cityName,String provinceRfc);
	List<ProvinceProject> getAllProvinceProject();
	List<ProvinceProject> getProvinceProjectByRfc(String provinceRfc);
	List<ProvinceProject> getProvinceProjectBySubjectName(String subjectName);
	List<ProvinceProject> getProvinceProjectByProjectName(String projectName);
	List<ProvinceProject> getProvinceProjectByCityName(String cityName);
	
	List<ProvinceProject> getProvinceProjectByRfcCityName(String rfc,String cityName);
	List<ProvinceProject> getProvinceProjectByRfcSubject(String rfc,String subjectName);
	List<ProvinceProject> getProvinceProjectByCityNameSubject(String cityName,String subjectName);
	List<ProvinceProject> getProvinceProjectByRfcCityNameSubject(String rfc,String cityName,String subjectName);
	void updateProvinceProject(ProvinceProject project);
}
