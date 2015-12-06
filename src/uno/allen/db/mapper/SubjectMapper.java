package uno.allen.db.mapper;

import java.util.List;
import uno.allen.entity.Subject;
public interface SubjectMapper {
	void insertSubject(uno.allen.entity.Subject subject);
	void deleteSubject(String subjectName);
	List<Subject> getSubjectByName(String subjectName);
	List<Subject> getSubjectByID(String ID);
	List<Subject> getAllSubject();
	List<Subject> getSubjectByClass(String sbjClass);
	List<Subject> getSubjectByRegulation(String sbjRegulation);
	List<Subject> getSubjectByItem(String sbjItem);
	
}
