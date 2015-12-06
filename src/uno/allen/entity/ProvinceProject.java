package uno.allen.entity;


public class ProvinceProject {
	private String Province_RFC_PPFK;
	private String City_Name_PPFK;
	private String Subject_PPFK;
	private String Project_Name;
	private int Total_Budget;
	private int Centre_Budget;
	private int Province_Budget;
	private String City_Local_RFC_PPFK;
	private int City_Local_Budget;
	private int City_Local_Cost;
	private int City_Local_Percent;
	private String County_RFC_PPFK;
	private int County_Budget;
	private int County_Cost;
	private int County_Percent;
	public String getProvince_RFC_PPFK() {
		return Province_RFC_PPFK;
	}
	public void setProvince_RFC_PPFK(String province_RFC_PPFK) {
		Province_RFC_PPFK = province_RFC_PPFK;
	}
	public String getCity_Name_PPFK() {
		return City_Name_PPFK;
	}
	public void setCity_Name_PPFK(String city_Name_PPFK) {
		City_Name_PPFK = city_Name_PPFK;
	}
	public String getSubject_PPFK() {
		return Subject_PPFK;
	}
	public void setSubject_PPFK(String subject_PPFK) {
		Subject_PPFK = subject_PPFK;
	}
	public String getProject_Name() {
		return Project_Name;
	}
	public void setProject_Name(String project_Name) {
		Project_Name = project_Name;
	}
	public int getTotal_Budget() {
		return Total_Budget;
	}
	public void setTotal_Budget(int total_Budget) {
		Total_Budget = total_Budget;
	}
	public int getCentre_Budget() {
		return Centre_Budget;
	}
	public void setCentre_Budget(int centre_Budget) {
		Centre_Budget = centre_Budget;
	}
	public int getProvince_Budget() {
		return Province_Budget;
	}
	public void setProvince_Budget(int province_Budget) {
		Province_Budget = province_Budget;
	}
	public String getCity_Local_RFC_PPFK() {
		return City_Local_RFC_PPFK;
	}
	public void setCity_Local_RFC_PPFK(String city_Local_RFC_PPFK) {
		City_Local_RFC_PPFK = city_Local_RFC_PPFK;
	}
	public int getCity_Local_Budget() {
		return City_Local_Budget;
	}
	public void setCity_Local_Budget(int city_Local_Budget) {
		City_Local_Budget = city_Local_Budget;
	}
	public int getCity_Local_Cost() {
		return City_Local_Cost;
	}
	public void setCity_Local_Cost(int city_Local_Cost) {
		City_Local_Cost = city_Local_Cost;
	}
	public int getCity_Local_Percent() {
		return City_Local_Percent;
	}
	public void setCity_Local_Percent(int city_Local_Percent) {
		City_Local_Percent = city_Local_Percent;
	}
	public String getCounty_RFC_PPFK() {
		return County_RFC_PPFK;
	}
	public void setCounty_RFC_PPFK(String county_RFC_PPFK) {
		County_RFC_PPFK = county_RFC_PPFK;
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
	@Override
	public String toString() {
		return "ProvinceProject [Province_RFC_PPFK=" + Province_RFC_PPFK + ", City_Name_PPFK=" + City_Name_PPFK
				+ ", Subject_PPFK=" + Subject_PPFK + ", Project_Name=" + Project_Name + ", Total_Budget=" + Total_Budget
				+ ", Centre_Budget=" + Centre_Budget + ", Province_Budget=" + Province_Budget + ", City_Local_RFC_PPFK="
				+ City_Local_RFC_PPFK + ", City_Local_Budget=" + City_Local_Budget + ", City_Local_Cost="
				+ City_Local_Cost + ", City_Local_Percent=" + City_Local_Percent + ", County_RFC_PPFK="
				+ County_RFC_PPFK + ", County_Budget=" + County_Budget + ", County_Cost=" + County_Cost
				+ ", County_Percent=" + County_Percent + "]";
	}
	
	
}
