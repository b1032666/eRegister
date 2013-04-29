<%@ page import="eregister.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'courseClasses', 'error')} ">
	<label for="courseClasses">
		<g:message code="course.courseClasses.label" default="Course Classes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${courseInstance?.courseClasses?}" var="c">
    <li><g:link controller="regClass" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="regClass" action="create" params="['course.id': courseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'regClass.label', default: 'RegClass')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'courseDescription', 'error')} ">
	<label for="courseDescription">
		<g:message code="course.courseDescription.label" default="Course Description" />
		
	</label>
	<g:textField name="courseDescription" value="${courseInstance?.courseDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'courseId', 'error')} ">
	<label for="courseId">
		<g:message code="course.courseId.label" default="Course Id" />
		
	</label>
	<g:textField name="courseId" value="${courseInstance?.courseId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'courseName', 'error')} ">
	<label for="courseName">
		<g:message code="course.courseName.label" default="Course Name" />
		
	</label>
	<g:textField name="courseName" value="${courseInstance?.courseName}"/>
</div>

