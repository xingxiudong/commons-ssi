<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>用户管理</title>
<link type="text/css" rel="stylesheet" href="${ctx}/commons/styles/default/global.css" />
</head>
<body>
<div class="wrap">
  <div class="nav">位置：用户管理</div>
  <div class="opr"><a class="back" href="javascript:void(0);" onclick="history.back();">返回</a></div>
  <div class="body">
    <s:form method="post" action="%{#ctx}/manager/user-info">
      <table width="100%" cellpadding="3" cellspacing="0" border="1" class="form">
        <tr>
          <th colspan="2"></th>
        </tr>
        <s:textfield label="用户名" name="user_name" id="user_name" required="true" requiredposition="left" size="40" maxlength="40" tooltip="用户名只能是数字、字母和下划线！" tooltipDelay="500" tooltipIconPath="%{#ctx}/commons/styles/images/icons/default/16px/information.gif" />
        <s:textfield label="密码" name="pass_word" id="pass_word" required="true" requiredposition="left" size="40" maxlength="40" />
        <s:textfield label="确认密码" name="pass_word_too" id="pass_word_too" required="true" requiredposition="left" size="40" maxlength="40" />
        <s:textfield label="生日" name="birthday" id="birthday" size="10" maxlength="10" cssClass="datepicker" />
        <tr>
          <td width="15%">&nbsp;</td>
          <td width="85%"><s:submit value="提交" theme="simple" /></td>
        </tr>
      </table>
    </s:form>
  </div>
</div>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
<script type="text/javascript" src="${ctx}/commons/scripts/validator.js"></script> 
<%@ include file="/commons/jsp/jquery-ui/jquery-ui-datepicker.jsp" %>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() { 
	$("#user_name").attr("dataType", "Require").attr("msg","用户名必须填写！");
	$("#pass_word").attr("dataType", "Require").attr("msg","密码必须填写！");
	$("#pass_word_too").attr("dataType", "Repeat").attr("to", "pass_word").attr("msg", "密码填写不一致！");
	
	$("#user-info").submit(function(){
		//return Validator.Validate(this, 3);
	});
	
	$("input:submit, a, button", ".opr, .form").button();
	
	//$( "#datepicker" ).datepicker();
	$("#birthday").datepicker({
		// api： http://jqueryui.com/demos/datepicker/
		dateFormat : 'yy-mm-dd',
		minDate : new Date(2010, 1 - 1, 15),
		maxDate : '+1y +6m', //'y' for years, 'm' for months, 'w' for weeks, 'd' for days, e.g. '+1m +1w'), or null for no limit.
		numberOfMonths: [1, 3],
		showOptions: {direction: 'right' },
		showButtonPanel: true,
		showAnim: 'drop',
		showMonthAfterYear: true,
		showOtherMonths: true,
		selectOtherMonths: true,
		showOn: "focus",
		stepMonths: 3,
		showWeek: true,
		gotoCurrent: true,
		constrainInput: true,
		changeMonth: true,
		changeYear: true,
		firstDay: 1 //Set the first day of the week
	});
});
//]]>--></script>
</body>
</html>
