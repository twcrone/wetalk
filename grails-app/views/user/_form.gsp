<%@ page import="com.goldragriff.wetalk.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${userInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'phoneNumber', 'error')} required">
	<label for="phoneNumber">
		<g:message code="user.phoneNumber.label" default="Phone Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phoneNumber" required="" value="${userInstance?.phoneNumber}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'shortName', 'error')} required">
	<label for="shortName">
		<g:message code="user.shortName.label" default="Short Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="shortName" required="" value="${userInstance?.shortName}"/>

</div>

