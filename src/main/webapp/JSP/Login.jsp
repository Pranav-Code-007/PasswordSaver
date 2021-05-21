<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>       
<%@ page import="database.UserData" %>
<%@ page import="java.sql.ResultSet" %>        

<!DOCTYPE html>
<html lang="eng">
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account</title>
<style><%@include file="accountStyle.css"%></style>
</head>
<body>


 
 <p class="editlink">
        <a class="linked" href="Home.html">Home</a>
  <%String mail_id = request.getParameter("mail_id"); %>      
  </p>      
    <form class="edit" action="editprofile">
    <input type='hidden' name="mail_id" value="<%= mail_id%>">
    <input  type="submit" value="Edit Profile">
    </form>
    
    
    <form class="add" action="addrecord">
    <input type='hidden' name="mail_id" value="<%= mail_id%>">
    <input  type="submit" value="add new record">
    </form>
    
    <br><br>
    <% %>
    
    <% UserData user = UserData.getObject();%>
    <h2 style="text-align:center">Welcome <%= user.getName(mail_id) %></h2>
    <br><br>
    <h1>Your Data</h1>
    <% 
   ResultSet result =  user.getData(mail_id); 
    while(result.next()){
    out.println("<div class=\"di\">"+
            "<p>Link/Name :- </p>"+result.getString("link")+
            "<p>Username :- </p>"+result.getString("username")+
            "<p>Password :- </p>"+result.getString("password")+
        "</div>");
    }
    result.close();
    %>
    





</body>
</html>