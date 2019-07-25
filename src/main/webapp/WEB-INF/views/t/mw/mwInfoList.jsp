<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>劳模信息管理</title>
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/mw/mwInfo/list?mwId=${mwInfo.mwId}">劳模信息列表</a></li>
		<li><a href="${ctx}/mw/mwInfo/form?mwId=${mwInfo.mwId}">劳模信息添加</a></li>
	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>劳模类型</th>
				<th>奖励授予年份</th>
				<th>奖励信息</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="mwInfo">
			<tr>
				<td><a href="${ctx}/mw/mwInfo/form?id=${mwInfo.id}">
					${mwInfo.mwType}
				</a></td>
				<td>
					<fmt:formatDate value="${mwInfo.mwDate}" pattern="yyyy-MM"/>
				</td>
				<td>
					${mwInfo.mwInfo}
				</td>
				<td>
    				<a href="${ctx}/mw/mwInfo/form?id=${mwInfo.id}&mwId=${mwInfo.mwId}">修改</a>
					<a href="${ctx}/mw/mwInfo/delete?id=${mwInfo.id}" onclick="return confirmx('确认要删除该劳模信息吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>