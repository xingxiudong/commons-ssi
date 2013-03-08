
String.prototype.repeat = function(count, seperator) {  
    seperator = seperator || '';  
    var a = new Array(count);  
    for (var i = 0; i < count; i++){  
        a[i] = this;  
    }  
    return a.join(seperator);  
};

String.prototype.format = function(){    
    var args = arguments;    
    return this.replace(/\{(\d+)\}/g,                    
        function(m,i){    
            return args[i];    
        });
};

/**
 * Object Deserialize.
 *
 * @param serialize_string: ready serialize string.
 * @param attr_joinchar: join char among attributes.
 * @param keyvalue_joinchar: join char between key and value of object.
 * @return deserialize object.
 * @Author XiuDong Xing
 * @version 2012-08-03
 */
String.prototype.deserialize = function(attr_joinchar, keyvalue_joinchar) {
	attr_joinchar = attr_joinchar || '&';
	keyvalue_joinchar = keyvalue_joinchar || '=';
	var ret = {};
	var params = this.split(attr_joinchar);
	for (var i = 0; i < params.length; i++) {
		var kvs = params[i].split(keyvalue_joinchar);
		ret[kvs[0]] = kvs[1];
	}
	return ret;
};

/**
	字母  日期或时间元素  表示  示例   
	G  Era 标志符  Text  AD   
	y  年  Year  1996; 96   
	M  年中的月份  Month  July; Jul; 07   
	w  年中的周数  Number  27   
	W  月份中的周数  Number  2   
	D  年中的天数  Number  189   
	d  月份中的天数  Number  10   
	F  月份中的星期  Number  2   
	E  星期中的天数  Text  Tuesday; Tue   
	a  Am/pm 标记  Text  PM   
	H  一天中的小时数（0-23）  Number  0   
	k  一天中的小时数（1-24）  Number  24   
	K  am/pm 中的小时数（0-11）  Number  0   
	h  am/pm 中的小时数（1-12）  Number  12   
	m  小时中的分钟数  Number  30   
	s  分钟中的秒数  Number  55   
	S  毫秒数  Number  978   
	z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00   
	Z  时区  RFC 822 time zone  -0800   
*/
Date.prototype.format = function(style) {  
    var o = {  
        "y{4}|y{2}" : this.getFullYear(), //year  
        "M{1,2}" : this.getMonth() + 1, //month  
        "d{1,2}" : this.getDate(),      //day  
        "H{1,2}" : this.getHours(),     //hour  
        "h{1,2}" : this.getHours()  % 12,  //hour  
        "m{1,2}" : this.getMinutes(),   //minute  
        "s{1,2}" : this.getSeconds(),   //second  
        "E" : this.getDay(),   //day in week  
        "q" : Math.floor((this.getMonth() + 3) / 3),  //quarter  
        "S{3}|S{1}"  : this.getMilliseconds() //millisecond  
    };
    for(var k in o ){  
        style = style.replace(new RegExp("("+ k +")"), function(m){  
            return ("0".repeat(m.length) + o[k]).substr(("" + o[k]).length);  
        }); 
    }
    return style;  
};