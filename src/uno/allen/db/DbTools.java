package uno.allen.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbTools {
	public static final SqlSessionFactory SQL_SESSION_FACTORY = init();

	private static SqlSessionFactory init() {
		String dataSourceConfiguration = "uno/allen/config/Mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources
					.getResourceAsStream(dataSourceConfiguration);
		} catch (IOException e) {
			System.exit(-1);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
}

