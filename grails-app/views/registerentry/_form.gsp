<%@ page import="eregister.Registerentry" %>



<div class="fieldcontain ${hasErrors(bean: registerentryInstance, field: 'registrationsheet', 'error')} required">
	<label for="registrationsheet">
		<g:message code="registerentry.registrationsheet.label" default="Registrationsheet" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="registrationsheet" name="registrationsheet.id" from="${eregister.Registrationsheet.list()}" optionKey="id" required="" value="${registerentryInstance?.registrationsheet?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registerentryInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="registerentry.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${eregister.Student.list()}" optionKey="id" required="" value="${registerentryInstance?.student?.id}" class="many-to-one"/>
</div>

