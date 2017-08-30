package cn.dao;

import java.util.List;

import cn.bean.Auction;

public interface AuctionDao {
	public List<Auction> findAuctionByPage(int startIndex);
	public int allCount();
	public List<Auction> findAuctionByPage(int startIndex,Auction auction);
	public Long allCount(Auction auction);
	/*
	 * �����Ʒ
	 */
	public boolean addAuction(Auction a);
	/**
	 * ���ҳ���Ʒ
	 */
	public Auction FindByid(int id);
	/**
	 * ������Ʒ
	 */
	public boolean updateAuction(Auction a);
	/**
	 * ɾ����Ʒ
	 */
	public boolean delAuction(int id);
}
