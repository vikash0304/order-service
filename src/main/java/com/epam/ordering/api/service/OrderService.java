package com.epam.ordering.api.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.ordering.api.Constants;
import com.epam.ordering.api.client.OrderItemClient;
import com.epam.ordering.api.dataaccess.OrderRepository;
import com.epam.ordering.api.dto.OrderItemDto;
import com.epam.ordering.api.dto.OrderRequest;
import com.epam.ordering.api.dto.Response;
import com.epam.ordering.api.dto.Result;
import com.epam.ordering.api.entity.Order;

/**
 * 
 * @author vikash
 *
 */
@Service
public class OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemClient orderItemClient;

	@Transactional
	public Response<?> addOrderDetails(OrderRequest orderRequest) {
		Response<?> response = null;
		int productId = orderRequest.getProductId();
		if (productId > 0) {
			
			try {
				ResponseEntity<OrderItemDto> orderItemDtoResponse = orderItemClient.getOrderItem(productId);
				if (orderItemDtoResponse.getStatusCode().equals(HttpStatus.OK)) {
					OrderItemDto orderItemDto = orderItemDtoResponse.getBody();
					Order order = new Order(orderRequest.getCustomerName(), LocalDateTime.now(),
							orderItemDto.getProductCode(), orderRequest.getShippingAddress(), orderRequest.getQuantity()*orderItemDto.getPrice());
					order = orderRepository.save(order);
					log.info("@@@  Item Saved Successfully, Order orderId: {}", order.getId());
					response = new Response<>(new Result(Constants.Success), HttpStatus.OK);

				} else {
					log.debug("@@@ Unable to fetch Item details., orderId: {}", orderItemDtoResponse.getBody());
					response = new Response<>(new Result(Constants.INVALID_PRODUCT), HttpStatus.BAD_REQUEST);
				}
			}catch(Exception e) {
				log.error("@@@ Unable to fetch Item details: {}", e.getMessage());
				response = new Response<>(new Result(Constants.INVALID_PRODUCT), HttpStatus.BAD_REQUEST);
			}
				
			} else {
				log.error("@@@ Invalid productId : {}", productId);
				response = new Response<>(new Result(Constants.INVALID_QUANTITY), HttpStatus.BAD_REQUEST);
			}
			
			
		return response;
	}

}
