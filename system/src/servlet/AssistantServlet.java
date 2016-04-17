package servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AssistantService;
import user.Assistant;
import user.Course;
import user.Student;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;
import daohelp.assistant.CourseInfo;
import daohelp.assistant.StudentAbsentInfo;
import daohelp.assistant.StudentClass;
import daohelp.assistant.StudentGradeInfo;
import daohelp.assistant.UpdateAbsentInfo;

public class AssistantServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AssistantService assistantService = new AssistantService();
	
	@SuppressWarnings("finally")	
	private int sent_email_to_student(List<UpdateAbsentInfo> list,String course_name,String email_type)
	{
		Session session = MailUtils.createSession("smtp.163.com","hfut_edu_manager@163.com" , "xiaojie1996");
		String manager_email = "hfut_edu_manager@163.com";
		int i = 0;
		if (email_type.equalsIgnoreCase("absent_add"))
		{
			for ( i = 0; i <list.size(); i++)
			{
				Student student = assistantService.query_student(list.get(i).getStudentID());
				String student_email = student.getStEmail();
				String theme = "学生缺勤管理系统通知";
				String massage = "缺勤通知" 
						+ "<p>"+student.getStName()+"同学"+"，你已被添加一次缺勤记录!"
						+ "<br>缺勤课程名："+course_name
						+ "<br>当前课堂总缺勤次数："+student.getStCourseAbsentTotal()
						+ "<br>当前早操总缺勤次数："+student.getStExerciseAbsentTotal()
						+ "<br>希望你能好好学习,天天向上，如有疑问请联系导员。"
						+ "</p>" ;
				Mail mail = new Mail(manager_email,student_email,theme,massage);	
				try
				{
					MailUtils.send(session, mail);
				} catch (Exception e)
				{
					throw new RuntimeException("失败了");
				}finally {
					continue;
				}
			}
		}else if (email_type.equalsIgnoreCase("absent_reduce")) {
			
		}
		return i;
	}
	
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
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		if (assistant!=null)
		{
			String new_password = request.getParameter("asPassword");
			assistant.setAsPassword(new_password);
			assistantService.modify_password(assistant);
			request.setAttribute("assistant_message", "恭喜，修改密码成功");
		}else {
			request.setAttribute("assistant_message", "修改失败，请重新登入后再试");
		}
		return "f:/assistant/assistant_message.jsp";
	}
	
	public String edit_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		String new_email = request.getParameter("asEmail");
		if (assistant != null)
		{
			assistant.setAsEmail(new_email);
			assistantService.edit_info(assistant);
			request.setAttribute("assistant_message", "修改邮箱成功！");
		}else {
			request.setAttribute("assistant_message", "修改邮箱失败，请重新登入后再试");
		}
		
		return "f:/assistant/assistant_message.jsp";
	}
	
	public String load_choose_class(HttpServletRequest request, HttpServletResponse response)//修改
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		
		if (assistant!=null)
		{
			List<StudentClass> student_class_list = assistantService.load_choose_class(assistant);	
			
			request.setAttribute("student_class_list", student_class_list);
			
			String method_path = request.getParameter("method_path");
			request.setAttribute("method_path",method_path);
			return "f:/assistant/assistant_choose_class.jsp";
		}else {
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp";
		}
	}
	
	public String edit_absent_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		String student_class = request.getParameter("student_class");
		request.setAttribute("student_class", student_class);
		if (assistant != null)
		{
			List<Student> student_list	= assistantService.edit_absent_info(student_class);
			request.setAttribute("student_list", student_list);
			if (student_list.size() == 0)
			{
				request.setAttribute("assistant_message", "本班级暂无学生");
				return "f:/assistant/assistant_message.jsp";
			}else {
				String studentID = student_list.get(0).getStID();
				List<CourseInfo> course_list = assistantService.load_course_info(studentID);

				Collections.sort(course_list, new Comparator<CourseInfo>()
				{

					@Override
					public int compare(CourseInfo arg0, CourseInfo arg1)
					{
						return arg1.getTerm().compareToIgnoreCase(arg0.getTerm());
					}	
				});


				String term = course_list.get(0).getTerm();
				for (int i = 0; i < course_list.size(); i++)
				{
					if (!course_list.get(i).getTerm().equalsIgnoreCase(term))
					{
						course_list.remove(i);
						i--;
					}
				}

				Map<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < course_list.size(); i++)
				{
					String course_name = course_list.get(i).getCourse_name();
					if (map.containsKey(course_name))
					{
						course_list.remove(i);
						i--;
					}else {
						map.put(course_name, "exist");
					}
				}

				request.setAttribute("course_list", course_list);
			}
			return "f:/assistant/assistant_edit_absent.jsp";
		}else {
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp";
		}
	}
	
	public String update_absent_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		if (assistant != null)
		{
			String add_reduce = request.getParameter("add_reduce");
			String courseID = request.getParameter("course");
			String[] studentID_list = request.getParameterValues("student");
			List<UpdateAbsentInfo> list = new ArrayList<UpdateAbsentInfo>();
			for (int i = 0; i < studentID_list.length; i++)
			{
				UpdateAbsentInfo uai = new UpdateAbsentInfo();
				uai.setAdd_reduce(add_reduce);
				uai.setCourseID(courseID);
				uai.setStudentID(studentID_list[i]);
				list.add(uai);
			}
			Course course =  assistantService.query_course_by_id(courseID);
			assistantService.update_absent_info(list);
			if (add_reduce.equalsIgnoreCase("+"))
			{
				try {
					if(course!=null)
						sent_email_to_student(list, course.getCrName(),"absent_add");
					else {
						sent_email_to_student(list, "早操","absent_add");
					}
					request.setAttribute("assistant_message", "操作添加信息成功");
				} catch (Exception e) {
					request.setAttribute("msg", "邮件发送失败,缺勤记录添加成功");
					return "f:/assistant/false.jsp";
				}
			}
			return "f:/assistant/assistant_message.jsp"; 
		}else {
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp";
		}
	}
	
	public String query_grade_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		String student_class = request.getParameter("student_class");
		if (assistant!=null)
		{
			List<StudentGradeInfo> grade_list = assistantService.query_grade_info(student_class);
			if (grade_list == null)
			{
				request.setAttribute("assistant_message", "要查询的班级学生数为0");
				return "f:/assistant/assistant_message.jsp";
			}
			
			for (int i = 0; i < grade_list.size(); i++)
			{
				if (grade_list.get(i).getTotal().equalsIgnoreCase("0"))
				{
					grade_list.get(i).setTotal("暂未考试");
				}
			}
			Collections.sort(grade_list, new Comparator<StudentGradeInfo>()
			{
				@Override
				public int compare(StudentGradeInfo arg0, StudentGradeInfo arg1)
				{
					if ((new Integer(arg0.getStudent_id())).equals(new Integer(arg1.getStudent_id())))
					{
						if (arg0.getTerm().equalsIgnoreCase(arg1.getTerm()))
						{
							return arg0.getCourse_name().compareTo(arg1.getCourse_name());
						}else {
							return arg0.getTerm().compareToIgnoreCase(arg1.getTerm());
						}
					}else {
						return (new Integer(arg0.getStudent_id())).compareTo(new Integer(arg1.getStudent_id()));
					}
				}
				
			});
			
			List<String> course_list = new ArrayList<String>();
			if (grade_list.size() != 0)
			{			
				StudentGradeInfo sgi = grade_list.get(0);
				for (int i = 0; i < grade_list.size(); i++)
				{
					if (sgi.getStudent_id().equals(grade_list.get(i).getStudent_id()))
					//if (sgi.getStudent_name().equals(grade_list.get(i).getStudent_name()))
					{
						course_list.add(grade_list.get(i).getCourse_name());
					}
				}

				
				List<List<StudentGradeInfo>> student_grade_list = new ArrayList<List<StudentGradeInfo>>();
				int student_num = grade_list.size()/course_list.size();
				for (int i = 0; i < student_num; i++)
				{
					List<StudentGradeInfo> grade_list_tmp = new ArrayList<StudentGradeInfo>();
					for (int j = i*course_list.size(); j < course_list.size()*(i+1); j++)
					{
						grade_list_tmp.add(grade_list.get(j));
					}
					student_grade_list.add(grade_list_tmp);
				}
				
				for (int i = 0; i < student_grade_list.size(); i++)
				{
					List<StudentGradeInfo> list = student_grade_list.get(i);
					Double credit_sum = 0.0;
					Double gpa_sum = 0.0;
					for (int j = 0; j < list.size(); j++)
					{
						 sgi =list.get(j);
						if (!sgi.getTotal().equalsIgnoreCase("暂未考试"))
						{							
							if (sgi.getAttribute().equals("必修"))
							{
								Double gpa = new Double(getGPA(sgi.getTotal()));	
								Double credit = new Double(sgi.getCredit());
								credit_sum += credit;
								gpa_sum += credit * gpa;
							}
						}
					}
					Double ave_gpa = gpa_sum/credit_sum;
					DecimalFormat df = new DecimalFormat("#.000");
					ave_gpa = new Double(df.format(ave_gpa.doubleValue()));
					for (int j = 0; j < list.size(); j++)
					{
						list.get(j).setGpa(ave_gpa.toString());
					}
				}
				request.setAttribute("course_list", course_list);
				request.setAttribute("student_grade_list", student_grade_list);
				return "f:/assistant/assistant_grade_info.jsp";
			}else {
				request.setAttribute("assistant_message", "本班成绩暂无存储信息");
				return "f:/assistant/assistant_message.jsp";
			}
				
			
		}else {
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp";
		}		
	}
	
	public String query_absent_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		String student_class = request.getParameter("student_class");
		if (assistant!=null)
		{
			List<StudentAbsentInfo> absent_list = assistantService.query_absent_info(student_class);
			if (absent_list == null)
			{
				request.setAttribute("assistant_message", "要查询的班级学生数为0");
				return "f:/assistant/assistant_message.jsp";
			}
			Collections.sort(absent_list, new Comparator<StudentAbsentInfo>()
			{
				@Override
				public int compare(StudentAbsentInfo arg0, StudentAbsentInfo arg1)
				{
					if ((new Integer(arg0.getStudent_id())).equals(new Integer(arg1.getStudent_id())))
					{
						if (arg0.getTerm().equalsIgnoreCase(arg1.getTerm()))
						{
							return arg0.getCourse_name().compareTo(arg1.getCourse_name());
						}else {
							return arg0.getTerm().compareToIgnoreCase(arg1.getTerm());
						}
					}else {
						return (new Integer(arg0.getStudent_id())).compareTo(new Integer(arg1.getStudent_id()));
					}
				}
				
			});
			List<String> course_list = new ArrayList<String>();
			if (absent_list.size() != 0)
			{			
				StudentAbsentInfo sai = absent_list.get(0);
				for (int i = 0; i < absent_list.size(); i++)
				{
					if (sai.getStudent_id().equals(absent_list.get(i).getStudent_id()))
					{
						course_list.add(absent_list.get(i).getCourse_name());
					}
				}
				request.setAttribute("course_list", course_list);	
				List<List<StudentAbsentInfo>> student_absent_list = new ArrayList<List<StudentAbsentInfo>>();
				int student_num = absent_list.size()/course_list.size();
				for (int i = 0; i < student_num; i++)
				{
					List<StudentAbsentInfo> temp = new ArrayList<StudentAbsentInfo>() ;
					for (int j = i*course_list.size(); j < course_list.size()*(i+1); j++)
					{
						temp.add(absent_list.get(j));
					}
					student_absent_list.add(temp);
				}
				request.setAttribute("student_absent_list", student_absent_list);
			}else {
				request.setAttribute("assistant_message", "要查询的班级学生数为0");
				return "f:/assistant/assistant_message.jsp";
			}
			return "f:/assistant/assistant_absent_info.jsp";
		}else {
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp";
		}
	}
	
	public String query_assistant_info(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Assistant assistant = (Assistant) request.getSession().getAttribute("assistant");
		if (assistant!=null)
		{
			return "f:/assistant/assistant_info.jsp"; 
		}else {			
			request.setAttribute("assistant_message", "操作失败，请重新登入");
			return "f:/assistant/assistant_message.jsp"; 
		}
	}
	
}

