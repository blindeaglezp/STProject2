package uno.allen.check;

import java.util.List;
import uno.allen.entity.Subject;
import uno.allen.fun.SubjectOp;

public class SubjectCheck {
	public boolean SubjectCheck(Subject subject){
		List<Subject> subjectByID = SubjectOp.getSubjectByID(subject.getSBJ_ID());
		if (subjectByID == null) {
			return true;
		}else {
			return false;
		}
	}
}
