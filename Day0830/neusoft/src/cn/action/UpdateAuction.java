package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.service.AuctionService;


@WebServlet("/UpdateAuction")
public class UpdateAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AuctionService as = new AuctionService();  
   
    public UpdateAuction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理修改商品请求");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("Auction1", as.findAuction(id));
		request.getRequestDispatcher("/updateAuction.jsp").forward(request, response);
		
	}

}
