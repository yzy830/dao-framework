package com.jhqc.pxsj.test.oldpojos;

import java.io.Serializable;
import java.util.Date;

import com.jhqc.pxsj.domain.annotation.Source;
import com.jhqc.pxsj.test.domain.OrderBase;
import com.jhqc.pxsj.test.domain.OrderDelivery;
import com.jhqc.pxsj.test.domain.OrderMonitor;
import com.jhqc.pxsj.test.domain.OrderPay;
import com.jhqc.pxsj.test.domain.OrderPayType;

@Source(domain = OrderBase.class, alias = "orderBase")
public class UserOrderDetailPO implements Serializable{
    
	private static final long serialVersionUID = 1175839216803017091L;

	private Integer  orderType;

	private String orderNo;

	private String currentNodeCode;

    private String nextNodeCode;

	private Date createDate;

	private Date payTime;

	private Date receiveTime;

	private Integer  orderSum;

	private Integer  orderAmt;

	private String payName;

	public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Source(domain = OrderPay.class, alias = "orderPay")
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Source(domain = OrderDelivery.class, alias = "orderDelivery")
    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
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

    @Source(domain = OrderPayType.class, alias = "payType")
    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }
}
