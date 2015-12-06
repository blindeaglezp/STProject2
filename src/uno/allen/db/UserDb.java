package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.UserMapper;
import uno.allen.entity.User;

public class UserDb {
	public static void insertUser(User user) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insertUser(user);;
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteUser(String userName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.deleteUser(userName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static List<User> getUserByUserName(String userName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<User> list = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getUserByUserName(userName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<User> getUserByCityName(String cityName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<User> list = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getUserByCityName(cityName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<User> getUserByCountyName(String countyName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<User> list = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getUserByCountyName(countyName);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<User> getUserByUserLevel(String userLevel) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<User> list = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getUserByUserLevel(userLevel);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
	public static List<User> getAllUser() {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<User> list = null;
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			list = mapper.getAllUser();
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
