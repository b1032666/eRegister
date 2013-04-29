<%@ page import="eregister.RegClass" %>



<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'classId', 'error')} ">
	<label for="classId">
		<g:message code="regClass.classId.label" default="Class Id" />
		
	</label>
	<g:textField name="classId" value="${regClassInstance?.classId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'classInstructor', 'error')} required">
	<label for="classInstructor">
		<g:message code="regClass.classInstructor.label" default="Class Instructor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="classInstructor" name="classInstructor.id" from="${eregister.Instructor.list()}" optionKey="id" required="" value="${regClassInstance?.classInstructor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="regClass.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${eregister.Course.list()}" optionKey="id" required="" value="${regClassInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'registerClass', 'error')} ">
	<label for="registerClass">
		<g:message code="regClass.registerClass.label" default="Register Class" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${regClassInstance?.registerClass?}" var="r">
    <li><g:link controller="registrationsheet" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registrationsheet" action="create" params="['regClass.id': regClassInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registrationsheet.label', default: 'Registrationsheet')])}</g:link>
</li>
</ul>

</div>

