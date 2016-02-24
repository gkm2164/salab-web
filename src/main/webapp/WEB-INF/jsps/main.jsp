<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<title>${PDESC.title}- Software Architecture Laboratory</title>

<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->
<link rel="stylesheet" href="/css/layout-properties.css" />
<link rel="stylesheet" href="/css/background-properties.css" />
<link rel="stylesheet" href="/css/border-line-properties.css" />
<link rel="stylesheet" href="/css/font-properties.css" />
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/bug-handler.css" />
<c:forEach var="elem" items="${PDESC.pageCSS}">
	<link rel="stylesheet" href="/css/${elem}" />
</c:forEach>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="/js/jquery-ui-1.10.4.min.js"></script>
<script src="/js/salab.definitions.js"></script>
<c:choose>
	<c:when test="${DEBUG == true}">
		<script src="/js/salab-debug.js"></script>
	</c:when>
	<c:when test="${DEBUG == false}">
		<script src="/js/salab.js"></script>
	</c:when>
	<c:otherwise>
		<script>
			alert("Error occured!");
		</script>
	</c:otherwise>
</c:choose>

<c:forEach var="elem" items="${PDESC.pageJS}">
	<script src="/js/${elem}"></script>
</c:forEach>
<body>
	<div id="container">
		<header>
			<div id="banner">
				<div id="salab-logo-box" class="logo">
					<a id="salab-logo-link" href="${ABSPATH}"> <img
						src="/img/SALAB_logo.png" alt="SALab logo"
						id="salab-logo" />
					</a>
				</div>
				<div id="salab-title">
					<h1>Software Architecture Laboratory</h1>
				</div>
				<div id="kaist-logo-box" class="logo">
					<a id="kaist-logo-link" href="http://www.kaist.ac.kr/"
						target="_blank"> <img src="/img/KAIST_logo.gif"
						alt="KAIST Logo" id="kaist-logo" />
					</a>
				</div>
				<br class="clearfix" />
			</div>
			<nav id="nav-global">
				<jsp:include page="./globalnavs.jsp" />
			</nav>
		</header>

		<section class="${LNAVS == null ? 'no-local-nav':'' }">
			<c:if test="${LNAVS != null}">
				<aside>
					<nav>
						<div id="nav-local">
							<jsp:include page="localnavs.jsp" />
						</div>
						<!-- Home일경우 제외하고 나머지 모두 -->
					</nav>
					<br class="clearfix" />
				</aside>
			</c:if>
			<article>
				<div id="page">
					<jsp:include page="${PDESC.pageFileName}" />
					<br class="clearfix" />
				</div>
				<br class="clearfix" />
			</article>
			<br class="clearfix" />
		</section>
		<footer>
			<div id="nav-history"></div>
			<div id="copyright">
				<p>
					Copyright 2013 SALab | Administrator <a
						href="mailto:kaist.salab@gmail.com">kaist.salab@gmail.com</a> | <a
						href="/email-deny">이메일주소 무단수집 거부 및 개인정보 보호정책</a>
				</p>
			</div>
			<div id="page-info"></div>
		</footer>
	</div>
</body>
</html>