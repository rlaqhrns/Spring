<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp" %>

<div class="row">
  <div class="col-lg-12"></div>
    <h class="page-header">게시글 조회</h>
  
</div>

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">게시글 조회 페이지</div>
      <div class="panel-body">

        <div class="form-gruop">
          <label>번호</label>
          <input class="form-control" type="text" name="bno" 
            value='<c:out value="${board.bno}"/>' readonly>
        </div>

        <div class="form-gruop">
          <label>제목</label>
          <input class="form-control" type="text" name="title" 
            value='<c:out value="${board.title}"/>' readonly>
        </div>

        <div class="form-gruop">
          <label>내용</label>
          <textarea class="form-control" rows="3" name="content" readonly>
            <c:out value="${board.content}"/></textarea>
        </div>

        <div class="form-gruop">
          <label>글쓴이</label>
          <input class="form-control" type="text" name="writer" 
            value='<c:out value="${board.writer}"/>' readonly>
        </div>

        <button data-oper="modify" class="btn btn-info">수정</button>
          <%-- onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'" --%>
        
        <button data-oper="list" class="btn btn-primary">목록</button>
        	 <%--onclick="location.href='/board/list'"   --%>

          <form id="operForm" action="/board/list" method="get">
            <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
            <input type="hidden" id="bno" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
            <input type="hidden" id="bno" name="amount" value='<c:out value="${cri.amount}"/>'>
          </form>

      </div> <!-- end of panel-body -->
    </div> <!-- end of panel -->
  </div> <!-- end of col-lg-12 -->
</div> <!-- end of row -->

<script>
$(document).ready(function(){ //265페이지
    var operForm = $("#operForm");

    //수정버튼이 눌리면 form태그의 action을 수정페이지로 변경
    $("button[data-oper='modify']").on("click",function(e){
      operForm.attr("action","/board/modify").submit();
    })

    //목록버튼이 눌리면 form태그의 action을 목록페이지로 변경
    $("button[data-oper='list']").on("click",function(e){
    	console.log("들어오나")
      operForm.find("#bno").remove(); //목록전체를 보여줘야하므로 bno제거
      operForm.attr("action","/board/list").submit();
    })
  })
</script>

<%@ include file="../includes/footer.jsp" %>