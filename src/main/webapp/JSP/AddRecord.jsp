<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>       
<%@ page import="javax.servlet.http.Cookie" %>  
<!DOCTYPE html>
<html>
<head>
<head>
    <style><%@include file="recordStyle.css"%></style>
    <title>addRecord</title>
</head>

<body>
<%String mail_id = request.getParameter("mail_id") ;
Cookie ck=new Cookie("mail_id",mail_id);//creating cookie object  
response.addCookie(ck);
ck =new Cookie("type","addrecord");
response.addCookie(ck);
%>
    <form name="SubmitData" action="submitt" method="post">
        <h1>NEW RECORD</h1>

        <div class="formcontainer">
            <div class="container">
                <label for="uname"><strong>Name/Link</strong></label>
                <input type="text" name="link" placeholder="Enter the url link or name of the website" name="link" minlength="3" maxlength="20" required>
                <label for="mail"><strong>Username</strong></label>
                <input type="text" name="username" placeholder="Enter the username" name="mail" minlength="3" maxlength="15" required>
                <label for="psw"><strong>Password</strong></label>
                <input type="password" name="password" placeholder="Enter Password" name="passowrd" minlength="8" maxlength="12" required>
            </div>
            <button type="submit"><strong>SUBMIT</strong></button>
        </div>
    </form>
</body>

</html>