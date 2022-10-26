<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<h1 align="center">Welcome Admin</h1>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Show list of all books in the library</h5>
    <p class="card-text">Click here to see the list of all books</p>
   <a href="All_Books.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">ISSUE A BOOK</h5>
    <p class="card-text">Click here to issue a book to a user</p>
   <a href="IssueBook.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Add a new book in list</h5>
    <p class="card-text">Click here to add a new book in list</p>
   <a href="NewBook.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Return a book and calculate fine</h5>
    <p class="card-text">Click here to return a book and calculate fine</p>
    <a href="ReturnBook.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Discard a book</h5>
    <p class="card-text">Click here to discard a book form the book list</p>
   <a href="DiscardBook.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Issue Membership</h5>
    <p class="card-text">Click here to issue an membership to a new user</p>
    <a href="Issue_Membership.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Search for a book</h5>
    <p class="card-text">Click here to search for a book</p>
     <a href="SearchBook.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
<div class="card" style="margin:70px">
  <div class="card-body">
    <h5 class="card-title">Show list of all Members</h5>
    <p class="card-text">Click here to see the list of members</p>
   <a href="All_Members.jsp"> <button type="button" class="btn btn-primary">Button</button></a>
  </div>
</div>
</body>
</html>