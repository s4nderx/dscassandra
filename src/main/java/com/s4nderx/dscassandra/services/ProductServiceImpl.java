package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.ProductDTO;
import com.s4nderx.dscassandra.model.entities.Product;
import com.s4nderx.dscassandra.repositories.ProductRepository;
import com.s4nderx.dscassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDTO findById(UUID id) {
        Product entity = this.getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID uuid){
        Optional<Product> result = repository.findById(uuid);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id nao encontrado: " + uuid));
    }
}
