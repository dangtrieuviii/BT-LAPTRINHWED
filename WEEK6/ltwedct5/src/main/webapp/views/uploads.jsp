<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Upload File</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 600px;
	margin: auto;
	padding: 20px;
	background-color: white;
	border-radius: 5px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 15px;
}

input[type="text"], input[type="email"], input[type="file"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	background-color: red;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: darkred;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Upload File</h2>
		<form action="${pageContext.request.contextPath}/upload" method="post"
			enctype="multipart/form-data">

			<div class="form-group">
				<label for="file">Choose File:</label> <input type="file"
					name="file" id="file" required />
			</div>
			<div>
				<button type="button"
					onclick="location.href='${pageContext.request.contextPath}/update">Update</button>
			</div>
			<div>
				<button type="submit">Upload</button>
			</div>
		</form>
	</div>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload File</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
    <div class="col-md-9 col-sm-9 profile-container">
        <h1>Upload File</h1>
        <div class="content-form-page">
            <div class="row">
                <div class="col-md-7 col-sm-7">
                    <form method="post" action="${pageContext.request.contextPath}/uploads" enctype="multipart/form-data" class="form-horizontal form-without-legend" role="form">
                        <c:if test="${alert !=null}">
						<h3 class="alert alertdanger">${alert}</h3>
					</c:if>
                        <div class="form-group">
                            <label for="multiPartServlet" class="col-lg-4 control-label">Choose a file:</label>
                            <div class="col-lg-8">
                                <input type="file" name="multiPartServlet" id="multiPartServlet" class="form-control" required />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-4 col-lg-8">
                                <input type="submit" value="Upload" class="btn btn-default" />
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right"></div>
            </div>
        </div>
    </div>
</body>
</html>
