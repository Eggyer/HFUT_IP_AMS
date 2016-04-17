package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import user.AcLinker;
import user.Admin;
import user.Assistant;
import user.Course;
import user.Student;
import user.Teacher;

public class AdminDao {
    private QueryRunner qr = new TxQueryRunner();
	public Admin login(Admin adform) {
		String sql = "SELECT * FROM admin WHERE adID=? AND adPassword=?";
    	Object []params={adform.getAdID(),adform.getAdPassword()};
    	Admin ad = null;
		try {
			ad = qr.query(sql, new BeanHandler<Admin>(Admin.class),params);
		} catch (SQLException e) {
			throw new RuntimeException("检查学生账号密码出错了");
		}
    	return ad;
	}
	public void addCourse(Course course) {
		String sql = "insert into course values(?,?,?,?)";
		Object []params = {course.getCrID(),course.getCrName(),course.getCrAttribute(),course.getCrCredit()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException("添加错误");
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
		sql+=" order by stID asc";
		List<Student> stl = null;
		try {
			stl = qr.query(sql,new BeanListHandler<Student>(Student.class),params.toArray());
		} catch (SQLException e) {
			throw new RuntimeException("查询错误");
		}
		return stl;
	}
	public void addStudent(Student st) {
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		Object []params = {st.getStID(),st.getStPassword(),st.getStName(),st.getStClass(),st.getStEmail(),st.getStCollege(),st.getStCourseAbsentTotal(),st.getStExerciseAbsentTotal()};
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException("添加错误");
		}

	}
	public List<Teacher> queryTeacher(Teacher tc) {
		String sql = "select * from teacher where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(tc.getTcID()!=null && !tc.getTcID().trim().isEmpty())
		{
			sql += " and tcID=?";
			params.add(tc.getTcID());
		}
		if(tc.getTcName()!=null && !tc.getTcName().trim().isEmpty())
		{
			sql += " and tcName=?";
			params.add(tc.getTcName());
		}
		if(tc.getTcCollege()!=null && !tc.getTcCollege().trim().isEmpty())
		{
			sql += " and tcCollege=?";
			params.add(tc.getTcCollege());
		}
		List<Teacher> tcList = null;
		sql+=" order by tcID asc ";
		try {
			tcList = qr.query(sql, new BeanListHandler<Teacher>(Teacher.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tcList;
	}
	public void addTeacher(Teacher tc) {
        String sql = "insert into teacher values(?,?,?,?,?)";
        Object []params = {tc.getTcID(),tc.getTcPassword(),tc.getTcName(),tc.getTcCollege(),tc.getTcEmail()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editCourse(Course course) {
        String sql = "update course set crName=?,crAttribute=?,crCredit=? where crID=? ";
        Object []params = {course.getCrName(),course.getCrAttribute(),course.getCrCredit(),course.getCrID()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delCourse(Course course) {
        String sql = "delete from course where crID=?";
        Object param = course.getCrID();
        try {
			qr.update(sql,param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editStudent(Student st) {
        String sql = "update student set stName=?,stClass=?,stCollege=? where stID=? ";
        Object []params = {st.getStName(),st.getStClass(),st.getStCollege(),st.getStID()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delStudent(Student st) {
        String sql = "delete from student where stID=?";
        Object param = st.getStID();
        try {
			qr.update(sql,param);
		} catch (SQLException e) {
			throw new RuntimeException("删除出错");
		}
	}
	public void delTeacher(Teacher tc) {
        String sql = "delete from teacher where tcID=?";
        Object param = tc.getTcID();
        try {
			qr.update(sql,param);
		} catch (SQLException e) {
			throw new RuntimeException("删除出错");
		}
	}
	public void editTeacher(Teacher tc) {
        String sql = "update teacher set tcName=?,tcCollege=? where tcID=? ";
        Object []params = {tc.getTcName(),tc.getTcCollege(),tc.getTcID()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public List<Assistant> queryAssistant(Assistant as) {
		String sql = "select * from assistant where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(as.getAsID()!=null && !as.getAsID().trim().isEmpty())
		{
			sql += " and asID=?";
			params.add(as.getAsID());
		}
		if(as.getAsName()!=null && !as.getAsName().trim().isEmpty())
		{
			sql += " and asName=?";
			params.add(as.getAsName());
		}
		if(as.getAsCollege()!=null && !as.getAsCollege().trim().isEmpty())
		{
			sql += " and asCollege=?";
			params.add(as.getAsCollege());
		}
		sql+=" order by asID asc";
		List<Assistant> asList = null;
		try {
			asList = qr.query(sql, new BeanListHandler<Assistant>(Assistant.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asList;
	}
	public void delAssistant(Assistant as) {
        String sql = "delete from assistant where asID=?";
        Object param = as.getAsID();
        try {
			qr.update(sql,param);
		} catch (SQLException e) {
			throw new RuntimeException("删除出错");
		}
	}
	public void editAssistant(Assistant as) {
        String sql = "update assistant set asName=?,asCollege=? where asID=? ";
        Object []params = {as.getAsName(),as.getAsCollege(),as.getAsID()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void addAssistant(Assistant as) {
        String sql = "insert into assistant values(?,?,?,?,?)";
        Object []params = {as.getAsID(),as.getAsPassword(),as.getAsName(),as.getAsCollege(),as.getAsEmail()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void addAcLinker(AcLinker acLinker) {
        String sql = "insert into aclinker values(?,?)";
        Object []params = {acLinker.getAssistantID(),acLinker.getStClass()};
        try {
			qr.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<AcLinker> queryAcLinker() {
		String sql = "select * from aclinker order by stClass asc";
		List<AcLinker> acLinkers = null;
		try {
			acLinkers = qr.query(sql, new BeanListHandler<AcLinker>(AcLinker.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acLinkers;
	}
	public List<AcLinker> queryAcLinkernull() {
		String sql = "select * from aclinker where assistantID='null'";
		List<AcLinker> acLinkers = null;
		sql+=" order by stClass asc";
		try {
			acLinkers = qr.query(sql, new BeanListHandler<AcLinker>(AcLinker.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acLinkers;
	}
	public void editAclinker(AcLinker acLinker) {
        String sql = "update aclinker set assistantID=? where stClass=?";
        Object []params = {acLinker.getAssistantID(),acLinker.getStClass()};
        try {
			qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<AcLinker> queryAcLinker(AcLinker acLinker) {
		String sql = "select * from aclinker where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(acLinker.getAssistantID()!=null&&!acLinker.getAssistantID().trim().isEmpty())
		{
		    sql+=" and assistantID=?";
		    params.add(acLinker.getAssistantID());
		}
		if(acLinker.getStClass()!=null&&!acLinker.getStClass().trim().isEmpty())
		{
			sql+=" and stClass=?";
			params.add(acLinker.getStClass());
		}
		sql+=" order by stClass asc";
		List<AcLinker> acLinkers = null;
		try {
			acLinkers = qr.query(sql, new BeanListHandler<AcLinker>(AcLinker.class),params.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acLinkers;
	}
}
