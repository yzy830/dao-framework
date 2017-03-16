package com.jhqc.pxsj.test.oldpojos;

public class CreateOrderAddrPO {

	private String orderNo;

	private String provinceId;//省

	private String provName;//省

	private String cityId;//市

	private String cityName;//市

	private String countyId;//区、县

	private String countyName;//区、县

	private String deliveryAddr;//详细收货地址

	private String recverName;//收货人

	private String recverTel;//联系电话

	private String zipcode;//邮政编码
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyId() {
		return countyId;
	}
	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getRecverName() {
		return recverName;
	}
	public void setRecverName(String recverName) {
		this.recverName = recverName;
	}
	public String getRecverTel() {
		return recverTel;
	}
	public void setRecverTel(String recverTel) {
		this.recverTel = recverTel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
