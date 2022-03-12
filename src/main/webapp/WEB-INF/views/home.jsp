<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Shop Member Home</title>
</head>
<body>
<p><a href="/member/logout">로그아웃</a></p>
<p><a href="/member/login">로그인</a></p>
<h1>
	Hello Shop Member!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  아이뒤 : ${m_id} </P>
<P>  이이름 : ${m_name} </P>
</body>
</html>