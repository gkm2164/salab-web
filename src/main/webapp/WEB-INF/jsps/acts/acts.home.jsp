<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>Activities</h1>
<div id="lab-event-accordion">
	<ul>
		<c:forEach var="elem" items="${activities}">
			<li>${elem.title}</li>
</c:forEach>
	</ul>
	<c:forEach var="elem" items="${activities}">
		<div>
		<h4>${elem.title}</h4>
			<p>${elem.date}</p>
		<div>${elem.contents}</div>
	</div>
</c:forEach>
</div>
<br class="clearfix"/>