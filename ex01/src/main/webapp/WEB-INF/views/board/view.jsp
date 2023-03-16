<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>글보기</h1>
	
	<table class="table">
		<tbody>
			<tr>
				<th>번호</th>
				<td>${vo.no }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td style="height: 200px">${vo.content }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${vo.writer }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.writeDate }"/></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><fmt:formatNumber pattern="#,###" value="${vo.hit }" /></td>
			</tr>
		</tbody>
	</table>
	
	<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">리스트</a>
	<a href="update.do?no=${vo.no }&inc=0&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}" class="btn btn-default">수정</a>
	
	<!-- 삭제버튼 누르면 밑의 비밀번호 입력 div가 나오게 -->
	<a href="#" class="btn btn-default" onclick="return false">삭제</a>
	
	<div>
		<form action="delete.do" method="post">
			<input name="no" value="${vo.no }" type="hidden">
			<div class="form-group">
				<label>비밀번호 :</label>
				<input name="pw" class="form-control">
			</div>
			<button class="btn btn-default">삭제</button>
		</form>		
	</div>

</div>
</body>
</html>