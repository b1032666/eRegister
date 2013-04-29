
<%@ page import="eregister.Enrollment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'enrollment.label', default: 'Enrollment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-enrollment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-enrollment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list enrollment">
			
				<g:if test="${enrollmentInstance?.enrolledDate}">
				<li class="fieldcontain">
					<span id="enrolledDate-label" class="property-label"><g:message code="enrollment.enrolledDate.label" default="Enrolled Date" /></span>
					
						<span class="property-value" aria-labelledby="enrolledDate-label"><g:formatDate date="${enrollmentInstance?.enrolledDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${enrollmentInstance?.regClass}">
				<li class="fieldcontain">
					<span id="regClass-label" class="property-label"><g:message code="enrollment.regClass.label" default="Reg Class" /></span>
					
						<span class="property-value" aria-labelledby="regClass-label"><g:link controller="regClass" action="show" id="${enrollmentInstance?.regClass?.id}">${enrollmentInstance?.regClass?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${enrollmentInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="enrollment.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${enrollmentInstance?.student?.id}">${enrollmentInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${enrollmentInstance?.id}" />
					<g:link class="edit" action="edit" id="${enrollmentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
