
<%@ page import="eregister.Instructor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'instructor.label', default: 'Instructor')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-instructor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-instructor" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="instructorId" title="${message(code: 'instructor.instructorId.label', default: 'Instructor Id')}" />
					
						<g:sortableColumn property="instructorName" title="${message(code: 'instructor.instructorName.label', default: 'Instructor Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${instructorInstanceList}" status="i" var="instructorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${instructorInstance.id}">${fieldValue(bean: instructorInstance, field: "instructorId")}</g:link></td>
					
						<td>${fieldValue(bean: instructorInstance, field: "instructorName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${instructorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
