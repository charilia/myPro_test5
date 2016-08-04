<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

<body>

	<h2>Hello World!</h2>

	<a href="toPage1.htm">To Page1</a>

	<c:set var="theString" value="I am a test String" />

	<!-- 这是替代if-else的做法, 因为c:if标签没有else -->
	<c:choose>
		<c:when test="${fn:contains(theString, 'test')}">
			find the right String !
   		</c:when>
		<c:otherwise>
			find the wrong String !
   		</c:otherwise>
	</c:choose>
	
	<!--<c:if test="${fn:contains(theString, 'test')}">
   		find the right String !
	</c:if>-->

</body>

</html>