<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div class="pubs-home">
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<div class="pubs-books-list">
		<h1>Books</h1>
		<div>
			<p>
				강성원, 소프트웨어 아키텍처로의 초대 – 소프트웨어 아키텍처 설계의 근본원리들<br /> 홍릉과학출판사, 2012.
			</p>
			<p>
				<img src="http://salab.kaist.ac.kr/img/book000.jpg">
			</p>
			<p>
				<a href="${ABSPATH}/materials/Part III-Chapter2-revision.pdf">제
					III부 3장 문서화 사례연구(수정본)</a>
			</p>
		</div>
		<div>
			<p>
				강성원, 체계적인 소프트웨어 제품라인 개발 이론<br />(2016 출간 예정).
			</p>
			<p>
				<img src="http://salab.kaist.ac.kr/img/book000_v2.png"
					style="max-width: 43%; height: auto;">
			</p>
		</div>
	</div>

	<div class="pubs-category-list">
		<h1>Publications</h1>
		<h3>SCI/SCIE Journal Papers</h3>
		<jsp:include page="pubs.journal.sci.jsp" />

		<h3>Other International Journal Papers</h3>
		<jsp:include page="pubs.journal.int.jsp" />

		<h3>International Conference Papers</h3>
		<jsp:include page="pubs.conf.int.jsp" />

		<h3>Domestic Journal papers</h3>
		<jsp:include page="pubs.journal.dom.jsp"/>

		<h3>Domestic Conference papers</h3>
		<jsp:include page="pubs.conf.dom.jsp" />
	</div>
</div>