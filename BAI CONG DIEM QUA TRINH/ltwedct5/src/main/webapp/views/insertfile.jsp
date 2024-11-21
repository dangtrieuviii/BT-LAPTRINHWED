<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>Servlet Multipart</div>


<form method="post" action="/HelloWorld/multiPartServlet" enctype="multipart/form-data">


Choose a file: <input type="file" name="multiPartServlet"/>


<input type="submit" value="Upload"/>


</form>
</body>
</html>