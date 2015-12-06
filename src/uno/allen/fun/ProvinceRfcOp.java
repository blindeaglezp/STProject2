package uno.allen.fun;

import java.util.List;

import uno.allen.db.ProvinceRfcDb;
import uno.allen.entity.ProvinceRfc;

public class ProvinceRfcOp {
	public static void insertProvinceRfc(ProvinceRfc provinceRfc){
		ProvinceRfcDb.insertProvinceRfc(provinceRfc);
	}
	public static List<ProvinceRfc> getAllProvinceRfc(){
		return ProvinceRfcDb.getAllProvinceRfc();
	}
	public static List<ProvinceRfc> getProvinceRfcByRfc(String provinceRfc){
		return ProvinceRfcDb.getProvinceRfcByRfc(provinceRfc);
	}
	public static List<ProvinceRfc> getProvinceRfcByCityName(String cityName){
		return ProvinceRfcDb.getProvinceRfcByCityName(cityName);
	}
	public static List<ProvinceRfc> getProvinceRfcBySubjectID(String subjectID){
		return ProvinceRfcDb.getProvinceRfcBySubjectID(subjectID);
	}
	public static List<ProvinceRfc> getProvinceRfcBySubjectName(String subjectName){
		return ProvinceRfcDb.getProvinceRfcBySubjectName(subjectName);
	}
	public static void deleteProvinceRfc(String provinceRfc){
		ProvinceRfcDb.deleteProvinceRfc(provinceRfc);
	}
}
