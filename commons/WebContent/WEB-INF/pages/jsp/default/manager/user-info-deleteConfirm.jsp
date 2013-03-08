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
    <s:form method="post" action="%{#ctx}/manager/user-info/%{id}" theme="simple">
      <s:hidden name="_method" value="DELETE" />
      <p> 确定需要删除  ${id}? </p>
      <div> <a class="sure" href="javascript:void(0);" onclick="document.getElementById('${id}').submit();">确定</a> <a class="cancel" href="javascript:void(0);" onclick="location.href='${ctx}/manager/user-info';">取消</a> </div>
    </s:form>
  </div>
</div>
</body>
</html>
