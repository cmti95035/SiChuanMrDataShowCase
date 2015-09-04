<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<title>MR数据展示</title>
	<style>
	.error
	{
		color: #ff0000;
		font-weight: bold;
	}
	</style>
</head>

<body>
	<h2><spring:message code="lbl.page" text="MR数据展示" /></h2>
	<br/>
	<form:form method="post" modelAttribute="mrdata">
		<%-- <form:errors path="*" cssClass="error" /> --%>
		<table>
			<tr>
				<td><spring:message code="lbl.province" text="省" /></td>
				<td><form:select path="province" items="${allProvinces}" itemValue="id" itemLabel="name" /></td>
				<td><form:errors path="province" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.city" text="市/地区" /></td>
				<td><form:select path="city" items="${allCities}" itemValue="id" itemLabel="name" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.roadName" text="路名" /></td>
				<td><form:select path="roadName" items="${allRoadNames}" itemValue="id" itemLabel="name" /></td>
				<td><form:errors path="roadName" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="在地图上显示MR数据"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>