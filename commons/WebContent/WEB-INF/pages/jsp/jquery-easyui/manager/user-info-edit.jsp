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
<script type="text/javascript" src="${ctx}/commons/scripts/datestringutils.js"></script>
</head>
<body>
<div style="width:100%;padding:0px;">
<div style="padding:6px 2px;border-bottom:1px solid #ccc;color:#C00;font-size:13px;">添加用户信息：</div>
<s:form method="post" action="%{#ctx}/manager/user-info">
  <s:hidden theme="simple" name="queryString" />
  <table width="100%" cellpadding="3" cellspacing="0" border="0">
    <tbody>
    <c:if test="${not empty id}">
    	<td class="tdLabel">ID:</td>
    	<td>${id}</td>
    </c:if>
    <fmt:formatDate var="birthday" value="${birthday}" pattern="yyyy-MM-dd" />
    <s:textfield label="用户名" name="user_name" id="user_name" required="true" requiredposition="left" size="40" maxlength="40" data-options="required:true,missingMessage:'用户名不能为空。'" cssClass="easyui-validatebox" />
    <s:textfield label="密码" name="pass_word" id="pass_word" required="true" requiredposition="left" size="40" maxlength="40" data-options="required:true,missingMessage:'密码不能为空。'" cssClass="easyui-validatebox" />
    <s:textfield label="确认密码" name="pass_word_too" id="pass_word_too" required="true" requiredposition="left" size="40" maxlength="40" cssClass="easyui-validatebox" data-options="required:true,validType:'equals[\"#pass_word\"]'" />
    <s:textfield label="生日" name="birthday" id="birthday1" size="10" maxlength="10" cssClass="easyui-datebox"><s:param name="value"><s:date name="birthday" format="yyyy-MM-dd"/></s:param></s:textfield>
    <tr>
      <td width="15%">&nbsp;</td>
      <td width="85%">
      	<a id="submit" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
      	<a id="redo" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">重置</a>
      	<a id="cancel" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
      	<a id="back" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-back'">返回</a>
      </td>
    </tr>
    </tbody>
  </table>
</s:form>
</div>
<%@ include file="/commons/jsp/jquery-ui/jquery-ui-datepicker.jsp" %>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() {
	$("#back").click(function(){ history.back(); });
	$("#cancel").click(function(){ location.href='${ctx}/manager/user-info?queryString=' + encodeURIComponent("${queryString}"); });
	$("#submit").click(function(){ $form.submit(); });
	$("#redo").click(function(){ $form[0].reset(); });
	
	// get global jQuery form. 
	var $form = $('#user-info');
	
	$form.submit(function(){
		var isSubmit = $(this).form('validate');
		if (isSubmit) {
			$.messager.progress();
			$("#submit,#redo,#concel,#back").linkbutton('disable');

			var id = "${id}";
			if (id.length > 0) $(this)[0].action += '/' + id + '?_method=put';
		}
		
		return $(this).form('validate');
	});

	// extend the 'equals' rule  
	$.extend($.fn.validatebox.defaults.rules, {
	    equals: {
	        validator: function(value,param){
	            return value == $(param[0]).val(); 
	        },
	        message: '两次输入不一致。'  
	    }
	});
});

//]]>--></script>
</body>
</html>
