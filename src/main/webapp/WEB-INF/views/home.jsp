<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>EBOOK</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap.css'/>"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value='/resources/css/2-col-portfolio.css'/>"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.11.3.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/user-detail.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.bootpag.min.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#display").change();
	});
</script>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">E-BOOK</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">HOME</a></li>
				<li><a href="<c:url value='/uploadController/getUploadForm'/>">UPLOAD</a>
				</li>
				<li><a href="#">CONTACT</a></li>
			</ul>
		</div>

	</nav>

	<!-- Page Content -->
	<div id="display">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Books to Read.. <small>books at your fingertips</small>
					</h1>
				</div>
			</div>
			<!-- /.row -->

			<!-- Projects Row -->
			<div class="row">
				<c:forEach items="${bookVos}" var="book">
					<div class="col-md-6 portfolio-item">
						<a href="#"> <img class="img-responsive"
							src="<c:url value='/showBookController/getBookImage?filename=${book.bookImage}'/>"
							alt="">
						</a>
						<h3>
							<a href="#"><c:out value="${book.bookName}" /></a>
						</h3>

						<h4>
							By
							<c:out value="${book.bookAuthor}" />
						</h4>
						<h4>
							Published Date :
							<fmt:formatDate value="${book.date}" pattern="dd/MM/yy" />
						</h4>
						<p>
							Click here to view PDF : <a class="pdf-size"
								href="<c:url value='/showBookController/getPdf?pdfPath=${book.file}'/>"><img
								src="<c:url value='/resources/images/pdflogo.png'/>"
								style="width: 35px; height: 18px;"></a>
						</p>
					</div>

				</c:forEach>
			</div>
		</div>

	</div>
	<!-- /.row -->
	<c:set var="count" value="${count}"></c:set>
	<hr>
	<div id="content">Dynamic Content goes here</div>
	<div id="page-selection">Pagination goes here</div>
	<script>
		// init bootpag
		$('#page-selection').bootpag({
			total : "${count}"/3,
			page : "${count}"/4,
			maxVisible : 4
		}).on("page", function(event, num) {
			showNextPage((num-1)*4);

		});
		function showNextPage(pageIndex) {
			
			$
					.post(
							"<c:url value='/showbooks?num='/>" + pageIndex,
							null,
							function(response) {
								document.getElementById("display").innerHTML = response;

							});
		}
	</script>

	<hr>

	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Your Website 2014</p>
			</div>
		</div>
		<!-- /.row -->
	</footer>

	<!-- /.container -->


</body>

</html>
