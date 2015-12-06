package uno.allen.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.CityMapper;
import uno.allen.db.mapper.TownMapper;
import uno.allen.entity.City;
import uno.allen.entity.Town;

public class TownDb {
	public static void insertTown(Town town) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			TownMapper mapper = session.getMapper(TownMapper.class);
			mapper.insertTown(town);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	public static void deleteTown(String townName) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			TownMapper mapper = session.getMapper(TownMapper.class);
			mapper.deleteTown(townName);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
	
	public static List<Town> getTownByCountyID(int ID) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		List<Town> list = null;
		try {
			TownMapper mapper = session.getMapper(TownMapper.class);
			list = mapper.getTownByCountyID(ID);
			session.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return list;
	}
}
