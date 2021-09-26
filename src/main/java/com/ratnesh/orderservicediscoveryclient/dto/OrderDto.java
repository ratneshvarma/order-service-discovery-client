package com.ratnesh.orderservicediscoveryclient.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrderDto {
	private Integer id;
	@NotNull(message = "Customer name is mandatory")
	private String customerName;
	@NotNull(message = "ShippingAddress is mandatory")
	private String shippingAddress;
	private List<OrderItemDto> items;
	private Double total;
	@JsonIgnore
	private List<String> productCodes;
		
	public OrderDto() {
		super();
	}
	
	public OrderDto(Integer id, String customerName,
			String shippingAddress, List<String> productCodes) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.productCodes = productCodes;
	}

	public OrderDto(Integer id, String customerName,
			String shippingAddress, List<OrderItemDto> items,
			Double total) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.items = items;
		this.total = total;
	}

	public OrderDto(String customerName,
			String shippingAddress, Double total) {
		super();
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public List<OrderItemDto> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	public List<String> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(List<String> productCodes) {
		this.productCodes = productCodes;
	}
	
}
