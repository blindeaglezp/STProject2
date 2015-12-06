package uno.allen.fun;

import java.util.List;

import uno.allen.db.TownDb;
import uno.allen.entity.Town;

public class TownOp {
	public static void insertTown(Town town){
		TownDb.insertTown(town);
	}
	public static List<Town> getTownByCountyID(int ID){
		return TownDb.getTownByCountyID(ID);
	}
	public static void deleteTown(String townName){
		TownDb.deleteTown(townName);
	}
}
