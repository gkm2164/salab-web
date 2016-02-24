<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="research-area">
	<img id="lab-research-area-img" src="${ABSPATH}/img/lab-research2.png" />
	<h1>Research</h1>
	<p>Research areas of the Software Architecture Lab include:</p> 
	<ul class="research-list">
<c:forEach var="elem" items="${RESEARCHES}">
		<li>${elem.name}</li>
</c:forEach> 
	</ul>
</div>

<!--div id="research-explain">
	<p>For more information, click above sections</p>
	<div id="research-explain-field"></div>
</div>

<div id="research-hidden-explain">
<c:forEach var="elem" items="${RESEARCHEXP}">
	<explain-field id="${elem.categoryID}">
		<h3>${elem.categoryName}</h3>
		<p>${elem.catDesc}</p>
	</explain-field>
</c:forEach>
</div-->