<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functionsx" prefix="fnx"%>

<%@taglib prefix="s" uri="/struts-tags" %>

<c:set var="ctx" value="${pageContext.request['contextPath']}" />

<c:set var="jquery_easyui_home" value="${ctx}/commons/plugins/jquery-easyui-1.3" />
<c:set var="jquery_easyui_theme" value="sunny" />