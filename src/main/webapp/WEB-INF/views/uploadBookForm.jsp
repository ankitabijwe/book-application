<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible"
	content="IE=EmulateIE7; IE=EmulateIE9">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" type="text/css" href='<c:url value='/resources/css/style.css'/>'
	media="all" />
<link rel="stylesheet" type="text/css" href='<c:url value='/resources/css/demo.css'/>'
	media="all" />
	<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script type="text/javascript">
function uploadBook(){
	$.post("<c:url value='//uploadController/uploadBook'/>",$("#uploadForm").serialize(),function(response){
		alert(response);
	});
}</script>
</head>
<body>
	<div class="container">
		<!-- freshdesignweb top bar -->
		<div class="freshdesignweb-top">
			<!-- 	 -->
			<span class="right"> <a href="home.jsp"><strong>Home</strong></a>
			</span>
			
			<div class="clr"></div>
		</div>
		<!--/ freshdesignweb top bar -->
		<header>
		<h1>
			<span></span>UPLOAD BOOK
		</h1>
		</header>
		<div id="msg">
			<label style="color:red">${msg}</label>
			</div>
		<div class="form">
		
			<form id="uploadForm" method="post" enctype="multipart/form-data"   
		action="../uploadController/uploadBook">   <!-- onsubmit="uploadBook()"> --> 
				<p class="contact">
					<label for="name">Book Name </label>
				</p>
				<input id="bookName" name="bookName" placeholder="book Name"
					required="" tabindex="1" type="text"><br>
				<br>

				<p class="contact">
					<label for="name">Author Name </label>
				</p>
				<input id="bookAuthor" name="bookAuthor" placeholder="author Name"
					required="" tabindex="1" type="text"><br>
				<br>

				<p class="contact">
					<label for="email">Email</label>
				</p>
				<input id="email" name="email" placeholder="example@domain.com"
					required="" type="email"><br>
				<br>

				<p class="contact">
					<label for="username">Upload pdf</label>
				</p>
				<input id="file" style="visibility: show;" name="file"
					type="file" /><br>
				<br>

				<p class="contact">
					<label for="username">Upload Book Image</label>
				</p>
				<input type="file" name="bookImage" id="bookImage"><br>
				<br> <input class="buttom" name="submit" id="submit"
					tabindex="5" value="Submit" type="submit"> <input
					class="buttom" name="reset" id="reset" tabindex="5" value="Reset"
					type="reset">
			</form>
		</div>
	</div>

</body>
</html>