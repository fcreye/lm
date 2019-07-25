<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>北京市房山区总工会劳模</title>
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
	<style>
	#btnMenu{
	display: none;
	}
	#mytitle{
		width: 100%;
		height: 100px;
		color: blue;
		padding-top:100px;
		font-size: 60px;
		font-weight: 500;
		text-align: center;
	}
	</style>
	<script LANGUAGE=”JavaScript”> 
<!– 
function openwin(url) { 
window.open (url, "newwindow", "height=300, width=400, top=200,left=200 toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no")
 } 
//–> 
</script> 
</head>
<body>
	<div id="header" class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="brand"><span id="productName">${fns:getConfig('productName')}</span></div>
			<div class="nav-collapse">
				<ul id="menu" class="nav" style="*white-space:nowrap;float:none;">
					<li class="menu active">
						<a class="menu" href="javascript:"<span>劳模信息列表</span></a>
					</li>
				</ul>
			</div>
		</div>
    </div>
	<form:form id="searchForm" modelAttribute="modelWorker" action="" method="post" class="breadcrumb form-search" style="margin-top:50px;">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium" style="width:300px;"/>
			</li>
			<li><label>劳模类型：</label>
				<select name="nameC" class="input-medium" style="width: 200px">
					<option value="">全部</option>
					<option value="1" <c:if test="${modelWorker.nameC == '1'}">selected="true"</c:if>>北京市劳模</option>
					<option value="2" <c:if test="${modelWorker.nameC == '2'}">selected="true"</c:if>>部级劳模</option>
					<option value="3" <c:if test="${modelWorker.nameC == '3'}">selected="true"</c:if>>全国劳模</option>
					<option value="4" <c:if test="${modelWorker.nameC == '4'}">selected="true"</c:if>>全国五一劳动奖章</option>
					<option value="5" <c:if test="${modelWorker.nameC == '5'}">selected="true"</c:if>>外省市劳模</option>
					<option value="6" <c:if test="${modelWorker.nameC == '6'}">selected="true"</c:if>>享受北京市级劳模待遇</option>
					<option value="7" <c:if test="${modelWorker.nameC == '7'}">selected="true"</c:if>>享受全国劳模待遇</option>
				</select>
			</li>
			<li><label style="width: 130px">奖励授予年份：</label>
				<input name="updateDate" type="text"  maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${modelWorker.updateDate}" pattern="yyyy-MM"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" style="width:100px;"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th align="center" style="text-align: center;">序号</th>
				<th align="center" style="text-align: center;">姓名</th>
				<th align="center" style="text-align: center;">性别</th>
				<th align="center" style="text-align: center;">出生日期</th>
				<th align="center" style="text-align: center;">身份证号</th>
				<th align="center" style="text-align: center;">工作单位</th>
				<th align="center" style="text-align: center;">详情</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="modelWorker" varStatus="stc">
			<tr>
				<td  align="center" style="text-align: center;">
					${(page.pageNo-1)*page.pageSize+stc.count }
				</td>
				<td  align="center" style="text-align: center;">
					${modelWorker.name}
				</td>
				<td  align="center" style="text-align: center;">
					${modelWorker.name}
				</td>
				<td  align="center" style="text-align: center;">
					${fns:getDictLabel (modelWorker.sex,'sex','wu')} 
				</td>
				<td  align="center" style="text-align: center;">
					<fmt:formatDate value="${modelWorker.birthday}" pattern="yyyy-MM-dd"/>
				</td>
				<td  align="center" style="text-align: center;">
					${modelWorker.idCode}
				</td>
				<td>
					${modelWorker.org}
				</td>
				<td  align="center" style="text-align: center;">
    				<a href="context?id=${modelWorker.id}">详情</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>