<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="name-card">
	<div class="name-card-personal">
		<div class="name-card-personal-info">
			<span class="name-card-name">
				<c:if test="${member.link != null}">
					${member.name}
					<a href="${member.link}">${member.link}</a>
				</c:if>
				<c:if test="${member.link == null}">
					${member.name}
				</c:if>
			</span>
			<c:if test="${member.alumniTable != null}">
				<span class="name-card-current-work">${member.alumniTable.currentWork}</span>
			</c:if>
			<c:if test="${member.interests.size() > 0}">
				<div class="name-card-interest">
					<h2>Research Interests</h2>
					<ul>
						<c:forEach var="ints" items="${member.interests}">
							<li>${ints.fieldName}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<br class="clearfix" />
		</div>
		<br class="clearfix" />
	</div>
	<c:if test="${member.publications.size() > 0}">
		<div class="name-card-career">
			<h2>Publications</h2>
			<ul>
				<c:forEach var="pubs" items="${pub_map.get(member)}">
					<li>${pubs}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
</div>