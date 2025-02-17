<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 세부사항</title>
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/detail.css">
</head>
<body>
	<div id="container">
		<main>
 		<jsp:include page = "/WEB-INF/views/include/header.jsp"></jsp:include> 
			<article class = "book-detail">
				<div class = "book-header">
					<h2 class = "book-title">${book.bookName }</h2>
					<div class = "book-info">
						<span>작가 : ${book.bookWriter } </span><br>
						<span>가격 : ${book.bookPrice }</span><br>
						<span>출판사 : ${book.publisher }</span><br>
						<span>장르 : ${book.genre }</span><br>
					</div>
				</div>
			</article>
			<div class = "button-group">
				<div class = "admin-button">
					<a href = "/book/delete?bookNo=${book.bookNo }" class="btn" onclick="deletelist">삭제</a>
					<a href = "/book/list" class="btn">목록</a>
				</div>
			</div>
		</main>
	</div>
	<!-- <script>
		function deletelist() {
			var answer = confirm("대여 정보까지 삭제됩니다.");	
		}
	</script> -->
		
</body>
</html>