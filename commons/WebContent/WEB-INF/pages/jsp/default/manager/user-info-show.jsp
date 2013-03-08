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
  <s:actionmessage />
  <div class="opr"><a class="back" href="javascript:void(0);" onclick="history.back();">返回</a>
  <div class="body">
    <table width="100%" cellpadding="3" cellspacing="0" border="1" class="form">
      <tr>
        <th colspan="2"></th>
      </tr>
      <tr>
        <td width="15%" class="tdLabel">用户ID：</td>
        <td width="85%">${id}</td>
      </tr>
      <tr>
        <td class="tdLabel">用户名：</td>
        <td>${user_name}</td>
      </tr>
      <tr>
        <td class="tdLabel">密码：</td>
        <td>${pass_word}</td>
      </tr>
      <tr>
        <td class="tdLabel">Birthday：</td>
        <td><fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd" /></td>
      </tr>
    </table>
  </div>
  <div class="opr"><a class="back" href="javascript:void(0);" onclick="history.back();">返回</a>
</div>
</body>
</html>
