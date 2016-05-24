<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="ctx">${pageContext.request.contextPath}</c:set>
<html lang="ko">
<head>
<title>BaseballTeam</title>
<meta charset="utf-8">
<link href="resources/css/bootstrap_modify.css" rel="stylesheet">
<link href="resources/css/layout.css" rel="stylesheet">
<script src="resources/js/jquery-2.1.3.js"></script>

</head>
<body>

	<!-- Main Navigation ================================================================================= -->
	<%@include file="/header/main.jspf"%>
	<!-- Header ========================================================================================== -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="jumbotron">
						<h2>선수 목록</h2>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<ol class="breadcrumb">
						<li>홈</li>
						<li class="active">선수목록</li>
					</ol>
				</div>
			</div>
		</div>
	</header>

	<!-- Container ======================================================================================= -->
	<div class="container">
		<div class="row">

			<div class="col-sm-12 col-lg-12">
				<div>
					<h3>등록 선수 목록</h3>
				</div>

				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<colgroup>
							<col width="100" />
							<col width="200" />
							<col width="100" />
							<col width="200" />
							<col width="200" />
							<col width="*" />
							<col width="100" />
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">번호</th>
								<th class="text-center">이름</th>
								<th class="text-center">등번호</th>
								<th class="text-center">포지션</th>
								<th class="text-center">특징</th>
								<th class="text-center">팀명</th>
								<th class="text-center">트래이드</th>
							</tr>
						</thead>
						<tbody>
							<!-- 
							<tr>
								<th colspan="7" class="text-center">등록된 선수 정보가 존재하지 않습니다.</th>
							</tr>
							 -->
							  <c:if test="${allList ne null}">
							  <c:forEach items="${allList}" var="team" varStatus="num">
							  <%-- <c:forEach items="${team.players}" var="list"> --%>
							<tr>
								<td class="text-center">${team.players.playerId}</td>
								<td class="text-center">${team.players.name}</td>
								<td class="text-center">${team.players.backNumber}</td>
								<td class="text-center">${team.players.position}</td>
								<td class="text-center">
								<c:if test="${team.players.throwing eq 'L'}">${team.players.throwing = '좌'}</c:if>
								<c:if test="${team.players.throwing eq 'R'}">${team.players.throwing = '우'}</c:if>
								투
								<c:if test="${team.players.hitting eq 'L'}">${team.players.hitting = '좌'}</c:if>
								<c:if test="${team.players.hitting eq 'R'}">${team.players.hitting = '우'}</c:if>
								타</td>
								<td class="text-center"><a href="${ctx}/teamDetail.do?id=${team.players.teamId}">${team.name}</a></td>
								<td class="text-center"><a href="${ctx}/tradeTargetList.do?id=${team.players.playerId}">트레이드</a></td>
							</tr>
							<%-- </c:forEach> --%>
							</c:forEach>
							</c:if>
							<c:if test="${allList eq null}">
							<c:forEach items="${player}" var="players" varStatus="status">
							<tr>
							<td class="text-center">${status.count}</td>
								<td class="text-center">${players.name}</td>
								<td class="text-center">${players.backNumber}</td>
								<td class="text-center">${players.position}</td>
								<td class="text-center">
								<c:if test="${players.throwing eq 'L'}">${players.throwing = '좌'}</c:if>
								<c:if test="${players.throwing eq 'R'}">${players.throwing = '우'}</c:if>
								투
								<c:if test="${players.hitting eq 'L'}">${players.hitting = '좌'}</c:if>
								<c:if test="${players.hitting eq 'R'}">${players.hitting = '우'}</c:if>
								타</td>
								<td class="text-center"><a href="${ctx}/teamDetail.do?id=${players.teamId}">${team.name}</a></td>
								<td class="text-center"><a href="${ctx}/tradeTargetList.do?id=${players.playerId}">트레이드</a></td>
							</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<!-- Footer ========================================================================================== -->
		<footer>
			<hr>
			<p>© NamooBaseball 2016.</p>
		</footer>
	</div>
</body>
</html>