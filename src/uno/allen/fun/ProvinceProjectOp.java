package uno.allen.fun;

import java.util.List;
import uno.allen.db.ProvinceProjectDb;
import uno.allen.entity.ProvinceProject;

public class ProvinceProjectOp {
//	����ɾ������
	public static void insertProvinceProject(ProvinceProject provinceProject){
		ProvinceProjectDb.insertProvinceProject(provinceProject);
	}
	public static void deleteProvinceProject(String projectName,String cityName,String provinceRfc){
		ProvinceProjectDb.deleteProvinceProject( projectName, cityName, provinceRfc);
	}
//	��ȡ���ݿ���Ŀ
	public static List<ProvinceProject> getAllProvinceProject(){
		return ProvinceProjectDb.getAllProvinceProject();
	}
	public static List<ProvinceProject> getProvinceProjectByRfc(String provinceRfc){
		return ProvinceProjectDb.getProvinceProjectByRfc(provinceRfc);
	}
	public static List<ProvinceProject> getProvinceProjectBySubjectName(String subjectName){
		return ProvinceProjectDb.getProvinceProjectBySubjectName(subjectName);
	}
	public static List<ProvinceProject> getProvinceProjectByProjectName(String projectName){
		return ProvinceProjectDb.getProvinceProjectByProjectName(projectName);
	}
	public static List<ProvinceProject> getProvinceProjectByCityName(String cityName){
		return ProvinceProjectDb.getProvinceProjectByCityName(cityName);
	}
	public static List<ProvinceProject> getProvinceProjectByRfcCityName(String rfc,String cityName){
		return ProvinceProjectDb.getProvinceProjectByRfcCityName(rfc, cityName);
	}
	public static List<ProvinceProject> getProvinceProjectByRfcSubject(String rfc,String subjectName){
		return ProvinceProjectDb.getProvinceProjectByRfcSubject(rfc, subjectName);
	}
	public static List<ProvinceProject> getProvinceProjectByCityNameSubject(String cityName,String subjectName){
		return ProvinceProjectDb.getProvinceProjectByCityNameSubject(cityName, subjectName);
	}
	public static List<ProvinceProject> getProvinceProjectByRfcCityNameSubject(String rfc,String cityName,String subjectName){
		return ProvinceProjectDb.getProvinceProjectByRfcCityNameSubject(rfc, cityName, subjectName);
	}
	
//	�������ݿ���Ŀ
	public static void updateProvinceProject(ProvinceProject project){
		ProvinceProjectDb.updateProvinceProject(project);
	}
}
