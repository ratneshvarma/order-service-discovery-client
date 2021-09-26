package com.ratnesh.orderservicediscoveryclient.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ratnesh.orderservicediscoveryclient.dto.OrderDto;
import com.ratnesh.orderservicediscoveryclient.dto.OrderItemDto;

@Service
public class OrderService {
	@Autowired
	private RestTemplate restTemplate;
	
	// Using RestTemplate which LoadBalanced
	public OrderDto getOrder(Integer id) {
		OrderDto order = findtOrder(id);
		if (order!=null) {
			List<OrderItemDto> items = new ArrayList<>();
			for(String productCode:order.getProductCodes()) {
			OrderItemDto item =	restTemplate.getForObject("http://item-service-discovery-client/items/"+productCode, OrderItemDto.class);
			if (item!=null) {
				items.add(item);
			}
			}
			order.setItems(items);
			Double total = order.getItems().stream().mapToDouble(product -> product.getQuantity() * product.getUnitPrice())
					.sum();
			return new OrderDto(order.getId(), order.getCustomerName(), order.getShippingAddress(), items, total);
		}
		
		
		return null;
	}
	
	
	//Using FeignClient
	public OrderDto getOrderViaFeignClient(Integer id) {
		OrderDto order = findtOrder(id);
		if (order!=null) {
			List<OrderItemDto> items = new ArrayList<>();
			for(String productCode:order.getProductCodes()) {
			OrderItemDto item =	restTemplate.getForObject("http://item-service-discovery-client/items/"+productCode, OrderItemDto.class);
			if (item!=null) {
				items.add(item);
			}
			}
			order.setItems(items);
			Double total = order.getItems().stream().mapToDouble(product -> product.getQuantity() * product.getUnitPrice())
					.sum();
			return new OrderDto(order.getId(), order.getCustomerName(), order.getShippingAddress(), items, total);
		}
		
		
		return null;
	}
	
	
	public static List<OrderDto> findOrders(){
		List<OrderDto> orders = new ArrayList<>();
		//# order-1
		orders.add( new OrderDto(1, "customet1", "shipping address1", Arrays.asList("ITEM0001")));
		//# order-2
		orders.add( new OrderDto(2, "customet2", "shipping address2", Arrays.asList("ITEM0003", "ITEM0004")));
		//# order-3
		orders.add( new OrderDto(3, "customet3", "shipping address3", Arrays.asList("ITEM0001", "ITEM0002", "ITEM0003")));
		return orders;
	}
	
	public static OrderDto findtOrder(Integer id) {
		OrderDto order = null;
		try {
			order = findOrders().stream().filter(o -> o.getId().equals(id)).findAny().get();
		} catch (Exception e) {
			// Not found error
		}
		return order;
	}

}
