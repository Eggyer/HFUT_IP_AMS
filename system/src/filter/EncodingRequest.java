package filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * 装饰reqeust
 * @author acm
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}
	public String getParameter(String name)
	{
		String value = req.getParameter(name);
		try {
			value = new String(value.getBytes("iso-8859-1"), "utf-8");
			System.out.println("编码用了没！！！！");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("编码出错了");
		}
		return value;	
	}

}
