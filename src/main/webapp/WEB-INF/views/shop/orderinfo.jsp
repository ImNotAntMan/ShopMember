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

    <title>주문 정보</title>

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
                    <h1 class="h3 mb-2 text-gray-800">주문 정보</h1>
                    <p class="mb-4"></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">
                            	<a href="/shop/list">상품 리스트</a><br>
                            </h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table border=2 class="table table-bordered" width="100%" cellspacing="0" align="center">
                                	<thead>    
                                        <tr>
                                            <th>상세코드</th>
                                            <th>상품코드</th>
                                            <th>상품명</th>
                                            <th>이미지</th>
                                            <th>수량</th>
                                            <th>단가</th>
                                            <th>금액</th>
                                        </tr>
                                	</thead>
                                    <tbody>
                                		<c:forEach items="${list}" var="ordersub"> <%-- ${list}내의 이름이 model.addAttribute(이름, 메서드) 여기서의 이름과 같아야 한다. / 컨트롤해서 넘긴 모델을 이렇게 받아야 한다. 글이 5개 있다면 5번 반복하면서 보드에 저장한다는 의미 --%>
                                			<tr>
                                				<td>${ordersub.os_code}</td>
                                				<td>${ordersub.p_code}</td>
                                				<td>${ordersub.p_name}</td>
                                				<td><img src="/resources/product/${ordersub.p_code}.jpg" height="50"></td>
                                				<td>${ordersub.os_cnt}</td>
                                				<td><fmt:formatNumber value="${ordersub.p_price}" pattern="#,###" />원</td>
                                				<td><fmt:formatNumber value="${ordersub.os_money}" pattern="#,###" />원</td>
                                			</tr>
                                		</c:forEach>
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