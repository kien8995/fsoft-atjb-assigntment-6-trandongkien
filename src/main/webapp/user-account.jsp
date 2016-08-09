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
<title>User Account</title>
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
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	<div class="container">
		<h1>User Information</h1>
		<s:form
			theme="bootstrap"
			role="form"
			validate="true"
			data-toggle="validator">
			<s:textfield
				name="userAccount"
				label="Account name:"
				type="text"
				required="required" />
				
				<s:textfield
				name="userFirstName"
				label="First name:"
				type="text"
				data-minlength="3"
				maxlength="10"
				required="required" />
				
				<s:textfield
				name="userLastName"
				label="Last name:"
				type="text"
				data-minlength="3"
				maxlength="10"
				required="required" />
				
				<s:textfield
				name="userEmail"
				label="Email:"
				type="email"
				data-minlength="3"
				maxlength="50"
				required="required" />
				
			<s:submit
				value="Submit"
				role="button"
				cssClass="btn btn-success" />
		</s:form>
	</div>
</body>
</html>