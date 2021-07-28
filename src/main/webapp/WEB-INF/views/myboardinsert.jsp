<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>INSERT</h1>

	<form action="insertres.do" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="mytitle" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성" />
					<input type="button" value="취소" onclick="" />
				</td>
			</tr>
		</table>	
	</form>

</body>
</html>