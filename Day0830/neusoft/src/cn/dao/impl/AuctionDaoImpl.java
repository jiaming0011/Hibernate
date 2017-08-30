package cn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cn.bean.Auction;
import cn.dao.AuctionDao;
import cn.util.HibernateUtil;

public class AuctionDaoImpl implements AuctionDao {

	HibernateUtil hu = null;
	Session session = null;
	@Override
	public List<Auction> findAuctionByPage(int startIndex) {
		List<Auction> list = null;
		hu = new HibernateUtil();
		session = hu.getSession();
		Query query=session.createQuery("from Auction auction order by auction.auctionId");
		query.setFirstResult(startIndex-1);
		query.setMaxResults(6);
		list = query.list();
		session.close();
		return list;
	}

	@Override
	public int allCount() {
		int count = 0;
		hu = new HibernateUtil();
		session = hu.getSession();
		String hql = "select count(*)  from Auction";

		 try {

		Query query = session.createQuery(hql);
	    count = ((Long) query.iterate().next()).intValue();

		} catch (Exception e) {

		e.printStackTrace();

		}finally{
			session.close();
		}
		 return count;
		
	}

	@Override
	public boolean addAuction(Auction a) {
		boolean isFlag = false;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 session.save(a);
			 tx.commit();
			 isFlag = true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		
		return isFlag;
	}

	@Override
	public Auction FindByid(int id) {
		Auction au = null;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 au = (Auction)session.get(Auction.class,id);
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return au;
		
	}

	@Override
	public boolean updateAuction(Auction a) {
		boolean isFlag = false;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 session.update(a);
			 tx.commit();
			 isFlag = true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		
		return isFlag;
		
	}

	@Override
	public boolean delAuction(int id) {
		Auction a = new Auction();
		boolean isFlag = false;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 a = (Auction)session.get(Auction.class,id);
			 session.delete(a);
			 tx.commit();
			 isFlag = true;
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return isFlag;
	}

	@Override
	public List<Auction> findAuctionByPage(int startIndex, Auction auction) {
		List<Auction> list = null;
		hu = new HibernateUtil();
		session = hu.getSession();
		Criteria criteria = session.createCriteria(Auction.class);
		if(auction!=null){
			if(auction.getAuctionName()!=null&& !"".equals(auction.getAuctionName())){
				criteria.add(Restrictions.like("auctionName", auction.getAuctionName(),MatchMode.ANYWHERE));
			}
			if(auction.getAuctionDesc()!=null&& !"".equals(auction.getAuctionDesc())){
				criteria.add(Restrictions.like("auctionDesc", auction.getAuctionDesc(),MatchMode.ANYWHERE));
			}
			if(auction.getAuctionStartTime()!=null&& !"".equals(auction.getAuctionStartTime())){
				criteria.add(Restrictions.ge("auctionStartTime", auction.getAuctionStartTime()));				
			}
			if(auction.getAuctionEndTime()!=null&& !"".equals(auction.getAuctionEndTime())){
				criteria.add(Restrictions.le("auctionEndTime",auction.getAuctionEndTime()));
			}
			if(auction.getAuctionStartPrice()!=0){
				criteria.add(Restrictions.ge("auctionStartPrice", auction.getAuctionStartPrice()));
			}
		}
		criteria.addOrder(Order.desc("auctionStartTime"));
		criteria.setFirstResult(startIndex-1);
		criteria.setMaxResults(6);
		list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public Long allCount(Auction auction) {
		long num = 0;
		hu = new HibernateUtil();
		session = hu.getSession();
		Criteria criteria = session.createCriteria(Auction.class);
		if(auction!=null){
			if(auction.getAuctionName()!=null&& !"".equals(auction.getAuctionName())){
				criteria.add(Restrictions.like("auctionName", auction.getAuctionName(),MatchMode.ANYWHERE));
			}
			if(auction.getAuctionDesc()!=null&& !"".equals(auction.getAuctionDesc())){
				criteria.add(Restrictions.like("auctionDesc", auction.getAuctionDesc(),MatchMode.ANYWHERE));
			}
			if(auction.getAuctionStartTime()!=null&& !"".equals(auction.getAuctionStartTime())){
				criteria.add(Restrictions.ge("auctionStartTime", auction.getAuctionStartTime()));				
			}
			if(auction.getAuctionEndTime()!=null&& !"".equals(auction.getAuctionEndTime())){
				criteria.add(Restrictions.le("auctionEndTime",auction.getAuctionEndTime()));
			}
			if(auction.getAuctionStartPrice()!=0){
				criteria.add(Restrictions.ge("auctionStartPrice", auction.getAuctionStartPrice()));
			}
		}
		criteria.setProjection(Projections.rowCount());
		num = (Long)criteria.uniqueResult();
		session.close();
		return num;
	}

}
