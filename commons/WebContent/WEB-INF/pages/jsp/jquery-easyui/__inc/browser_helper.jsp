<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="datagrid-mask"></div>  
<div class="datagrid-mask-msg">  
  <div style="font-weight:bold; color:red;">对不起，您使用的浏览器版本太低（Internet Explorer <span id="browser_version"></span>），访问系统会存在速度和兼容性的问题！</div>  
  <div style="font-weight:bold; color:green;">我们推荐您使用最新版的 Chrome、Firefox、或 IE9 及以上版本的浏览器。</div>  
  <div><a href="http://www.google.cn/chrome/intl/zh-CN/landing_chrome.html" target="_blank">下载 Chrome 浏览器</a></div>  
  <div><a href="http://firefox.com.cn/" target="_blank">下载 Firefox 火狐浏览器</a> </div>  
  <div><a href="http://windows.microsoft.com/zh-CN/internet-explorer/products/ie/home/" target="_blank">下载 Internet Explorer 9 浏览器</a> </div>  
</div>
<script type="text/javascript"><!--//<![CDATA[
$(function(){
    if(self != top){
        top.location = self.location;
    }

    var lameIE = $.browser.msie && $.browser.version < 9;
    if (lameIE) {
        $('#browser_version').html($.browser.version);

        var $mask = $('.datagrid-mask');
        var $mask_msg = $('.datagrid-mask-msg');

        $mask.css({
            display: 'block',
            width: $(window).width(),
            height: $(window).height()
        }).appendTo(document.body);

        $mask_msg.css({
            display: 'block', //显示出来
            'z-index': 9999, //最顶层，用户才能点到链接
            width: 560,
            height: 90,
            padding: '10px 10px 10px 60px', //覆盖原来的样式
            background: '#ffc url("${ctx}/jquery-easyui/themes/default/images/messager_warning.gif") no-repeat scroll 10px 10px', //覆盖原来的样式
            left: ($(window).width()  - $mask_msg.outerWidth())/2,
            top:  ($(window).height() - $mask_msg.outerHeight())/2
        });

        $(window).resize(function() {
            $mask.css({
                width:  $(window).width(),
                height: $(window).height()
            });
            $mask_msg.css({
                left: ($(window).width()  - $mask_msg.outerWidth())/2,
                top:  ($(window).height() - $mask_msg.outerHeight())/2
            });
        }).resize();
    }
});
//]]>--></script>
</body>
</html>
