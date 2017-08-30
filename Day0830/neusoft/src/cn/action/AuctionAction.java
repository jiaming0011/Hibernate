package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Auction;
import cn.service.AuctionService;


@WebServlet("/AuctionAction")
public class AuctionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AuctionService as = new AuctionService();  
    
    public AuctionAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ÎÒÒª¾ºÅÄ£¡");
		Auction a = new Auction();
		int id = Integer.parseInt(request.getParameter("id"));
		a = as.findAuction(id);
		request.setAttribute("a", a);
		request.getRequestDispatcher("/auction.jsp").forward(request, response);			
	}

}
