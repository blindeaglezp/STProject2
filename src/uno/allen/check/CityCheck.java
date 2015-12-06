package uno.allen.check;

import uno.allen.entity.City;
import uno.allen.fun.CityOp;

public class CityCheck {
	public boolean CityCheck(City city){
		City byID = CityOp.getCityByID(city.getCityID());
		City byName = CityOp.getCityByName(city.getCityName());
		if (byID== null && byName == null) {
			return true;
		}else{
			return false;
		}
		
	}
}
