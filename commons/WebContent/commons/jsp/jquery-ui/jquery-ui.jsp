<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="jquery_ui_home" value="${ctx}/commons/plugins/jquery-ui-1.8.16" />
<c:set var="jquery_home" value="${ctx}/commons/scripts" />
<c:if test="${false}">
<!-- Themes from : base,black-tie,blitzer,cupertino,dark-hive,dot-luv,eggplant,excite-bike,
hot-sneaks,humanity,le-frog,mint-choc,overcast,pepper-grinder,redmond,smoothness,
south-street,start,sunny,swanky-purse,trontastic,ui-darkness,ui-lightness,vader -->
</c:if>
<c:set var="theme" value="ui-lightness" />

<link rel="stylesheet" href="${jquery_ui_home}/themes/${theme}/jquery.ui.all.css" />
<link rel="stylesheet" href="${ctx}/commons/styles/default/jquery-ui-overwrite.css" />
<script src="${jquery_ui_home}/ui/jquery.ui.core.js"></script>