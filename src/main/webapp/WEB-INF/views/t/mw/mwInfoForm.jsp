<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>劳模信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/mw/mwInfo/list?mwId=${mwInfo.mwId}">劳模信息列表</a></li>
		<li class="active"><a href="${ctx}/mw/mwInfo/form?id=${mwInfo.id}&mwId=${mwInfo.mwId}">劳模信息${not empty mwInfo.id?'修改':'添加'}
		</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="mwInfo" action="${ctx}/mw/mwInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="mwId"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">劳模类型：</label>
			<div class="controls">
					<form:input path="mwType" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">奖励授予年份：</label>
			<div class="controls">
				<input name="mwDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${mwInfo.mwDate}" pattern="yyyy-MM"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">奖励信息：</label>
			<div class="controls">
				<form:input path="mwInfo" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" style="width: 100px;"/>
		</div>
	</form:form>
</body>
</html>