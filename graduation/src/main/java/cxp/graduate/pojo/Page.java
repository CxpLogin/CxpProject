package cxp.graduate.pojo;

import java.io.Serializable;

/**
 * @ClassName：Page
 * @Description: 分页实体类
 * @date: 2019-04-29
 */
public class Page implements Serializable{	
	private static final long serialVersionUID = 5997755033565978673L;
	private int pageNum;//当前页码
	private int totalCount;//总记录数
	private String indate;//根据时间查询
	private int did_sid;//根据时间查询
	private int limit;//查询几条数据
	private int start;//从第几条数据开始
	//select * from sensor where indate = '' and did_sid = '' limit (1 - 1) * 10,10;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getDid_sid() {
		return did_sid;
	}
	public void setDid_sid(int did_sid) {
		this.did_sid = did_sid;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", totalCount=" + totalCount + ", indate=" + indate + ", did_sid=" + did_sid
				+ ", limit=" + limit + ", start=" + start + "]";
	}
}
