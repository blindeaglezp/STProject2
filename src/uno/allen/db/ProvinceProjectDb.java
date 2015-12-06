package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.ProvinceProjectMapper;
import uno.allen.entity.ProvinceProject;

public class ProvinceProjectDb {
	public static void insertProvinceProject(ProvinceProject provinceProject) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			mapper.insertProvinceProject(provinceProject);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteProvinceProject(String projectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			mapper.deleteProvinceProject(projectName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void updateProvinceProject(ProvinceProject project) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			mapper.updateProvinceProject(project);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<ProvinceProject> getAllProvinceProject() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getAllProvinceProject();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByRfc(String provinceRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByRfc(provinceRfc);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectBySubjectName(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectBySubjectName(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByProjectName(String projectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByProjectName(projectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByCityName(String cityName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByCityName(cityName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByRfcCityName(String rfc,String cityName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByRfcCityName( rfc, cityName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByRfcSubject(String rfc,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByRfcSubject( rfc, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByCityNameSubject(String cityName,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByCityNameSubject( cityName, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<ProvinceProject> getProvinceProjectByRfcCityNameSubject(String rfc,String cityName,String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<ProvinceProject> list = null;
		try {
			ProvinceProjectMapper mapper = session.getMapper(ProvinceProjectMapper.class);
			list = mapper.getProvinceProjectByRfcCityNameSubject( rfc, cityName, subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
