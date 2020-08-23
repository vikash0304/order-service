package com.epam.ordering.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.ordering.api.dto.OrderItemDto;
import feign.Headers;

/**
 * FeignClient to fetch RestApi to call Rest-API will send request and response
 * 
 * @author vikash
 *
 */
@FeignClient(name = "order-item-service", configuration = AppClientConfig.class)
@Headers("Content-Type: application/json")
public interface OrderItemClient {

	@RequestMapping(method = RequestMethod.GET, path = "${order.item.url.get}")
	public ResponseEntity<OrderItemDto> getActionableDsl(@PathVariable("itemId") int itemId);
}
