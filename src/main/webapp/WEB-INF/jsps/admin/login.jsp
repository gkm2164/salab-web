<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: gyeongmin
  Date: 3/7/16
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post">
  <p>
    ID: <input type="text" name="id"/>
  </p>
  <p>
    Password: <input type="password" name="password"/>
  </p>
  <button type="submit">Submit</button>
</form>