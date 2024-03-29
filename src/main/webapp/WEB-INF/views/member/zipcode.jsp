<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
	</head>
	<body>
		<h1>배송지 등록</h1>
		<form action="/member/shippinginsert" name="frm" id="frm" method="post">
			<input type="hidden" name="m_id" value="${m_id}">
        	<input type="text" name="s_zipcode" id="sample4_postcode" class="d_form mini" placeholder="우편번호">
	        <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="d_btn"><br>
    	    <input type="text" name="s_address01" id="sample4_roadAddress" class="d_form std" placeholder="도로명주소">
 	        <span id="guide" style="color:#999;display:none"></span>
    	    <input type="text" name="s_address02" id="sample4_detailAddress" class="d_form" placeholder="상세주소">
    	    <br>
        	<input type="button" value="배송지 등록" class="form-control" onclick="document.getElementById('frm').submit();">&nbsp;
        	<a href="javascript:Winclose();">닫기</a>
        </form>
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script>
            function sample4_execDaumPostcode() {
                new daum.Postcode({
                    oncomplete: function(data) {
                        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                        // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                        var roadAddr = data.roadAddress; // 도로명 주소 변수
                        var extraRoadAddr = ''; // 추가 정보 변수

                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraRoadAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraRoadAddr !== ''){
                            extraRoadAddr = ' (' + extraRoadAddr + ')';
                        }

                        // 우편번호와 주소 정보를 해당 필드에 넣는다.
                        document.getElementById('sample4_postcode').value = data.zonecode;
                        document.getElementById("sample4_roadAddress").value = roadAddr;
                        document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                        
                        // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                        if(roadAddr !== ''){
                            document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                        } else {
                            document.getElementById("sample4_extraAddress").value = '';
                        }

                        var guideTextBox = document.getElementById("guide");
                        // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                        if(data.autoRoadAddress) {
                            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                            guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                            guideTextBox.style.display = 'block';
                        } else {
                            guideTextBox.innerHTML = '';
                            guideTextBox.style.display = 'none';
                        }
                    }
                }).open();
            }
        </script>
	</body>
	<script type="text/javascript">
		function Winclose() {
			opener.location.reload();
			window.close();
		}
	</script>
<div class="card-body">
	<div class="table-responsive">
		<c:forEach items="${list}" var="shipping">
			<div class="form-group row">
				<div class="col-sm-6 mb-3 mb-sm-0">
					우편번호 : ${shipping.s_zipcode }<br> 주소 :
					${shipping.s_address01}&nbsp;&nbsp;${shipping.s_address02}<br>
					<a href="/member/shippingupdate?s_num=${shipping.s_num}&m_id=${m_id}">수정</a>&nbsp;&nbsp;&nbsp;
					<a href="/member/shippingdelete?s_num=${shipping.s_num}&m_id=${m_id}">삭제</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<tr>
			<td colspan="1" align="center">
			<c:if test="${pageview.prev}">
				<a href="/member/zipcode?pageNum=${pageview.startPage - 1}&m_id=${m_id}">[<<]</a>&nbsp;&nbsp;
                <a href="/member/zipcode?pageNum=${pageview.startPage - 1}&m_id=${m_id}">[Prev]</a>&nbsp;&nbsp;
            </c:if>
            <c:forEach var="num" begin="${pageview.startPage}" end="${pageview.endPage}">
				<c:if test="${num != pageview.page.pageNum}">
					<a href="/member/zipcode?pageNum=${num}&m_id=${m_id}">[${num}]</a>&nbsp;&nbsp;
                </c:if>
				<c:if test="${num == pageview.page.pageNum}">
					<b>[${num}]</b>&nbsp;&nbsp;
                </c:if>
				</c:forEach> <c:if test="${pageview.next}">
					<a href="/member/zipcode?pageNum=${pageview.endPage + 1}&m_id=${m_id}">[Next>]</a>&nbsp;&nbsp;
                    <a href="/member/zipcode?pageNum=${pageview.endPage + 1}&m_id=${m_id}">[>>]</a>&nbsp;&nbsp;
                </c:if>
        	</td>
		</tr>
	</div>
</div>
</html>