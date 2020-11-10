<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp" %>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables 예제</h6>
              <div class="panel-heading">Board List Page
                 <button onclick="linkRegister();" type="button" class="btn btn-xs pull-right" style="color: violet">회원 추가</button>
              </div>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered dt-responsive nowrap" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>이름</th>
                      <th>계좌번호</th>
                      <th>총 입금액</th>
                      <th>총 출금액</th>
                      <th>잔고</th>
                      <th>대출가능여부</th>
                      <th>입.출금</th>
                      <th>계좌 생성일</th>
                      <th>최근 입출금 날짜</th>
                      
                      
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>#번호</th>
                      <th>이름</th>
                      <th>계좌번호</th>
                      <th>총 입금액</th>
                      <th>총 출금액</th>
                      <th>잔고</th>
                      <th>대출가능여부</th>
               	      <th>입.출금</th>
                      <th>계좌 생성일</th>
                      <th>최근 입출금 날짜</th>
                      
                    </tr>
                  </tfoot>
                  <tbody>
                  <c:forEach items="${bankTransaction}" var="bank">
                    <tr>
                     <td><c:out value="${bank.cus_id}"/></td>
                     <td> <a href="/bank/modify?cus_id=<c:out value='${bank.cus_id}'/>"><c:out value="${bank.cus_name}"/></a></td>
                  <td><c:out value="${bank.cus_serial}"/></td>
                  <td><c:out value="${bank.deposit}"/></td>
                  <td><c:out value="${bank.withdraw}"/></td>
                  <td><c:out value="${bank.balance}" /></td>
                  <td ><c:out value="${bank.booleanLoan}" /></td>
                  <td><button type="button" onclick='location.href="/bank/bankTransaction?cus_id=<c:out value="${bank.cus_id}" />"' >입.출금</button></td>
                  
                  <td><fmt:formatDate pattern="yyyy-MM-dd" 
                            value="${bank.regDate}"/></td>
                  <td><fmt:formatDate pattern="yyyy-MM-dd" 
                            value="${bank.updateDate}"/></td>
                   </c:forEach>
                  </tbody>
                </table>
                 <!-- End of DataTales Example -->
                 
               
                 
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
     $(document).ready(function(){
/*         let table = $('#dataTable').DataTable({sDom: 'lrtip'}); */
        var result = '<c:out value="${result}"/>';
        let balance = '<c:out value="${bank.balance}"/>';
      
        checkModal(result);
        $(".loanBoolean").each(function(index, item){

          $(this).html(loanBoolean(balance));
          console.log(this);
        })
        history.replaceState({}, null, null);
        
        //히스토리가 스텍에 쌓이는 상태는 모달창을 보여주지 않기 위해 추가함
        //histody.replaceState(stateObj, title, [url])
     });
  	function loanBoolean(balance){
  		console.log("잔액 : " + balance);
  		
  		let result = "";
  		if(parseInt(balance) < 500){
  			result = "N";
  		}else{
  			result = "Y";
  		}
  			return result;
  	}
  	function money(cus_id){
		location.href = "/bank/update"     		
  	}
     
     function linkRegister(){
     	
  		 location.href = "/bank/register";
     
     }
     
     
     function checkModal(result) {

        if (result === '' || history.state) { //히스토리 스택(LIFO(Last input First Output))에 있으면 true이므로 return
           return;
        }
        
        if (parseInt(result) > 0) {
           $(".modal-body").html(
                 "게시글 " + parseInt(result)
                       + " 번이 등록되었습니다.");
        }
         
        $("#myModal").modal("show");
     }
     
     $("#regBtn").on("click", function(){
        self.location = "/board/register";
     })
     



  </script>

  <%@ include file="../include/footer.jsp" %>