<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>
<div class="pubs-home">
  <div class="pubs-books-list">
    <h1>Books</h1>
    <div>
      <p>
        강성원, 소프트웨어 아키텍처로의 초대 – 소프트웨어 아키텍처 설계의 근본원리들<br /> 홍릉과학출판사, 2012.
      </p>
      <p>
        <img src="http://salab.kaist.ac.kr/img/book000.jpg">
      </p>
      <p>
        <a href="/materials/Part III-Chapter2-revision.pdf">제
          III부 3장 문서화 사례연구(수정본)</a>
      </p>
    </div>
    <div>
      <p>
        강성원, 체계적인 소프트웨어 제품라인 개발 이론<br />(2016 출간 예정).
      </p>
      <p>
        <img src="/img/book000_v2.png"
             style="max-width: 43%; height: auto;">
      </p>
    </div>
  </div>

  <div class="pubs-category-list">
    <h1>Publications</h1>

    <c:forEach items="${PUBS}" var="pubs">
      <h3>${pubs.name}</h3>
      <ul class="pub-paper-list">
        <c:forEach items="${pubs.list}" var="elem">
          <li>${elem}</li>
        </c:forEach>
      </ul>
    </c:forEach>
  </div>
</div>