package com.epam.ordering.api.dto;
/**
 * 
 * @author vikash
 *
 */
public class OrderRequest {

	private Integer quantity;
	private Integer productId;
	private String customerName;
	private String shippingAddress;

	public OrderRequest() {
		this.productId = 0;
		this.quantity=1;
	}

	public OrderRequest(Integer productId, String customerName, String shippingAddress, Integer quantity) {
		this.productId = productId;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.quantity=quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

}
