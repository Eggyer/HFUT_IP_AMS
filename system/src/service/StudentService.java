package service;
import java.util.List;
import dao.StudentDao;
import daohelp.student.absent_info;
import daohelp.student.course_info;
import daohelp.student.grade_info;
import user.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
	public Student login(Student stform) {
		return studentDao.login(stform);
	}
	public void modify_password(Student student)
	{
		studentDao.modify_password(student);
	}
	public void edit_info(Student student)
	{
		studentDao.edit_info(student);
	}
	public List<absent_info> query_absent_info(Student student)
	{
		
		return studentDao.query_absent_info(student);
	}
	public List<grade_info> query_grade_info(Student student)
	{
		return studentDao.query_grade_info(student);
	}
	public List<course_info> query_course_info(Student student)
	{
		return studentDao.query_course_info(student);
	}

}
