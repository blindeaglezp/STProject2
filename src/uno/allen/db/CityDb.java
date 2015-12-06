package uno.allen.db;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import uno.allen.db.mapper.CityMapper;
import uno.allen.entity.City;



public class CityDb {
	public static void insertCity(City city) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityMapper mapper = session.getMapper(CityMapper.class);
			mapper.insertCity(city);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteCity(String cityName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityMapper mapper = session.getMapper(CityMapper.class);
			mapper.deleteCity(cityName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<City> getAllCity() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<City> list = null;
		try {
			CityMapper mapper = session.getMapper(CityMapper.class);
			list = mapper.getAllCity();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	
	public static City getCityByName(String name) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		City city = new City();
		try {
			CityMapper mapper = session.getMapper(CityMapper.class);
			city = mapper.getCityByName(name);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return city;
	}
	public static City getCityByID(int ID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		City city = new City();
		try {
			CityMapper mapper = session.getMapper(CityMapper.class);
			city = mapper.getCityByID(ID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return city;
	}
}
