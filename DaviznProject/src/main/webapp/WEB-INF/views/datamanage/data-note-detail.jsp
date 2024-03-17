<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

				
		<!-- content -->
		<div class="container">
		
			<div class="col-md-12 content-container">
		
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/index.dvn">홈</a></li>
        			<li><a href="${pageContext.request.contextPath}/userStrg.dvn">저장소 목록</a></li>
         			<li><a href="${pageContext.request.contextPath}/personalData/showPersonalDataList.dvn?strgseq=${note.strgseq}">데이터 목록</a></li>
					<li class="active">노트형 데이터  제목</li>
				</ol>
		
				<div class="note-detail-option">
					<a href="${pageContext.request.contextPath}/note/detailNote.dvn?dataseq=${note.dataseq}&strgseq=${note.strgseq}&function=m"><span class="glyphicon glyphicon-pencil note-detail-modi" 
						data-toggle="tooltip" title="노트 수정하기" aria-hidden="true">
					
						</span></a>
					<a href="${pageContext.request.contextPath}/personalData/deletePersonalData.dvn?dataseq=${note.dataseq}&strgseq=${note.strgseq}"><span class="glyphicon glyphicon-trash note-detail-modi" 
						data-toggle="tooltip" title="노트 삭제하기" aria-hidden="true"></span></a>
				</div>
		
				<div class="panel panel-success note-detail-content">
					<div class="panel-heading note-detail-title">
						<h3 class="panel-title">
							${note.dataname}&nbsp;&nbsp;&nbsp;&nbsp;
							<small class="note-detail-date">${note.datacreate}</small>
						</h3>
					</div>
					<div class="panel-body">${note.datahtml}</div>
				</div>
					
				<div id="push"></div>
						
			</div>
			
		</div>
		
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/resources/js/data-note-detail.js"></script>
