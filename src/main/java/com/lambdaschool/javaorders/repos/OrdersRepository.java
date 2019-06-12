package com.lambdaschool.javaorders.repos;

import com.lambdaschool.javaorders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
