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
	<script>
		function ZipWinOpen(m_id) {
			window.open("/member/zipcode?m_id="+m_id, "", "width=500,height=600,toolbar=no, menubar=no, scrollbar=no");
		}
	</script>
    <title>회원 정보</title>

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
                    <h1 class="h3 mb-2 text-gray-800">상세보기</h1>
                    <p class="mb-4"></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/member/update?m_id=${member.m_id}&?pageNum=${pageNum}">정보수정</a></h6>
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/shop/orderinfo?m_id=${member.m_id}&?pageNum=${pageNum}">구매내역</a></h6>
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/member/logout?m_id=${member.m_id}&?pageNum=${pageNum}">로그아웃</a></h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        이름 : ${member.m_name}
                                    </div>
                                </div>
                                <div class="form-group">
                                   가입일 : ${member.m_rdate}
                                </div>
                                <div class="form-group">
                                   아이디 : ${member.m_id}
                                </div>
                                
                            </div>
                        </div>
                    </div>

                </div>
                    <h1 class="h3 mb-2 text-gray-800">배송지 리스트</h1>
                    <p class="mb-4"></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">
                            <input type="button" value="배송지 등록" class="form-control" onclick="ZipWinOpen('${member.m_id}')">
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                             	<c:forEach items="${list}" var="shipping">
                                <div class="form-group row">
                                 		<div class="col-sm-6 mb-3 mb-sm-0">
                                        	우편번호 : ${shipping.s_zipcode }<br>
                                        	주소 : ${shipping.s_address01}&nbsp;&nbsp;${shipping.s_address02}<br>
                                        	<a href="/member/shippingupdate?s_num=${shipping.s_num}&m_id=${m_id}">수정</a>&nbsp;&nbsp;&nbsp;
                                        	<a href="/member/shippingdelete?s_num=${shipping.s_num}">삭제</a>
                                    	</div>
								</div>
                               	</c:forEach>
                            </div>
                            <div>
                                    	<tr>
                                    		<td colspan="1" align="center">
                                    			<c:if test="${pageview.prev}">
                                    				<a href="/member/read?pageNum=${pageview.startPage - 1}&m_id=${m_id}">[<<]</a>&nbsp;&nbsp;
                                    				<a href="/member/read?pageNum=${pageview.startPage - 1}&m_id=${m_id}">[Prev]</a>&nbsp;&nbsp;
                                    			</c:if>
                                    			<c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
                                    				<c:if test="${num != pageview.page.pageNum}">
                                    					<a href="/member/read?pageNum=${num}&m_id=${m_id}">[${num}]</a>&nbsp;&nbsp;
                                    				</c:if>
                                    				<c:if test="${num == pageview.page.pageNum}">
                                    					<b>[${num}]</b>&nbsp;&nbsp;
                                    				</c:if>
                                    			</c:forEach>
                                    			<c:if test="${pageview.next}">
                                    				<a href="/member/read?pageNum=${pageview.endPage + 1}&m_id=${m_id}">[Next>]</a>&nbsp;&nbsp;
                                    				<a href="/member/read?pageNum=${pageview.endPage + 1}&m_id=${m_id}">[>>]</a>&nbsp;&nbsp;
                                    			</c:if>                                    			
                                    		</td>
                                    	</tr>
                        	</div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

<%@include file="../include/footer.jsp" %>
</body>

</html>