package uno.allen.entity;

public class CountyRfc {
	private int County_FK_RFC;
	private String County_RFC;
	private String SBJ_ID_CountyFK;
	private String SBJ_Name_CountyFK;
	private String Town_Name;
	public int getCounty_FK_RFC() {
		return County_FK_RFC;
	}
	public void setCounty_FK_RFC(int county_FK_RFC) {
		County_FK_RFC = county_FK_RFC;
	}
	public String getCounty_RFC() {
		return County_RFC;
	}
	public void setCounty_RFC(String county_RFC) {
		County_RFC = county_RFC;
	}
	public String getSBJ_ID_CountyFK() {
		return SBJ_ID_CountyFK;
	}
	public void setSBJ_ID_CountyFK(String sBJ_ID_CountyFK) {
		SBJ_ID_CountyFK = sBJ_ID_CountyFK;
	}
	public String getSBJ_Name_CountyFK() {
		return SBJ_Name_CountyFK;
	}
	public void setSBJ_Name_CountyFK(String sBJ_Name_CountyFK) {
		SBJ_Name_CountyFK = sBJ_Name_CountyFK;
	}
	public String getTown_Name() {
		return Town_Name;
	}
	public void setTown_Name(String town_Name) {
		Town_Name = town_Name;
	}
	@Override
	public String toString() {
		return "CountyRfc [County_FK_RFC=" + County_FK_RFC + ", County_RFC=" + County_RFC + ", SBJ_ID_CountyFK="
				+ SBJ_ID_CountyFK + ", SBJ_Name_CountyFK=" + SBJ_Name_CountyFK + ", Town_Name=" + Town_Name + "]";
	}
	
	
}
