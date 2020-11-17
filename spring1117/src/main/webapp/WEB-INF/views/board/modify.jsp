<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp" %>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시글 수정</h1>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">게시글 수정</div>
            <div class="panel-body">
                <form action="/board/modify" role="form" method="post">
                    <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
                    <input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
                    <div class="form-group">
                        <label>번호</label>
                        <input type="text" class="form-control" name="bno"
                            value='<c:out value="${board.bno}"/>'
                                readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>제목</label>
                        <input type="text" class="form-control" name="title"
                            value='<c:out value="${board.title}"/>'
                                readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>내용</label>
                        <textarea class="form-control" rows="3" name="content">
                            <c:out value="${board.content}"/>
                        </textarea>
                    </div>
                    <div class="form-group">
                        <label>저자</label>
                        <input type="text" class="form-control" name="writer"
                            value='<c:out value="${board.writer}"/>'
                                readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>등록일</label>
                        <input type="text" class="form-control" name="regDate"
                            value='<fmt:formatDate pattern="yyyy/MM/dd" 
                                value="${board.regDate}"/>' readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label>수정일</label>
                        <input type="text" class="form-control" name="updateDate"
                            value='<fmt:formatDate pattern="yyyy/MM/dd" 
                                value="${board.updateDate}"/>' readonly="readonly">
                    </div>
                    <!-- data-oper의 oper는 다른 곳에서 jquery로 value(modify/remove/list)를 얻음 -->
                    <button type="submit" data-oper="modify" class="btn btn-primary">수정</button>
                    <button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
                    <button type="submit" data-oper="list" class="btn btn-info">목록</button>
                </form>
            </div> <!-- panel-body의 끝 -->
        </div> <!-- panel의 끝 -->
    </div> <!-- col-lg-12의 끝 -->
</div> <!-- row의 끝 -->
<script>
    $(document).ready(function () {
        var formObj = $("form"); //form 태그를 찾아서 jquery 객체화
        $('button').on("click", function(e){ //버튼이 눌리면
            e.preventDefault(); //이벤트를 중지시키고
            var operation = $(this).data("oper"); //modify.jsp에서의 정보를 얻어옴
            console.log(operation);
            if(operation === 'remove'){
                formObj.attr("action", "/board/remove"); //form 태그의 action 값을 변경
            } else if(operation === 'list'){
                //리스트 목록으로 이동
                //self.location = "/board/list";
                formObj.attr("action", "/board/list")
                	.attr("method", "get"); //action과 method 변경

                var pageNumTag = $("input[name='pageNum']").clone();
                var amountTag = $("input[name='amount']").clone();

                formObj.empty(); //form 태그의 내용을 다 비움
                formObj.append(pageNumTag);
                formObj.append(amountTag);
                //return ;
            }
            formObj.submit();
        });
    });
</script>

<%@ include file="../includes/footer.jsp" %>