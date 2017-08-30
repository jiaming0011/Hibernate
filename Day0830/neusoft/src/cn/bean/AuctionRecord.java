package cn.bean;

public class AuctionRecord {
	private int id;
	private AuctionUser userId;
	private Auction auctionId;
	private String auctionTime;
	private double auctionPrice;
	public AuctionRecord(int id, AuctionUser userId, Auction auctionId,
			String auctionTime, double auctionPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.auctionId = auctionId;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
	}
	public AuctionRecord() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AuctionUser getUserId() {
		return userId;
	}
	public void setUserId(AuctionUser userId) {
		this.userId = userId;
	}
	public Auction getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Auction auctionId) {
		this.auctionId = auctionId;
	}
	public String getAuctionTime() {
		return auctionTime;
	}
	public void setAuctionTime(String auctionTime) {
		this.auctionTime = auctionTime;
	}
	public double getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(double auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	
}
