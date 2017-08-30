package cn.bean;

import java.util.HashSet;
import java.util.Set;

public class AuctionUser {
	private int  userId  ;
	private String userName ;
	private String  userPassword;
	private String userCardNo ;
	private String userTel  ;
	private String userAddress ;
	private String userPostNumber ;
	private int userIsadmin;
	private String userQuestion;
	private String userAnswer;
	private Set record2=new HashSet();
	
	
	
	
	public AuctionUser(int userId, String userName, String userPassword,
			String userCardNo, String userTel, String userAddress,
			String userPostNumber, int userIsadmin, String userQuestion,
			String userAnswer, Set record2) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCardNo = userCardNo;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userPostNumber = userPostNumber;
		this.userIsadmin = userIsadmin;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
		this.record2 = record2;
	}
	public Set getRecord2() {
		return record2;
	}
	public void setRecord2(Set record2) {
		this.record2 = record2;
	}
	public AuctionUser(String userName, String userPassword, String userCardNo,
			String userTel, String userAddress, String userPostNumber,
			int userIsadmin, String userQuestion, String userAnswer) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCardNo = userCardNo;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userPostNumber = userPostNumber;
		this.userIsadmin = userIsadmin;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}
	public AuctionUser(int userId, String userName, String userPassword,
			String userCardNo, String userTel, String userAddress,
			String userPostNumber, int userIsadmin, String userQuestion,
			String userAnswer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCardNo = userCardNo;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userPostNumber = userPostNumber;
		this.userIsadmin = userIsadmin;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}
	public AuctionUser() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserCardNo() {
		return userCardNo;
	}
	public void setUserCardNo(String userCardNo) {
		this.userCardNo = userCardNo;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPostNumber() {
		return userPostNumber;
	}
	public void setUserPostNumber(String userPostNumber) {
		this.userPostNumber = userPostNumber;
	}
	public int getUserIsadmin() {
		return userIsadmin;
	}
	public void setUserIsadmin(int userIsadmin) {
		this.userIsadmin = userIsadmin;
	}
	public String getUserQuestion() {
		return userQuestion;
	}
	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	
}
