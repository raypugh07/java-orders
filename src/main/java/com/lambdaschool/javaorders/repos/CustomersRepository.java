package com.lambdaschool.javaorders.repos;

import com.lambdaschool.javaorders.model.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers,Long> {
}
