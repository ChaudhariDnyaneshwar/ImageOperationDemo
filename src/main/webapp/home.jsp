<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row">
 
   <div class="col-sm-4">.col-sm-3</div>
   <div class="col-sm-4">
<div class="container">
  <h2>Student Data Fill form </h2>
  <form action="insert" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter your name" name="name">
    </div>
    <div class="form-group">
      <label for="age">Age:</label>
      <input type="number" class="form-control" id="age" placeholder="Enter your Age" name="age">
    </div>
    
    <div class="form-group">
      <label for="image">Image:</label>
      <input type="file" class="form-control" id="photo" placeholder="select img" name="photo">
    </div>
    <div class="form-group">
      <label for="button">button:</label>
      <input type="submit"  id="button" value="submit"  class="btn btn-success">
    </div>
    <p>${msg}</p>
    
    <a href="index.jsp" class="btn btn-success">List</a>
    </div>
  </form>
</div>
<div class="col-sm-4">.col-sm-3</div>
</div>




</body>
</html>