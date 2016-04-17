package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.AssistantService;
import service.StudentService;
import service.TeacherService;
import user.Admin;
import user.Assistant;
import user.Student;
import user.Teacher;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
            String userType = request.getParameter("usertype");
            String userid = request.getParameter("userid");
            String userpassword = request.getParameter("userpassword");
            String userverifycode = request.getParameter("verifycode");
            if(userType==null)
            {
            	Admin adform = new Admin();
            	adform.setAdID(userid);
            	adform.setAdPassword(userpassword);
            	AdminService ads = new AdminService();
            	Admin ad = ads.login(adform);
            	if(ad!=null)
            	{
            		ServletContext application = request.getServletContext();
            		@SuppressWarnings("unchecked")
					Map<String, Boolean> idMap = (Map<String, Boolean>) application.getAttribute("ID");
            		boolean con = idMap.containsKey(ad.getAdID());
            		if(con)
            		{
            			boolean judge = idMap.get(ad.getAdID());
            			idMap.put(ad.getAdID(), !judge);
            			request.getSession().setAttribute("judge",!judge);
            		}
            		else {
						idMap.put(ad.getAdID(), true);
						request.getSession().setAttribute("judge",true);
					}
            		request.getSession().setAttribute("admin", ad);
            		response.sendRedirect(request.getContextPath()+"/admin/adminIndex.jsp");
            		return;
            	}
            	else
            	{
					request.setAttribute("msg","用户名或密码错误");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
            	}
            }
            
            if(userType.equals("student"))
            {
            	Student stform = new Student();
            	stform.setStID(userid);
            	stform.setStPassword(userpassword);
            	StudentService sts = new StudentService();
            	Student st = sts.login(stform);
            	if(st!=null)
            	{
            		ServletContext application = request.getServletContext();
            		@SuppressWarnings("unchecked")
					Map<String, Boolean> idMap = (Map<String, Boolean>) application.getAttribute("ID");
            		boolean con = idMap.containsKey(st.getStID());
            		if(con)
            		{
            			boolean judge = idMap.get(st.getStID());
            			idMap.put(st.getStID(), !judge);
            			request.getSession().setAttribute("judge",!judge);
            		}
            		else {
						idMap.put(st.getStID(), true);
						request.getSession().setAttribute("judge",true);
					}
            		
            		request.getSession().setAttribute("student", st);
            		response.sendRedirect(request.getContextPath()+"/student/student_index.jsp");
            		return;
            	}
            	else {
					request.setAttribute("msg","用户名或密码错误");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
            }
            
            if(userType.equals("teacher"))
            {
            	Teacher tcform = new Teacher();
            	tcform.setTcID(userid);
            	tcform.setTcPassword(userpassword);
            	TeacherService tcs = new TeacherService();
            	Teacher tc = tcs.login(tcform);
            	if(tc!=null)
            	{
            		ServletContext application = request.getServletContext();
            		@SuppressWarnings("unchecked")
					Map<String, Boolean> idMap = (Map<String, Boolean>) application.getAttribute("ID");
            		boolean con = idMap.containsKey(tc.getTcID());
            		if(con)
            		{
            			boolean judge = idMap.get(tc.getTcID());
            			idMap.put(tc.getTcID(), !judge);
            			request.getSession().setAttribute("judge",!judge);
            		}
            		else {
						idMap.put(tc.getTcID(), true);
						request.getSession().setAttribute("judge",true);
					}
            		
            		request.getSession().setAttribute("teacher", tc);
            		response.sendRedirect(request.getContextPath()+"/teacher/teacherIndex.jsp");
            	}
            	else {
					request.setAttribute("msg","用户名或密码错误");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
            }
            
            if(userType.equals("assistant"))
            {
            	Assistant asform = new Assistant();
            	asform.setAsID(userid);
            	asform.setAsPassword(userpassword);
            	AssistantService asss = new AssistantService();
            	Assistant as = asss.login(asform);
            	if(as!=null)
            	{
            		ServletContext application = request.getServletContext();
            		@SuppressWarnings("unchecked")
					Map<String, Boolean> idMap = (Map<String, Boolean>) application.getAttribute("ID");
            		boolean con = idMap.containsKey(as.getAsID());
            		if(con)
            		{
            			boolean judge = idMap.get(as.getAsID());
            			idMap.put(as.getAsID(), !judge);
            			request.getSession().setAttribute("judge",!judge);
            		}
            		else {
						idMap.put(as.getAsID(), true);
						request.getSession().setAttribute("judge",true);
					}
            		
            		request.getSession().setAttribute("assistant", as);
            		response.sendRedirect(request.getContextPath()+"/assistant/assistant_index.jsp");
            	}
            	else {
					request.setAttribute("msg","用户名或密码错误");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
            }
	}

}
