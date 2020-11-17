<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp" %>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables 예제</h6>
              <button id="regBtn" type="button" class="btn btn-xs pull-right">
                신규 게시글 등록
              </button>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  <c:forEach items="${list}" var="board">
                    <tr>
                    <!-- 번호와 제목에 hyperlink 걸기 254p -->
                      <td><c:out value="${board.bno}"/></td>
                      <%-- <td><a href='/board/get?bno=<c:out value="${board.bno}"/>'> --%> <!-- 309p -->
                        <%-- <c:out value="${board.title}"/></a></td> --%>
                      <td><a class='move' href='<c:out value="${board.bno}"/>'>
                        <c:out value="${board.title}"/></a></td>
                      <td><c:out value="${board.writer}"></c:out></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" 
                            value="${board.regDate}"/>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" 
                            value="${board.updateDate}"/>
                  </c:forEach>
                  </tbody>
                </table>
                <!-- End of DataTales Example -->
                <div class="row">
                  <div class="col-lg-12">
                    <form action="/board/list" id="searchForm" method="get">
                      <select name="type">
                        <option value=""
                          <c:out value="${pageMaker.cri.type==null?'selected':''}"/>>--
                        </option>
                        <option value="T">
                          <c:out value="${pageMaker.cri.type eq 'T' ? 'selected':''}"/>
                        제목</option>
                        <option value="C">
                        <c:out value="${pageMaker.cri.type eq 'C' ? 'selected':''}"/>
                        내용</option>
                        <option value="W">
                        <c:out value="${pageMaker.cri.type eq 'W' ? 'selected':''}"/>
                        저자</option>
                        <option value="TC">
                          <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected':''}"/>
                        제목 OR 내용</option>
                        <option value="TW">
                          <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected':''}"/>
                        제목 OR 저자</option>
                        <option value="TWC">
                          <c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected':''}"/>
                        제목 OR 저자 OR 내용</option>
                      </select>
                      <input type="text" name="keyword"
                        value='<c:out value="${pageMaker.cri.keyword}"/>'/>
                      <input type="hidden" name="pageNum" value='${pageMaker.cri.pageNum}'
                        value='<c:out value="${pageMaker.cri.pageNum}"/>'/>
                      <input type="hidden" name="amount" value='${pageMaker.cri.amount}'
                        value='<c:out value="${pageMaker.cri.amount}"/>'/>
                      <button class="btn btn-preventDefault">검색</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row"> <!-- 311p -->
            <div class="col-lg-12">
              <form action="/board/list" id="actionForm" method="get">
                <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
              </form>
            </div>
          </div>      
          <div class="pull-right">
            <ul class="pagination">
              <c:if test="${pageMaker.prev}">
                <li class="paginate_button previous"><a href="#">이전</a></li>
              </c:if>
              <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                <li class="pagenate_button"><a href="#">${num}</a></li>
              </c:forEach>
              <c:if test="${pageMaker.next}">
                <li class="paginate_button next"><a href="${pageMaker.endPage +1}">Next</a></li>
              </c:if>
            </ul>
          </div>
                
          <div class="modal" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Modal title</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <p>작업이 완료되었습니다.</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  
  <script>
    $(document).ready(function(){//250p, 257p history로 수정
      var result = '<c:out value="${result}"/>';
      checkModal(result);
      history.replaceState({}, null, null); //257p
      //history가 스택에 쌓이는 상태는 모달창을 보여주지 않기 위해 추가함
      function checkModal(result) {

        if (result === '' || history.state) { // or 추가
        //result에 값이 없거나 state가 스택(LIFO-Last Input First Ouput)에 있으면 true가 되므로 종료함
          return;
        }
        
        if (parseInt(result) > 0) {
          $(".modal-body").html(
              "게시글 " + parseInt(result)
                  + " 번이 등록되었습니다.");
        }
        
        $("#myModal").modal("show");
      }
      
      //311p
        $("#regBtn").on("click", function(){
          self.location = "/board/register";
        });
        var actionForm = $("#actionForm");
        $(".paginate_button a").on("click", function(e){
          e.preventDefault();
          console.log('click');
          actionForm.find("input[name='pageNum']").val($(this).attr("href"));
        //id가 actionForm (Form, input type=hidden)
        //class가 paginate_button 하위요소의 a태그가 눌리면 a태그의 속성값 href를 찾고
        //그 값을(url) 가져와서 actionForm > input type name = pageNum
        //찾은 url을 저장
        });
        
        $(".move").on("click", function(e){
          e.preventDefault();
          actionForm.append("<input type='hidden' name='bno' value= '" 
            + $(this).attr("href") + "'>");
          actionForm.attr("action", "/board/get").submit();
        });

        var searchForm = $('#searchForm');
        $('#searchForm button').on("click", function(e){
            if(!searchForm.find("option:selected").val()){
              alert("키워드를 입력하세요.");
              return false;
            }
            searchForm.find("input[name='pageNum']").val("1");
            e.preventDefault();
            searchForm.submit();
        });
    });
  
  </script>

  <%@ include file="../includes/footer.jsp" %>