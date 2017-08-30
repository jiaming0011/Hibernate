package cn.service;

import cn.bean.Auction;
import cn.dao.impl.AuctionDaoImpl;

public class AuctionService {
	AuctionDaoImpl adi = new AuctionDaoImpl();
	public boolean addAuction(Auction a){
		return adi.addAuction(a);
	}
	public Auction findAuction(int id){
		return adi.FindByid(id);
	}
	public boolean updateAuction(Auction a){
		return adi.updateAuction(a);
	}
	public boolean removeAuction(int id){
		return adi.delAuction(id);
	}
}
