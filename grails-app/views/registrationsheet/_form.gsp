<%@ page import="eregister.Registrationsheet" %>



<div class="fieldcontain ${hasErrors(bean: registrationsheetInstance, field: 'dateSigned', 'error')} required">
	<label for="dateSigned">
		<g:message code="registrationsheet.dateSigned.label" default="Date Signed" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateSigned" precision="day"  value="${registrationsheetInstance?.dateSigned}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: registrationsheetInstance, field: 'regClass', 'error')} required">
	<label for="regClass">
		<g:message code="registrationsheet.regClass.label" default="Reg Class" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regClass" name="regClass.id" from="${eregister.RegClass.list()}" optionKey="id" required="" value="${registrationsheetInstance?.regClass?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationsheetInstance, field: 'registersheet', 'error')} ">
	<label for="registersheet">
		<g:message code="registrationsheet.registersheet.label" default="Registersheet" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${registrationsheetInstance?.registersheet?}" var="r">
    <li><g:link controller="registerentry" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registerentry" action="create" params="['registrationsheet.id': registrationsheetInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registerentry.label', default: 'Registerentry')])}</g:link>
</li>
</ul>

</div>

