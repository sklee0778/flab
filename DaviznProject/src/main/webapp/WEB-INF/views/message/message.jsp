<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se"
	uri="http://www.springframework.org/security/tags"%>

      <style>
         .nav-tabs active{color: #555; cursor: default; background-color: #fff; border: 1px solid #ddd; border-bottom-color: transparent;}
      </style>
      
      
   <div class="container">
      <div class="col-md-12 content-container">
      <div class="product-tab">
        <ul class="nav nav-tabs">
         <li class="active"><a href="#msg_receive">받은 쪽지함</a></li>
         <li><a href="#msg_write">쪽지 보내기</a></li>
         <li><a href="#msg_send">보낸 쪽지함</a></li>
        </ul><!-- .nav-tabs -->   
        
        <input type="hidden" id="userid" value="${userid}">
        
        <div class="tab-content">
           <!-- 받은 쪽지함 시작 -->
         <div class="tab-pane active t1" id="msg_receive">
            <table class="table table-responsive">
               <thead>
                  <tr>
                     <th>보낸 사람</th>
                     <th>제목</th>
                     <th>보낸 날짜</th>
                     <th>삭제</th>
                  </tr>
               </thead>
               
               <tbody>
                  <c:forEach var="i" items="${rmlist}">


                     <tr>
                        <td>
                           ${i.sender}
                        </td>
                        
                        <td>
                           
                           <a href="${pageContext.request.contextPath}/message/changecheckedstate.dvn?message_num=${i.message_num}" data-toggle="modal" data-target="#msg_content">${i.message_title}</a>    
                           <!-- Modal -->
                           <div class="modal fade" id="msg_content" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                             <div class="modal-dialog" role="document">
                               <div class="modal-content">
                                 <div class="modal-header">
                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                   <p class="modal-title" id="myModalLabel">${i.message_title}</p>
                                 </div>
                                 <div class="modal-body">
                                      ${i.message_content}
                                 </div>
                                 <div class="modal-footer">
                                   <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                 </div>
                               </div>
                             </div>
                           </div>
                        </td>
                        
                        <td>${i.message_date}</td>
                        <td>
                           <a class="btn btn-danger" href="${pageContext.request.contextPath}/message/deleteReceiveMessage.dvn?message_num=${i.message_num}">삭제</a>
                        </td>
                     </tr>

                  </c:forEach>
               </tbody>
            </table>
         </div><!-- 받은 쪽지함 끝-->
         
         <!-- 쪽지보내기 시작 -->
         <div class="tab-pane t2" id="msg_write">
           <form action="sendMessage.dvn" method="post">
              <table class="table table-responsive">
                 <tr>
                    <th>
                       받는 사람:
                    </th>
                    
                    <td>
                       <se:authentication property="name" var="LoginUser" />
   
                       <input type="text" class="form-control" id="receiver" name="receiver" >
                       <div><p id="div_view" style="background-color: white"></p></div>
                       <input type="hidden" name="sender" id="sender" value="${LoginUser}">
                    </td>
                 </tr>
                 
                 <tr>
                    <th>제목: </th>
                    <td>
                       <input type="text" class="form-control" name="message_title">
                    </td>
                 </tr>
                 <tr>
                    <th>
                       내용: 
                    </th>
                    
                    <td>
                       <textarea class="form-control" style="resize:none; height:200px;" wrap="soft" name="message_content"></textarea>
                    </td>
                 </tr>
                 <tr>
                    <td colspan="2"><input type="submit" class="btn btn-danger" value="전송"></td>
                 </tr>
              </table>
           </form>
         </div><!-- 쪽지보내기 -->
         
         <!-- 보낸 쪽지함 -->
         <div class="tab-pane t3" id="msg_send">
           <table class="table table-responsive">
              <thead>
                 <tr>
                    <th>받는 사람</th>
                    <th>제목</th>
                    <th>보낸 시간</th>
                    <th>삭제</th>
                 </tr>
              </thead>
              
              <tbody>
                  <c:forEach var="i" items="${smlist}">

                     <tr>
                        <td>
                           ${i.receiver}
                        </td>
                        
                        <td>
                           
                           <a href="${pageContext.request.contextPath}/message/changecheckedstate.dvn?message_num=${i.message_num}" data-toggle="modal" data-target="#msg_content">${i.message_title}</a>            
                           <!-- Modal -->
                           <div class="modal fade" id="msg_content" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                             <div class="modal-dialog" role="document">
                               <div class="modal-content">
                                 <div class="modal-header">
                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                   <p class="modal-title" id="myModalLabel">${i.message_title}</p>
                                 </div>
                                 <div class="modal-body">
                                      ${i.message_content}
                                 </div>
                                 <div class="modal-footer">
                                   <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                 </div>
                               </div>
                             </div>
                           </div>
                        </td>
                        
                        <td>${i.message_date}</td>
                        <td>
                           <a class="btn btn-danger" href="${pageContext.request.contextPath}/message/deleteSendMessage.dvn?message_num=${i.message_num}">삭제</a>
                        </td>
                     </tr>

                  </c:forEach>
               </tbody>
           </table>
         </div><!-- 보낸 쪽지함  끝 -->
         
        </div><!-- .tab-content -->
      </div>
      </div></div>
  