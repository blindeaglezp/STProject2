package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.CountyRfcMapper;
import uno.allen.entity.CountyRfc;

public class CountyRfcDb {
	public static void insertCountyRfc(CountyRfc countyRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			mapper.insertCountyRfc(countyRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteCountyRfc(String countyRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			mapper.deleteCountyRfc(countyRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<CountyRfc> getCountyRfcByRfc(String countyRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CountyRfc> list = null;
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			list = mapper.getCountyRfcByRfc(countyRfc);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CountyRfc> getCountyRfcByCountyID(int countyID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CountyRfc> list = null;
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			list = mapper.getCountyRfcByCountyID(countyID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CountyRfc> getCountyRfcBySubjectID(String subjectID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CountyRfc> list = null;
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			list = mapper.getCountyRfcBySubjectID(subjectID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CountyRfc> getCountyRfcBySubjectName(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CountyRfc> list = null;
		try {
			CountyRfcMapper mapper = session.getMapper(CountyRfcMapper.class);
			list = mapper.getCountyRfcBySubjectName(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
