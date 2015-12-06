package uno.allen.check;

import java.util.List;

import uno.allen.entity.County;
import uno.allen.fun.CountyOp;

public class CountyCheck {
	public boolean CountyCheck(County county){
		int cityID = county.getCity_FK();
		String countyName = county.getCounty_Name();
		List<County> countyByCityID = CountyOp.getCountyByCityID(cityID);
		List<County> countyByCountyName = CountyOp.getAllCountyByCountyName(countyName);
		if (countyByCityID == null && countyByCountyName == null) {
			return true;
		}else{
			return false;
		}
	}
}
