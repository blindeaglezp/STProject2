package uno.allen.fun;

import java.util.List;
import uno.allen.db.UserDb;
import uno.allen.entity.User;

public class UserOp {
	public static void insertUser(User user){
		UserDb.insertUser(user);
	}
	public static List<User> getUserByUserName(String userName){
		return UserDb.getUserByUserName(userName);
	}
	public static List<User> getUserByCityName(String cityName){
		return UserDb.getUserByCityName(cityName);
	}
	public static List<User> getUserByCountyName(String countyName){
		return UserDb.getUserByCountyName(countyName);
	}
	public static List<User> getUserByUserLevel(String userLevel){
		return UserDb.getUserByUserLevel(userLevel);
	}
	public static List<User> getAllUser(){
		return UserDb.getAllUser();
	}
	public static void deleteUser(String userName){
		UserDb.deleteUser(userName);
	}
}
