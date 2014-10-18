<%@ page import="com.goldragriff.wetalk.MessageGroup" %>



<div class="fieldcontain ${hasErrors(bean: messageGroupInstance, field: 'members', 'error')} ">
	<label for="members">
		<g:message code="messageGroup.members.label" default="Members" />
		
	</label>
	<g:select name="members" from="${com.goldragriff.wetalk.User.list()}" multiple="multiple" optionKey="id" optionValue="${{it.name}}" size="5" value="${messageGroupInstance?.members*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: messageGroupInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="messageGroup.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${messageGroupInstance?.name}"/>

</div>

