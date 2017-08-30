package cn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import cn.bean.AuctionUser;
import cn.dao.UserDao;
import cn.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	HibernateUtil hu = null;
	Session session = null;
	@Override
	public List<AuctionUser> findUser(AuctionUser user) {
		List<AuctionUser> list = null;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tran = session.beginTransaction();
		try {
			System.out.println(user.getUserName());
			 Criteria criteria = session.createCriteria(AuctionUser.class);
			 criteria.add(Example.create(user));
			 list = criteria.list();
			
			 tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	
		
	}

	@Override
	public List<AuctionUser> findAllUser() {
		
		return null;
	}

	@Override
	public AuctionUser getUser(int id) {
		AuctionUser au = null;
		hu = new HibernateUtil();
		session = hu.getSession();
		Transaction tx=session.beginTransaction();
		try {
			 au = (AuctionUser)session.get(AuctionUser.class,id);
			 
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return au;
	}

	@Override
	public void addUser(AuctionUser user) {
		session = hu.getSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(user);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}finally{
			session.close();
		}
		
	}

}
