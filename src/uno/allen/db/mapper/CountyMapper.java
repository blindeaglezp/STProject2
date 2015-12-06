package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.County;

public interface CountyMapper {
	void insertCounty(County county);
	List<County> getAllCountyByCityID(int cityID);
	List<County> getAllCountyByCountyID(int countyID);
	List<County> getAllCountyByCountyName(String countyName);
	List<County> getAllCounty();
	void deleteCounty(String countyName);
}
