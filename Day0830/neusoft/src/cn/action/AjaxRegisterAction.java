package cn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.AuctionUser;
import cn.service.UserService;


@WebServlet("/AjaxRegisterAction")
public class AjaxRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService us = new UserService();   
   
    public AjaxRegisterAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理注册请求");
		String returnStr="用户名可用";
		String registerName = request.getParameter("account");
		System.out.println(registerName);
		AuctionUser user = new AuctionUser();
		user.setUserName(registerName);
		if(us.checkUser(user)!=null){
			returnStr="用户名已存在";
		}
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();  
	    out.print(returnStr);  
	    out.flush();  
		
		
	}

}
