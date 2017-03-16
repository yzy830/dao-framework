package com.jhqc.pxsj.test.oldpojos;

import java.sql.Date;

import com.jhqc.pxsj.test.domain.Status;

public class OrderQueryRequestPO {

	private String appId;

	private Long shopId;

	private Long userId;

	private String orderNo;

	private Date startDate;

	private Date endDate;

	private String nextNodeCode;

	private String orderType;

	private Status status;

	private Status orderStatus;

	private String orderBy;
	
	private Page page;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getNextNodeCode() {
		return nextNodeCode;
	}
	public void setNextNodeCode(String nextNodeCode) {
		this.nextNodeCode = nextNodeCode;
	}
	public Status getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
}
