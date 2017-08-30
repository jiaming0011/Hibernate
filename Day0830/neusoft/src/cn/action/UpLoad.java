package cn.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bean.Auction;
import cn.service.AuctionService;



@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuctionService as = new AuctionService();
       
    
    public UpLoad() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("处理上传商品请求");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		Auction au = new Auction();
		String auctionName = request.getParameter("auctionName");
		auctionName = new String(auctionName.getBytes("ISO8859-1"),"UTF-8");
		System.out.println(auctionName);
		au.setAuctionName(auctionName);
		double startPrice = Double.parseDouble(request.getParameter("startPrice"));
		au.setAuctionStartPrice(startPrice);
		double upSet = Double.parseDouble(request.getParameter("upSet"));
		au.setAuctionUpset(upSet);
		String startTime = request.getParameter("startTime");
		au.setAuctionStartTime(startTime);
		String endTime = request.getParameter("endTime");
		au.setAuctionEndTime(endTime);
		String desc = request.getParameter("desc");
		desc = new String(desc.getBytes("ISO8859-1"),"UTF-8");
		au.setAuctionDesc(desc);
		 //为解析类提供配置信息  
	     DiskFileItemFactory factory = new DiskFileItemFactory(); 
	     //创建解析类的实例  
	     ServletFileUpload sfu = new ServletFileUpload(factory);
	     //开始解析  
	     sfu.setFileSizeMax(1024*400);  
	   //每个表单域中数据会封装到一个对应的FileItem对象上  
	     try{
	    	 List<FileItem> items = sfu.parseRequest(request); 
	    	 //区分表单域  
	    	 for (int i = 0; i < items.size(); i++) {  
	                FileItem item = items.get(i);  
	              //isFormField为true，表示这不是文件上传表单域  
	                if(!item.isFormField()){  
	                    ServletContext sctx = getServletContext();  
	                    //获得存放文件的物理路径  
	                    //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹  
	                    String path = sctx.getRealPath("/img");  
	                    System.out.println(path); 
	                    //获得文件名  
	                    String fileName = item.getName();  
	                    System.out.println(fileName);  
	                  //该方法在某些平台(操作系统),会返回路径+文件名  
	                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
	                    File file = new File(path+"\\"+fileName);  
	                    HttpSession session = request.getSession();
	                    String newImage = "/neusoft/img/"+fileName;
                        au.setAuctionPic(newImage);
                        au.setAuctionPicType("jpg");
                        boolean isFlag = as.addAuction(au);
	                    if(!file.exists()){  
	                        item.write(file);  
	                        System.out.println(fileName);  	                       
	                    }
	                    if(isFlag){
                      	  response.sendRedirect("/neusoft/index.html");  
                        }
	                    else{
	                    	response.sendRedirect("/neusoft/error3.jsp");  
	                    }
	                }  
	            }  
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        } 
		
	}
	
}
