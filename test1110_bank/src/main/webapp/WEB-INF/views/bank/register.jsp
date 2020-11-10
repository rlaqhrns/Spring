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
            <form action="/bank/register" role="form" method="post">
                <div class="form-group">
                    <label>이름</label><input class="form-control" name="cus_name">
                </div>
                <div class="form-group">
                    <label>비밀번호</label><input class="form-control" name="cus_password">
                </div>
                
                <button type="submit" class="btn btn-default">전송 버튼</button>
                <button type="reset" class="btn btn-default">초기화 버튼</button>
                <button type="button" class="btn btn-info" onclick='location.href="/bank/list"'>목록</button>
            </form>
        </div>
    </div>
</div>


<%@ include file="../include/footer.jsp" %>