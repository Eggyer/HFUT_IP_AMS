package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoadingFilter
 */
@WebFilter("/*")
public class LoadingFilter  implements Filter {

    public LoadingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    //处理post编码问题
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest) request; 
		//调用修饰类EncodingRequest将其get进行修改编码
		if(req.getMethod().equalsIgnoreCase("GET"))
		{
		   EncodingRequest erEncodingRequest = new EncodingRequest(req);
		   chain.doFilter(erEncodingRequest, response);
		}else if(req.getMethod().equals("POST"))
		{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
