package cn.bean;

import java.util.HashSet;
import java.util.Set;

public class Auction {
	private int auctionId;
	private String  auctionName;
	private double auctionStartPrice;//起拍价
	private double auctionUpset ;//底价
	private String auctionStartTime ;//开始时间
	private String auctionEndTime  ;//结束时间
	private String auctionPic ;//商品图片路径
	private String auctionPicType;//商品的图片类型 jpg,png,gif
	private String auctionDesc ;//商品的描述
	private Set record1=new HashSet(0);
	
	
	public Auction(int auctionId, String auctionName, double auctionStartPrice,
			double auctionUpset, String auctionStartTime,
			String auctionEndTime, String auctionPic, String auctionPicType,
			String auctionDesc, Set record1) {
		super();
		this.auctionId = auctionId;
		this.auctionName = auctionName;
		this.auctionStartPrice = auctionStartPrice;
		this.auctionUpset = auctionUpset;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndTime = auctionEndTime;
		this.auctionPic = auctionPic;
		this.auctionPicType = auctionPicType;
		this.auctionDesc = auctionDesc;
		this.record1 = record1;
	}
	
	public Auction(int auctionId, String auctionName, double auctionStartPrice,
			double auctionUpset, String auctionStartTime,
			String auctionEndTime, String auctionPic, String auctionPicType,
			String auctionDesc) {
		super();
		this.auctionId = auctionId;
		this.auctionName = auctionName;
		this.auctionStartPrice = auctionStartPrice;
		this.auctionUpset = auctionUpset;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndTime = auctionEndTime;
		this.auctionPic = auctionPic;
		this.auctionPicType = auctionPicType;
		this.auctionDesc = auctionDesc;
	}
	public Auction() {
		super();
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public double getAuctionStartPrice() {
		return auctionStartPrice;
	}
	public void setAuctionStartPrice(double auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}
	public double getAuctionUpset() {
		return auctionUpset;
	}
	public void setAuctionUpset(double auctionUpset) {
		this.auctionUpset = auctionUpset;
	}
	public String getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(String auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public String getAuctionEndTime() {
		return auctionEndTime;
	}
	public void setAuctionEndTime(String auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	public String getAuctionPic() {
		return auctionPic;
	}
	public void setAuctionPic(String auctionPic) {
		this.auctionPic = auctionPic;
	}
	public String getAuctionPicType() {
		return auctionPicType;
	}
	public void setAuctionPicType(String auctionPicType) {
		this.auctionPicType = auctionPicType;
	}
	public String getAuctionDesc() {
		return auctionDesc;
	}
	public void setAuctionDesc(String auctionDesc) {
		this.auctionDesc = auctionDesc;
	}

	public Set getRecord1() {
		return record1;
	}

	public void setRecord1(Set record1) {
		this.record1 = record1;
	}
	
	
}
