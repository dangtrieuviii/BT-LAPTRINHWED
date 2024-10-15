<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="col-md-9 col-sm-9 profile-container">
		<h1>Update Profile</h1>
		<div class="content-form-page">
			<div class="row">
				<div class="col-md-7 col-sm-7">
					<form action="${pageContext.request.contextPath}/update"
						method="post" enctype="multipart/form-data"
						class="form-horizontal form-without-legend" role="form">
						<c:if test="${alert !=null}">
							<h3 class="alert alertdanger">${alert}</h3>
						</c:if>
						<div class="form-group">
							<label for="fullname" class="col-lg-4 control-label">Fullname</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="fullname"
									name="fullname" required>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="email" name="email">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-lg-4 control-label">Phone</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="phone" name="phone">
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-offset-6 col-lg-8">
								<button type="submit" class="btn btn-primary">Update</button>
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
