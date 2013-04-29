
<%@ page import="eregister.Registrationsheet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registrationsheet.label', default: 'Registrationsheet')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-registrationsheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-registrationsheet" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list registrationsheet">
			
				<g:if test="${registrationsheetInstance?.dateSigned}">
				<li class="fieldcontain">
					<span id="dateSigned-label" class="property-label"><g:message code="registrationsheet.dateSigned.label" default="Date Signed" /></span>
					
						<span class="property-value" aria-labelledby="dateSigned-label"><g:formatDate date="${registrationsheetInstance?.dateSigned}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationsheetInstance?.regClass}">
				<li class="fieldcontain">
					<span id="regClass-label" class="property-label"><g:message code="registrationsheet.regClass.label" default="Reg Class" /></span>
					
						<span class="property-value" aria-labelledby="regClass-label"><g:link controller="regClass" action="show" id="${registrationsheetInstance?.regClass?.id}">${registrationsheetInstance?.regClass?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationsheetInstance?.registersheet}">
				<li class="fieldcontain">
					<span id="registersheet-label" class="property-label"><g:message code="registrationsheet.registersheet.label" default="Registersheet" /></span>
					
						<g:each in="${registrationsheetInstance.registersheet}" var="r">
						<span class="property-value" aria-labelledby="registersheet-label"><g:link controller="registerentry" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${registrationsheetInstance?.id}" />
					<g:link class="edit" action="edit" id="${registrationsheetInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
