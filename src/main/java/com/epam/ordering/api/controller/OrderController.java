package com.epam.ordering.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.ordering.api.Constants;
import com.epam.ordering.api.dto.OrderRequest;
import com.epam.ordering.api.dto.Response;
import com.epam.ordering.api.dto.Result;
import com.epam.ordering.api.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Order")
@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@ApiOperation("Add Order details")
	@PostMapping(value = "/addDetails", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<?> addOrderDetails(
			@RequestBody @ApiParam(required = true, value = "Order to be add") OrderRequest orderRequest) {

		if (orderRequest != null) {
			Response<?> response = orderService.addOrderDetails(orderRequest);
			return new ResponseEntity<>(response.getResult(), response.getStatus());
		} else {
			log.error(Constants.INVALID_INPUT);
			return new ResponseEntity<>(new Result(Constants.INVALID_INPUT), HttpStatus.BAD_REQUEST);
		}
	}
	
}
