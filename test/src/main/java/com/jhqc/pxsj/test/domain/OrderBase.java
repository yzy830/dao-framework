package com.jhqc.pxsj.test.domain;

import java.util.Date;

import com.jhqc.pxsj.domain.annotation.Domain;
import com.jhqc.pxsj.domain.annotation.Id;
import com.jhqc.pxsj.domain.annotation.Now;
import com.jhqc.pxsj.domain.annotation.Property;

@Domain(table = "pxsj_soa.t_d_order_base")
public class OrderBase {
    private Long orderId;
    
    private String orderNo;
    
    private String transactionCode;
    
    private String appId;
    
    private String templateCode;
    
    private String orderType;
    
    private Long shopId;
    
    private Long userId;
    
    private Integer orderSum;
    
    private Integer orderAmt;
    
    private Integer deliveryFee;
    
    private Integer merchandiseQuantity;
    
    private Status shopStatus;
    
    private Date createDate;
    
    private Status userStatus;
    
    private Date maintainDate;
    
    private String maintainStatus;
    
    private String userRemake;
    
    private String linkTel;

    @Id
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

    @Property("appId")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    @Property("odrer_type")
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

    @Property("merchandise_qty_total")
    public Integer getMerchandiseQuantity() {
        return merchandiseQuantity;
    }

    public void setMerchandiseQuantity(Integer merchandiseQuantity) {
        this.merchandiseQuantity = merchandiseQuantity;
    }

    @Property("order_status")
    public Status getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Status shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Now
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date cretaeDate) {
        this.createDate = cretaeDate;
    }

    @Property("status")
    public Status getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Status userStatus) {
        this.userStatus = userStatus;
    }

    public Date getMaintainDate() {
        return maintainDate;
    }

    public void setMaintainDate(Date maintainDate) {
        this.maintainDate = maintainDate;
    }

    public String getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(String maintainStatus) {
        this.maintainStatus = maintainStatus;
    }

    public String getUserRemake() {
        return userRemake;
    }

    public void setUserRemake(String userRemark) {
        this.userRemake = userRemark;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }
}
