<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="relation">
  <p>
    <form:label path="intId">Interest</form:label>
    <form:select path="intId">
      <form:option value="Select Interest" />
      <form:options items="${interests}" itemLabel="fieldName" itemValue="id" />
    </form:select>
  </p>
  <p>
    <form:label path="memId">Member</form:label>
    <form:select path="memId">
      <form:option value="Select Member" />
      <form:options items="${members}" itemLabel="name" itemValue="id" />
    </form:select>
  </p>
</form:form>
