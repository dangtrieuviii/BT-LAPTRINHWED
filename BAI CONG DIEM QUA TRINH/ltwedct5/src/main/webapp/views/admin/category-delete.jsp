<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="formbold-main-wrapper">
	<div class="formbold-form-wrapper">
		<!-- Form to delete product by ID -->
		<form action="${pageContext.request.contextPath}/admin/product/delete"
			method="post">
			<h2 class="formbold-form-label formbold-form-label-2"
				style="color: #dc3545; text-align: center; font-size: 24px; text-transform: uppercase;">Delete
				Product by ID</h2>

			<div class="formbold-mb-5">
				<label for="productId" class="formbold-form-label">Product
					ID <span style="color: red;">*</span>
				</label> <input type="text" id="categoryid" name="categoryid"
					placeholder="Enter product ID" class="formbold-form-input" required />
			</div>

			<div style="margin-top: 20px;">
				<!-- Submit button for deleting product -->
				<button type="submit" class="formbold-btn w-full">Delete</button>
			</div>
		</form>

		<!-- Message section for deletion status (success/failure) -->
		<%
		String deleteStatus = (String) request.getAttribute("deleteStatus");
		if (deleteStatus != null) {
		%>
		<p
			style="color: <%="Success".equals(deleteStatus) ? "green" : "red"%>; text-align: center;">
			<%=deleteStatus%>
		</p>
		<%
		}
		%>
	</div>
</div>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Inter", sans-serif;
}

.formbold-main-wrapper {
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 48px;
}

.formbold-form-wrapper {
	margin: 0 auto;
	max-width: 550px;
	width: 100%;
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.formbold-form-label {
	display: block;
	font-weight: 500;
	font-size: 16px;
	color: #07074d;
	margin-bottom: 8px;
}

.formbold-form-input {
	width: 100%;
	padding: 12px 16px;
	border-radius: 6px;
	border: 1px solid #e0e0e0;
	background: white;
	font-weight: 500;
	font-size: 16px;
	color: #6b7280;
	outline: none;
	resize: none;
	margin-bottom: 20px;
}

.formbold-btn {
	text-align: center;
	font-size: 16px;
	border-radius: 6px;
	padding: 14px 32px;
	border: none;
	font-weight: 600;
	background-color: #dc3545;
	color: white;
	cursor: pointer;
	width: 100%;
}

.formbold-btn:hover {
	background-color: #c82333;
	box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
}
</style>
