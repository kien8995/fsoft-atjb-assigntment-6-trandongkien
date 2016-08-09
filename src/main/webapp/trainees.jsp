<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib
	uri="/struts-tags"
	prefix="s"%>
<%@taglib
	uri="/struts-jquery-tags"
	prefix="sj"%>
<%@taglib
	uri="/struts-bootstrap-tags"
	prefix="sb"%>
<!DOCTYPE html>
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=UTF-8">
<title>Trainees</title>
<sj:head />
<sb:head />
<script
	type="text/javascript"
	src="bootstrap-validator/dist/validator.min.js"></script>
<link
	rel="stylesheet"
	type="text/css"
	href="toastr/build/toastr.min.css" />
<script
	type="text/javascript"
	src="toastr/build/toastr.min.js"></script>
</head>
<body>
	<script>
		toastr.info('Hi, <s:property value="#session.user.getAccount()" /> ');
	</script>
	<s:if test="%{isExist == true}">
		<script>
			setTimeout(function() {
				toastr.success('Account Updated !')
			}, 1000);
		</script>
	</s:if>
	<s:else>
		<script>
			setTimeout(function() {
				toastr.success('Account Created !')
			}, 1000);
		</script>
	</s:else>
	<div class="container">
		<h2>
			Hi,
			<s:property value="#session.user.getAccount()" />
		</h2>
		<div class="row">
			<div class="col-xs-6 col-md-8 col-lg-10 vcenter">
				<h4>
					<span class="label label-info">First Name</span>
					&nbsp;
					<s:property value="#session.user.getFirstName()" />
				</h4>
				<h4>
					<span class="label label-info">Last Name</span>
					&nbsp;
					<s:property value="#session.user.getLastName()" />
				</h4>
				<h4>
					<span class="label label-success">Email</span>
					&nbsp;
					<s:property value="#session.user.getEmail()" />
				</h4>
				<a
					href='<s:url action="user-account"/>'
					class="btn btn-warning"
					role="button">Go back</a>
			</div>
			<div class="col-xs-6 col-md-4 col-lg-2 vcenter">
				<a
					href='<s:url action="feedbacks"/>'
					class="btn btn-warning btn-lg"
					role="button">Feedbacks</a>
			</div>
		</div>
		<div class="table-responsive">
			<h3>Guests list</h3>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Account</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator
						var="u"
						value="users"
						status="rowStatus">
						<tr>
							<td>
								<s:property value='%{#rowStatus.index + 1}' />
							</td>
							<td>
								<s:property value="#u.getAccount()" />
							</td>
							<td>
								<s:property value="#u.getFirstName()" />
							</td>
							<td>
								<s:property value="#u.getLastName()" />
							</td>
							<td>
								<s:property value="#u.getEmail()" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<s:property value="users.size()" />
							&nbsp;result(s).
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
</html>