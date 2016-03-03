<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Alumni</h1>
<ul id="archives-year">
  <c:forEach items="${alumniYears}" var="elem">
    <li><a onclick="alumniFill('${elem}');">${elem}</a></li>
  </c:forEach>
</ul>

<div id="name-card-target"><br><br><span style="font-size:30px; color:Gray;"> Click the</span><span style="font-size:30px; color:purple;"> year </span></span><span style="font-size:30px; color:Gray;">you want to browse!!</span></div>
<!-- h3><br><br>  Click year you want to see alumni list</h3-->