package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.ProductDTO;

import java.util.UUID;

public interface ProductService {

    ProductDTO findById(UUID id);

}
