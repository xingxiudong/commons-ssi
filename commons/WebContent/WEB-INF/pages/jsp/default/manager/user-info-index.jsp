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
  <div class="query">
    <s:form action="user-info!index" method="post" theme="simple" > 用户ID：
      <s:textfield name="user_id" id="user_id" theme="simple" size="20" />
      用户名：
      <s:textfield name="param.user_name_like" id="user_name_like" theme="simple" size="20" />
      每页显示:
      <s:select list="#{'10':'10条','20':'20条','50':'50条','100':'100条'}" name="pager.pageSize" theme="simple" onchange="this.form.submit();" />
      <s:submit value="查询" theme="simple" />
    </s:form>
  </div>
  <div class="opr"><a href="javascript:void(0);" id="deleteAll" class="delBtn">删除</a> <a href="user-info/new">创建一个新用户</a> <a class="back" href="javascript:void(0);" onClick="history.back();">返回</a></div>
  <div class="body">
    <table id="list" width="100%" cellpadding="3" cellspacing="0" border="1" class="datagrad">
      <tr>
        <th width="3%"><input type="checkbox" name="pks_ckall" id="checkAllBtn" /></th>
        <th width="5%">序号</th>
        <th>用户ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th width="10%">操作</th>
      </tr>
      <c:forEach var="cur" items="${rows}" varStatus="vs">
        <tr>
          <td align="center"><input type="checkbox" name="pks" id="pks_${cur.user_id}" value="${cur.user_id}" /></td>
          <td align="center">${(pager.currentPage - 1) * pager.pageSize + vs.count}</td>
          <td>${cur.user_id}</td>
          <td>${cur.user_name}</td>
          <td>${cur.pass_word}</td>
          <td align="center" nowrap="nowrap"><a href="user-info/${cur.user_id}">查看</a> <a href="user-info/${cur.user_id}/edit">修改</a> <a href="user-info/${cur.user_id}/deleteConfirm">删除</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>
  <div class="page-ctrl">
    <form id="bottomPageForm" name="bottomPageForm" method="post" action="user-info!index">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" >
        <tr>
          <td height="40" align="right"><script type="text/javascript" src="${ctx}/commons/scripts/pager.js">;</script> 
            <script type="text/javascript">
	            var pager = new Pager(document.bottomPageForm, ${pager.recordCount}, ${pager.pageSize}, ${pager.currentPage});
	            pager.addHiddenInputs("user_id", "${m.param.user_id}");
	            pager.addHiddenInputs("param.user_name_like", "${m.param.user_name_like}");
	            pager.addHiddenInputs("pager.pageSize", "${pager.pageSize}");
	            document.write(pager.toString());
	      </script></td>
        </tr>
      </table>
    </form>
  </div>
</div>
<%@ include file="/commons/jsp/jquery-ui/jquery-ui-button.jsp" %>
<script type="text/javascript" src="${ctx}/commons/scripts/jquery.formutils.js"></script>
<script type="text/javascript"><!--//<![CDATA[
$(document).ready(function() {
	$("#deleteAll").click(function() {
		if(confirm("确认全部删除吗？")) {
			$("#list").postFormWithFields("${ctx}/manager/user-info!destroy");
		}
	});
	$("#checkAllBtn").checkAll("pks", $("#list"));
	
	$("#user-info").find("input[type='text']").xInput();
	
	$("input:submit, a, button", ".opr, .query").button();
	//$("a", ".opr").click(function() { return false; });
});
//]]>--></script>
</body>
</html>
