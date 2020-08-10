<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
 .fix{width:100%; height:450px; overflow:auto;}
   
</style>

</head>

<body>
<h2></h2>
<div class="row">
  <div class="col-sm-4">.col-sm-3</div>
   <div class="col-sm-4" >

<a href="list" class="btn btn-success">List</a>

<c:forEach items="${lis}" var="list">

    <!--  pannel code start -->
  <div class="panel panel-default">
  <div class="panel-body">A Basic Panel
  <div class="row">
  <div class="col-sm-6">
    <h3>Student Id:  ${list.id}  </h3> </br>  
     <h4>Student Name:    ${list.name}</h4></br>
      <h4>Student Age:    ${list.age}</h4></br>
          
    </div>      
    
    
    <div class="col-sm-6">
      <img width="100" height="100"  src="getStudentPhoto/<c:out value='${list.id}'/>" class="img-thumbnail" alt="Cinque Terre">
     <a href="delet/${list.id}" class="btn btn-danger">delete</a>
      </div>
     
   
   </div>
   </div>
</div>
                   <!--  pannel code end-->
  
    


</c:forEach>




</div>



  <div class="col-sm-4">.col-sm-3</div>
</div> 
</body>
</html>
