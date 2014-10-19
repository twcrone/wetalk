
<%@ page import="com.goldragriff.wetalk.Message" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-message" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-message" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="createdDate" title="${message(code: 'message.createdDate.label', default: 'Created Date')}" />
					
						<th><g:message code="message.from.label" default="From" /></th>
					
						<g:sortableColumn property="text" title="${message(code: 'message.body.label', default: 'Body')}" />
					
						<th><g:message code="message.to.label" default="To" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${messageInstanceList}" status="i" var="messageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${messageInstance.id}">${fieldValue(bean: messageInstance, field: "createdDate")}</g:link></td>
					
						<td>${fieldValue(bean: messageInstance, field: "from")}</td>
					
						<td>${fieldValue(bean: messageInstance, field: "text")}</td>
					
						<td>${fieldValue(bean: messageInstance, field: "to")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${messageInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
