package uno.allen.db.mapper;
import java.util.List;

import uno.allen.entity.City;
public interface CityMapper {
	void insertCity(City city);
	void deleteCity(String cityName);
	List<City> getAllCity();
	City getCityByName(String name);
	City getCityByID(int ID);
}
