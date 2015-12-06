package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.CityRfc;

public interface CityRfcMapper {
	void insertCityRfc(CityRfc cityRfc);
	void deleteCityRFC(String cityRfc);
	List<CityRfc> getCityRfcByCityID(int ID);
	List<CityRfc> getCityRfcByCityRfc(String cityRfc);
	List<CityRfc> getCityRfcByCountyName(String countyName);
	List<CityRfc> getCityRfcBySbjID(String sbjID);
	List<CityRfc> getCityRfcBySbjName(String sbjName);
}
