<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
div#course-SEP523 * {
	font-family: 맑은 고딕;
}

div#course-SEP523 table {
	margin-left: auto;
	margin-right: auto;
	width: 90%;
}

div#course-SEP523 table,div#course-SEP523 th,div#course-SEP523 td {
	border: 1px solid;
	border-collapse: collapse;
}

div#course-SEP523 th {
	background-color: rgb(238, 236, 225);
}

div#course-SEP523 td {
	padding-left: 0.5em;
}

.course-disk-icon {
	width: 30px;
}

.sungwonkang {
	background-color: rgb(198, 217, 241);
}

.seonahlee {
	background-color: rgb(253, 233, 217);
}

.jihyeonlee {
	background-color: rgb(229, 223, 236);
}

.junghokim {
	background-color: rgb(234, 241, 221);
}

.nocolor {
	background-color: rgb(255, 255, 255);
}
</style>
<div id="course-SEP523">
	<h1 align="center">강의 일정</h1>
	<table>
		<tbody>
			<tr>
				<th width="60px"></th>
				<th width="100px">날짜</th>
				<th width="150px">주제</th>
				<th>내용</th>
				<th>다운로드</th>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="7" align="center" class="nocolor">
					<p>1주차</p>
					<p>(8시간)</p>
				</td>
				<td rowspan="5" align="center">
					<p>5월 8일</p>
					<p>(목)</p>
					<p>(강성원)</p>
				</td>
				<td>
					<p>과정 개요</p>
				</td>
				<td>
					<p>P0. 과정 개요</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/03. P00-Course introduction-v7.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="4">
					<p>요구사항</p>
					<p>도출</p>
				</td>
				<td>
					<p>P1. 아키텍처 드라이버</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/04. P01-Architecture Driver-v4.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P2. 품질속성, 검증가능성</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/05. P02-QA Verifiability QA Scenarios-v2.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A1. 아키텍처 문서화</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/06. A01-Architecture Documentation(IEEE 1471).pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>Lab 1: 문서 A, B 작성/발표</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="2" align="center">
					<p>5월 9일</p>
					<p>(금)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="2">
					<p>아키텍처</p>
					<p>문제 분석</p>
				</td>
				<td>
					<p>P3. 아키텍처 문제 분석</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/07. P03-Architectural Problem Analysis.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>Lab 2: 문서 C 작성/발표</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="8" align="center" class="nocolor">
					<p>2주차</p>
					<p>(8시간)</p>
				</td>
				<td rowspan="4" align="center">
					<p>5월15일</p>
					<p>(목)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="4">
					<p>아키텍처 설계</p>
					<p>(1)</p>
				</td>
				<td>
					<p>P4. 컴포넌트 커넥터</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/08. P04-Component and connector-v3.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P5. 아키텍처 스타일</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/09. P05-Arch Styles-v3.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P6. 아키텍처 관점체계</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/10. P06-Arch VP Framework-v3.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P7. 설계의 일반원리</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/11. P07-General Design Principles-v3.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="4" align="center">
					<p>5월16일</p>
					<p>(금)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="4">
					<p>아키텍처 설계</p>
					<p>(2)</p>
				</td>
				<td>
					<p>P8. 아키텍처 설계 절차</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/12. P08-Arch Design Process-v4.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P9. 아키텍처 패턴</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/13. P09-Arch Patterns-v3.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P10. 품질속성 설계</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/14 .P10-QA Design Strategies-v2.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
				</a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>Lab 3: 문서 D, E 작성</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="junghokim">
				<td rowspan="11" align="center" class="nocolor">
					<p>3주차</p>
					<p>(16시간)</p>
				</td>
				<td align="center">
					<p>5월19일(월)</p>
					<p>(김정호)</p>
				</td>
				<td>
					<p>소프트웨어 아키텍처 실전 예제 소개 - 1</p>
				</td>
				<td>
					<p>- 소프트웨어 아키텍처 설계 이론과 실제 프로젝트</p>
					<p>- 에자일 개발 방법론과 아키텍처 설계</p>
					<p>- 실전 소프트웨어 아키텍처 예제 소개 – 아키텍처 뷰</p>
				</td>
				<td align="center" class="nocolor"><a href="${ABSPATH}/materials/SEP523/ETRI - Software Architecture Design.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="junghokim">
				<td align="center">
					<p>5월21일(수)</p>
					<p>(김정호)</p>
				</td>
				<td>
					<p>소프트웨어 아키텍처 실전 예제 소개 - 2</p>
				</td>
				<td>
					<p>- 실전 소프트웨어 아키텍처 예제 소개 – 아키텍처 평가, 프로토타입</p>
					<p>- 소프트웨어 아키텍트 역할과 조직 문제</p>
				</td>
				<td align="center" class="nocolor"><a href="${ABSPATH}/materials/SEP523/ETRI - Software Architecture Pattern.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="4" align="center">
					<p>5월22일</p>
					<p>(목)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="4">
					<p>아키텍처 분석 및 평가</p>
				</td>
				<td>
					<p>P11. 아키텍처 분석</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/15. P11-Arch Analysis-v4.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>Lab 4: 문서 F 작성</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>P12. 아키텍처 평가</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/16. P12-Arch Evaluation-v4.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>Lab 5: 문서 G 작성</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="5" align="center">
					<p>5월23일</p>
					<p>(금)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="5">
					<p>사례연구</p>
				</td>
				<td>
					<p>A2-C1-1. Siemens 방법</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/18. A02-C1-1-Siemens Architecture Design -Intro.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A2-C1-2. 개념뷰</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/19. A02-C1-2-Conceptual View-v2.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A2-C1-3. 실행뷰</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/21. A02-C1-4-Execution View-v3.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A2-C1-4. 모듈뷰</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/20. A02-C1-3-Module View-v2.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A2-C1-5. 코드뷰</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/22. A02-C1-5-Code View-v2.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="seonahlee">
				<td rowspan="7" align="center" class="nocolor">
					<p>4주차</p>
					<p>(16시간)</p>
				</td>
				<td align="center">
					<p>5월26일</p>
					<p>(월)</p>
					<p>(이선아)</p>
				</td>
				<td>
					<p>아키텍처 재구축</p>
				</td>
				<td>
					<p>아키텍처 재구축</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/Architecture-Reconstruction.zip"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="jihyeonlee">
				<td align="center">
					<p>5월28일</p>
					<p>(수)</p>
					<p>(이지현, 강성원)</p>
				</td>
				<td>
					<p>아키텍처 기반의 소프트웨어</p>
					<p>시험</p>
				</td>
				<td>
					<p>- 이론</p>
					<p>- 적용 사례</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/SEP523-Architecture Based Testing.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td rowspan="4" align="center">
					<p>5월29일</p>
					<p>(목)</p>
					<p>(강성원)</p>
				</td>
				<td rowspan="4">
					<p>아키텍처 설계(3)</p>
				</td>
				<td>
					<p>Lab 6: 문서 수정</p>
				</td>
				<td class="nocolor"></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A3. UML을 사용한 아키텍처 기술</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/23. A03-Architecture Description with UML-v3.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A4 – More on Architecture Patterns</p>
				</td>
				<td align="center" class="nocolor"><a
					href="${ABSPATH}/materials/SEP523/24. A04-More on Architecture Patterns-v3.pdf"><img
						class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" /></a></td>
			</tr>
			<tr class="sungwonkang">
				<td>
					<p>A5 - More on Quality Attribute Strategies</p>
				</td>
				<td align="center" class="nocolor">
					<a href="${ABSPATH}/materials/SEP523/25. A05-More on QA Design Strategies-v5.pdf">
						<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
					</a>
				</td>
			</tr>
			<tr class="sungwonkang">
				<td align="center">
					<p>5월30일</p>
					<p>(금)</p>
					<p>(강성원)</p>
				</td>
				<td>
					<p>임베디드</p>
					<p>아키텍처</p>
				</td>
				<td>
					<p>E1 - Embedded Architecture Design</p>
					<p>E2 - UML State Machine Diagram</p>
					<p>E3 - Embedded Arch Design 사례연구</p>
				</td>
				<td align="center" class="nocolor">
					<img class="course-disk-icon" src="${ABSPATH}/img/disk-icon.jpg" />
					<p>
						<a href="${ABSPATH}/materials/SEP523/28. E01-Embedded Systems-v3.pdf">E1</a>,
						<a href="${ABSPATH}/materials/SEP523/29. E02-UML State Machine.pdf">E2</a>,
						<a href="${ABSPATH}/materials/SEP523/30. E03-Architecture Design (Elevator Control)- Exercise-v3.pdf">E3</a>
					</p>
				</td>
			</tr>
		</tbody>
	</table>
</div>