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
<s:head />
</head>
<body>
<div class="wrap">
  <div class="nav">位置：用户管理</div>
  <div class="opr"><a class="back" href="javascript:void(0);" onclick="history.back();">返回</a></div>
  <div class="body">
    <s:form method="post" action="%{#ctx}/manager/user-info/%{id}">
      <s:hidden name="_method" value="put" />
      <table width="100%" cellpadding="3" cellspacing="0" border="1" class="form">
        <tr>
          <th colspan="2"></th>
        </tr>
        <s:textfield name="id" label="用户ID" disabled="true"/>
        <s:textfield label="用户名" name="user_name" id="user_name" required="true" requiredposition="left" size="40" maxlength="40" tooltip="用户名只能是数字、字母和下划线！" tooltipDelay="500" tooltipIconPath="%{#ctx}/commons/styles/images/icons/default/16px/information.gif" />
        <s:textfield label="密码" name="pass_word" id="pass_word" required="true" requiredposition="left" size="40" maxlength="40" />
        <s:textfield label="确认密码" name="pass_word_too" id="pass_word_too" required="true" requiredposition="left" size="40" maxlength="40" />
        <s:textfield label="生日" name="birthday" id="birthday" size="10" maxlength="10" />
        <tr>
          <td width="15%">&nbsp;</td>
          <td width="85%"><s:submit type="button" value="提交" theme="simple" /></td>
        </tr>
      </table>
    </s:form>
  </div>
</div>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.js"></script> 
<script type="text/javascript" src="${ctx}/commons/scripts/validator.js"></script> 
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() { 
	$("#user_name").attr("dataType", "Require").attr("msg","用户名必须填写！");
	$("#user-info").submit(function(){
		return Validator.Validate(this, 3);
	});
});
//]]>--></script>
</body>
</html>
