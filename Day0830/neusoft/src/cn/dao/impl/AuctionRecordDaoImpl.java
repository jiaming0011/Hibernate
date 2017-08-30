package cn.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.bean.AuctionRecord;
import cn.dao.AuctionRecordDao;
import cn.util.HibernateUtil;

public class AuctionRecordDaoImpl implements AuctionRecordDao {

	HibernateUtil hu = null;
	Session session = null;
	@Override
	public boolean saveAuctionRecord(AuctionRecord record) {
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(record);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

}
