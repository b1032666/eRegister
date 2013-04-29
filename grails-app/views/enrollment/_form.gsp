<%@ page import="eregister.Enrollment" %>



<div class="fieldcontain ${hasErrors(bean: enrollmentInstance, field: 'enrolledDate', 'error')} required">
	<label for="enrolledDate">
		<g:message code="enrollment.enrolledDate.label" default="Enrolled Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="enrolledDate" precision="day"  value="${enrollmentInstance?.enrolledDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: enrollmentInstance, field: 'regClass', 'error')} required">
	<label for="regClass">
		<g:message code="enrollment.regClass.label" default="Reg Class" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="regClass" name="regClass.id" from="${eregister.RegClass.list()}" optionKey="id" required="" value="${enrollmentInstance?.regClass?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: enrollmentInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="enrollment.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${eregister.Student.list()}" optionKey="id" required="" value="${enrollmentInstance?.student?.id}" class="many-to-one"/>
</div>

