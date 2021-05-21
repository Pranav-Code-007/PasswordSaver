<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage = "ErrorPage.jsp" %>      
<%@ page import="javax.servlet.http.Cookie" %>    

<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            padding-top: 5%;
            padding-left: 15%;
        }
        
        form {
            border: 5px solid #000000;
            width: 300px;
            height: 180px;
            padding-left: 30px;
        }
        
        input[type=submit] {
            color: rgb(0, 0, 0);
            border-color: rgb(64, 6, 156);
            background-color: aqua;
            font-weight: bold;
        }
        
        input[type=text] {
            width: 90%;
            padding-top: 10px;
            margin: 8px 0;
            display: inline-block;
            border: 2px solid rgb(0, 0, 0);
            box-sizing: border-box;
        }
    </style>
</head>

<body>

<%String mail_id = request.getParameter("mail_id") ;
Cookie ck=new Cookie("mail_id",mail_id);            //creating cookie object  
response.addCookie(ck);
ck =new Cookie("type","editprofile");
response.addCookie(ck);
%>
    <form name="SubmitData" action="submitt" method="post">
        Name <input type="text" name="name" minlength="3" maxlength="15"> <br><br> Last Name<input type="text" name="lastname" minlength="3" maxlength="15">
        <input type="submit" value="Submit">
    </form>
</body>

</html>