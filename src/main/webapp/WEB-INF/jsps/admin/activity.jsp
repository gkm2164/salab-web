<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2016-03-07
  Time: 오후 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="activity">
  <p>
    <form:label path="title">Title</form:label>
    <form:input path="title"/>
  </p>
  <p>
    <form:label path="contents">Contents</form:label>
    <form:textarea path="contents"></form:textarea>
  </p>
  <p>
    <form:label path="date">Contents</form:label>
    <form:input path="date" type="date"></form:input>
  </p>
  <button type="submit">Submit!</button>
</form:form>