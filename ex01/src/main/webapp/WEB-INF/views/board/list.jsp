<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		let no = $(this).find(".no").text();
		location = "view.do?no="+no+"&inc=1";
		});
});
</script>
<style type="text/css">
.dataRow:hover{
	cursor: pointer;
}
</style>
</head>
<body>
<div class="container">
<h1>게시판리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="vo">	
				<tr class="dataRow">
					<td class="no">${vo.no }</td>
					<td>${vo.title }</td>
					<td>${vo.writer }</td>
					<td>${vo.writeDate }</td>
					<td>${vo.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<a href="write.do">글쓰기</a>
</div>
</body>
</html>