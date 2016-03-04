<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gyeongmin
  Date: 3/4/16
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>${member.name}'s Publications</h2>
<ul>
  <c:forEach items="${member.publications}" var="pub">
    <li>${pub}</li>
  </c:forEach>
</ul>
