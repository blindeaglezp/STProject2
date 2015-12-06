package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.CountyMapper;
import uno.allen.entity.County;

public class CountyDb {
	public static void insertCounty(County county) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			mapper.insertCounty(county);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteCounty(String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			mapper.deleteCounty(countyName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<County> getAllCountyByCityID(int cityID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<County> list = null;
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			list = mapper.getAllCountyByCityID(cityID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<County> getAllCountyByCountyID(int countyID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<County> list = null;
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			list = mapper.getAllCountyByCountyID(countyID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<County> getAllCountyByCountyName(String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<County> list = null;
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			list = mapper.getAllCountyByCountyName(countyName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<County> getAllCounty() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<County> list = null;
		try {
			CountyMapper mapper = session.getMapper(CountyMapper.class);
			list = mapper.getAllCounty();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
