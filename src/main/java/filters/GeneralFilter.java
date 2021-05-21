package filters;

import filters.validation.RegisterValidation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class GeneralFilter implements Filter {

    public GeneralFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String email = (String)req.getParameter("mail_id");
		
		if(email == null || !RegisterValidation.isEmailValid(email)) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>"
					+ "<h1 style=\"color:red\" text-align:\"center\" >"
					+ "Please login"
					+ "</h1>"
					+ "<a href=\"login.html\">login</a>"
					+ "</html></body>");
			
		}
		else
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
