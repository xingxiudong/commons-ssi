<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${ctx}/commons/styles/jquery-easyui/global.css" />
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/${jquery_easyui_theme}/easyui.css" />
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/icon.css" />
<script type="text/javascript" src="${jquery_easyui_home}/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${jquery_easyui_home}/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/commons/scripts/datestringutils.js"></script>
<style>
.wrap {margin:10px;}
.view-text, .view-bar {padding:5px 0px;}
</style>
</head>
<body>
<div class="wrap">
<div class="view-text"><table id="pg" class="easyui-propertygrid" style="width:400px;" data-options="showGroup:true"></table></div>
<div class="view-bar">
<a id="back" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-back'">返回</a>
<a id="cancel" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
</div>
</div>
<script type="text/javascript"><!--//<![CDATA[
$(function() {
	$("#back").click(function(){ history.back(); });
	$("#cancel").click(function(){ location.href='${ctx}/manager/user-info?queryString=' + encodeURIComponent("${queryString}"); });
	
	var rows = [
		{"field":"user_id","name":"用户ID","group":"基础信息"},  
		{"field":"user_name","name":"用户名","group":"登录信息"},
		{"field":"pass_word","name":"密码","group":"登录信息"},
		{"field":"real_name","name":"姓名","group":"用户资料"},
		{"field":"birthday","name":"生日","group":"用户资料","pattern":"yyyy-MM-dd"}
	];

	$.getJSON('${ctx}/manager/user-info/${id}.json', function(jsondata) {
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			
			row.value = jsondata[row.field];
			if (!row.value) row.value = '<span style="color:#F00;">未填写</span>';
			if (typeof row.value == 'object' && row.value.time) row.value = new Date(row.value.time).format(row.pattern);
		}
		$('#pg').propertygrid('loadData',rows);
	});
});

function showGroup(){
	$('#pg').propertygrid({
		showGroup:true
	});
}

function hideGroup(){
	$('#pg').propertygrid({
		showGroup:false
	});
}

function hideHeader(){
	$('#pg').propertygrid({
		showHeader:false
	});
}
//]]>--></script>
</body>
</html>
