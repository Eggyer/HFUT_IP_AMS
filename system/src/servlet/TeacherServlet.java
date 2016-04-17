package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TeacherService;
import user.Assistant;
import user.Course;
import user.CtTime;
import user.Grade;
import user.GradeInfo;
import user.StGrade;
import user.Student;
import user.Teacher;
import user.crCtTime;
import user.Time;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;

public class TeacherServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeacherService tcs = new TeacherService();
    public String changeInfo(HttpServletRequest request,HttpServletResponse response)
     {
    	 Teacher tc = (Teacher) request.getSession().getAttribute("teacher");
    	 String tcEmail = request.getParameter("tcEmail");
    	 tc.setTcEmail(tcEmail);
    	 tcs.changeInfo(tc);
    	 return"f:/teacher/success.jsp";
     }
    public String changePassword(HttpServletRequest request,HttpServletResponse response)
     {
    	 Teacher tc = (Teacher)request.getSession().getAttribute("teacher");
    	 String tcPassword = request.getParameter("tcPassword");
    	 tc.setTcPassword(tcPassword);
    	 tcs.changePassword(tc);
    	 return"f:/teacher/success.jsp";
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
 		List<Course> crList = tcs.queryCourse(course);
 		request.setAttribute("crList", crList);
 		return"f:/teacher/courseList.jsp"; 
 	}
 	public String preAddCtTime(HttpServletRequest request,HttpServletResponse response)
 	{
 		String crID = request.getParameter("courseID");
 		Course course = new Course();
 		course.setCrID(crID);
 		request.setAttribute("cr",course);
 		return "f:/teacher/addCtTime.jsp";
 	}
 	public String addCtTime(HttpServletRequest request,HttpServletResponse response)
 	{
 		String courseID = request.getParameter("crID");
 		String term = request.getParameter("term");
 		String courseClass = request.getParameter("crClass");
 		String teacherID =((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		String []mon = request.getParameterValues("mon");
 		String []tu = request.getParameterValues("tu");
 		String []we = request.getParameterValues("we");
 		String []th = request.getParameterValues("th");
 		String []fr = request.getParameterValues("fr");
 		String []sa = request.getParameterValues("sa");
 		String []su = request.getParameterValues("su");
 		if(mon!=null)
 		{
 			for(int i=0;i<mon.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("1");
 				ctTime.setTime(mon[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		if(tu!=null)
 		{
 			for(int i=0;i<tu.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("2");
 				ctTime.setTime(tu[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		if(we!=null)
 		{
 			for(int i=0;i<we.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("3");
 				ctTime.setTime(we[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		if(th!=null)
 		{
 			for(int i=0;i<th.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("4");
 				ctTime.setTime(th[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		if(fr!=null)
 		{
 			for(int i=0;i<fr.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("5");
 				ctTime.setTime(fr[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}	
 		}
 		if(sa!=null)
 		{
 			for(int i=0;i<sa.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("6");
 				ctTime.setTime(sa[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		if(su!=null)
 		{
 			for(int i=0;i<su.length;i++)
 			{
 				CtTime ctTime = new CtTime();
 				ctTime.setTeacherID(teacherID);
 				ctTime.setCourseID(courseID);
 				ctTime.setTerm(term);
 				ctTime.setWeek("7");
 				ctTime.setTime(su[i]);
 				ctTime.setCourseClass(courseClass);
 				tcs.addCtTime(ctTime);
 			}
 		}
 		return"f:/teacher/success.jsp";
 	}
 	public void judgecrClass(HttpServletRequest request,HttpServletResponse response) throws IOException
 	{
 		String crClass = request.getParameter("crClass");
 		if(crClass.trim().equals(""))
 		{
 			response.getWriter().print("0");
 			return;
 		}
 		CtTime ctTime = new CtTime();
 		ctTime.setCourseClass(crClass);
 		List<CtTime> ctList = tcs.queryCtTime(ctTime);
		if(ctList.isEmpty())
			 response.getWriter().print("0");
		else 
	    	 response.getWriter().print("1");
 	}
 	public String queryCtTime(HttpServletRequest request,HttpServletResponse response)
 	{
 		String courseID = request.getParameter("courseID");
 		String courseClass = request.getParameter("courseClass");
 		String term = request.getParameter("term");
 		CtTime ctTime = new CtTime();
 		String teacherID = ((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		ctTime.setTeacherID(teacherID);
 		ctTime.setCourseClass(courseClass);
 		ctTime.setCourseID(courseID);
 		ctTime.setTerm(term);
 		List<crCtTime> crList = tcs.queryCrCtTime(ctTime);
 		request.setAttribute("crList",crList);
 		return "f:/teacher/ctTimeList.jsp";
 	}
 	public String delCtTime(HttpServletRequest request,HttpServletResponse response)
 	{
 		String courseID = request.getParameter("crID");
 		String courseClass = request.getParameter("crClass");
 		CtTime ctTime = new CtTime();
 		ctTime.setCourseID(courseID);
        ctTime.setCourseClass(courseClass);
        String teacherID = ((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		ctTime.setTeacherID(teacherID);
 		tcs.delCtTime(ctTime);
 		return "f:/teacher/success.jsp";
 	}
 	public String queryGrade(HttpServletRequest request,HttpServletResponse response)
 	{
 		String courseName = request.getParameter("courseName");
 		String courseID = request.getParameter("courseID");
 		String studentID = request.getParameter("studentID");
 		String teacherID = ((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		String courseClass = request.getParameter("courseClass");
 		Grade grade = new Grade();
 		grade.setStudentID(studentID);
 		grade.setTeacherID(teacherID);
 		grade.setCourseID(courseID);
 		grade.setCourseName(courseName);
 		grade.setCourseClass(courseClass);
 		List<GradeInfo> grList = tcs.queryGrade(grade);
 		request.setAttribute("grList", grList);
 		return"f:/teacher/gradeList.jsp";
 	}
 	public String preAddSt(HttpServletRequest request,HttpServletResponse response)
 	{
 		String crID = request.getParameter("crID");
 		String crClass = request.getParameter("crClass");
 		crCtTime crCtTime = new crCtTime();
 		crCtTime.setCourseID(crID);
 		crCtTime.setCourseClass(crClass);
 		request.setAttribute("cr", crCtTime);
 		return"f:/teacher/queryStudent.jsp";
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
		List<Student> stList = tcs.queryStudent(st);
		Grade grade = new Grade();
		
 		String crID = request.getParameter("crID");
 		String crClass = request.getParameter("crClass");
 		
 		
		grade.setCourseID(crID);
		grade.setCourseClass(crClass);
		List<GradeInfo> stGrade = tcs.queryGrade(grade);
		for(int i = 0; i<stGrade.size();i++)
		{
			for(int j = 0 ; j<stList.size() ;)
			{
				if(stGrade.get(i).getStudentID().equals(stList.get(j).getStID()))
				{
					stList.remove(j);
				}
				else {
					 j++;
				}
			}
		}
		request.setAttribute("stList", stList);
		

 		crCtTime crCtTime = new crCtTime();
 		crCtTime.setCourseID(crID);
 		crCtTime.setCourseClass(crClass);
 		request.setAttribute("cr", crCtTime);
		return"f:/teacher/studentList.jsp";
	}
	public String addGrade(HttpServletRequest request,HttpServletResponse response)
	{
 		String crID = request.getParameter("crID");
 		String crClass = request.getParameter("crClass");
 		CtTime ctTime = new CtTime();
 		ctTime.setCourseID(crID);
 		ctTime.setCourseClass(crClass);
 		List<crCtTime> crList = tcs.queryCrCtTime(ctTime);
 		crCtTime crcCtTime = crList.get(0);
 		String crName = crcCtTime.getCrName();
 		String teacherID = ((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		String []stIDs = request.getParameterValues("studentID");
 		for(int i = 0 ;i<stIDs.length;i++)
 		{
 			Grade grade = new Grade();
 			grade.setAbsent("0");
 			grade.setCourseClass(crClass);
 			grade.setCourseID(crID);
 			grade.setCourseName(crName);
 			grade.setExam("0");
 			grade.setOrdinary("0");
 			grade.setStudentID(stIDs[i]);
 			grade.setTeacherID(teacherID);
 			grade.setTotal("0");
 			grade.setTerm(crcCtTime.getTerm());
 			tcs.addGrade(grade);
 		}
		return "f:/teacher/success.jsp";
	}
	public String preChangeGrade(HttpServletRequest request,HttpServletResponse response)
	{
 		String crID = request.getParameter("crID");
 		String crClass = request.getParameter("crClass");
 		String teacherID = ((Teacher)request.getSession().getAttribute("teacher")).getTcID();
 		Grade grade = new Grade();
 		grade.setCourseID(crID);
 		grade.setCourseClass(crClass);
 		grade.setTeacherID(teacherID);
 		List<GradeInfo> grList = tcs.queryGrade(grade);
 		request.setAttribute("grList", grList);
		return"f:/teacher/changeGradeList.jsp";
	}
	public String changeGrade(HttpServletRequest request,HttpServletResponse response)
	{
		String []stIDs = request.getParameterValues("stID");
		String []crIDs = request.getParameterValues("crID");
		String []crName = request.getParameterValues("crName");
		String []crClass =request.getParameterValues("crClass");
		String []ordinary = request.getParameterValues("ordinary");
		String []exam = request.getParameterValues("exam");
		Double or = new Double(request.getParameter("or"));
		Grade grade = new Grade();
		for(int i=0; i<stIDs.length ;i++)
		{
			grade.setCourseClass(crClass[i]);
			grade.setCourseID(crIDs[i]);
			grade.setCourseName(crName[i]);
			grade.setExam(exam[i]);
			grade.setOrdinary(ordinary[i]);
			grade.setStudentID(stIDs[i]);
			Double orGr = new Double(ordinary[i]);
			Double exGr = new Double(exam[i]);
			Double total = orGr*or+exGr*(1-or);
			grade.setTotal(total.toString());
			tcs.changeGrade(grade);
		}
		return "f:/teacher/success.jsp";
	}
	public String showTime(HttpServletRequest request,HttpServletResponse response)
	{
		String crID = request.getParameter("crID");
		String crClass = request.getParameter("crClass");
		CtTime ctTime = new CtTime();
		ctTime.setCourseID(crID);
		ctTime.setCourseClass(crClass);
		List<Time> ctList = tcs.queryTime(ctTime);
		for(int i = 0;i<ctList.size();i++)
		{
			Time time = ctList.get(i);
			request.setAttribute("ct"+time.getWeek()+time.getTime(), time);
		}
		return "f:/teacher/time.jsp";
	}
	public String preAddAbsent(HttpServletRequest request,HttpServletResponse response)
	{
		String courseClass = request.getParameter("crClass");
		String courseID = request.getParameter("crID");
		String week = request.getParameter("crWe");
		String time = request.getParameter("crTi");
		CtTime ctTime = new CtTime();
		ctTime.setCourseClass(courseClass);
		ctTime.setCourseID(courseID);
		ctTime.setWeek(week);
		ctTime.setTime(time);
		request.setAttribute("cr", ctTime);
		return "f:/teacher/absentQueryStudent.jsp";
	}
	public String absentQueryStudent(HttpServletRequest request,HttpServletResponse response)
	{
		String courseClass = request.getParameter("crClass");
		String courseID = request.getParameter("crID");
		String week = request.getParameter("week");
		String time = request.getParameter("time");
		CtTime ctTime = new CtTime();
		ctTime.setCourseClass(courseClass);
		ctTime.setCourseID(courseID);
		ctTime.setWeek(week);
		ctTime.setTime(time);
		request.setAttribute("cr", ctTime);
		
		String stID = request.getParameter("stID");
		String stName = request.getParameter("stName");
		String stClass = request.getParameter("stClass");
		String stCollege = request.getParameter("stCollege");
		StGrade stGrade = new StGrade();
		stGrade.setStID(stID);
		stGrade.setStName(stName);
		stGrade.setCourseID(courseID);
		stGrade.setCourseClass(courseClass);
		stGrade.setStClass(stClass);
		stGrade.setStCollege(stCollege);
		List<StGrade> stList = tcs.queryStGrade(stGrade);
		request.setAttribute("stList", stList);
		return "f:/teacher/absentStudentList.jsp";
	}
	public String addAbsent(HttpServletRequest request,HttpServletResponse response) throws MessagingException, IOException
	{
		String []stIDs = request.getParameterValues("studentID");
		String courseClass = request.getParameter("crClass");
		String courseID = request.getParameter("crID");
		Course course = new Course();
		course.setCrID(courseID);
		List<Course> crList = tcs.queryCourse(course);
		course = crList.get(0);
		String week = request.getParameter("week");
		String time = request.getParameter("time");
		List<String> stClassList = new ArrayList<String>();
		List<Student> stList = new ArrayList<Student>();
		for(int i = 0 ;i<stIDs.length ;i++)
		{
			Student stTmp = new Student();
			stTmp.setStID(stIDs[i]);
			List<Student> tmpList = tcs.queryStudent(stTmp);
			stTmp = tmpList.get(0);
			stList.add(stTmp);
		    boolean judge = true;	
		    for(int k = 0 ;k<stClassList.size();k++)
		    {
				if(stClassList.get(k).equals(stTmp.getStClass()))
				{
					judge = false;
				}
			}
			if(judge)
		    {
			    stClassList.add(stTmp.getStClass());
			}
		}
		boolean judge = true;
		String msg = "";
		for(int i = 0;i<stClassList.size();i++)
		{
			String stClass = stClassList.get(i);
			Assistant as = tcs.queryAssistant(stClass);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String lock=format.format(date);
			String stuStr = "缺勤时间"+lock+"&nbsp&nbsp"+"课程ID："+courseID+"&nbsp&nbsp"+"课程名称："+course.getCrName()+"&nbsp&nbsp"+"教学班："+courseClass+"&nbsp&nbsp"+"星期"+week+"&nbsp&nbsp"+"第"+time+"节课";
			stuStr+="</br>";
			int k = 0;
			for(int j = 0 ;j<stList.size();j++)
			{
				if(stList.get(j).getStClass().equals(stClass))
				{
					k++;
					stuStr+="学号：";
					stuStr+=stList.get(j).getStID();
					stuStr+="&nbsp&nbsp";
					stuStr+="姓名：";
					stuStr+=stList.get(j).getStName();
					stuStr+="&nbsp&nbsp";
					stuStr+=stList.get(j).getStClass();
					stuStr+="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
					if(k%3==0)
					 stuStr+="</br>";
				}
			}
			try {
				Session session = MailUtils.createSession("smtp.163.com","hfut_edu_manager@163.com" , "xiaojie1996");
				String manager_email = "hfut_edu_manager@163.com";
				Mail mail = new Mail(manager_email, as.getAsEmail(), "学生缺勤管理系统通知", stuStr);
				MailUtils.send(session, mail);
			} catch (Exception e) {
				judge=false;
				msg+=stuStr+"<br/>";
			}
		}
		if(!judge)
		{
			request.setAttribute("msg", msg+"</br>发送失败，请重新尝试");
			return "r:/teacher/false.jsp";
		}
		return "r:/teacher/success.jsp";
	}
}
