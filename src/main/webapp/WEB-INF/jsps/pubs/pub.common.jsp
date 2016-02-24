<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>${PUBLICATIONS.category}</h2>
<c:forEach var="publists" items="${PUBLICATIONS.publists}">
	<h3>${publists.typename}</h3>
	<ul class="pub-paper-list">
		<c:forEach var="elem" items="${publists.publist}">
			<li>
				${elem.text}
			<c:if test="${elem.link.length() > 0}">
				(<a href="${elem.link}">Download</a>)
			</c:if>
			</li>
		</c:forEach>
	</ul>
</c:forEach>