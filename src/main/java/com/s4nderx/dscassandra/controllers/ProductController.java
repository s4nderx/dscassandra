package com.s4nderx.dscassandra.controllers;

import com.s4nderx.dscassandra.model.dto.ProductDTO;
import com.s4nderx.dscassandra.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID uuid) {
        ProductDTO dto = this.service.findById(uuid);
        return ResponseEntity.ok(dto);
    }

}
