package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.CityRfcMapper;
import uno.allen.entity.CityRfc;

public class CityRfcDb {
	public static void insertCityRfc(CityRfc cityRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			mapper.insertCityRfc(cityRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteCityRFC(String cityRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			mapper.deleteCityRFC(cityRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<CityRfc> getCityRfcByCityID(int cityID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityRfc> list = null;
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			list = mapper.getCityRfcByCityID(cityID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityRfc> getCityRfcByCityRfc(String cityRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityRfc> list = null;
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			list = mapper.getCityRfcByCityRfc(cityRfc);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityRfc> getCityRfcByCountyName(String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityRfc> list = null;
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			list = mapper.getCityRfcByCountyName(countyName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityRfc> getCityRfcBySbjID(String sbjID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityRfc> list = null;
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			list = mapper.getCityRfcBySbjID(sbjID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityRfc> getCityRfcBySbjName(String sbjName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityRfc> list = null;
		try {
			CityRfcMapper mapper = session.getMapper(CityRfcMapper.class);
			list = mapper.getCityRfcBySbjName(sbjName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
