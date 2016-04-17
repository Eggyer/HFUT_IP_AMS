package service;

import java.util.List;

import dao.TeacherDao;
import user.Assistant;
import user.Course;
import user.CtTime;
import user.Grade;
import user.GradeInfo;
import user.StGrade;
import user.Student;
import user.Teacher;
import user.Time;
import user.crCtTime;

public class TeacherService {
    private TeacherDao tcd = new TeacherDao();
	public Teacher login(Teacher tcform) {
		return tcd.login(tcform);
	}
	public void changeInfo(Teacher tc) {
        tcd.changeInfo(tc);		
	}
	public void changePassword(Teacher tc) {
        tcd.changePassword(tc);		
	}
	public List<Course> queryCourse(Course course) {
		return tcd.queryCourse(course);
	}
	public void addCtTime(CtTime ctTime) {
        tcd.addCtTime(ctTime);		
	}
	public List<CtTime> queryCtTime(CtTime ctTime) {
		return tcd.queryCtTime(ctTime);
	}
	public List<crCtTime> queryCrCtTime(CtTime ctTime) {
		return tcd.queryCrCtTime(ctTime);
	}
	public void delCtTime(CtTime ctTime) {
        tcd.delCtTime(ctTime);		
	}
	public List<GradeInfo> queryGrade(Grade grade) {
		return tcd.queryGrade(grade);
	}
	public List<Student> queryStudent(Student st) {
		return tcd.queryStudent(st);
	}
	public void addGrade(Grade grade) {
        tcd.addGrade(grade);		
	}
	public void changeGrade(Grade grade) {
        tcd.changeGrade(grade);		
	}
	public List<Time> queryTime(CtTime ctTime) {
		return tcd.queryTime(ctTime);
	}
	public List<StGrade> queryStGrade(StGrade stGrade) {
		return tcd.queryStGrade(stGrade);
	}
	public Assistant queryAssistant(String stClass) {
		return tcd.queryAssistant(stClass);
	}

}
