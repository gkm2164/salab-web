<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>${member.name}'s Publications</h2>
<ul>
  <c:forEach items="${publications}" var="pub">
    <li>${pub}</li>
  </c:forEach>
</ul>
