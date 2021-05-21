
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignUp() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
//		stmt.executeUpdate("create table users( name varchar(15) not null , last_name varchar(15) not null , email varchar(20) not null , password varchar(12) not null , primary key(email))");
//		stmt.executeUpdate("create table data(username varchar(15) , password varchar(15) , link varchar(25) , email varchar(20) references users(email))");
		
		 PrintWriter out = response.getWriter();
		 out.println("doGet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		
//		String name = request.getParameter("name").trim();
//	    String last_name = request.getParameter("lastname").trim();
//	    String email = request.getParameter("mail_id").trim();
//	    String password = request.getParameter("password").trim();
//	   
        out.println("<html>");
	    out.println("<html><body text=\"#00FF00\"><h1 style=\"text-align:center;\">You have successfully registered</h1>"
	    		+ "<a href=\"login.html\">Login</a>"
	    		+ "</body></html>");
		out.println("</html>");
		out.close();
		
	}

}
