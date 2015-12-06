package uno.allen.db.mapper;

import java.util.List;

import uno.allen.entity.CountyRfc;

public interface CountyRfcMapper {
	void insertCountyRfc(CountyRfc countyRfc);
	void deleteCountyRfc(String countyRfc);
	List<CountyRfc> getCountyRfcByRfc(String countyRfc);
	List<CountyRfc> getCountyRfcByCountyID(int countyID);
	List<CountyRfc> getCountyRfcBySubjectID(String subjectID);
	List<CountyRfc> getCountyRfcBySubjectName(String subjectName);
}
