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
<script type="text/javascript" src="${jquery_easyui_home}/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.utils.js"></script>
<script type="text/javascript" src="${ctx}/commons/scripts/datestringutils.js"></script>
<script type="text/javascript"><!--//<![CDATA[
// Set page default configuration here. 
var config = {
	ctx : '${ctx}',
	action_name : 'user-info',
	action : "${ctx}/manager/user-info",
	primary_key : 'user_id',
	search_form_id : '#searchForm',
	datagrid_id : '#datagrid',
	pageNumber : parseInt("${pageNumber}"),
	pageSize : parseInt("${pageSize}"),
	sort : "${sort}",
	order : "${order}"
};

$(function(){
	// datagrid initializtion.
	var $datagrid = $(config.datagrid_id).datagrid({
		//title:'My Title',
		//iconCls:'icon-save',
		width:600,
		height:350,
		nowrap: false,
		striped: true,
		fit: true,
		url:config.action + '!index.json',
		sortName: config.sort || config.primary_key,
		sortOrder: config.order || 'asc',
		idField: config.primary_key,
		method:'get',
		singleSelect:false, // true as default;
		toolbar:"#toolbar",
		pageNumber:config.pageNumber,
		pageSize:config.pageSize,
		queryParams : getStaticParam(),
		frozenColumns:[[
         	//{field:'ck',checkbox:true},
        	{field:'user_id',title:'用户ID',width:80,sortable:true}
		]],
		columns:[[
			{field:'user_name',title:'用户名',width:120,sortable:true},
			{field:'real_name',title:'姓名',width:120},
			{field:'birthday',title:'生日',width:120,sortable:true,formatter:function(value,row,index){
				return value ? new Date(Date.parse(value)).format("yyyy-MM-dd") : value;
			}},
			{field:'sex',title:'性别',width:120},
			{field:'is_active',title:'是否激活',width:80,align:'center',formatter:function(value,row,index){
					return "未激活,已激活".split(',')[value];
				},styler: function(value,row,index){
					return 'color:' + 'red,green'.split(',')[value] + ';';
				}
			},
			{field:'opt',title:'操作',width:100,align:'center',formatter:function(value,row,index){
					var btns = [];
					btns[btns.length] = '<a href="javascript:void(0);" onclick="location.href=\'{0}/{1}?queryString=\' + getQueryString(config.datagrid_id, config.search_form_id) + \'\';">查看</a>'.format(config.action, row[config.primary_key]);
					btns[btns.length] = '<a href="javascript:void(0);" onclick="location.href=\'{0}/{1}/edit?queryString=\' + getQueryString(config.datagrid_id, config.search_form_id) + \'\';\">编辑</a>'.format(config.action, row[config.primary_key]);
					return btns.join(" | ");
				}
			}
		]],
		pagination:true,
		rownumbers:true,
		onLoadSuccess : function(data){
			addPaginationButton();
		},
		onLoadError : function(){ alert("Server error!"); }
	});

	// pagination initializtion.
	function addPaginationButton() {
		var pager = $datagrid.datagrid('getPager');    // get the pager of datagrid  
		pager.pagination({
		    buttons:[{
		        iconCls:'icon-add',
		        handler:function(){
		            location.href = config.action + '/new';
		        }
		    },{
		        iconCls:'icon-edit',
		        handler:function(){
		        	var selectedRows = $datagrid.datagrid('getSelections');
		        	if (!selectedRows || selectedRows.length == 0) { $.messager.alert('警告', '没有选择行！', 'warning'); return; }
		        	location.href = config.action + '/' + selectedRows[0][config.primary_key] + '/edit?queryString=' + getQueryString(config.datagrid_id, config.search_form_id);
		        }
		    },{
		        iconCls:'icon-remove',
		        handler:function(){
		        	var selectedRows = $datagrid.datagrid('getSelections');
		        	if (!selectedRows || selectedRows.length == 0) { $.messager.alert('警告', '没有选择行！', 'warning'); return; }
		        	
		        	$.messager.confirm('确定？', '已选中 ' + selectedRows.length + ' 行，确定删除？', function(r){
		        		if (r){
		        			var request_url = config.action + "!destroy.json?_method=delete&";
		    	        	for (var i = 0; i < selectedRows.length; i++) {
		    	        		var row = selectedRows[i];
		    	        		request_url += "pks=" + row[config.primary_key] + '&';
		    	        	}
		    	        	$.getJSON(request_url, function(responseText, textStatus, XMLHttpRequest){
		    	        		if (textStatus == "success") {
		    	        			$datagrid.datagrid("reload").datagrid("unselectAll");
		    	        			$.messager.alert('信息', '信息删除成功！', 'info');
		    	        		} else {
		    	        			var msg = "Sorry but there was an error: ";
		        	        		$.messager.alert('错误', msg + XMLHttpRequest.status + " " + XMLHttpRequest.statusText, 'error');
		    	        		}
		    	        	});
		        		}
		        	});
		        }
		    },{ iconCls:'icon-save', handler:function(){ alert('导出'); }
		    }],
		    onBeforeRefresh:function(){ return true; }
		});
	}
});

