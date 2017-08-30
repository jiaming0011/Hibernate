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
		//�Ȼ�ȡ��Ʒ����
		Auction auction = ad.FindByid(record.getAuctionId().getAuctionId());
		//1.��Ʒ���ܹ���
		if(record.getAuctionTime().compareTo(auction.getAuctionEndTime())>=0){
			throw new Exception("��Ʒ��ͣ��");
		}
		if(auction.getRecord1().size()>0){//����Ѿ������Ĺ����۸����������о��ļ۵���߼�
			AuctionRecord maxRecord =(AuctionRecord)auction.getRecord1().toArray()[0];
			if(record.getAuctionPrice()<=maxRecord.getAuctionPrice()){
				throw new Exception("�۸����������о��ļ۵���߼�");
			}
		}else{//û�˾��Ĺ�
			if(record.getAuctionPrice()<=auction.getAuctionStartPrice()){
				throw new Exception("�۸����������ļ�");
			}
		}
		ard.saveAuctionRecord(record);
	}
}
