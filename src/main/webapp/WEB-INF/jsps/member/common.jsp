<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${MEMBER_STATUS}</h1>
<c:forEach var="elem" items="${MEMBER_LIST}">
	<c:set var="member" value="${elem}" scope="request" />
	<jsp:include page="./namecard.jsp" flush="true" />
</c:forEach>