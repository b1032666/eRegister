
<%@ page import="eregister.Registerentry" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registerentry.label', default: 'Registerentry')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-registerentry" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-registerentry" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="registerentry.registrationsheet.label" default="Registrationsheet" /></th>
					
						<th><g:message code="registerentry.student.label" default="Student" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${registerentryInstanceList}" status="i" var="registerentryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${registerentryInstance.id}">${fieldValue(bean: registerentryInstance, field: "registrationsheet")}</g:link></td>
					
						<td>${fieldValue(bean: registerentryInstance, field: "student")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${registerentryInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
