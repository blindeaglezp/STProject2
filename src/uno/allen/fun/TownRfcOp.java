package uno.allen.fun;

import uno.allen.db.TownRfcDb;
import uno.allen.entity.TownRfc;

public class TownRfcOp {
	public static void insertTownRfc(TownRfc townRfc){
		TownRfcDb.insertTownRfc(townRfc);
	}
}
