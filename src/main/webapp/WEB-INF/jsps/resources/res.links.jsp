<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Links</h1>
<c:forEach var="elem" items="${LINKS}">
	<h2>${elem.groupName}</h2>
	<ul class="resources-links">
	<c:forEach var="e" items="${elem.links}">
		<li>${e.name}, <a href="${e.link}">${e.link}</a>
	</c:forEach>
	</ul>
</c:forEach>
