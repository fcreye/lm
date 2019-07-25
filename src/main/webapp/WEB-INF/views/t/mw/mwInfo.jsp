<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
	<title>劳模信息</title>
</head>
<body>
<style>
	.rightTeTabCon{
		color:#444;
		text-align: left;
	}
	table{
		color:#444;
		text-align: center;
		width: 80%;
	}
	.rightTeTabCon h2{
		font-size: 20px;
		font-weight: bold;
		line-height: 35px;
		color:#97310e;
		font-family: '黑体';
		-webkit-margin-before: 0.83em;
	    -webkit-margin-after: 0.83em;
	    -webkit-margin-start: 40px;
	    -webkit-margin-end: 0px;
	}
	.basicInfor p {
	    float: left;
	    margin-left:40px;
	    font-size: 14px;
	    line-height: 24px;
	    width: 70%;
	    -webkit-margin-before: 1em;
	    -webkit-margin-after: 1em;
	    -webkit-margin-start: 0px;
	    -webkit-margin-end: 0px;
	    -webkit-padding-start: 40px;
}
.basicInfor img {
    float: right;
    width: 25%;
    padding-bottom: 10px;
}
.bottomMore li {
    border-top: 1px solid #ccc;
    padding: 15px 0;
}

.teacherscontmain {
    border-top: 2px solid #999;
    width: 80%;
    margin:30px auto;
}
.teacherscontmain ul li {
    margin: 0;
    list-style: none;
    line-height: 22px;
    clear: both;
}
#text2 p{
text-indent:2em;
}

.fanhui{
	height: 50px;
	font-size: 24px;
	color:#fff;
}
</style>
	<div id="header" class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="brand"><span id="productName">${fns:getConfig('productName')}</span></div>
			<div class="nav-collapse">
				<ul id="menu" class="nav" style="*white-space:nowrap;float:none;">
					<li class="menu">
						<a class="menu" href="${ctx }/../f/mw/list"<span>返回劳模信息列表</span></a>
					</li>
					<li class="menu active">
						<a class="menu" href="javascript:"<span>劳模详细信息</span></a>
					</li>
				</ul>
			</div>
		</div>
    </div>
<!-- 正文  开始-->
	
	<div style="width: 100%; text-align: center;">
		<div class="teacherscontmain" id="teacherscontmain">
			<div class="rightTeTabCon"> 
		        <h2 id="BasicInfoName">&nbsp;</h2>
		        <h2 id="BasicInfoName">&nbsp;</h2>
		        <h2 id="BasicInfoName">${mw.name}</h2>
		        <div class="basicInfor">
		            <p>
		                <span>性&nbsp;&nbsp;&nbsp;&nbsp;别：
		                ${fns:getDictLabel(mw.sex, "sex", "")}
		                </span><br>
		                <span>出生日期：
		                <fmt:formatDate value="${mw.birthday}" pattern="yyyy-MM-dd"/>
		                </span><br>
		                <span>身份证号：${mw.idCode }</span><br>
		                <span>工作单位：${mw.org }</span><br>
		                <span></span>
		            </p>
		            <img src="${mw.image }"  alt="${mw.name }">
		        </div>
		        
		        <ul class="bottomMore">
		            <li id="text1">
		             <h3 class="BasicInfoName">劳模信息</h3>
		            <table>
		            <tr>
		            	<th align="center" width="30%">
						劳模类型	   
		            		</th>
		            		<th align="center" width="30%">
						奖励授予年份  
		            		</th>
		            		<th>
						奖励信息	   
		            		</th>
		            	</tr>
		            <c:forEach items="${infos }" var="u">
		            	<tr>
		            		<td align="center" width="30%">
						${u.mwType}	   
		            		</td>
		            		<td align="center" width="30%">
						<fmt:formatDate value="${u.mwDate}" pattern="yyyy-MM"/>   
		            		</td>
		            		<td>
						${u.mwInfo }	   
		            		</td>
		            	</tr>
		            </c:forEach>
		            </table>
		            </li>
		            <li id="text2" >
		            <h3 class="BasicInfoName">简要事迹</h3>
		             	${mw.content }
		            </li>
		        </ul>
		    </div>
		</div>
	</div>
</body>
</html>