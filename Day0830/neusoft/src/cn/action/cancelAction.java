package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cancelAction")
public class cancelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public cancelAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ÎÒÒª×¢Ïú£¡");
		HttpSession session = request.getSession();
		session.invalidate();
		//request.getRequestDispatcher("/index.html").forward(request, response);
		response.sendRedirect("/neusoft/index.html");
	}

}
