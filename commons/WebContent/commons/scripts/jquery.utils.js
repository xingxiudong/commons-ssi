(function($){
	$.fn.extend({
		formable : function(url, data, opts, $fields, callback) {
			url = (url.indexOf("?") != -1 ? url : (url + "?"));
			data = data || {};
			opts = $.extend({
				formMethod : 'POST',
				formTarget : '',
				formId : $(this).attr('id')
			}, opts);
			$fields = $fields || $(this).find("input").clone();
			
			url += "&amp;" + $.param(data);
			
			var $form = $("<form id='formable_" + opts.formId + "' method='" + opts.formMethod + "' action='" + url + "' target='" + opts.formTarget + "' />");
			$form.append($fields).hide().appendTo("body");
			
			// 执行回调函数
			callback($form);
			
			return $(this);
		}, 
		postFormWithFields : function(url, data) {
			data = $.extend({
				_method : 'DELETE'
			}, data);
			var $cbks = $(this).find("input[type='checkbox'][name='pks']").filter(":checked");
			if ($cbks.length == 0) { alert('未选择删除项'); return; }
			$(this).formable(url, data, null, $cbks.clone(), function($form) {
				$form.submit();
			});
		},
		checkAll : function(name, $parents) {
			$this = $(this);
			var select_text = "input[type='checkbox'][name='pks']";
			$parents = $parents || $("body");
			$this.click(function() {
				$parents.find(select_text).each(function() {
					if (!this.disabled) {
						this.checked = $this[0].checked;
						setTitle($this);
					}
				});
			});
			setTitle($this);
			function setTitle($this) { $this.attr('title', $this[0].checked ? '取消选择' : '选择'); }
		},
		xInput : function(xCallback) {
			$(this).each(function(){
				$input = $(this);
				if (!$input) return;
				$input.css({'padding-right':'12px'});
				$input.wrap("<span style='position:relative;display:bolck;' />");
				$input.after("<b style='position:absolute;right:0px;top:0px;display:none;margin:0px;padding-right:3px;'>×</b>");
				
				$input.next().css({"cursor":"default"}).click(function(){
					$(this).prev().val("");
					$(this).hide();
					xCallback && xCallback();
				});
				
				$input.blur(function(){
					$(this).val($.trim($(this).val()));
					$(this).val().length > 0 ? $(this).next().show() : $(this).next().hide();
				});
				
				$(this).val().length > 0 ? $(this).next().show() : $(this).next().hide();
			});
		}
	});
})(jQuery);