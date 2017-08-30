package cn.dao;

import java.util.List;

import cn.bean.AuctionUser;

public interface UserDao {
	public List<AuctionUser> findUser(AuctionUser user);//带条件查询
	public List<AuctionUser> findAllUser();//查找所有
	public AuctionUser getUser(int id);//根据id查找
	public void addUser(AuctionUser user);//添加用户
}
