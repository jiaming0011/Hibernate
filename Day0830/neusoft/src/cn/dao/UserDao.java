package cn.dao;

import java.util.List;

import cn.bean.AuctionUser;

public interface UserDao {
	public List<AuctionUser> findUser(AuctionUser user);//��������ѯ
	public List<AuctionUser> findAllUser();//��������
	public AuctionUser getUser(int id);//����id����
	public void addUser(AuctionUser user);//����û�
}
