
<%@ page import="eregister.Registrationsheet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registrationsheet.label', default: 'Registrationsheet')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-registrationsheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-registrationsheet" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dateSigned" title="${message(code: 'registrationsheet.dateSigned.label', default: 'Date Signed')}" />
					
						<th><g:message code="registrationsheet.regClass.label" default="Reg Class" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${registrationsheetInstanceList}" status="i" var="registrationsheetInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${registrationsheetInstance.id}">${fieldValue(bean: registrationsheetInstance, field: "dateSigned")}</g:link></td>
					
						<td>${fieldValue(bean: registrationsheetInstance, field: "regClass")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${registrationsheetInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
