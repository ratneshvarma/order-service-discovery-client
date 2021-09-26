package com.ratnesh.orderservicediscoveryclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratnesh.orderservicediscoveryclient.dto.OrderDto;
import com.ratnesh.orderservicediscoveryclient.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders/{id}")
	public OrderDto getOrder(@PathVariable("id") Integer id) {
		return orderService.getOrder(id);
	}

	@GetMapping("/orders-via-feignclient/{id}")
	public OrderDto getOrderViaFeignClient(@PathVariable("id") Integer id) {
		return orderService.getOrderViaFeignClient(id);
	}

	
}
