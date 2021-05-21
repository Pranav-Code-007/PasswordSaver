<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>       
<%@ page import="javax.servlet.http.Cookie" %>    
<%@ page import="database.UserData" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>submit</title>
</head>
<body>
<%  
   final String EDITPROFILE = "editprofile";
   final String ADDRECORD = "addrecord";
   UserData user = UserData.getObject();
    Cookie ck[]=request.getCookies(); 
    String mail_id = ck[0].getValue();
    String type = ck[1].getValue();
    out.print("Hello "+ck[0].getValue());
    out.println("Hello "+ck[1].getValue()+"  "+request.getParameter("link"));
    try{
    if(EDITPROFILE.equals(type)){
    	user.updateName(request.getParameter("name"), mail_id);
    	user.updateLastName(request.getParameter("lastname"), mail_id);
    	out.println("<h3 style=\"color:green text-align:center;\">Profile Updated</h3>");
    	return;
    }
    if(ADDRECORD.equals(type)){

   user.insertNewRecord(mail_id, request.getParameter("link"), request.getParameter("username"), request.getParameter("password"));
   out.println("<h3 style=\"color:green text-align:center;\">Record Added</h3>");
    	return;
    }
    else{
    	out.println("<h1 style=\"color:red text-align:center;\">"+
                    "Error / Please Log In"+
    			    "<a href=\"login.html\">LogIn</a>");
    }
    }
    catch(Exception e){
    	out.println("Something went wrong");
    }
    %>
</body>
</html>