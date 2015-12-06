package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import uno.allen.db.mapper.SubjectMapper;
import uno.allen.entity.Subject;

public class SubjectDb {
	public static void insertSubject(Subject subject) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			mapper.insertSubject(subject);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteSubject(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			mapper.deleteSubject(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<Subject> getAllSubject() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getAllSubject();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<Subject> getSubjectByName(String subjectName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getSubjectByName(subjectName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<Subject> getSubjectByID(String ID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getSubjectByID(ID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<Subject> getSubjectByClass(String sbjClass) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getSubjectByClass(sbjClass);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<Subject> getSubjectByRegulation(String sbjRegulation) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getSubjectByRegulation(sbjRegulation);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<Subject> getSubjectByItem(String sbjItem) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Subject> list = null;
		try {
			SubjectMapper mapper = session.getMapper(SubjectMapper.class);
			list = mapper.getSubjectByItem(sbjItem);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
