package cn.service;

import cn.bean.Auction;
import cn.bean.AuctionRecord;
import cn.dao.AuctionDao;
import cn.dao.AuctionRecordDao;
import cn.dao.impl.AuctionDaoImpl;
import cn.dao.impl.AuctionRecordDaoImpl;

public class AuctionRecordService {
	AuctionRecordDao ard = new AuctionRecordDaoImpl();
	AuctionDao ad = new AuctionDaoImpl();
	public void createBid(AuctionRecord record) throws Exception{
		//先获取商品详情
		Auction auction = ad.FindByid(record.getAuctionId().getAuctionId());
		//1.商品不能过期
		if(record.getAuctionTime().compareTo(auction.getAuctionEndTime())>=0){
			throw new Exception("商品已停拍");
		}
		if(auction.getRecord1().size()>0){//如果已经有人拍过，价格必须高于所有竞拍价的最高价
			AuctionRecord maxRecord =(AuctionRecord)auction.getRecord1().toArray()[0];
			if(record.getAuctionPrice()<=maxRecord.getAuctionPrice()){
				throw new Exception("价格必须高于所有竞拍价的最高价");
			}
		}else{//没人竞拍过
			if(record.getAuctionPrice()<=auction.getAuctionStartPrice()){
				throw new Exception("价格必须高于起拍价");
			}
		}
		ard.saveAuctionRecord(record);
	}
}
