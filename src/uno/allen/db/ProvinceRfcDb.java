package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.ProvinceRfcMapper;
import uno.allen.entity.ProvinceRfc;

public class ProvinceRfcDb {
	public static void insertProvinceRfc(ProvinceRfc provinceRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			mapper.insertProvinceRfc(provinceRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteProvinceRfc(String provinceRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			mapper.deleteProvinceRfc(provinceRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<ProvinceRfc> getAllProvinceRfc() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceRfc> list = null;
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			list = mapper.getAllProvinceRfc();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceRfc> getProvinceRfcByRfc(String provinceRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceRfc> list = null;
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			list = mapper.getProvinceRfcByRfc(provinceRfc);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceRfc> getProvinceRfcByCityName(String cityName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceRfc> list = null;
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			list = mapper.getProvinceRfcByCityName(cityName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceRfc> getProvinceRfcBySubjectID(String subjectID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceRfc> list = null;
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			list = mapper.getProvinceRfcBySubjectID(subjectID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceRfc> getProvinceRfcBySubjectName(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceRfc> list = null;
		try {
			ProvinceRfcMapper mapper = session.getMapper(ProvinceRfcMapper.class);
			list = mapper.getProvinceRfcBySubjectName(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
