<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: #1e90ff;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
  
input[type=text], input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
input[type=text]:focus, input[type=password]:focus {  
  background-color: orange;  
  outline: none;  
}  
 div {  
            padding: 10px 0;  
         }  
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
</style>  
</head>  
<body>  
<form action="BookIssueUser" method=post>  
  <div class="container">  
  <center>  <h1> BOOK ISSUE</h1> </center>  
  <hr>  
  <label> Member Name </label>   
<input type="text" name="member_name" placeholder= "MemberName" size="15" required />  
 <label> Member Id </label>   
<input type="text" name="member_id" placeholder= "MemberID" size="15" required />   
  
<label> Book Name </label>    
<input type="text" name="book_name" placeholder="BookName" size="15"required />   
<label> Book ID </label>    
<input type="text" name="book_id" placeholder="BookID" size="15"required />  
<div>  

<button type="submit"  class="registerbtn" >Register</button>    
</form>  
</body>  
</html>  