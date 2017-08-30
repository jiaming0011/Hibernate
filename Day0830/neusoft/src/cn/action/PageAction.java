package cn.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Auction;
import cn.bean.Page;
import cn.dao.impl.AuctionDaoImpl;


@WebServlet("/PageAction")
public class PageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PageAction() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理分页请求");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		Auction a = new Auction();
		String cName = request.getParameter("cName");
		String cDesc = request.getParameter("cDesc");
		String cStartTime = request.getParameter("cStartTime");
		String cEndTime = request.getParameter("cEndTime");
		double cPrice = 0;
		if(request.getParameter("cPrice")!=null&& !"".equals(request.getParameter("cPrice"))){
			cPrice = Double.parseDouble(request.getParameter("cPrice"));
		}
		a.setAuctionName(cName);
		a.setAuctionDesc(cDesc);
		a.setAuctionStartTime(cStartTime);
		a.setAuctionEndTime(cEndTime);
        a.setAuctionStartPrice(cPrice);			
		
		int pageIndex=Integer.parseInt(request.getParameter("pageIndex")==""?"1":request.getParameter("pageIndex"));
		System.out.println(pageIndex);
		Page pa = new Page();
		pa.setPageIndex(pageIndex);
		pa.setPageSize(6);
		pa.setCountSize(new AuctionDaoImpl().allCount(a).intValue());
		pa.initFp();
		pa.setList(new AuctionDaoImpl().findAuctionByPage(pa.getStartIndex(),a));
		request.setAttribute("AuctionPage", pa);
		request.setAttribute("au", a);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		 
	
	}

}
