<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- Centered Title -->
<h1 class="centered-title">CATEGORY TABLE - PROGRAMMING LOGIC
	CONTROLLER</h1>

<a href="${pageContext.request.contextPath }/admin/category/create"
	class="create-button"> Create New Category </a>
	
<table class="container">
	<thead>
		<tr>
			<th>STT</th>
			<th>Image</th>
			<th>Category ID</th>
			<th>Category Name</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${Listcate}" var="cate" varStatus="STT">
			<tr>
				<td>${STT.index + 1}</td>
				<td><c:if test="${cate.image.substring(0,5) != 'https'}">
						<c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
					</c:if> <c:if test="${cate.image.substring(0,5) == 'https'}">
						<c:url value="${cate.image}" var="imgUrl"></c:url>
					</c:if> <img height="150" width="200" src="${imgUrl}"
					alt="${cate.categoryname}" /></td>
				<td>${cate.categoryId}</td>
				<td>${cate.categoryname}</td>
				<td><c:if test="${cate.status == 1}">
						<span>Active</span>
					</c:if> <c:if test="${cate.status != 1}">
						<span>Non-Active</span>
					</c:if></td>
				<td><a
					href="<c:url value='/admin/category/update?id=${cate.categoryId}'/>">Update</a>
					| <a
					href="<c:url value='/admin/category/delete?id=${cate.categoryId}'/>">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- CSS Styles -->
<style>
body {
	font-family: 'Bahnschrift', sans-serif;
	/* Apply Bahnschrift font with fallback */
}

.centered-title {
	text-align: center; /* Center the title */
	margin-bottom: 20px; /* Space below the title */
}

.container {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.container {
	border: 2px solid #dc3545; /* Thicker border around the table */
}

.container th, .container td {
	border: 3px solid black; /* Thicker border for cells */
	padding: 12px;
	text-align: center; /* Center text in table cells */
}

.container th {
	background-color: #f4f4f4;
	color: #333;
}

.create-button {
	display: inline-block;
	background-color: #dc3545; /* Red background */
	color: white; /* White text */
	padding: 10px 15px;
	text-decoration: none;
	border-radius: 5px;
	margin-top: 10px;
}

.create-button:hover {
	background-color: #c82333; /* Darker red on hover */
}

img {
	border-radius: 5px;
}
</style>
