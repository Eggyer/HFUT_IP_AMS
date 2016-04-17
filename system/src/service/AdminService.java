package service;

import java.util.List;

import dao.AdminDao;
import user.AcLinker;
import user.Admin;
import user.Assistant;
import user.Course;
import user.Student;
import user.Teacher;

public class AdminService {
    private AdminDao add = new AdminDao();
	public Admin login(Admin adform) {
		return add.login(adform);
	}
	public void addCourse(Course course) {
		add.addCourse(course); 
	}
	public List<Course> queryCourse(Course course) {
		return add.queryCourse(course);
	}
	public List<Student> queryStudent(Student st) {
		return add.queryStudent(st);
	}
	public void addStudent(Student st) {
		add.addStudent(st);
	}
	public List<Teacher> queryTeacher(Teacher tc) {
		return add.queryTeacher(tc);
	}
	public void addTeacher(Teacher tc) {
		add.addTeacher(tc);
	}
	public void editCourse(Course course) {
        add.editCourse(course);		
	}
	public void delCourse(Course course) {
        add.delCourse(course);		
	}
	public void editStudent(Student st) {
        add.editStudent(st);		
	}
	public void delStudent(Student st) {
        add.delStudent(st);		
	}
	public void delTeacher(Teacher tc) {
        add.delTeacher(tc);		
	}
	public void editTeacher(Teacher tc) {
		add.editTeacher(tc);
	}
	public List<Assistant> queryAssistant(Assistant as) {
		return add.queryAssistant(as);
	}
	public void delAssistant(Assistant as) {
        add.delAssistant(as);		
	}
	public void editAssistant(Assistant as) {
        add.editAssistant(as);		
	}
	public void addAssistant(Assistant as) {
        add.addAssistant(as);		
	}
	public void addAcLinker(AcLinker acLinker) {
		add.addAcLinker(acLinker);
	}
	public List<AcLinker> queryAcLinker() {
		return add.queryAcLinker();
	}
	public List<AcLinker> queryAcLinkernull() {
		return add.queryAcLinkernull();
	}
	public void editAcLinker(AcLinker acLinker) {
        add.editAclinker(acLinker);		
	}
	public List<AcLinker> queryAcLinker(AcLinker acLinker) {
		return add.queryAcLinker(acLinker);
	}

}
