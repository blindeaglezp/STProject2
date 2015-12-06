package uno.allen.entity;

public class Subject {
	private String SBJ_Class;
	private String SBJ_Regulation;
	private String SBJ_Item;
	private String SBJ_ID;
	private String SBJ_Name;
	public String getSBJ_Class() {
		return SBJ_Class;
	}
	public void setSBJ_Class(String sBJ_Class) {
		SBJ_Class = sBJ_Class;
	}
	public String getSBJ_Regulation() {
		return SBJ_Regulation;
	}
	public void setSBJ_Regulation(String sBJ_Regulation) {
		SBJ_Regulation = sBJ_Regulation;
	}
	public String getSBJ_Item() {
		return SBJ_Item;
	}
	public void setSBJ_Item(String sBJ_Item) {
		SBJ_Item = sBJ_Item;
	}
	public String getSBJ_ID() {
		return SBJ_ID;
	}
	public void setSBJ_ID(String sBJ_ID) {
		SBJ_ID = sBJ_ID;
	}
	public String getSBJ_Name() {
		return SBJ_Name;
	}
	public void setSBJ_Name(String sBJ_Name) {
		SBJ_Name = sBJ_Name;
	}
	@Override
	public String toString() {
		return "Subject [SBJ_Class=" + SBJ_Class + ", SBJ_Regulation=" + SBJ_Regulation + ", SBJ_Item=" + SBJ_Item
				+ ", SBJ_ID=" + SBJ_ID + ", SBJ_Name=" + SBJ_Name + "]";
	}
	
	
}
