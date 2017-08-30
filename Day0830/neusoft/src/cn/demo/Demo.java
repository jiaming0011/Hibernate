package cn.demo;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bean.Auction;
import cn.bean.AuctionRecord;
import cn.bean.AuctionUser;
import cn.util.HibernateUtil;

public class Demo {
	HibernateUtil hu = null;
	Session session = null;
	@Test
	public void test01(){
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 AuctionUser user = new AuctionUser(1,"ÕÅÈý","123","123","123","123","123",123,"123","123");
			 session.save(user);
			 tx.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		

	}
	@Test
	public void test02(){
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 Auction a = new Auction(1,"1",1,1,"1995-06-19","1995-06-20","1","1","1");
			 session.save(a);
			 tx.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	@Test
	public void test03(){
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 AuctionUser au = (AuctionUser)session.get(AuctionUser.class,1);
			 Auction a=(Auction)session.get(Auction.class,1);
			 AuctionRecord ar = new AuctionRecord(8,au,a,"1995-06-19",200);
			 session.save(ar);
			 tx.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	@Test
	public void test04(){
		hu = new HibernateUtil();
		session = hu.getSession();
		List<AuctionUser> list = null;
		Transaction tx=session.beginTransaction();
		try {
			 Criteria criteria = session.createCriteria(AuctionUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	@Test
	public void test05(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String abc = df.format(new Date());
		System.out.println(abc);
	}
}
