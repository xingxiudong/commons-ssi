<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title> 欢迎光临  </title>
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/${jquery_easyui_theme}/easyui.css">
<link rel="stylesheet" type="text/css" href="${jquery_easyui_home}/themes/icon.css">
<script type="text/javascript" src="${jquery_easyui_home}/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${jquery_easyui_home}/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#tt2').datagrid({
		title:'My Title',
		iconCls:'icon-save',
		width:600,
		height:350,
		nowrap: false,
		striped: true,
		fit: true,
		url:'user-info!index.json',
		sortName: 'user_id',
		sortOrder: 'asc',
		idField:'user_id',
		method:'get',
		toolbar:"#tb",
		frozenColumns:[[
         	{field:'ck',checkbox:true},
        	{field:'user_id',title:'用户ID',width:80,sortable:true}
		]],
		columns:[[
			{field:'user_name',title:'用户名',width:120,sortable:true},
			{field:'real_name',title:'姓名',width:120},
			{field:'birthday',title:'生日',width:120,sortable:true,formatter:function(value,row,index){
				return value;
			}},
			{field:'sex',title:'性别',width:120},
			{field:'is_active',title:'是否激活',width:80,align:'center',formatter:function(value,row,index){
				return "未激活,已激活".split(',')[value];
			},styler: function(value,row,index){
				return 'color:' + 'red,green'.split(',')[value] + ';';
			}},
			{field:'opt',title:'操作',width:100,align:'center', rowspan:2,
				formatter:function(value,rec){
					return '<span style="color:red">Edit Delete</span>';
				}
			}
		]],
		pagination:true,
		rownumbers:true,
		onHeaderContextMenu: function(e, field){
			e.preventDefault();
			if (!$('#tmenu').length){
				createColumnMenu('tt2');
			}
			$('#tmenu').menu('show', {
				left:e.pageX,
				top:e.pageY
			});
		}
	});
	
	var pager = $('#tt2').datagrid('getPager');    // get the pager of datagrid  
	pager.pagination({
	    showPageList:true,
	    buttons:[{
	        iconCls:'icon-search',
	        handler:function(){
	            alert('search');
	        }
	    },{
	        iconCls:'icon-add',
	        handler:function(){
	            alert('add');
	        }
	    },{
	        iconCls:'icon-edit',
	        handler:function(){
	            alert('edit');
	        }
	    },{
	        iconCls:'icon-remove',
	        handler:function(){
	            alert('remove');
	        }
	    }],
	    onBeforeRefresh:function(){
	        //alert('before refresh');
	        return true;
	    }
	});
});
function openTab(containerId, node) {
	if ($('#' + containerId).tabs('exists', node.text)) {
		$('#' + containerId).tabs('select', node.text);
	} else {
		var content = '<iframe id="' + node.id + '" src="' + node.attributes.target + '" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>';
		$('#' + containerId).tabs('add', {
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
function createColumnMenu(containerId){
	var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
	var fields = $('#' + containerId).datagrid('getColumnFields');
	for(var i=0; i<fields.length; i++){
		var title = $('#' + containerId).datagrid('getColumnOption', fields[i]).title;
		$('<div iconCls="icon-ok" title="'+title+'" />').html(fields[i]).appendTo(tmenu);
	}
	tmenu.menu({
		onClick: function(item){
			if (item.iconCls=='icon-ok'){
				$('#' + containerId).datagrid('hideColumn', item.text);
				tmenu.menu('setIcon', {
					target: item.target,
					iconCls: 'icon-empty'
				});
			} else {
				$('#' + containerId).datagrid('showColumn', item.text);
				tmenu.menu('setIcon', {
					target: item.target,
					iconCls: 'icon-ok'
				});
			}
		}
	});
}
function doSearch(){
    $('#tt2').datagrid('reload',{
        'param.user_name_like': encodeURI($('#user_name_like').val())
    });
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true" title="North Title" style="height:100px;padding:10px;">
		<p>The north content.${fn:length(modelList)}</p>
	</div>
	<div data-options="region:'south',split:true" title="South Title" style="height:100px;padding:10px;background:#efefef;">
		<div class="easyui-layout" data-options="fit:true" style="background:#ccc;">
			<div data-options="region:'center'" align="center">Suport by jQuery EasyUI software - <a href="http://www.jeasyui.com/contact.php" target="_blank">Commercial License</a></div>
			<!-- <div data-options="region:'east',split:true" style="width:200px;">sub center</div> -->
		</div>
	</div>
	<div data-options="region:'east',iconCls:'icon-reload',split:true" title="Tree Menu" style="width:180px;">
		<ul class="easyui-tree" data-options="url:'view-tree-item/1.json',animate:true,dnd:true,method:'get',
			onClick: function(node){
				openTab('tt', node);
				$(this).tree('toggle', node.target);
			}"></ul>
	</div>
	<div id="west" data-options="region:'west',split:true" title="West Menu" style="width:220px;padding1:1px;overflow:hidden;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach var="cur" items="${modelList[0].children}" varStatus="vs">
				<div title="${cur.text}">
					<ul class="easyui-tree" data-options="url:'view-tree-item/${cur.id}.json?exclude_start=true',method:'get',animate:true,dnd:true,onClick: function(node){
						openTab('tt', node);
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
	<div data-options="region:'center'" title="Main Title" style="overflow:hidden;">
		<div id="tt" class="easyui-tabs" data-options="fit:true,border:false">
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
			<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="overflow:hidden;padding:5px;">
				<table id="tt2"></table> 
				<div id="tb" style="padding:5px;height:auto">
					<div style="margin-bottom:5px">  
				        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>  
				        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>  
				        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>  
				        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>  
				        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>  
				    </div>
				    <div>
				        Birthday From: <input id="birthday_ge" type="text" class="easyui-datebox" style="width:80px" />  
				        To: <input id="birthday_le" type="text" class="easyui-datebox" style="width:80px" />
				        User Name:   
				        <input id="user_name_like" style="width:100px" />
				        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="doSearch()">Search</a>  
				    </div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() {
});
//]]>--></script>
</body>
</html>
