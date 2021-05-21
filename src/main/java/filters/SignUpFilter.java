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



public class SignUpFilter implements Filter {

    public SignUpFilter() {}

	
	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
	//	HttpSession session = req.getSession();
		String name = (String)req.getParameter("name");
		String last_name = (String)req.getParameter("lastname");
		String email = (String)req.getParameter("mail_id");
		String password = (String)req.getParameter("password");
		PrintWriter out = response.getWriter();
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("signup.html");
		boolean flag=true;
		if(!RegisterValidation.isDataValid(name, last_name, email, password)){			
		flag = false;
		out.println("<html><body text=\"#ffffff\"><h2 style=\"color:white font-size:160% text-align:center;\">"+name+last_name+email+password+"Data is not valid</h2></body></html>");
		reqDispatcher.include(request, response);
		
		
			
		}else {
		UserData userData = UserData.getObject();	
		if(userData.isUserAvailable(email)) {
		flag=false;			
		out.println("<html><body text=\"#ffffff\"><h2 style=\"color:red font-size:160% text-align:center;\">User already exists</h2>"
				
				+ "</body></html>");
		reqDispatcher.include(request, response);
	}
		}
		if(flag==true) {
			try {
			UserData userData =  UserData.getObject();
			userData.insertData(name, last_name, email, password);
			}
			catch(SQLException e) {
				out.println("Something went wrong");
			}
			
		chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
