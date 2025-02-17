<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/mypage.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<div class="container">
	<main>
		<h2 class="title">회원 정보</h2>
		<form action="/user/mypage" method = "post">
				<div class="info-group">
					<label>아이디</label>
					<input type = "text" value="${user.userId }" name="userId"> <br>				
				</div>
				<div class="info-group">
					<label>이름</label>
					<input type = "text" value="${user.userName }" name="userName"> <br>				
				</div>
				<div class="info-group">
					<label>나이</label>
					<input type = "number" min="14"value="${user.age }"  name = "age"> <br>				
				</div>
				<div class="info-group">
					<label>주소</label>
					<input type = "text" value="${user.userAddr }" name="userAddr"> <br>				
				</div>
				<div class="info-group">
					<label>성별</label>
					<div class="radio-group">
					<label>
						<input type = "radio" name = "gender" value ="M" <c:if test="${user.gender == 'M' }">checked</c:if>>남					
					</label>
					<label>
						<input type ="radio" name="gender" value="F" <c:if test="${user.gender == 'F' }">checked</c:if>>여 <br>				
					</label>
					</div>
				</div>
					<button type ="submit" class="save-button">회정 정보 수정완료</button>
			</form>
				<form action="/user/delete" method="post">
	   				 <input type="hidden" name="userId" value="${user.userId}">
	   				 <button class="del-button" type="submit">회원탈퇴</button>
				</form>
	</main>
	</div>
</body>
</html>