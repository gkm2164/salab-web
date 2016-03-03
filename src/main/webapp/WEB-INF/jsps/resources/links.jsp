<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Links</h1>
<c:forEach var="elem" items="${resourceGroup}">
	<h2>${elem.groupName}</h2>
	<ul class="resources-links">
	<c:forEach var="e" items="${elem.resourceList}">
		<li>${e.title}, <a href="<c:url value='${e.contents}' />" target="_blank">${e.contents}</a>
	</c:forEach>
	</ul>
</c:forEach>
