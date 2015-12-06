package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.User;

public interface UserMapper {
	void insertUser(User user);
	void deleteUser(String userName);
	List<User> getUserByUserName(String userName);
	List<User> getUserByCityName(String cityName);
	List<User> getUserByCountyName(String countyName);
	List<User> getUserByUserLevel(String userLevel);
	List<User> getAllUser();
}
