package com.jhqc.pxsj.test.oldpojos;

import java.util.Date;

import com.jhqc.pxsj.domain.annotation.Ignored;
import com.jhqc.pxsj.domain.annotation.Source;
import com.jhqc.pxsj.test.domain.OrderBase;
import com.jhqc.pxsj.test.domain.OrderMonitor;
import com.jhqc.pxsj.test.domain.Status;

@Source(domain = OrderBase.class, alias = "orderBase")
public class OrderBasePO{
	private Long orderId;
	
	private String orderNo;

	private String transactionCode;

	private String templateCode;

	private Integer  orderType;

	private Long  shopId;

	private Long  userId;

	private Integer  orderSum;

	private Integer  orderAmt;

	private Integer  deliveryFee;

	private Integer merchandiseQuantity;

	private String createDate;

	private Status status;

	private Status orderStatus;

	private String currentNodeCode;

    private String nextNodeCode;

	private boolean isOrderMaintain;

	private String endDate;

	private String userRemake;

	private String linkTel;

	private Date maintainDate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer odrerType) {
        this.orderType = odrerType;
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

    public Integer getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Integer orderSum) {
        this.orderSum = orderSum;
    }

    public Integer getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(Integer orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getMerchandiseQuantity() {
        return merchandiseQuantity;
    }

    public void setMerchandiseQuantity(Integer merchandiseQuantity) {
        this.merchandiseQuantity = merchandiseQuantity;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Status getUserStatus() {
        return status;
    }

    public void setUserStatus(Status status) {
        this.status = status;
    }

    public Status getShopStatus() {
        return orderStatus;
    }

    public void setShopStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Source(domain = OrderMonitor.class, alias = "orderMonitor")
    public String getCurrentNodeCode() {
        return currentNodeCode;
    }

    public void setCurrentNodeCode(String currentNodeCode) {
        this.currentNodeCode = currentNodeCode;
    }

    @Source(domain = OrderMonitor.class, alias = "orderMonitor")
    public String getNextNodeCode() {
        return nextNodeCode;
    }

    public void setNextNodeCode(String nextNodeCode) {
        this.nextNodeCode = nextNodeCode;
    }

    @Ignored
    public boolean isOrderMaintain() {
        return isOrderMaintain;
    }

    public void setOrderMaintain(boolean isOrderMaintain) {
        this.isOrderMaintain = isOrderMaintain;
    }

    @Source(domain = OrderMonitor.class, alias = "orderMonitor")
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

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

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }
}
