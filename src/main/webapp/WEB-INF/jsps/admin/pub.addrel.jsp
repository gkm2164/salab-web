<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2016-03-04
  Time: 오후 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="relation">
  <p>
    <form:select path="pubId">
      <form:option value="-1">Select Publication</form:option>
      <form:options items="${publications}" itemLabel="title" itemValue="id" />
    </form:select>
  </p>
  <p>
    <form:select path="memberId">
      <form:option value="-1">Select Publication</form:option>
      <form:options items="${members}" itemLabel="name" itemValue="id" />
    </form:select>
  </p>
  <p>
    <form:label path="order">Author Order</form:label>
    <form:input path="order" />
  </p>
  <button type="submit">Submit!</button>
</form:form>