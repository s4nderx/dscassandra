package com.s4nderx.dscassandra.repositories;

import com.s4nderx.dscassandra.model.entities.Product;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

    @AllowFiltering
    List<Product> findByDepartment(String department);
    
}
