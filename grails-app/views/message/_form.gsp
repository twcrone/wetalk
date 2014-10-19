<%@ page import="com.goldragriff.wetalk.Message" %>



<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'createdDate', 'error')} required">
	<label for="createdDate">
		<g:message code="message.createdDate.label" default="Created Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="createdDate" precision="day"  value="${messageInstance?.createdDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'from', 'error')} required">
	<label for="from">
		<g:message code="message.from.label" default="From" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="from" name="from.id" from="${com.goldragriff.wetalk.User.list()}" optionKey="id" required="" value="${messageInstance?.from?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="message.text.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="text" required="" value="${messageInstance?.text}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'to', 'error')} required">
	<label for="to">
		<g:message code="message.to.label" default="To" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="to" name="to.id" from="${com.goldragriff.wetalk.MessageGroup.list()}" optionKey="id" required="" value="${messageInstance?.to?.id}" class="many-to-one"/>

</div>

