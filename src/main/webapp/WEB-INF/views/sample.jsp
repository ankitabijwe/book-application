<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
