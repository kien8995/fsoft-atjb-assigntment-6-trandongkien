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
<title>Feedbacks</title>
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
	<div class="container">
		<h1>Feedbacks</h1>
		<s:form
			theme="bootstrap"
			role="form"
			validate="true"
			data-toggle="validator">
			<s:select
				label="Feedback type, choose from one of following types:"
				headerKey="-1"
				headerValue="-- Select Feedback --"
				list="feedbackTypeList"
				name="feedbackType"
				theme="bootstrap"
				required="true">
			</s:select>
			<s:radio
				label="Feedback rate:"
				list="feedbackRateList"
				name="feedbackRate"
				value="defaultFeedbackRateValue"
				theme="bootstrap"
				required="true" />
			<s:textarea
				label="Notes:"
				name="feedbackNote"
				cols="10"
				rows="3"
				theme="bootstrap" />
			<s:submit
				value="Submit"
				role="button"
				cssClass="btn btn-success" />
			<a
				href='<s:url action="trainees" />'
				role="button"
				class="btn btn-warning">Go back</a>
		</s:form>
		<div class="table-responsive">
			<h3>Feedback list</h3>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Feedback Type</th>
						<th>Feedback Rate</th>
						<th>Notes</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator
						var="fb"
						value="feedbacks"
						status="rowStatus">
						<tr>
							<td>
								<s:property value='%{#rowStatus.index + 1}' />
							</td>
							<td>
								<s:property value="#fb.getFeedbackType().toString()" />
							</td>
							<td>
								<s:property value="#fb.getFeedbackRate().toString()" />
							</td>
							<td>
								<s:property value="#fb.getNotes()" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<s:property value="feedbacks.size()" />
							&nbsp;result(s).
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
</body>
</html>