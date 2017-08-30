package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.AuctionUser;
import cn.service.UserService;


@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理登录请求");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String admin = request.getParameter("admin");//勾选为on
		String password = request.getParameter("upassword");
		String yanzhengma = request.getParameter("yanzhengma");
		HttpSession session = request.getSession();
		String vCode = session.getAttribute("vCode").toString();
		if(!yanzhengma.equals(vCode)){
			System.out.println("验证码错误");
			response.sendRedirect("/neusoft/error.jsp");
		}else{
			UserService us = new UserService();
			AuctionUser user = new AuctionUser();
			user.setUserName(name);
			user.setUserPassword(password);
			if(admin!=null){
				user.setUserIsadmin(1);
			}
			if(us.checkUser(user)!=null){
				session.setAttribute("auctionUser",us.checkUser(user));
				request.getRequestDispatcher("/index.html").forward(request, response);
			}else{
				response.sendRedirect("/neusoft/error2.jsp");
			}
			
		}
		
		System.out.println(name+"\t"+password+"\t"+vCode+"\t"+admin);
		
	}

}
