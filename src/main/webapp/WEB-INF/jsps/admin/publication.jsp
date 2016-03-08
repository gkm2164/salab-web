<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2016-03-04
  Time: 오후 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="publication">
  <p>
    <form:label path="publicationType">Publication Type</form:label>
    <form:select path="publicationType">
      <form:option value="-1">Select type</form:option>
      <form:options items="${pubTypes}" itemLabel="name" itemValue="value" />
    </form:select>
  </p>
  <p>
    <form:label path="title">Title</form:label>
    <form:input path="title" />
  </p>
  <p>
    <form:label path="metadata">Metadata</form:label>
    <form:input path="metadata" />
  </p>
  <p>
    <form:label path="date">Date</form:label>
    <form:input path="date" type="date" />
  </p>
  <button type="submit">Submit!</button>
</form:form>

<div id="publication-list-box">
  <ul>
    <c:forEach items="${publicationList}" var="elem">
      <li>${elem}</li>
    </c:forEach>
  </ul>
</div>