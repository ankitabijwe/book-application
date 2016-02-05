<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script type="text/javascript">
function showBook(){
	alert("Hi ...........");
	$.post("<c:url value='/showBookController/showBook'/>",null, function(response){
		alert("Hello");
		var data = response;
	});
}
</script>
</head>
<body>
<label>Search Book</label>
<select >
<option value ="bookName"> Book Name</option>
<option value ="bookAuthor">Author Name </option>
</select>

<input type="button" onclick="showBook()" value="Show book"/>
</body>
</html>