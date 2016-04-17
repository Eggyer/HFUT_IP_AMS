package dao;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import daohelp.student.absent_info;
import daohelp.student.course_info;
import daohelp.student.grade_info;
import user.Student;

public class StudentDao {
    private QueryRunner qr = new TxQueryRunner();
	public Student login(Student stform) {
		String sql = "SELECT * FROM student WHERE stID=? AND stPassword=?";
    	Object []params={stform.getStID(),stform.getStPassword()};
    	Student st = null;
		try {
			st = qr.query(sql, new BeanHandler<Student>(Student.class),params);
		} catch (SQLException e) {
			throw new RuntimeException("检查学生账号密码出错了");
		}
    	return st;
	}
	public void modify_password(Student student)
	{
		String sql = "update student set stPassword = ? where stID = ?";
		Object [] params = {student.getStPassword(),student.getStID()};
		try
		{
			qr.update(sql,params);
		} catch (SQLException e)
		{
			throw new RuntimeException("修改密码，dao操作出现异常");
		}
	}
	public void edit_info(Student student)
	{
		String sql = "update student set stEmail = ? where stID = ?";
		Object [] params = {student.getStEmail(),student.getStID()};
		try
		{
			qr.update(sql,params);
		} catch (SQLException e)
		{
			throw new RuntimeException("修改个人信息，dao操作出现异常");
		}
	}
	public List<absent_info> query_absent_info(Student student)
	{
		String sql = " select courseName as cname , absent , term "
				+ " from grade "
				+ " where grade.studentID = ? "
				+ " and absent > 0 ";
		System.out.println(student);
		Object [] params = {student.getStID()};
		try
		{
			return qr.query(sql, new BeanListHandler<absent_info>(absent_info.class),params);
		} catch (SQLException e)
		{
			throw new RuntimeException("查询absent_info dao 操作异常");
		}
	}
	public List<grade_info> query_grade_info(Student student)
	{
		String sql = " SELECT "
					+" grade.courseName AS course_name , "
					+" grade.absent AS absent, "
					+" grade.ordinary AS ordinary, "
					+" grade.exam AS exam, "
					+" grade.total AS total, "
					+" grade.term AS term, "
					+" course.crCredit AS credit, "
					+" course.crAttribute AS attribute "
					+" FROM grade,course "
					+" WHERE grade.courseID = course.crID "
					+ "AND total <> 0 "
					+ "AND grade.studentID = ?";
		Object [] params = {student.getStID()};
		try
		{
			return qr.query(sql,new BeanListHandler<grade_info>(grade_info.class),params);
		} catch (SQLException e)
		{
			throw new RuntimeException("查询失败，dao操作出现异常");
		}
	}
	public List<course_info> query_course_info(Student student)
	{
		String sql = "SELECT "
					+"grade.courseName AS course_name, "
					+"grade.courseClass AS course_class, "
					+"cttime.term AS term, "
					+"cttime.`week` AS 'week', "
					+"cttime.time AS time "
					+"FROM grade,cttime "
					+"WHERE  "
					+"grade.courseID = cttime.courseID "
					+"AND grade.teacherID = cttime.teacherID "
					+"AND grade.term = cttime.term "
					+"AND grade.courseClass = cttime.courseClass "
					+"AND grade.studentID = ?";
		Object [] params = {student.getStID()};
		List<course_info> list = null;
			try {
				 list = qr.query(sql,new BeanListHandler<course_info>(course_info.class),params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		
	}

}

