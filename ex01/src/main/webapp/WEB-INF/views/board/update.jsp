<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>글수정폼</h1>
		<form action="update.do" method="post">
			<div class="form-group">
				<label>글번호</label>
				<input id ="no" name="no" class="form-control" readonly="readonly" value="${vo.no }">
			</div>
			<div class="form-group">
				<label>제목</label>
				<input id="title" name="title" class="form-control" value="${vo.title }">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea id="content" rows="5" name="content" class="form-control">${vo.content }</textarea>
			</div>
			<div class="form-group">
				<label>작성자</label>
				<input id="writer" name="writer" class="form-control" readonly="readonly" value="${vo.writer }">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input id="pw" name="pw" class="form-control" type="password">
			</div>
			<button>수정</button>
		</form>
	</div>
</body>
</html>