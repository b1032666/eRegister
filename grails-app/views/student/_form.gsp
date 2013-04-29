<%@ page import="eregister.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'fullStudentName', 'error')} ">
	<label for="fullStudentName">
		<g:message code="student.fullStudentName.label" default="Full Student Name" />
		
	</label>
	<g:textField name="fullStudentName" value="${studentInstance?.fullStudentName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'studentNumber', 'error')} ">
	<label for="studentNumber">
		<g:message code="student.studentNumber.label" default="Student Number" />
		
	</label>
	<g:textField name="studentNumber" value="${studentInstance?.studentNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'students', 'error')} ">
	<label for="students">
		<g:message code="student.students.label" default="Students" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.students?}" var="s">
    <li><g:link controller="registerentry" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registerentry" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registerentry.label', default: 'Registerentry')])}</g:link>
</li>
</ul>

</div>

