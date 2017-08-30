	var xhr;
	function checkAll(){
		 var flag=document.getElementById("rem_u").checked;
		
			if(flag)
			{
			   document.getElementById("rg").disabled=false;
			}
			else
			{
			   document.getElementById("rg").disabled=true;
			}
	}
	function checkAccount() {
		var reg_account = $("#register-account").val();
		if (reg_account == "") {
			messageShow("1","请输入用户名","#message-box1");
		} 
		else {			
			if (reg_account.length<6) {
				messageShow("0","","#message-box1");
				messageShow("1","用户名要求不低于6个字符","#message-box1");
			}
			else{
			var URLStr="/neusoft/AjaxRegisterAction?account="+reg_account;
			ajaxRequest("get",URLStr,true,"#message-box1");
			}
		}

	}
	function checkPassword() {
		var reg_password = $("#register-password").val();
		if (reg_password == "") {
			messageShow("1","请输入密码","#message-box2");
		} 
		else {			
			if (reg_password.length<6) {
				messageShow("0","","#message-box2");
				messageShow("1","密码要求不低于6个字符","#message-box2");
			}else{
				messageShow("0","","#message-box2");
			}			
		}

	}
	function checkCard() {
		var reg_card = $("#register-card").val();
		if (reg_card == "") {
			messageShow("1","身份证号必填","#message-box3");
		} else{
			messageShow("0","","#message-box3");
		}
	}
	function checkTel() {
		var reg_tel = $("#register-tel").val();
		if (reg_tel == "") {
			messageShow("1","电话号码必填","#message-box4");
		} else{
			messageShow("0","","#message-box4");
		}
	}

	/* 显示消息提示      
			type 用于标识消息类型      说明：0 代表清空;1 代表错误;
			meg_context  用于标识消息文本
			meg_box 消息显示的位置
	 */
	
	function messageShow(type,meg_context,meg_box) {
		if(type==0){
			$(meg_box).hide();
        }
		else if(type==1){			
			$(meg_box).show();
			$(meg_box).html(meg_context);
		}
	}
	
			
	/* ajax 异步请求
			ajaxMethod  访问方式    值只能是  get或post,
			ajaxURL   访问地址,
			ajaxSyn	  是否是异步请求  值只能是true/false ,默认值是true.
			meg_box   消息显示的位置
	*/		
	function ajaxRequest(ajaxMethod,ajaxURL,ajaxSyn,meg_box){
		//1.创建xmlHttpRequest 对象  ,创建请求对象
			xhr=new XMLHttpRequest();
			if(xhr!=null){
				//2.设置请求路径和方式
				xhr.open(ajaxMethod, ajaxURL,ajaxSyn);
				//3.设置回调函数
				xhr.onreadystatechange = function(){ajaxCall(meg_box);};
				//4.发送请求
				xhr.send();
				
			}
		
	}
	
	/* 回调函数 */
	function ajaxCall(meg_box) {  
        if(xhr.readyState == 4 ) {       //完全得到服务器的响应  
            if(xhr.status == 200) {      //没有异常  
                var text = xhr.responseText; 
                if(text=="用户名已存在"){
                	messageShow("1",text,meg_box);
                }
                else{
                    messageShow("0",text,meg_box);
                }
            }else if(xhr.status==500){
            	
            }
        }  
    }  
	
	





