<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Courses</h1>
<c:forEach var="elem" items="${courses}">
	<div class="course-card">
		<c:choose>
		<c:when test="${elem.courseId.length() > 0}">
		<h3><a href="/courses/${elem.courseId}">${elem.title}</a></h3>
		</c:when>
		<c:otherwise>
		<h3>${elem.title}</h3>
		</c:otherwise>
		</c:choose>
		<div class="course-desc">${elem.description}</div>
	</div>
</c:forEach>