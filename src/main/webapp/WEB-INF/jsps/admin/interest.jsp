<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="interest">
  <p>
    <form:label path="fieldName">Research Area Name</form:label>
    <form:input path="fieldName" />
  </p>
  <p>
    <form:label path="fieldDesc">Research Area description</form:label>
    <form:textarea path="fieldDesc"></form:textarea>
  </p>
  <button type="submit">Submit</button>
</form:form>