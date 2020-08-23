package com.epam.ordering.api.dto;
/**
 * 
 * @author vikash
 *
 */
public class OrderRequest {

	private Integer productId;
	private String customerName;
	private String shippingAddress;

	public OrderRequest() {
		this.productId = 0;
	}

	public OrderRequest(Integer productId, String customerName, String shippingAddress) {
		this.productId = productId;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
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
