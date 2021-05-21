package filters;

import database.UserData;
import filters.validation.RegisterValidation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LogInFilter implements Filter {

    
    public LogInFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String mail_id = (String)req.getParameter("mail_id");
		String password = (String)req.getParameter("password");
		PrintWriter out = resp.getWriter();
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("login.html");
		boolean flag = true;
		if(!(RegisterValidation.isEmailValid(mail_id) && RegisterValidation.isPasswordValid(password))) {
			flag = false;
			
			out.println("<html><body text=\"#ffffff\"><h2 style=\"color:red font-size:160% text-align:center;\">"
					+ "Wrong loginId or Password</h2>"
					+ "</body></html>");
			
			reqDispatcher.include(req, resp);	
		
		
		}
		else {
			
         UserData userdata= UserData.getObject();
         
         
			if(!userdata.isUserAvailable(mail_id)) {
				
				flag = false;
				out.println("<html><body text=\"#ffffff\"><h2 style=\"color:red font-size:160% text-align:center;\">"
						+ "User does not exist</h2>"
						+ "</body></html>");
				
				reqDispatcher.include(req, resp);	
					
		}
			else {
				try {
				if(!password.equals(userdata.getPassword(mail_id))){
					flag = false;
					out.println("<html><body text=\"#ffffff\"><h2 style=\"color:red font-size:160% text-align:center;\">"
							+ "Password is Incorrect</h2>"
							+ "</body></html>");
					
					reqDispatcher.include(req, resp);	
					
				}
				}
				catch(SQLException e) {
					System.out.println("Exception Occured in LogInFilter" +e.getMessage());
				}
				
				
			}
		
		}
		
		
		if(flag==true) {
			chain.doFilter(request, response);	
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
