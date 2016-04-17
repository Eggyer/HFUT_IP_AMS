package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
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

public class TeacherDao {
    private QueryRunner qr = new TxQueryRunner();
	public Teacher login(Teacher tcform) {
		String sql = "SELECT * FROM teacher WHERE tcID=? AND tcPassword=?";
		Object []params = {tcform.getTcID(),tcform.getTcPassword()};
    	Teacher tc = null;
		try {
			tc = qr.query(sql, new BeanHandler<Teacher>(Teacher.class),params);
		} catch (SQLException e) {
			throw new RuntimeException("检查教师账号密码出错了");
		}
    	return tc;
	}
	public void changeInfo(Teacher tc) {
        String sql = "update teacher set tcEmail=? where tcID=? ";
        Object []params = {tc.getTcEmail(),tc.getTcID()};
        try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void changePassword(Teacher tc) {
        String sql = "update teacher set tcPassword=? where tcID=? ";
        Object []params = {tc.getTcPassword(),tc.getTcID()};
        try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Course> queryCourse(Course course) {
		String sql = "select * from course where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(course.getCrID()!=null && !course.getCrID().trim().isEmpty())
		{
			sql += " and crID=?";
			params.add(course.getCrID());
		}
		if(course.getCrName()!=null && !course.getCrName().trim().isEmpty())
		{
			sql += " and crName=?";
			params.add(course.getCrName());
		}
		if(course.getCrAttribute()!=null && !course.getCrAttribute().trim().isEmpty())
		{
			sql += " and crAttribute=?";
			params.add(course.getCrAttribute());
		}
		if(course.getCrCredit()!=null && !course.getCrCredit().trim().isEmpty())
		{
			sql += " and crCredit=?";
			params.add(course.getCrCredit());
		}
		sql+=" order by crID asc";
		List<Course> crL = null;
		try {
			crL = qr.query(sql,new BeanListHandler<Course>(Course.class),params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException("查询错误");
		}
		return crL;
	}
	public void addCtTime(CtTime ctTime) {
        String sql = "insert into cttime values(?,?,?,?,?,?)";
        Object []params = {ctTime.getCourseID(),ctTime.getTeacherID(),
        		ctTime.getCourseClass(),ctTime.getTerm(),
        		ctTime.getWeek(),ctTime.getTime()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<CtTime> queryCtTime(CtTime ctTime) {
		String sql = "select * from cttime where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(ctTime.getCourseID()!=null&&!ctTime.getCourseID().trim().isEmpty())
		{
			sql+=" and courseID=? ";
			params.add(ctTime.getCourseID());
		}
		if(ctTime.getCourseClass()!=null&&!ctTime.getCourseClass().trim().isEmpty())
		{
			sql+=" and courseClass=?";
			params.add(ctTime.getCourseClass());
		}
		if(ctTime.getTeacherID()!=null&&!ctTime.getTeacherID().trim().isEmpty())
		{
			sql+=" and teacherID=?";
			params.add(ctTime.getTeacherID());
		}
		if(ctTime.getTerm()!=null&&!ctTime.getTerm().trim().isEmpty())
		{
			sql+=" and term=?";
			params.add(ctTime.getTerm());
		}
		if(ctTime.getTime()!=null&&!ctTime.getTime().trim().isEmpty())
		{
			sql+=" and time=?";
			params.add(ctTime.getTime());
		}
		if(ctTime.getWeek()!=null&&!ctTime.getWeek().trim().isEmpty())
		{
			sql+=" and week=?";
			params.add(ctTime.getWeek());
		}
		sql+=" order by courseID asc";
		List<CtTime> ctList = null;
		try {
			ctList=qr.query(sql,new BeanListHandler<CtTime>(CtTime.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ctList;
	}
	public List<crCtTime> queryCrCtTime(CtTime ctTime) {
		String sql = "select courseID,courseClass,crName,crAttribute,crCredit,term FROM cttime,course "
				+ "WHERE cttime.courseID=course.crID";
		List<Object> params = new ArrayList<Object>();
		if(ctTime.getCourseID()!=null&&!ctTime.getCourseID().trim().isEmpty())
		{
			sql+=" and cttime.courseID=? ";
			params.add(ctTime.getCourseID());
		}
		if(ctTime.getCourseClass()!=null&&!ctTime.getCourseClass().trim().isEmpty())
		{
			sql+=" and cttime.courseClass=?";
			params.add(ctTime.getCourseClass());
		}
		if(ctTime.getTeacherID()!=null&&!ctTime.getTeacherID().trim().isEmpty())
		{
			sql+=" and cttime.teacherID=?";
			params.add(ctTime.getTeacherID());
		}
		sql+=" group by courseClass order by cttime.courseID asc";
		List<crCtTime> ctList = null;
		try {
			ctList=qr.query(sql,new BeanListHandler<crCtTime>(crCtTime.class),params.toArray());
		} catch (SQLException e) {
		}
		return ctList;
	}
	public void delCtTime(CtTime ctTime) {
        String sql = "delete from cttime where courseID=? and courseClass=? and teacherID=?";	
        Object []params = {ctTime.getCourseID(),ctTime.getCourseClass(),ctTime.getTeacherID()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<GradeInfo> queryGrade(Grade grade) {
		String sql = "select grade.*,student.stName as studentName from grade,student where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(grade.getCourseID()!=null&&!grade.getCourseID().trim().isEmpty())
		{
			sql+=" and grade.courseID=?";
			params.add(grade.getCourseID());
		}
		if(grade.getCourseClass()!=null&&!grade.getCourseClass().trim().isEmpty())
		{
			sql+=" and grade.courseClass=?";
			params.add(grade.getCourseClass());
		}
		if(grade.getStudentID()!=null&&!grade.getStudentID().trim().isEmpty())
		{
			sql+=" and grade.studentID=?";
			params.add(grade.getStudentID());
		}
		if(grade.getTeacherID()!=null&&!grade.getTeacherID().trim().isEmpty())
		{
			sql+=" and grade.teacherID=?";
			params.add(grade.getTeacherID());
		}
		if(grade.getCourseName()!=null&&!grade.getCourseName().trim().isEmpty())
		{
			sql+=" and grade.courseName=?";
			params.add(grade.getCourseName());
		}
		sql+=" and grade.studentID=student.stID order by grade.term desc , grade.courseID asc, grade.studentID asc ";
		List<GradeInfo> grList = null;
		try {
			grList = qr.query(sql,new BeanListHandler<GradeInfo>(GradeInfo.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grList;
	}
	public List<Student> queryStudent(Student st) {
		String sql = "select * from student where 1=1";
		List<Object> params = new ArrayList<Object>();
		if(st.getStID()!=null && !st.getStID().trim().isEmpty())
		{
			sql += " and stID=?";
			params.add(st.getStID());
		}
		if(st.getStName()!=null && !st.getStName().trim().isEmpty())
		{
			sql += " and stName=?";
			params.add(st.getStName());
		}
		if(st.getStClass()!=null && !st.getStClass().trim().isEmpty())
		{
			sql += " and stClass=?";
			params.add(st.getStClass());
		}
		if(st.getStCollege()!=null && !st.getStCollege().trim().isEmpty())
		{
			sql += " and stCollege=?";
			params.add(st.getStCollege());
		}
		List<Student> stl = null;
		try {
			stl = qr.query(sql,new BeanListHandler<Student>(Student.class),params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException("查询错误");
		}
		return stl;
	}
	public void addGrade(Grade grade) {
       String sql = "insert into grade values(?,?,?,?,?,?,?,?,?,?)";
       Object []params = {grade.getAbsent(),grade.getCourseID(),grade.getTeacherID(),grade.getTerm(),grade.getCourseClass()
    		   ,grade.getOrdinary(),grade.getExam(),grade.getStudentID(),grade.getCourseName(),grade.getTotal()};
       try {
		qr.update(sql, params);
	} catch (SQLException e) {
		e.printStackTrace();
	}
       
	}
	public void changeGrade(Grade grade) {
       String sql = "update grade set exam=?,ordinary=?,total=? where "
       		+ "courseID=? and courseClass=? and studentID=? and courseName=?";
       Object []params = {grade.getExam(),grade.getOrdinary(),grade.getTotal(),grade.getCourseID()
    		   ,grade.getCourseClass(),grade.getStudentID(),grade.getCourseName()};
       try {
		qr.update(sql, params);
	} catch (SQLException e) {
		e.printStackTrace();
	}
       
	}
	public List<Time> queryTime(CtTime ctTime) {
		String sql = "select courseID,courseClass,crName AS courseName,week,time,term FROM cttime,course "
				+ "WHERE cttime.courseID=course.crID";
		List<Object> params = new ArrayList<Object>();
		if(ctTime.getCourseID()!=null&&!ctTime.getCourseID().trim().isEmpty())
		{
			sql+=" and cttime.courseID=? ";
			params.add(ctTime.getCourseID());
		}
		if(ctTime.getCourseClass()!=null&&!ctTime.getCourseClass().trim().isEmpty())
		{
			sql+=" and cttime.courseClass=?";
			params.add(ctTime.getCourseClass());
		}
		if(ctTime.getTeacherID()!=null&&!ctTime.getTeacherID().trim().isEmpty())
		{
			sql+=" and cttime.teacherID=?";
			params.add(ctTime.getTeacherID());
		}
		List<Time> ctList = null;
		try {
			ctList=qr.query(sql,new BeanListHandler<Time>(Time.class),params.toArray());
		} catch (SQLException e) {
		}
		return ctList;
	}
	public List<StGrade> queryStGrade(StGrade stGrade) {
		String sql = "SELECT teacherID,courseClass,courseID,stID,stName,stClass,stCollege,stCourseAbsentTotal "
				+ "FROM grade,student WHERE grade.studentID=student.stID ";
		List<Object> params = new ArrayList<Object>();
		if(stGrade.getStID()!=null&&!stGrade.getStID().trim().isEmpty())
		{
			sql+=" and stID=?";
			params.add(stGrade.getStID());
		}
		if(stGrade.getStName()!=null&&!stGrade.getStName().trim().isEmpty())
		{
			sql+=" and stName=?";
			params.add(stGrade.getStName());
		}
		if(stGrade.getStClass()!=null&&!stGrade.getStClass().trim().isEmpty())
		{
			sql+=" and stClass=?";
			params.add(stGrade.getStClass());
		}
		if(stGrade.getCourseID()!=null&&!stGrade.getCourseID().trim().isEmpty())
		{
			sql+=" and courseID=?";
			params.add(stGrade.getCourseID());
		}
		if(stGrade.getStCollege()!=null&&!stGrade.getStCollege().trim().isEmpty())
		{
			sql+=" and stCollege=?";
			params.add(stGrade.getStCollege());
		}
		List<StGrade> stList = null;
		try {
			stList = qr.query(sql,new BeanListHandler<StGrade>(StGrade.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stList;
	}
	public Assistant queryAssistant(String stClass) {
		String sql = "SELECT assistant.* FROM assistant,aclinker "
				+ "WHERE assistant.asID=aclinker.assistantID AND "
				+ "aclinker.stClass=? order by assistant.asID asc";
		Assistant as = null;
		try {
			as = qr.query(sql, new BeanHandler<Assistant>(Assistant.class),(Object)stClass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return as;
	}
}

