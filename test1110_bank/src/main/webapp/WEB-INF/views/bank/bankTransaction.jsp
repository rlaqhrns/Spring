<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../include/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"> 게시글 등록</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading"></div>
        </div>
        <div class="panel-body">
            <form action="/bank/bankTransaction" role="form" method="post">
                <div class="form-group">
                    <label>번호</label><input type="hidden" class="form-control" name="cus_id" value='<c:out value="${bankTransaction.cus_id}"/>'readonly>
                </div>
                <div class="form-group">
                    <label>이름</label><input class="form-control" name="cus_name" value='<c:out value="${bankTransaction.cus_name}"/>'readonly>
                </div>
                <div class="form-group">
                    <label>잔고</label><input class="form-control" name="balance" value='<c:out value="${bankTransaction.balance}"/>'readonly>
                </div>
                <div class="form-group">
                    <label>입금</label><input class="form-control" value="0" name="deposit">
                </div>
                <div class="form-group">
                    <label>출금</label><input class="form-control" value="0" name="withdraw">
                </div>
                
                <button type="submit" class="btn btn-default">전송 버튼</button>
                <button type="reset" class="btn btn-default">초기화 버튼</button>
                <button type="button" class="btn btn-info" onclick='location.href="/bank/list"'>목록</button>
                
            </form>
        </div>
    </div>
</div>


<%@ include file="../include/footer.jsp" %>