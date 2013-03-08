<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/jsp/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh" lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Error Page</title>
<link type="text/css" rel="stylesheet" href="${ctx}/commons/styles/default/global.css" />
</head>
<body>
Error!
<s:actionmessage />
<br/>
<a class="back" href="javascript:void(0);" onclick="history.back();">返回</a>
</body>
</html>
