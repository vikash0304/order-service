package com.epam.ordering.api.dto;

public class OrderItemDto {

	private String productCode;
	private String productName;
	private double price;
	private Integer Quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderItemDto [productCode=" + productCode + ", productName=" + productName + ", Quantity=" + Quantity
				+ "]";
	}
	
}
