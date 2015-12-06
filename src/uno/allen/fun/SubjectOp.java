package uno.allen.fun;

import java.util.List;
import uno.allen.db.SubjectDb;
import uno.allen.entity.Subject;

public class SubjectOp {
	public static void insertSubject(Subject subject){
		SubjectDb.insertSubject(subject);
	}
	public static List<Subject> getAllSubject(){
		return SubjectDb.getAllSubject();
	}
	public static List<Subject> getSubjectByID(String ID){
		return SubjectDb.getSubjectByID(ID);
	}
	public static List<Subject> getSubjectByClass(String sbjClass){
		return SubjectDb.getSubjectByClass(sbjClass);
	}
	public static List<Subject> getSubjectByRegulation(String sbjRegulation){
		return SubjectDb.getSubjectByRegulation(sbjRegulation);
	}
	public static List<Subject> getSubjectByItem(String sbjItem){
		return SubjectDb.getSubjectByItem(sbjItem);
	}
	public static void deleteSubject(String subjectName){
		SubjectDb.deleteSubject(subjectName);
	}
	public static List<Subject> getSubjectByName(String subjectName){
		return SubjectDb.getSubjectByName(subjectName);
	}
}
