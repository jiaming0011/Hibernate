package cn.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Auction;
import cn.bean.AuctionRecord;
import cn.bean.AuctionUser;
import cn.service.AuctionRecordService;
import cn.service.AuctionService;


@WebServlet("/PriceAction")
public class PriceAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuctionRecordService ars = new AuctionRecordService();
	AuctionService as = new AuctionService();
       
   
    public PriceAction() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("¾ºÅÄ");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		AuctionRecord record = new AuctionRecord();
		int id = Integer.parseInt(request.getParameter("id"));
		Auction a = new Auction();
		a = as.findAuction(id);	
		record.setAuctionId(a);
		AuctionUser au = (AuctionUser)request.getSession().getAttribute("auctionUser");
		record.setUserId(au);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String abc = df.format(new Date());
		record.setAuctionTime(abc);
		double price = Double.parseDouble(request.getParameter("auctionPrice"));
		record.setAuctionPrice(price);
		try {
			ars.createBid(record);
			response.sendRedirect("/neusoft/AuctionAction?id="+id);
		} catch (Exception e) {
			request.getSession().setAttribute("errorMsg", e.getMessage());
			response.sendRedirect("error4.jsp");
		}
	}

}
