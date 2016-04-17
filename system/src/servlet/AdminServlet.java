package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import user.AcLinker;
import user.Assistant;
import user.Course;
import user.Student;
import user.Teacher;
import cn.itcast.servlet.BaseServlet;

public class AdminServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminService ads = new AdminService();
	public String addCourse(HttpServletRequest request,HttpServletResponse response)
	{
		String courseID = request.getParameter("courseID");
		String courseName = request.getParameter("courseName");
		String courseAttribute = request.getParameter("courseAttribute");
		String courseCredit = request.getParameter("courseCredit");
		Course course = new Course();
		course.setCrID(courseID);
		course.setCrName(courseName);
		course.setCrAttribute(courseAttribute);
		course.setCrCredit(courseCredit);
		ads.addCourse(course);
		return "f:/success.jsp";
	}
	public void judgeCourseID(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String courseID = request.getParameter("courseID");
		if(courseID.trim().equals(""))
		{
			response.getWriter().print("0");
			return;
		}
		Course course = new Course();
		course.setCrID(courseID);
		List<Course> couList = ads.queryCourse(course);
		if(couList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
	}
	public void judgestID(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String stID = request.getParameter("stID");
		if(stID.trim().equals(""))
		{
			response.getWriter().print("0");
			return;
		}
		Student st = new Student();
		st.setStID(stID);
		List<Student> stList = ads.queryStudent(st);
		if(stList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
	}
	public String addStudent(HttpServletRequest request,HttpServletResponse response)
	{
		String stID = request.getParameter("stID");
		String stName = request.getParameter("stName");
		String stClass = request.getParameter("stClass");
		String stCollege = request.getParameter("stCollege");
		Student st = new Student();
		st.setStID(stID);
		st.setStName(stName);
		st.setStEmail("无");
		st.setStCourseAbsentTotal("0");
		st.setStPassword("000000");
		st.setStCollege(stCollege);
		st.setStClass(stClass);
		st.setStExerciseAbsentTotal("0");
		ads.addStudent(st);
		return "f:/success.jsp";
	}
	public String addTeacher(HttpServletRequest request,HttpServletResponse response)
	{
		String tcID = request.getParameter("tcID");
		String tcName = request.getParameter("tcName");
		String tcCollege = request.getParameter("tcCollege");
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		tc.setTcName(tcName);
		tc.setTcPassword("000000");
		tc.setTcCollege(tcCollege);
		tc.setTcEmail("无");
		ads.addTeacher(tc);
		return "f:/success.jsp";
	}
	public void judgetcID(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String tcID = request.getParameter("tcID");
		if(tcID.trim().equals(""))
		{
			response.getWriter().print("0");
			return;
		}
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		List<Teacher> tcList = ads.queryTeacher(tc);
		if(tcList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
	}
	public String queryCourse(HttpServletRequest request,HttpServletResponse response)
	{
		String crID = request.getParameter("courseID");
		String crName = request.getParameter("courseName");
		String crAttribute = request.getParameter("courseAttribute");
		String crCredit = request.getParameter("courseCredit");
		Course course = new Course();
		course.setCrID(crID);
		course.setCrName(crName);
		course.setCrAttribute(crAttribute);
		course.setCrCredit(crCredit);
		List<Course> crList = ads.queryCourse(course);
		request.setAttribute("crList", crList);
		return"f:/admin/courseList.jsp"; 
	}
	public String preEditCourse(HttpServletRequest request,HttpServletResponse response)
	{
		String crID = request.getParameter("courseID");
		Course course = new Course();
		course.setCrID(crID);
		List<Course> crList = ads.queryCourse(course);
		course = crList.get(0);
		request.setAttribute("course", course);
		return"f:/admin/editCourse.jsp";
	}
	public String editCourse(HttpServletRequest request,HttpServletResponse response)
	{
		String crID = request.getParameter("courseID");
		String crName = request.getParameter("courseName");
		String crAttribute = request.getParameter("courseAttribute");
		String crCredit = request.getParameter("courseCredit");
		Course course = new Course();
		course.setCrID(crID);
		course.setCrName(crName);
		course.setCrCredit(crCredit);
		course.setCrAttribute(crAttribute);
		ads.editCourse(course);
		return"f:/success.jsp";
	}
	public String delCourse(HttpServletRequest request,HttpServletResponse response)
	{
		String crID = request.getParameter("courseID");
		Course course = new Course();
		course.setCrID(crID);
		ads.delCourse(course);
		return"f:/success.jsp";
	}
	public String queryStudent(HttpServletRequest request,HttpServletResponse response)
	{
		String stID = request.getParameter("stID");
		String stName = request.getParameter("stName");
		String stClass = request.getParameter("stClass");
		String stCollege = request.getParameter("stCollege");
		Student st = new Student();
		st.setStID(stID);
		st.setStName(stName);
		st.setStCollege(stCollege);
		st.setStClass(stClass);
		List<Student> stList = ads.queryStudent(st);
		request.setAttribute("stList", stList);
		return"f:/admin/studentList.jsp";
	}
	public String preEditStudent(HttpServletRequest request,HttpServletResponse response)
	{
		String stID = request.getParameter("stID");
		Student st = new Student();
		st.setStID(stID);
		List<Student> stList = ads.queryStudent(st);
		st = stList.get(0);
		request.setAttribute("st", st);
		List<AcLinker> acLinkers = ads.queryAcLinker();
		request.setAttribute("acLinkers", acLinkers);
		return "f:/admin/editStudent.jsp";
	}
	public String editStudent(HttpServletRequest request,HttpServletResponse response) 
	{
		String stID = request.getParameter("stID");
		String stName = request.getParameter("stName");
		String stClass = request.getParameter("stClass");
		String stCollege = request.getParameter("stCollege");
		Student st = new Student();
		st.setStID(stID);
		st.setStName(stName);
		st.setStCollege(stCollege);
		st.setStClass(stClass);
		ads.editStudent(st);
		return"f:/success.jsp";
	}
	public String delStudent(HttpServletRequest request, HttpServletResponse response)
	{
		String stID = request.getParameter("stID");
		Student st = new Student();
		st.setStID(stID);
		ads.delStudent(st);
		return "f:/success.jsp";
	}
    public String preEditTeacher(HttpServletRequest request,HttpServletResponse response)
    {
    	String tcID = request.getParameter("tcID");
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		List<Teacher> tcList = ads.queryTeacher(tc);
		tc = tcList.get(0);
		request.setAttribute("tc", tc);
    	return "f:/admin/editTeacher.jsp";
    }
    public String queryTeacher(HttpServletRequest request,HttpServletResponse response)
    {
		String tcID = request.getParameter("tcID");
		String tcName = request.getParameter("tcName");
		String tcCollege = request.getParameter("tcCollege");
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		tc.setTcName(tcName);
		tc.setTcCollege(tcCollege);
		List<Teacher> tcList = ads.queryTeacher(tc);
		request.setAttribute("tcList", tcList);
    	return "f:/admin/teacherList.jsp";
    }
    public String editTeacher(HttpServletRequest request,HttpServletResponse response)
    {
		String tcID = request.getParameter("tcID");
		String tcName = request.getParameter("tcName");
		String tcCollege = request.getParameter("tcCollege");
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		tc.setTcName(tcName);
		tc.setTcCollege(tcCollege);
		ads.editTeacher(tc);
    	return "f:/success.jsp";
    }
	public String delTeacher(HttpServletRequest request, HttpServletResponse response)
	{
		String tcID = request.getParameter("tcID");
		Teacher tc = new Teacher();
		tc.setTcID(tcID);
		ads.delTeacher(tc);
		return "f:/success.jsp";
	}
	public void judgeasID(HttpServletRequest request , HttpServletResponse response) throws IOException
	{
		String asID = request.getParameter("asID");
		if(asID.trim().equals(""))
		{
			response.getWriter().print("0");
			return;
		}
		Assistant as = new Assistant();
		as.setAsID(asID);
		List<Assistant> asList = ads.queryAssistant(as);
		if(asList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
	}
	public String delAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		String asID = request.getParameter("asID");
		Assistant as = new Assistant();
		as.setAsID(asID);
		ads.delAssistant(as);
		return "f:/success.jsp";
	}
	public String preEditAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		String asID = request.getParameter("asID");
		Assistant as = new Assistant();
		as.setAsID(asID);
		List<Assistant> asList = ads.queryAssistant(as);
		as = asList.get(0);
		request.setAttribute("as", as);
		AcLinker acLinker = new AcLinker();
		List<AcLinker> acLinkerList = ads.queryAcLinker(acLinker);
		request.setAttribute("acLinkers", acLinkerList);
		return "f:/admin/editAssistant.jsp";
	}
	public String editAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		String asID = request.getParameter("asID");
		String asName = request.getParameter("asName");
		String asCollege = request.getParameter("asCollege");
		Assistant as = new Assistant();
		as.setAsID(asID);
		as.setAsName(asName);
		as.setAsCollege(asCollege);
        String []stClass = request.getParameterValues("asClass");
        AcLinker acLinker = new AcLinker();
        acLinker.setAssistantID(asID);
		if(stClass!=null)
		{
           for(int i = 0 ;i<stClass.length ;i++)
           {
        	    acLinker.setStClass(stClass[i]);
        	    ads.editAcLinker(acLinker);
           }
		}
	    ads.editAssistant(as);
		return "f:/success.jsp";
	}
	public String addAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		String asID = request.getParameter("asID");
		String asName = request.getParameter("asName");
		String asCollege = request.getParameter("asCollege");
		String []asClass = request.getParameterValues("asClass");
		AcLinker acLinker = new AcLinker();
		acLinker.setAssistantID(asID);
		for(int i = 0 ; i<asClass.length ;i++)
		{
			acLinker.setStClass(asClass[i]);
			ads.editAcLinker(acLinker);
		}
		Assistant as = new Assistant();
		as.setAsID(asID);
		as.setAsName(asName);
		as.setAsCollege(asCollege);
		as.setAsPassword("000000");
		as.setAsEmail("无");
		ads.addAssistant(as);
		return "f:/success.jsp";
	}
	public String queryAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		String asID = request.getParameter("asID");
		String asName = request.getParameter("asName");
		String asCollege = request.getParameter("asCollege");
		Assistant as = new Assistant();
		as.setAsID(asID);
		as.setAsName(asName);
		as.setAsCollege(asCollege);
		List<Assistant> asList = ads.queryAssistant(as);
		request.setAttribute("asList", asList);
		return "f:/admin/assistantList.jsp";
	}
	public String addAcLinker(HttpServletRequest request,HttpServletResponse response)
	{
		String stClass = request.getParameter("stClass");
		String assistantID = "null";
		System.out.println(stClass);
		AcLinker acLinker = new AcLinker();
		acLinker.setAssistantID(assistantID);
		acLinker.setStClass(stClass);
		ads.addAcLinker(acLinker);
		return "f:/success.jsp";
	}
	public String preAddStudent(HttpServletRequest request,HttpServletResponse response)
	{
		List<AcLinker> acLinkers = ads.queryAcLinker();
		request.setAttribute("acLinkers", acLinkers);
		return "f:/admin/addStudent.jsp";
	}
	public String preAddAssistant(HttpServletRequest request,HttpServletResponse response)
	{
		List<AcLinker> acLinkers = ads.queryAcLinkernull();
		request.setAttribute("acLinkers", acLinkers);
		return "f:/admin/addAssistant.jsp";
	}
	public void judgeStClass(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		String stClass = request.getParameter("stClass");
		stClass=new String(stClass.getBytes("iso-8859-1"),"utf-8");
		if(stClass.trim().equals(""))
		{
			response.getWriter().print("0");
			return;
		}
		AcLinker acLinker = new AcLinker();
		acLinker.setStClass(stClass);
		List<AcLinker> acLinkerList = ads.queryAcLinker(acLinker);
		if(acLinkerList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
	}
	public String queryAcLinker(HttpServletRequest request,HttpServletResponse response)
	{
		String assistantID = request.getParameter("assistantID");
		String stClass = request.getParameter("stClass");
		AcLinker acLinker = new AcLinker();
		acLinker.setAssistantID(assistantID);
		acLinker.setStClass(stClass);
		List<AcLinker> acList = ads.queryAcLinker(acLinker);
		request.setAttribute("acLinkers", acList);
		return "f:/admin/acLinkerList.jsp";
	}
}
