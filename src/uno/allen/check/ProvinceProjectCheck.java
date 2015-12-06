package uno.allen.check;

import java.util.List;

import uno.allen.entity.ProvinceProject;
import uno.allen.fun.ProvinceProjectOp;

public class ProvinceProjectCheck {
	public boolean ProvinceProjectCheck(ProvinceProject project){
		List<ProvinceProject> projectByProjectName = ProvinceProjectOp.getProvinceProjectByProjectName(project.getProject_Name());
		List<ProvinceProject> projectByProvinceRfc = ProvinceProjectOp.getProvinceProjectByRfc(project.getProvince_RFC_PPFK());
		if (projectByProjectName == null && projectByProvinceRfc == null) {
			return true;
		}else {
			return false;
		}
	}
}
