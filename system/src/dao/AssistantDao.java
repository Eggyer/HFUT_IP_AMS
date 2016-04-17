package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import daohelp.assistant.CourseInfo;
import daohelp.assistant.StudentAbsentInfo;
import daohelp.assistant.StudentClass;
import daohelp.assistant.StudentGradeInfo;
import daohelp.assistant.UpdateAbsentInfo;
import user.Assistant;
import user.Course;
import user.Student;

public class AssistantDao {
    private QueryRunner qr = new TxQueryRunner();
	public Assistant login(Assistant asform) {
		String sql = "SELECT * FROM assistant WHERE asID=? AND asPassword=?";
		Object []params ={asform.getAsID(),asform.getAsPassword()}; 
    	Assistant as = null;
		try {
			as= qr.query(sql, new BeanHandler<Assistant>(Assistant.class),params);
		} catch (SQLException e) {
			throw new RuntimeException("检查管理账号密码出错了");
		}
    	return as;
	}
	public void modify_password(Assistant assistant)
	{
		String sql = "update assistant set asPassword = ? where "
				+ " asID = ? ";
		
		Object [] params = {assistant.getAsPassword(),assistant.getAsID()};
		
		try
		{
			qr.update(sql,params);
		} catch (SQLException e)
		{
			throw new RuntimeException("修改失败，dao操作异常");
		}
	}
	public void edit_info(Assistant assistant)
	{
		String sql = "update assistant set asEmail = ? where "
				+ " asID = ? ";
		Object [] params = {assistant.getAsEmail(),assistant.getAsID()};
		
		try
		{
			qr.update(sql,params);
		} catch (SQLException e)
		{
			throw new RuntimeException("修改失败，dao操作异常");
		}
	}
	public List<StudentClass> load_choose_class(Assistant assistant)//修改
	{
		String sql = " select aclinker.stClass as student_class "
				+" from aclinker"//+ " from assistant,aclinker "
				+ " where ? = aclinker.assistantID ";
		Object [] params = {assistant.getAsID()};
		try
		{
			return qr.query(sql, new BeanListHandler<StudentClass>(StudentClass.class),params);
		} catch (SQLException e)
		{
			throw new RuntimeException("加载班级信息失败,dao操作异常");
		}
		
	}
	public List<Student> edit_absent_info(String student_class)
	{
		String sql = " select * "
				+ " from student "
				+ " where stClass = ? ";
		Object [] params = {student_class};
		
		try
		{
			return qr.query(sql, new BeanListHandler<Student>(Student.class),params);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	public List<CourseInfo> load_course_info(String studentID)
	{
		String sql = " SELECT "
				+" grade.courseID AS course_id, "
				+ "grade.courseName AS course_name, "
				+" grade.courseClass AS course_class, "
				+" cttime.term AS term, "
				+" cttime.`week` AS 'week', "
				+" cttime.time AS time "
				+" FROM grade,cttime "
				+" WHERE "
				+" grade.courseID = cttime.courseID "
				+" AND grade.teacherID = cttime.teacherID "
				+" AND grade.term = cttime.term "
				+" AND grade.courseClass = cttime.courseClass "
				+" AND grade.studentID=? ";
		Object [] params = {studentID};
		
		try
		{
			return qr.query(sql, new BeanListHandler<CourseInfo>(CourseInfo.class),params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void update_absent_info(List<UpdateAbsentInfo> list)
	{
		try
		{
			if (list.get(0).getCourseID().equalsIgnoreCase("exercise_absent"))
			{
				for (int i = 0; i < list.size(); i++)
				{
					
					String sql = " update student "
							+ " set stExerciseAbsentTotal =  stExerciseAbsentTotal "
							+ list.get(i).getAdd_reduce() +" 1 "
							+ " where stId = ? ";
					Object[] params = {list.get(i).getStudentID()};
					qr.update(sql,params);
				}
			}else {
				for (int i = 0; i < list.size(); i++)
				{
					
					String sql = " update grade "
							+ " set absent =  absent "
							+ list.get(i).getAdd_reduce() +" 1 "
							+ " where studentId = ? "
							+ " and courseID = ? ";
					Object[] params = {list.get(i).getStudentID(),list.get(i).getCourseID()};
					qr.update(sql,params);
				}
				for (int i = 0; i < list.size(); i++)
				{
					
					String sql = " UPDATE student "
							+ " SET student.stCourseAbsentTotal "
							+ " = (SELECT SUM(grade.absent) from grade "
							+ " WHERE grade.studentID = ?) "
							+ " WHERE stID = ? ";
					Object[] params = {list.get(i).getStudentID(),list.get(i).getStudentID()};
					qr.update(sql,params);
				}

			}	
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public List<StudentGradeInfo> query_grade_info(String student_class)
	{
		String sql = " SELECT "
				+" student.stID AS student_id , "
				+" student.stName AS student_name, " 
				+" grade.courseName AS course_name, "
				+" student.stCourseAbsentTotal AS absent_total, "
				+" grade.total AS total, "
				+" grade.term AS term, "
				+" course.crCredit AS credit, "
				+" course.crAttribute AS attribute "
				+" FROM student,grade,course "
				+" WHERE "
				+" student.stClass = ? " 
				+" AND grade.studentID = student.stID "
				+" AND grade.courseID = course.crID ";
		Object [] params = {student_class};
		try
		{
			return qr.query(sql, new BeanListHandler<StudentGradeInfo>(StudentGradeInfo.class),params);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public List<StudentAbsentInfo> query_absent_info(String student_class)
	{
		String sql = " SELECT " 
				+ " student.stID AS student_id, "
				+ " student.stName AS student_name, "
				+ " grade.courseName AS course_name, "
 				+ " grade.absent AS absent, "
				+ " grade.term AS term,"
				+ " student.stCourseAbsentTotal AS absent_total "
				+ " FROM "
				+ " student,grade "
				+ " WHERE "
				+ " student.stClass = ? "
				+ " AND student.stID = grade.studentID ";
		Object [] params = {student_class};
		try
		{
			return qr.query(sql, new BeanListHandler<StudentAbsentInfo>(StudentAbsentInfo.class),params);
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null ;
		}
	}
	public List<Student> query_student_emails(String student_class)
	{
		String sql = "select * from student where student.stClass = ?";
		Object[] params = {student_class};
		try
		{
			return qr.query(sql, new BeanListHandler<Student>(Student.class),params);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Course query_course_by_id(String courseID)
	{
		String sql = "select * from course where course.crID = ?";
		Object[] params = {courseID};
		try
		{
			return qr.query(sql,new BeanHandler<Course>(Course.class),params);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Student query_student(String stID) {
		String sql = "select * from student where stID=?";
		Object param = stID;
		Student student = null;
		try {
			student = qr.query(sql, new BeanHandler<Student>(Student.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

}

