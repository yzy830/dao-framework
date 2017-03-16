package com.jhqc.pxsj.test.oldpojos;

public class CreateOrderMerchandisePO {
	private String orderNo;

	private Long  shopId;

	private Long merchandiseId;

	private Long skuId;

	private String merchandiseName;

	private String merchandisePrice;

	private int orderMerchandiseQty;

	private String skuPhoto;

	private String skuDetail;
	
	public Long getMerchandiseId() {
		return merchandiseId;
	}
	public void setMerchandiseId(Long merchandiseId) {
		this.merchandiseId = merchandiseId;
	}
	public Long getSkuId() {
		return skuId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public String getMerchandiseName() {
		return merchandiseName;
	}
	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}
	public String getMerchandisePrice() {
		return merchandisePrice;
	}
	public void setMerchandisePrice(String merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}
	public int getOrderMerchandiseQty() {
		return orderMerchandiseQty;
	}
	public void setOrderMerchandiseQty(int orderMerchandiseQty) {
		this.orderMerchandiseQty = orderMerchandiseQty;
	}
	public String getSkuPhoto() {
		return skuPhoto;
	}
	public void setSkuPhoto(String skuPhoto) {
		this.skuPhoto = skuPhoto;
	}
	public String getSkuDetail() {
		return skuDetail;
	}
	public void setSkuDetail(String skuDetail) {
		this.skuDetail = skuDetail;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	
	
}
