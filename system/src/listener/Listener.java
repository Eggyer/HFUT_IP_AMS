package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		Map<String, Boolean> idMap = new HashMap<String, Boolean>();
		ServletContext application = event.getServletContext();
		application.setAttribute("ID", idMap);
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
	}
}
