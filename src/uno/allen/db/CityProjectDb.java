package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.CityProjectMapper;
import uno.allen.entity.CityProject;

public class CityProjectDb {
	public static void insertCityProject(CityProject cityProject) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			mapper.insertCityProject(cityProject);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteCityProject(String cityRfc,String projectName,String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			mapper.deleteCityProject( cityRfc, projectName, countyName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void updateCityProject(CityProject cityProject) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			mapper.updateCityProject(cityProject);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<CityProject> getAllCityProject() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getAllCityProject();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByCityRfc(String cityRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByCityRfc(cityRfc);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectBySubjectName(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectBySubjectName(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByCountyName(String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByCountyName(countyName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByProjectName(String projectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByProjectName(projectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	
	public static List<CityProject> getCityProjectByRfcSubject(String rfc,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByRfcSubject(rfc, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByRfcCounty(String rfc,String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByRfcCounty( rfc, countyName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByCountySubject(String countyName,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByCountySubject( countyName, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<CityProject> getCityProjectByRfcCountySubject(String rfc,String countyName,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<CityProject> list = null;
		try {
			CityProjectMapper mapper = session.getMapper(CityProjectMapper.class);
			list = mapper.getCityProjectByRfcCountySubject( rfc, countyName, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
