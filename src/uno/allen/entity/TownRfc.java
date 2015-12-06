package uno.allen.entity;

public class TownRfc {
	private int Town_FK_RFC;
	private String Town_RFC;
	private String SBJ_ID_TFK;
	private String SBJ_Name_TFK;
	public int getTown_FK_RFC() {
		return Town_FK_RFC;
	}
	public void setTown_FK_RFC(int town_FK_RFC) {
		Town_FK_RFC = town_FK_RFC;
	}
	public String getTown_RFC() {
		return Town_RFC;
	}
	public void setTown_RFC(String town_RFC) {
		Town_RFC = town_RFC;
	}
	public String getSBJ_ID_TFK() {
		return SBJ_ID_TFK;
	}
	public void setSBJ_ID_TFK(String sBJ_ID_TFK) {
		SBJ_ID_TFK = sBJ_ID_TFK;
	}
	public String getSBJ_Name_TFK() {
		return SBJ_Name_TFK;
	}
	public void setSBJ_Name_TFK(String sBJ_Name_TFK) {
		SBJ_Name_TFK = sBJ_Name_TFK;
	}
	@Override
	public String toString() {
		return "TownRfc [Town_FK_RFC=" + Town_FK_RFC + ", Town_RFC=" + Town_RFC + ", SBJ_ID_TFK=" + SBJ_ID_TFK
				+ ", SBJ_Name_TFK=" + SBJ_Name_TFK + "]";
	}
	
	
}
