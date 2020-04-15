<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("userId") %>
	<br>
	
	<div class="result">
		<p id="result">${isUserExist}</p>
		<p id="endpoint">search has ended.</p>
	</div>
</body>
</html>