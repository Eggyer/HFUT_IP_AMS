package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import user.Student;
import cn.itcast.servlet.BaseServlet;
import daohelp.student.absent_info;
import daohelp.student.course_info;
import daohelp.student.grade_info;

public class StudentServlet extends BaseServlet
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentService();
	
	private static double getGPA(String grade)
	{
	
		if (grade.equals("优")) return 3.9;
		if (grade.equals("良")) return 3.0;
		if (grade.equals("中")) return 2.0;
		if (grade.equals("及格")) return 1.2;
		if (grade.equals("不及格")) return 0;
		
		Double score = new Double(grade);
		if (score>=95)return 4.3;
		else if (score >=90) return 4.0;
		else if (score >=85) return 3.7;
		else if (score >=82) return 3.3;
		else if (score >=78) return 3.0;
		else if (score >=75) return 2.7;
		else if (score >=72) return 2.3;
		else if (score >=68) return 2.0;
		else if (score >=66) return 1.7;
		else if (score >=64) return 1.3;
		else if (score >=60) return 1.0;
		else return 0;
		
	}
	
	public String modify_password(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String new_password = request.getParameter("stPassword");
		Student student = (Student) request.getSession().getAttribute("student");
		if (student != null)
		{
			student.setStPassword(new_password);
			studentService.modify_password(student);
			request.setAttribute("student_message", "修改密码成功");
		}else {
			request.setAttribute("student_message", "请重新登入，修改密码失败");
		}
		return "f:/student/student_message.jsp";
	}
	
	public String edit_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String new_stEmail = request.getParameter("stEmail");
		Student student = (Student) request.getSession().getAttribute("student");
		if (student != null)
		{
			student.setStEmail(new_stEmail);
			studentService.edit_info(student);
			request.setAttribute("student_message", "修改个人信息成功");
		}else {
			request.setAttribute("student_message", "请重新登入，修改个人信息失败");
		}
		return "f:/student/student_message.jsp";
	}
	
	public String query_absent_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Student student = (Student) request.getSession().getAttribute("student");
		if (student !=null)
		{
			List<absent_info> list = studentService.query_absent_info(student);
			Collections.sort(list, new Comparator<absent_info>()
			{
				@Override
				public int compare(absent_info arg0, absent_info arg1)
				{
					// TODO Auto-generated method stub
					return arg1.getTerm().compareToIgnoreCase(arg0.getTerm());
				}
			});
			Map<String, Integer> absent_total = new LinkedHashMap<String, Integer>();
			for (int i = 0; i < list.size(); i++)
			{
				absent_info ai = list.get(i);
				if (absent_total.containsKey(ai.getTerm()))
				{
					absent_total.put(ai.getTerm(), absent_total.get(ai.getTerm())+ new Integer(ai.getAbsent()));
				}else {
					absent_total.put(ai.getTerm(),new Integer(ai.getAbsent()));
				}
			}
			request.setAttribute("absent_info_map", absent_total);
			request.setAttribute("absent_info_list", list);
			if (list.size() == 0)
			{
				request.setAttribute("student_message", "无缺课记录");
				return "f:/student/student_message.jsp";
			}else {				
				return "f:/student/student_absent_list.jsp";
			}
		}else {
			request.setAttribute("student_message", "请重新登入，查询失败");
			return "f:/student/student_message.jsp";
		}	
	}
	
	public String query_grade_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Student student  = (Student) request.getSession().getAttribute("student");
		if (student!=null)
		{
			List<grade_info> list = studentService.query_grade_info(student);
			Collections.sort(list, new Comparator<grade_info>()
			{
				public int compare(grade_info arg0, grade_info arg1)
				{
					return arg1.getTerm().compareToIgnoreCase(arg0.getTerm());
				}
			});
			Double credit_sum = 0.0;
			Double gpa_sum = 0.0;
			for (int i = 0; i < list.size(); i++)
			{
				grade_info gi =list.get(i);
				System.out.println(gi);
				if (gi.getAttribute().equals("必修"))
				{
					Double gpa = new Double(getGPA(gi.getTotal()));
					gi.setGpa(gpa.toString());
					
					Double credit = new Double(gi.getCredit());
					credit_sum += credit;
					gpa_sum += credit * gpa;
				}else {
					gi.setGpa("选修课程无gpa");
				}
			}
			Double ave_gpa = gpa_sum/credit_sum;
			request.setAttribute("ave_gpa", ave_gpa);
			request.setAttribute("grade_info_list", list);
			return "f:/student/student_grade_list.jsp";
		}else {
			request.setAttribute("student_message", "请重新登入，查询失败");
			return "f:/student/student_message.jsp";
		}	
	}
	
	public String query_course_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Student student = (Student) request.getSession().getAttribute("student");
		if (student!=null)
		{	
			List<course_info> list = studentService.query_course_info(student);
			Collections.sort(list,new Comparator<course_info>()
			{
				public int compare(course_info arg0, course_info arg1)
				{
					return arg1.getTerm().compareToIgnoreCase(arg0.getTerm());
				}
			});
			if (list.size()!=0)
			{			
				String term = list.get(0).getTerm();
				for (int i = 0; i < list.size(); i++)
				{
					if (!list.get(i).getTerm().equalsIgnoreCase(term))
					{
						list.remove(i);
						i--;
					}
				}
				for (int i = 0; i < list.size(); i++)
				{
					course_info c = list.get(i);
					String time = "week";
					time = time + c.getWeek()+"_" +c.getTime();
					System.out.println(time);
					request.setAttribute(time, c.getCourse_name() + "<br>"
											+ c.getCourse_class() +"班<br>"
											+"第"+ c.getTime()+"节" );
				}
				
/*				JSONArray jsonArray = JSONArray.fromObject(list);
				System.out.println(jsonArray);
				String jsonstr = jsonArray.toString();
				request.setAttribute("a", "aaa");
				request.setAttribute("b", jsonstr);*/
				return "f:/student/student_course_table.jsp";
			}else {
				request.setAttribute("student_message", "您无记录课程信息");
				return "f:/student/student_message.jsp";
			}

		}else {			
			request.setAttribute("student_message", "请重新登入，查询失败");
			return "f:/student/student_message.jsp";
		}
	}
	
}

