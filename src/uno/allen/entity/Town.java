package uno.allen.entity;

public class Town {
	private int County_FK;
	private int Town_ID;
	private String Town_Name;
	public int getCounty_FK() {
		return County_FK;
	}
	public void setCounty_FK(int county_FK) {
		County_FK = county_FK;
	}
	public int getTown_ID() {
		return Town_ID;
	}
	public void setTown_ID(int town_ID) {
		Town_ID = town_ID;
	}
	public String getTown_Name() {
		return Town_Name;
	}
	public void setTown_Name(String town_Name) {
		Town_Name = town_Name;
	}
	
	public String toString(){
		String reString = "TownID="+Town_ID+"TownName"+Town_Name;
		return reString;
	}
}
