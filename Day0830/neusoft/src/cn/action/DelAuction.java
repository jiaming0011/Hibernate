package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.AuctionService;


@WebServlet("/DelAuction")
public class DelAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuctionService as = new AuctionService();
    
    public DelAuction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("¥¶¿Ì…æ≥˝«Î«Û");
		int id = Integer.parseInt(request.getParameter("id"));
		if(as.removeAuction(id)){
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
