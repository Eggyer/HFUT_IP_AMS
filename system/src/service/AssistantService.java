package service;

import java.util.List;

import dao.AssistantDao;
import daohelp.assistant.CourseInfo;
import daohelp.assistant.StudentAbsentInfo;
import daohelp.assistant.StudentClass;
import daohelp.assistant.StudentGradeInfo;
import daohelp.assistant.UpdateAbsentInfo;
import user.Assistant;
import user.Course;
import user.Student;

public class AssistantService {
    private AssistantDao assistantDao = new AssistantDao();
	public Assistant login(Assistant asform) {
		return assistantDao.login(asform);
	}
	public void modify_password(Assistant assistant)
	{
		assistantDao.modify_password(assistant);
	}
	public void edit_info(Assistant assistant)
	{
		assistantDao.edit_info(assistant);
	}
	public List<StudentClass> load_choose_class(Assistant assistant)
	{
		// TODO Auto-generated method stub
		return assistantDao.load_choose_class(assistant);
	}
	public List<Student> edit_absent_info(String student_class)
	{
		// TODO Auto-generated method stub
		return assistantDao.edit_absent_info(student_class);
	}
	public List<CourseInfo> load_course_info(String studentID)
	{
		// TODO Auto-generated method stub
		return assistantDao.load_course_info(studentID);
	}
	public void update_absent_info(List<UpdateAbsentInfo> list)
	{
		assistantDao.update_absent_info(list);
	}
	public List<StudentGradeInfo> query_grade_info(String student_class)
	{
		return assistantDao.query_grade_info(student_class);
	}
	public List<StudentAbsentInfo> query_absent_info(String student_class)
	{
		// TODO Auto-generated method stub
		return assistantDao.query_absent_info(student_class);
	}
	public List<Student> query_student_emails(String student_class)
	{
		// TODO Auto-generated method stub
		return assistantDao.query_student_emails(student_class);
	}
	public Course query_course_by_id(String courseID)
	{
		// TODO Auto-generated method stub
		return assistantDao.query_course_by_id(courseID);
	}
	public Student query_student(String stID) {
		return assistantDao.query_student(stID);
	}

}

