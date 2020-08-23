package com.epam.ordering.api.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.ordering.api.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	
}
