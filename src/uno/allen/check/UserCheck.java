package uno.allen.check;

import java.util.List;

import uno.allen.entity.User;
import uno.allen.fun.UserOp;

public class UserCheck {
	public boolean UserCheck(User user){
		String userCity = user.getUser_City_Name();
		String userName = user.getUser_Name();
		List<User> userCityGet = UserOp.getUserByCityName(userCity);
		List<User> userNameGet = UserOp.getUserByUserName(userName);
		if (userCityGet == null && userNameGet == null) {
			return true;
		}else {
			return false;
		}
	}
}
