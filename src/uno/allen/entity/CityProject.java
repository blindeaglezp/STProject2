package uno.allen.entity;

public class CityProject {
	private String City_RFC_CPFK;
	private String County_name_CPFK;
	private String Subject_Name_CPFK;
	private String Project_Name;
	private int Total_Budget;
	private String County_Local_RFC_CPFK;
	private int County_Budget;
	private int County_Cost;
	private int County_Percent;
	private String Town_RFC_CPFK;
	private int Town_Budget;
	private int Town_cost;
	private int Town_percent;
	public String getCity_RFC_CPFK() {
		return City_RFC_CPFK;
	}
	public void setCity_RFC_CPFK(String city_RFC_CPFK) {
		City_RFC_CPFK = city_RFC_CPFK;
	}
	public String getCounty_name_CPFK() {
		return County_name_CPFK;
	}
	public void setCounty_name_CPFK(String county_name_CPFK) {
		County_name_CPFK = county_name_CPFK;
	}
	public String getSubject_Name_CPFK() {
		return Subject_Name_CPFK;
	}
	public void setSubject_Name_CPFK(String subject_Name_CPFK) {
		Subject_Name_CPFK = subject_Name_CPFK;
	}
	public String getProject_Name() {
		return Project_Name;
	}
	public void setProjec_Name(String project_Name) {
		Project_Name = project_Name;
	}
	public int getTotal_Budget() {
		return Total_Budget;
	}
	public void setTotal_Budget(int total_Budget) {
		Total_Budget = total_Budget;
	}
	public String getCounty_Local_RFC_CPFK() {
		return County_Local_RFC_CPFK;
	}
	public void setCounty_Local_RFC_CPFK(String county_Local_RFC_CPFK) {
		County_Local_RFC_CPFK = county_Local_RFC_CPFK;
	}
	public int getCounty_Budget() {
		return County_Budget;
	}
	public void setCounty_Budget(int county_Budget) {
		County_Budget = county_Budget;
	}
	public int getCounty_Cost() {
		return County_Cost;
	}
	public void setCounty_Cost(int county_Cost) {
		County_Cost = county_Cost;
	}
	public int getCounty_Percent() {
		return County_Percent;
	}
	public void setCounty_Percent(int county_Percent) {
		County_Percent = county_Percent;
	}
	public String getTown_RFC_CPFK() {
		return Town_RFC_CPFK;
	}
	public void setTown_RFC_CPFK(String town_RFC_CPFK) {
		Town_RFC_CPFK = town_RFC_CPFK;
	}
	public int getTown_Budget() {
		return Town_Budget;
	}
	public void setTown_Budget(int town_Budget) {
		Town_Budget = town_Budget;
	}
	public int getTown_cost() {
		return Town_cost;
	}
	public void setTown_cost(int town_cost) {
		Town_cost = town_cost;
	}
	public int getTown_percent() {
		return Town_percent;
	}
	public void setTown_percent(int town_percent) {
		Town_percent = town_percent;
	}
	@Override
	public String toString() {
		return "CityProject [City_RFC_CPFK=" + City_RFC_CPFK + ", County_name_CPFK=" + County_name_CPFK
				+ ", Subject_Name_CPFK=" + Subject_Name_CPFK + ", Project_Name=" + Project_Name + ", Total_Budget="
				+ Total_Budget + ", County_Local_RFC_CPFK=" + County_Local_RFC_CPFK + ", County_Budget=" + County_Budget
				+ ", County_Cost=" + County_Cost + ", County_Percent=" + County_Percent + ", Town_RFC_CPFK="
				+ Town_RFC_CPFK + ", Town_Budget=" + Town_Budget + ", Town_cost=" + Town_cost + ", Town_percent="
				+ Town_percent + "]";
	}
	
	
}
