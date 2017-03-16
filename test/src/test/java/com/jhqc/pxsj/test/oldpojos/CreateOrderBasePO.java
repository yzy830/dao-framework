package com.jhqc.pxsj.test.oldpojos;

import java.math.BigDecimal;
import java.util.List;

public class CreateOrderBasePO {
	private String orderNo;

	private String transactionCode;

	private String templateCode;

	private Integer  odrerType;

	private Long  shopId;

	private Long  userId;

	private BigDecimal  orderSum;

	private BigDecimal  orderAmt;

	private BigDecimal  deliveryFee;

	private Integer merchandiseQtyTotal;

	private String userRemake;

	private String linkTel;

	private CreateOrderAddrPO orderAddr;

	private List<CreateOrderMerchandisePO> orderMerchandiseList;
	
	
	public String getUserRemake() {
		return userRemake;
	}
	public void setUserRemake(String userRemake) {
		this.userRemake = userRemake;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOdrerType() {
		return odrerType;
	}
	public void setOdrerType(Integer odrerType) {
		this.odrerType = odrerType;
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
	public BigDecimal getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(BigDecimal orderSum) {
		this.orderSum = orderSum;
	}
	public BigDecimal getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public Integer getMerchandiseQtyTotal() {
		return merchandiseQtyTotal;
	}
	public void setMerchandiseQtyTotal(Integer merchandiseQtyTotal) {
		this.merchandiseQtyTotal = merchandiseQtyTotal;
	}
	public CreateOrderAddrPO getOrderAddr() {
		return orderAddr;
	}
	public void setOrderAddr(CreateOrderAddrPO orderAddr) {
		this.orderAddr = orderAddr;
	}
	public List<CreateOrderMerchandisePO> getOrderMerchandiseList() {
		return orderMerchandiseList;
	}
	public void setOrderMerchandiseList(
			List<CreateOrderMerchandisePO> orderMerchandiseList) {
		this.orderMerchandiseList = orderMerchandiseList;
	}
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	
	
	
	
}
