<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>Activities</h1>
<div id="lab-event-accordion">
	<ul>
<c:forEach var="elem" varStatus="status" items="${ACTIVITIES}">
		<li index="${status.count}" id="event-${status.count}" class="event-list">${elem.preview}</li>
</c:forEach>
	</ul>
<c:forEach var="elem" varStatus="status" items="${ACTIVITIES}">
	<div index="${status.count}" id="event-content-${status.count}" class="event-content">
		<h4>${elem.title}</h4>
		<div>${elem.contents}</div>
	</div>
</c:forEach>
</div>
<br class="clearfix"/>