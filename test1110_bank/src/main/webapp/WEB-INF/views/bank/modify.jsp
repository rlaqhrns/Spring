<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">회원정보 수정</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">회원정보 수정</div>
            <div class="panel-body">
                <form action="/bank/modify" role="form" method="post">
                    <div class="form-group">
                        <label>번호</label>
                        <input type="text" class="form-control" name="cus_id" value='<c:out value="${bankTransaction.cus_id}"/>' readonly>
                    </div>
                    <div class="form-group">
                        <label>이름</label>
                        <input type="text" class="form-control" name="cus_name" value='<c:out value="${bankTransaction.cus_name}"/>' />
                    </div>
                    <div class="form-group">
                        <label>비밀번호</label>
                        <input type="text" class="form-control" name="cus_password" value='<c:out value="${bankTransaction.cus_password}"/>'>
                    </div>
                   
                   
                    <button type="submit" data-oper="modify" class="btn btn-default">수정</button>
                    <button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
                    <button type="submit" data-oper="list" class="btn btn-info">목록</button>
                </form>
            </div> <!-- panel-body끝 -->
        </div>  <!-- panel 끝 -->
    </div>  <!-- col-lg-12 끝 -->
</div>  <!-- row의 끝 -->

<script>
    $(document).ready(function() {
        let formObj = $("form");
        $("button").on("click", function(e){ //버튼이 눌리면
            e.preventDefault(); //이벤트를 중지시키고
            let operation = $(this).data("oper"); //modify.jsp에서의 정보를 얻어옴
            console.log(operation);
            if(operation === 'remove'){
                formObj.attr("action","/bank/remove"); //form tag의 action값을 변경
            } else if(operation === 'list'){
                //리스트 목록으로 이동
                self.location = "/bank/list";
                return;
            }
            formObj.submit();
        });
        
    });
</script>