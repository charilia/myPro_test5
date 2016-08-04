<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="WEB-INF/custom.tld"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>welcome</title>
</head>
<body background="image8.jpg">
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/mysql" user="root" password="" />

	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from user1;
	</sql:query>

	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.name}" /></td>
				<td><c:out value="${row.age}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="submit" value="提交" /></td>
			<td><input type="text" id="name" placeholder="输入姓名"></td>
			<td><input type="text" id="age" placeholder="输入年龄"></td>
		</tr>

	</table>

	<sql:update dataSource="${snapshot}" var="result">
		INSERT INTO user1 (name , age) VALUES ('${inputName}', '${inputAge}');
	</sql:update>

	<script type="text/javascript" color="255,255,255" opacity='0.7'
		zIndex="-2" count="99" src="//github.atool.org/canvas-nest.min.js"></script>
</body>
</html>