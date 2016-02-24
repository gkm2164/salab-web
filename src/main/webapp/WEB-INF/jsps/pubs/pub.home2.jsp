<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<div class="pubs-home">
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<div class="pubs-category-list">
		<h1>Publications</h1>
		<ul>
			<li><a href="${ABSPATH}/pubs/sa">Software Architecture</a></li>
			<li><a href="${ABSPATH}/pubs/spl">Software Product Line</a></li>
			<li><a href="${ABSPATH}/pubs/st">Software Testing</a></li>
			<li><a href="${ABSPATH}/pubs/se">Software Engineering</a></li>
			<li><a href="${ABSPATH}/pubs/cn">Communication Networks and Protocol Testing</a></li>
		</ul>
	</div>
	<div class="pubs-books-list">
		<h1>Books</h1>
		<ul>
			<li>강성원, 소프트웨어 아키텍처로의 초대 – 소프트웨어 아키텍처 설계의 근본원리들, 홍릉과학출판사, 2012.</li>
		</ul>
		<p><img src="http://salab.kaist.ac.kr/img/book000.jpg"><a href="${ABSPATH}/materials/Part III-Chapter2-revision.pdf">	제 III부 3장 문서화 사례연구(수정본)</a></p>
	</div>
</div>