// Other codes write here...
$(function(){
	$("#param_user_name_like").xInput();
});

function doSearch(datagridId, searchFormId) {
	var query_params = $(searchFormId).serialize();
	var query_objs = query_params.deserialize();
	//$(datagridId).datagrid('reload', query_objs).datagrid("clearSelections");
	$(datagridId).datagrid({pageNumber:1,queryParams:query_objs}).datagrid("clearSelections");
}
function to(url) {
	location.href = url;
}

function getQueryString(datagridId, searchFormId) {
	var options = $(datagridId).datagrid('options');
	if (!options) return "";

	var query_string = $(searchFormId).serialize();
	query_string += '&page=' + options.pageNumber;
	query_string += '&rows=' + options.pageSize;
	query_string += '&sort=' + options.sortName;
	query_string += '&order=' + options.sortOrder;
	
	return encodeURIComponent(query_string);
}

function getStaticParam() {
	return "${query.queryString}".deserialize();
}

// Override the datagrid loader to fix bug: Datagrid can't display pageNumber where it's greater than 2.
// Bug report: http://www.jeasyui.com/forum/index.php?topic=545.0
$.extend($.fn.datagrid.defaults, {
	loader: function(param, success, error){
		var opts = $(this).data('datagrid').options;
		var pager = $(this).datagrid('getPager');
		if (pager.length && pager.pagination('options').total == 1){
			pager.pagination('refresh',{
				pageNumber:opts.pageNumber,
				total: opts.pageNumber*opts.pageSize
			});
		}
		if (!opts.url) return false;
		$.ajax({
			type: opts.method,
			url: opts.url,
			data: param,
			dataType: 'json',
			success: function(data){
				success(data);
			},
			error: function(){
				error.apply(this, arguments);
			}
		});
	}
});
//]]>--></script>
</head>
<body>
<table id="datagrid"></table>
<div id="toolbar" style="height:auto;">
	<div class="message-info">
		<div class="message-tip icon-tip">&nbsp;</div>
		<div>
		<ul style="margin:0px;">
			<li>单击表格工具栏中的操作按钮能够进行“添加”、“修改”、“删除”和“导出”操作。</li>
			<li>选择日期 t1 到 t2 时，将查询 t1 时刻至 t2-1 时刻的记录。例如“2012-01-01”至“2013-01-01”，将查询“2012-01-01 00:00:00”至“2012-12-31 23:59:59”的记录。</li>
			<li style="display:none;"><c:forEach items="${query}" var="map"> 
				<c:if test="${map.value ne '' and map.value ne null}">
				<c:out value="${map.key}" /> =  <c:out value="${map.value}" /> <br/>
				</c:if>
				</c:forEach></li>
			<c:if test="${fn:length(query.queryString) gt 0 }">
			<li>查询参数列表： <br/>
				<ul>
				<c:forEach items="${fn:split(query.queryString, '&')}" var="cur">
					<c:set var="c" value="${fn:split(cur, '=')}" />
					<c:if test="${fn:length(c) gt 1}">
						<li><c:out value="${c[0]}" /> = <c:out value="${c[1]}" escapeXml="true" /> </li>
					</c:if>
				</c:forEach></ul>
				</li></c:if>
		</ul></div>
	</div>
    <div style="padding:5px;">
	<form id="searchForm">
        生日 从: <input id="param_birthday_ge" name="param.birthday_ge" type="text" class="easyui-datebox" style="width:90px" value="${query.param.birthday_ge}" />  
        到: <input id="param_birthday_lt" name="param.birthday_lt" type="text" class="easyui-datebox" style="width:90px" value="${query.param.birthday_lt}" />
        用户名:   
        <input id="param_user_name_like" name="param.user_name_like" class="inputx" type="text" size="10" value="${query.param.user_name_like}" />
        <input id="is_active" name="is_active" class="inputx" type="text" size="10" value="${query.is_active}" />
        
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'" onclick="doSearch('#datagrid', '#searchForm')">查询</a>  
        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="to('user-info');">清空</a>  
    </form>
    </div>
</div>
</body>
</html>