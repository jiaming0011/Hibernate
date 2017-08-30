package cn.service;

import cn.bean.AuctionUser;
import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;

public class UserService {
	UserDao ud = new UserDaoImpl();
 public AuctionUser checkUser(AuctionUser user){
	 
	 if(ud.findUser(user).size()>0){
		 return ud.findUser(user).get(0);
	 }
	 return null;
 }
 public void registerUser(AuctionUser user){
	 ud.addUser(user);
 }
}
