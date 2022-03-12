<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>상품 관리</title>

    <!-- Custom fonts for this template -->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/js/demo/datatables-demo.js"></script>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

<%@include file="../include/left.jsp" %>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

<%@include file="../include/header.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">상품 리스트</h1>
                    <p class="mb-4"></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/product/insert">상품 등록</a></h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table border=2 class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>고유번호</th>
                                            <th>이  름</th>
                                            <th>단가</th>
                                            <th>이미지</th>
                                            <th>작성일</th>
                                            <th>수정일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${list}" var="product">
                                    		<tr>
                                    			<td><a href="/product/read?p_code=${product.p_code}">${product.p_code}</a></td>
                                    			<td>${product.p_name}</td>
                                    			<td>${product.p_price}원</td>
                                    			<td><img src="/resources/product/${product.p_code}.jpg" height="50" width = "40"></td>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd HH-mm-ss" value="${product.p_rdate}" /></td>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd HH-mm-ss" value="${product.p_udate}" /></td>
                                    		</tr>
                                    	</c:forEach>
                                    	<tr>
                                    		<td colspan="6" align="center">
                                    			<c:if test="${pageview.prev}">
                                    				<a href="/admin/list?pageNum=${pageview.startPage - 1}">[<<]</a>&nbsp;&nbsp;
                                    				<a href="/admin/list?pageNum=${pageview.startPage - 1}">[Prev]</a>&nbsp;&nbsp;
                                    			</c:if>
                                    			<c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
                                    				<c:if test="${num != pageview.page.pageNum}">
                                    					<a href="/admin/list?pageNum=${num}">[${num}]</a>&nbsp;&nbsp;
                                    				</c:if>
                                    				<c:if test="${num == pageview.page.pageNum}">
                                    					<b>[${num}]</b>&nbsp;&nbsp;
                                    				</c:if>
                                    			</c:forEach>
                                    			<c:if test="${pageview.next}">
                                    				<a href="/admin/list?pageNum=${pageview.endPage + 1}">[Next>]</a>&nbsp;&nbsp;
                                    				<a href="/admin/list?pageNum=${pageview.endPage + 1}">[>>]</a>&nbsp;&nbsp;
                                    			</c:if>                                    			
                                    		</td>
                                    	</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

<%@include file="../include/footer.jsp" %>
</body>

</html>