<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>On-line Reader</title>
<meta http-equiv="X-UA-Compatible"
	content="IE=EmulateIE7; IE=EmulateIE9">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon.ico.png" />">
<script type="text/javascript">
	
</script>
</head>
<body>

	<a id="bookForm"
		href="<c:url value='/uploadController/getUploadForm'/>">Upload
		Book </a>

	<table>
		<c:forEach items="${bookVos}" var="book">
			<tr>
				<td>Book_ID :</td>
				<td><c:out value="${book.id}" /></td>
			</tr>
			<tr>
				<td>Author :</td>
				<td><c:out value="${book.bookAuthor}" /></td>
			</tr>
			<tr>
				<td>Book Name :</td>
				<td><c:out value="${book.bookName}" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><c:out value="${book.email}"></c:out>
			<tr>

				<td>Image :</td>
				<td><img
					src="<c:url value='/showBookController/getBookImage?filename=${book.bookImage}'/>"
					width="100" heigth="100">
			</tr>
			<tr>
				<td>PDF <a
					href="<c:url value='/showBookController/getPdf?pdfPath=${book.file}'/>"><img
						src="<c:url value='/resources/images/pdflogo.png'/>" width="30"
						heigth="20"></a></td>


			</tr>
		</c:forEach>
	</table>
</body>
</html>
