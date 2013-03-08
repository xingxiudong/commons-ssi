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
.c {margin:10px;}
</style>
</head>
<body>
<div style="padding:6px 2px;border-bottom:1px solid #ccc;color:#C00;font-size:13px;">您确定需要删除这条记录吗？</div>
<div class="c">
<s:form method="post" action="%{#ctx}/manager/user-info/%{id}" theme="simple">
  <s:hidden name="_method" value="DELETE" />
</s:form>
</div>
<div class="c">
<a id="submit" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="document.getElementById('${id}').submit();">确定</a>
<a id="concel" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="history.back();">取消</a>
</div>
<div class="c"><table id="pg" class="easyui-propertygrid" style="width:400px;" data-options="showGroup:true"></table></div>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() {
	var rows = [
		{"field":"user_id","name":"用户ID","group":"基础资料","editor":"text"},  
		{"field":"user_name","name":"用户名","group":"用户登录信息","editor":"text"},
		{"field":"pass_word","name":"密码","group":"用户登录信息","editor":"text"},
		{"field":"real_name","name":"姓名","group":"用户资料","editor":"text"},
		{"field":"birthday","name":"生日","group":"用户资料","editor":"datebox","pattern":"yyyy-MM-dd"}
	];
	
	$.getJSON('${ctx}/manager/user-info/${id}.json', function(jsondata) {
		//$('#pg').propertygrid({scrollbarSize:0,showGroup:true})
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			row.value = jsondata[row.field];
			if (row.value) {
				if (typeof row.value == 'object' && row.value.time) row.value = new Date(row.value.time).format(row.pattern);
				$('#pg').propertygrid('appendRow', row);
			}
		}
	});
});
//]]>--></script>
</body>
</html>
