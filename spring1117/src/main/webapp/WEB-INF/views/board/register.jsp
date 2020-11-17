<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp" %>
	<div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">게시글 등록</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">게시글 등록</div>
            </div>
            <div class="panel-body">
                <form action="/board/register" role="form" method="post">
                    <div class="form-groupe">
                            <label>제목</label><input class="form-control" name="title">
                    </div>
                    <div class="form-groupe">
                        <label>텍스트 영역</label>
                        <textarea class="form-control" rows=3 name="content"></textarea>
                    </div>
                    <div class="form-groupe">
                        <label>저자</label><input class="form-control" name="writer">
                    </div>
                    <button type="submit" class="btn btn-primary">전송 버튼</button>
                    <button type="reset" class="btn btn-info">초기화 버튼</button>
                </form>
            </div>
        </div>
    </div>
<%@ include file="../includes/footer.jsp" %>