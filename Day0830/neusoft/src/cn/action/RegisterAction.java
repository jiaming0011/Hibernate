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


@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserService();
       
   
    public RegisterAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("×¢²áÅÐ¶Ï");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		String newName = request.getParameter("newName");
		String newPassword = request.getParameter("newPassword");
		String newCard = request.getParameter("newCard");
		String newTel = request.getParameter("newTel");
		String newEmail = request.getParameter("newEmail");
		String newAddress = request.getParameter("newAddress");
		if((newName.length()<6)||(newPassword.length()<6)||newName.equals("")||newPassword.equals("")||newCard.equals("")||newTel.equals("")||newEmail.equals("")||newAddress.equals("")){
			response.sendRedirect("/neusoft/error3.jsp");
		}else{
			AuctionUser user = new AuctionUser(newName,newPassword,newCard,newTel,newAddress,newEmail,0,"","");
			us.registerUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("auctionUser",us.checkUser(user));
			request.getRequestDispatcher("/index.html").forward(request, response);
			
		}
	}

}
