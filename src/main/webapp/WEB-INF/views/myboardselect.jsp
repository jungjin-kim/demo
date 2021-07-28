<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>SELECT</h1>

	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'" />
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'" />
				<input type="button" value="목록" onclick="" />
			</td>
		</tr>
	</table>

</body>
</html>