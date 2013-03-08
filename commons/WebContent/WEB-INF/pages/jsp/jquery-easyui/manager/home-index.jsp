<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title> 首页 - 管理后台  </title>
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/${jquery_easyui_theme}/easyui.css" />
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/icon.css" />
<script type="text/javascript" src="${jquery_easyui_home}/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${jquery_easyui_home}/jquery.easyui.min.js"></script>
<script type="text/javascript">
function openTab(containerId, node) {
	if ($(containerId).tabs('exists', node.text)) {
		$(containerId).tabs('select', node.text);
	} else {
		var content = '<iframe id="' + node.id + '" src="' + node.attributes.target + '" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>';
		$(containerId).tabs('add', {
			title:node.text,
			content:content,
			//iconCls:'icon-reload',
			closable:true,
			tools:[{
				iconCls:'icon-mini-refresh',
				handler:function(){
					$("#" + node.id).attr("src", node.attributes.target);
				}
			}]
		});
	}
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" title="" style="height:50px;padding:10px;">
		<span style="font-size:20px;font-weight:800;font-family:'微软雅黑','黑体'">信息管理系统(jQuery EasyUi Support)</span>
	</div>
	<div data-options="region:'south',split:true" title="" style="height:30px;padding:4px;background:#efefef;text-align:center;">
		Technical support by jQuery EasyUI software - <a href="http://www.jeasyui.com/contact.php" target="_blank">Commercial License</a>
	</div>
	<div data-options="region:'east',iconCls:'icon-reload',split:true,collapsed:true" title="功能树菜单" style="width:180px;">
		<!-- <ul class="easyui-tree" data-options="url:'view-tree-item/1.json',animate:true,dnd:true,method:'get',
			onClick: function(node){
				openTab('#tt', node);
				$(this).tree('toggle', node.target);
			}"></ul> -->
	</div>
	<div id="west" data-options="region:'west',split:true" title="功能菜单" style="width:220px;padding1:1px;overflow:hidden;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach var="cur" items="${modelList[0].children}" varStatus="vs">
				<div title="${cur.text}">
					<ul class="easyui-tree" data-options="url:'view-tree-item/${cur.id}.json?exclude_start=true',method:'get',animate:true,dnd:true,onClick: function(node){
						openTab('#tt', node);
						$(this).tree('toggle', node.target);
					}"></ul>
				</div>
			</c:forEach>
			<div title="Test Module" style="padding:10px;overflow:auto;">
				<ul>
					<li><a class="newT" href="javascript:void(0)" data-options="mod_id:'1',mod_url:'${ctx}/manager/user-info'">模块一</a></li>
					<li><a class="newT" href="javascript:void(0)" data-options="mod_id:'2',mod_url:'http://match.2012.sina.com.cn/schedule/date/2012-07-30/'">模块二：2012伦敦奥运会</a></li>
					<li><a class="newT" href="javascript:void(0)" data-options="mod_id:'3',mod_url:'http://www.baidu.com'">模块三:百度</a></li>
					<li><a class="newT" href="javascript:void(0)" data-options="mod_id:'4',mod_url:'http://g.cn'">模块四</a></li>
					<li><a class="newT" href="javascript:void(0)" data-options="mod_id:'5',mod_url:'${ctx}/manager/user-info'">模块五</a></li>
				</ul>
				<ul id="tt3" class="easyui-tree" data-options="url:'view-tree-item/1.json'"></ul>
			</div>
		</div>
	</div>
	<div data-options="region:'center'" title="" style="overflow:hidden;">
		<div id="tt" class="easyui-tabs" data-options="fit:true,border:false,tools:'#tab-tools'">
			<div title="Welcome" style="padding:20px;overflow:hidden;"> 
				<div style="margin-top:20px;">
					<h3>jQuery EasyUI framework help you build your web page easily.</h3>
					<ul>
						<li>easyui is a collection of user-interface plugin based on jQuery.</li> 
						<li>using easyui you don't write many javascript code, instead you defines user-interface by writing some HTML markup.</li> 
						<li>easyui is very easy but powerful.</li> 
					</ul>
				</div>
			</div>
		</div>
	</div>

<div id="tab-tools">
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">换肤</a>
	<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-help'"></a>
</div>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() {
});
//]]>--></script>
<jsp:include page="../__inc/browser_helper.jsp" />
</body>
</html>
