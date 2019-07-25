<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>劳动模范管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		
		 function btnImport(_id,_name){
			 $("#mwId").val(_id);
				$.jBox("iframe:${ctx}/mw/mwInfo/form?mwId="+_id, 
						{
							title:"增加"+_name+"劳模类型事迹", 
							buttons:{"关闭":true},
							width: 550, 
						    height: 350, 
					bottomText:"多个劳模事迹分次增加！"});
		 } 
	</script>
</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mw/modelWorker/">劳动模范列表</a></li>
		<li><a href="${ctx}/mw/modelWorker/form">劳动模范添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="modelWorker" action="${ctx}/mw/modelWorker/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idCode" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>身份证号</th>
				<th>工作单位</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="modelWorker">
			<tr>
				<td><a href="${ctx}/mw/modelWorker/form?id=${modelWorker.id}">
					${modelWorker.name}
				</a></td>
				<td>
					${fns:getDictLabel (modelWorker.sex,'sex','wu')} 
				</td>
				<td>
					<fmt:formatDate value="${modelWorker.birthday}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					${modelWorker.idCode}
				</td>
				<td>
					${modelWorker.org}
				</td>
				<td>
    				<a href="${ctx}/mw/modelWorker/form?id=${modelWorker.id}">修改</a>
    				<a href="javascript:;" onclick="btnImport('${modelWorker.id}','${modelWorker.name}')">增加劳模事迹</a>
					<a href="${ctx}/mw/modelWorker/delete?id=${modelWorker.id}" onclick="return confirmx('确认要删除该劳动模范吗？', this.href)">删除</a>
    				<a href="${ctx}/../f/mw/context?id=${modelWorker.id}">预览</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>