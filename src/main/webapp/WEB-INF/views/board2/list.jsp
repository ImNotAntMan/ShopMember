<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>게시판 리스트</title>

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
                    <h1 class="h3 mb-2 text-gray-800">리스트</h1>
                    <p class="mb-4"></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/board2/insert">게시판 글 쓰기</a>${user}&nbsp;${age}세</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table border=2 class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>파일</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${list}" var="board">
                                    		<tr>
                                    			<td>${board.b_num}</td>
                                    			<td><a href="/board2/read?b_num=${board.b_num}&pageNum=${pageview.page.pageNum}">${board.b_subject}</a></td>
                                    			<td>
                                    			<c:set var="string1" value="${board.b_file}" />
                                    			<c:set var="length" value="${fn:length(string1)}" /> 
                                    			<c:set var="string2" value="${fn:substring(string1, length -3, length)}" />
												<c:if test="${board.b_file != null}">
                                    				<a href="/board2/download?b_num=${board.b_num}">${board.b_file}</a>
                                    			</c:if>
                                    			<c:if test="${board.b_file == null}">
                                    				없음
                                    			</c:if>
                                    			</td>
                                    			<td>${board.b_name}</td>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd HH-mm-ss" value="${board.b_date}" /></td>
                                    		</tr>
                                    	</c:forEach>
                                    	<tr>
                                    		<td colspan="5" align="center">
                                    			<c:if test="${pageview.prev}">
                                    				<a href="/board2/list?pageNum=${pageview.startPage - 1}">[<<]</a>&nbsp;&nbsp;
                                    				<a href="/board2/list?pageNum=${pageview.startPage - 1}">[Prev]</a>&nbsp;&nbsp;
                                    			</c:if>
                                    			<c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
                                    				<c:if test="${num != pageview.page.pageNum}">
                                    					<a href="/board2/list?pageNum=${num}">[${num}]</a>&nbsp;&nbsp;
                                    				</c:if>
                                    				<c:if test="${num == pageview.page.pageNum}">
                                    					<b>[${num}]</b>&nbsp;&nbsp;
                                    				</c:if>
                                    			</c:forEach>
                                    			<c:if test="${pageview.next}">
                                    				<a href="/board2/list?pageNum=${pageview.endPage + 1}">[Next>]</a>&nbsp;&nbsp;
                                    				<a href="/board2/list?pageNum=${pageview.endPage + 1}">[>>]</a>&nbsp;&nbsp;
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