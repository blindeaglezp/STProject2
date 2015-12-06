package uno.allen.db.mapper;

import java.util.List;

import uno.allen.entity.ProvinceRfc;

public interface ProvinceRfcMapper {
	void insertProvinceRfc(ProvinceRfc provinceRfc);
	List<ProvinceRfc> getAllProvinceRfc();
	List<ProvinceRfc> getProvinceRfcByRfc(String provinceRfc);
	List<ProvinceRfc> getProvinceRfcByCityName(String cityName);
	List<ProvinceRfc> getProvinceRfcBySubjectID(String subjectID);
	List<ProvinceRfc> getProvinceRfcBySubjectName(String subjectName);
	void deleteProvinceRfc(String provinceRfc);
}
