package com.epam.ordering.api.client;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import feign.codec.Encoder;

public class AppClientConfig {

	 public Encoder feignEncoder() {
		 	MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
	        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
	        return new SpringEncoder(objectFactory);
	}
}
