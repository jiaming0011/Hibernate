package cn.bean;

import java.util.List;

public class Page {
	private int countSize=0;//总记录数
	private int pageSize=3;//每页大小
	private int numpage=1;//总页数
	private int startIndex=1;//开始下标
	private int lastIndex=5;//结束下标
	private boolean nextPage=false;//是否有下一页
	private boolean lastPage=false;//是否有上一页
	private int pageIndex=1;//当前页
	private List<Auction> list = null;//当前页的数据
	public int getCountSize() {
		return countSize;
	}
	public void setCountSize(int countSize) {
		this.countSize = countSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNumpage() {
		return numpage;
	}
	public void setNumpage(int numpage) {
		this.numpage = numpage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	public boolean isNextPage() {
		return nextPage;
	}
	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<Auction> getList() {
		return list;
	}
	public void setList(List<Auction> list) {
		this.list = list;
	}
	public Page(int countSize, int pageSize, int numpage, int startIndex,
			int lastIndex, boolean nextPage, boolean lastPage, int pageIndex,
			List<Auction> list) {
		super();
		this.countSize = countSize;
		this.pageSize = pageSize;
		this.numpage = numpage;
		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
		this.nextPage = nextPage;
		this.lastPage = lastPage;
		this.pageIndex = pageIndex;
		this.list = list;
	}
	public Page() {
		super();
	}
	public void initFp(){
		this.numpage = countSize%pageSize==0?countSize/pageSize:countSize/pageSize+1;
		this.startIndex = (pageIndex-1)*pageSize+1;
		this.lastIndex = pageIndex*pageSize;
		if(pageIndex>1){
			this.lastPage=true;
		}else{
			this.lastPage=false;
		}
		
		if(numpage>pageIndex){
			this.nextPage=true;
		}else{
			this.nextPage=false;
		}
	}
}
