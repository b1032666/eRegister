<%@ page import="eregister.Instructor" %>



<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'classesTaught', 'error')} ">
	<label for="classesTaught">
		<g:message code="instructor.classesTaught.label" default="Classes Taught" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${instructorInstance?.classesTaught?}" var="c">
    <li><g:link controller="regClass" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="regClass" action="create" params="['instructor.id': instructorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'regClass.label', default: 'RegClass')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'instructorId', 'error')} ">
	<label for="instructorId">
		<g:message code="instructor.instructorId.label" default="Instructor Id" />
		
	</label>
	<g:textField name="instructorId" value="${instructorInstance?.instructorId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'instructorName', 'error')} ">
	<label for="instructorName">
		<g:message code="instructor.instructorName.label" default="Instructor Name" />
		
	</label>
	<g:textField name="instructorName" value="${instructorInstance?.instructorName}"/>
</div>

