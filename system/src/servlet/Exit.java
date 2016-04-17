package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.Admin;
import user.Assistant;
import user.Student;
import user.Teacher;

public class Exit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            Student st = null;
            Teacher tc = null;
            Assistant as = null;
            Admin ad = null;
            if(request.getSession().getAttribute("student")!=null)
            {
            	st =(Student)request.getSession().getAttribute("student");
            }
            if(request.getSession().getAttribute("teacher")!=null)
            {
            	tc =(Teacher)request.getSession().getAttribute("Teacher");
            }
            if(request.getSession().getAttribute("assistant")!=null)
            {
            	as =(Assistant)request.getSession().getAttribute("Assistant");
            }
            if(request.getSession().getAttribute("admin")!=null)
            {
            	ad = (Admin)request.getSession().getAttribute("admin");
            }
        	ServletContext application = request.getServletContext();
        	@SuppressWarnings("unchecked")
			Map<String, Boolean> idMap = (Map<String, Boolean>) application.getAttribute("ID");
            if(st!=null)
            {
            	boolean con = idMap.containsKey(st.getStID());
            	if(con)
            	{
            		idMap.remove(st.getStID());
            	}
            	request.getSession().removeAttribute("student");
            }
            if(tc!=null)
            {
            	boolean con = idMap.containsKey(tc.getTcID());
            	if(con)
            	{
            		idMap.remove(tc.getTcID());
            	}
            	request.getSession().removeAttribute("teacher");
            }
            if(as!=null)
            {
            	boolean con = idMap.containsKey(tc.getTcID());
            	if(con)
            	{
            		idMap.remove(as.getAsID());
            	}
            	request.getSession().removeAttribute("assistant");
            }
            if(ad!=null)
            {
            	boolean con = idMap.containsKey(tc.getTcID());
            	if(con)
            	{
            		idMap.remove(ad.getAdID());
            	}
            	request.getSession().removeAttribute("admin");
            }
            request.getSession().invalidate();
            request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
