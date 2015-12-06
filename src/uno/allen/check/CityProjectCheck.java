package uno.allen.check;

import java.util.List;

import uno.allen.entity.CityProject;
import uno.allen.fun.CityProjectOp;

public class CityProjectCheck {
	public boolean CityProjectCheck(CityProject cityProject){
		List<CityProject> projectByCityRfc = CityProjectOp.getCityProjectByCityRfc(cityProject.getCity_RFC_CPFK());
		List<CityProject> projectByName = CityProjectOp.getCityProjectByProjectName(cityProject.getProject_Name());
		if (projectByCityRfc == null && projectByName == null) {
			return true;
		}else {
			return false;
		}
	}
}
