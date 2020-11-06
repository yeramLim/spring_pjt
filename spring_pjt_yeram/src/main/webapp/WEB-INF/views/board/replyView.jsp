<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="reply" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<input type="hidden" name="bId" value="${replyView.bId }">
			<input type="hidden" name="bGroup" value="${replyView.bGroup }">
			<input type="hidden" name="bStep" value="${replyView.bStep }">
			<input type="hidden" name="bIndent" value="${replyView.bIndent }">

			<tr>
				<td>번호</td>
				<td>${replyView.bId }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${replyView.bHit }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" value="${replyView.bName }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="[RE] ${replyView.bTitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="bContent" value="${replyView.bContent }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변"><a href="list">목록보기</a>
				</td>
			</tr>
		</table>

</body>
</html>