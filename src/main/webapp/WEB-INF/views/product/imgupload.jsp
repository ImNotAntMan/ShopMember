<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
	</head>
	<body>
		<h1>상품 이미지 등록</h1>
		<form action="/product/imgupload" method="post" enctype="multipart/form-data">
		<input type="hidden" name="p_code" value="${p_code}">
			상품 코드 : ${p_code}<br>
		<input type="file" name="p_image"><br>
		<input type="submit" value="저장하기">
		</form>
		<a href="javascript:Winclose();">닫기</a>
	</body>
	<script type="text/javascript">
		function Winclose() {
			opener.location.reload();
			window.close();
		}
	</script>
</html>