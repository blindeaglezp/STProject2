package uno.allen.entity;

public class User {
	private String User_City_Name;
	private String User_County_Name;
	private String User_Name;
	private String User_Password;
	private String User_Level;
	public String getUser_City_Name() {
		return User_City_Name;
	}
	public void setUser_City_Name(String user_City_Name) {
		User_City_Name = user_City_Name;
	}
	public String getUser_County_Name() {
		return User_County_Name;
	}
	public void setUser_County_Name(String user_County_Name) {
		User_County_Name = user_County_Name;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getUser_Password() {
		return User_Password;
	}
	public void setUser_Password(String user_Password) {
		User_Password = user_Password;
	}
	public String getUser_Level() {
		return User_Level;
	}
	public void setUser_Level(String user_Level) {
		User_Level = user_Level;
	}
	@Override
	public String toString() {
		return "User [User_City_Name=" + User_City_Name + ", User_County_Name=" + User_County_Name + ", User_Name="
				+ User_Name + ", User_Password=" + User_Password + ", User_Level=" + User_Level + "]";
	}
	
}
