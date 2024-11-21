<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- Centered Title -->
<h1 class="centered-title">VIDEO TABLE - PROGRAMMING LOGIC
	CONTROLLER</h1>

<a href="${pageContext.request.contextPath }/admin/video/create"
	class="create-button"> Create New Category </a>

<table class="container">
	<thead>
		<tr>
			<th>STT</th>
			<th>Video Image</th>
			<th>Video Title</th>
			<th>Description</th>
			<th>Views</th>
			<th>Category</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${Listvid}" var="vid" varStatus="STT">
			<tr>
				<td>${STT.index + 1}</td>
				<td><c:if test="${vid.poster.substring(0,5) != 'https'}">
						<c:url value="/image?fname=${vid.poster}" var="imgUrl"></c:url>
					</c:if> <c:if test="${vid.poster.substring(0,5) == 'https'}">
						<c:url value="${vid.poster}" var="imgUrl"></c:url>
					</c:if> <img height="150" width="200" src="${imgUrl}" alt="${vid.title}" />
				</td>
				<td>${vid.title}</td>
				<td>${vid.description}</td>
				<td>${vid.views}</td>
				<td><c:if test="${vid.active == 1}">
						<span>Active</span>
					</c:if> <c:if test="${vid.active != 1}">
						<span>Non-Active</span>
					</c:if></td>
				<td><a
					href="<c:url value='/admin/video/update?id=${vid.videoid}'/>">Update</a>
					| <a href="<c:url value='/admin/video/delete?id=${vid.videoid}'/>">Delete</a>
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
