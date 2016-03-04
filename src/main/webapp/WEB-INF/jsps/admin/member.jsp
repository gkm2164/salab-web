<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" modelAttribute="member">
  <p>
    <form:label path="name">Name</form:label>
    <form:input path="name" />
  </p>

  <p>
    <form:label path="koreanName">Korean Name</form:label>
    <form:input path="koreanName" />
  </p>

  <p>
    <form:label path="degree">Degree</form:label>
    <form:select path="degree">
      <form:option value="-1">Choose degree</form:option>
      <form:options items="${degreeList}" itemValue="degree" itemLabel="label"/>
    </form:select>
  </p>

  <p>
    <form:label path="link">Link</form:label>
    <form:input path="link" />
  </p>

  <p>
    <form:label path="enterDate">Enterdate</form:label>
    <form:input path="enterDate" type="date" />
  </p>

  <p>
    <form:label path="graduated">Graduated</form:label>
    <form:checkbox path="graduated" />
  </p>

  <p>
    <form:label path="graduatedYear">Graduated Year</form:label>
    <form:input path="graduatedYear" />
  </p>
  <button type="submit">Submit!</button>
</form:form>

