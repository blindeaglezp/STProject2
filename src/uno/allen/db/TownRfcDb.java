package uno.allen.db;

import org.apache.ibatis.session.SqlSession;

import uno.allen.db.mapper.TownRfcMapper;
import uno.allen.entity.TownRfc;

public class TownRfcDb {
	public static void insertTownRfc(TownRfc townRfc) {
		SqlSession session = DbTools.SQL_SESSION_FACTORY.openSession();
		try {
			TownRfcMapper mapper = session.getMapper(TownRfcMapper.class);
			mapper.insertTownRfc(townRfc);
			session.commit();
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			session.close();
		}
	}
}
