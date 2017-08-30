package cn.dao;

import java.util.List;

import cn.bean.Auction;

public interface AuctionDao {
	public List<Auction> findAuctionByPage(int startIndex);
	public int allCount();
	public List<Auction> findAuctionByPage(int startIndex,Auction auction);
	public Long allCount(Auction auction);
	/*
	 * 添加商品
	 */
	public boolean addAuction(Auction a);
	/**
	 * 查找出商品
	 */
	public Auction FindByid(int id);
	/**
	 * 更新商品
	 */
	public boolean updateAuction(Auction a);
	/**
	 * 删除商品
	 */
	public boolean delAuction(int id);
}
