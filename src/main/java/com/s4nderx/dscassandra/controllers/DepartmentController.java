package com.s4nderx.dscassandra.controllers;

import com.s4nderx.dscassandra.model.dto.DepartmentDTO;
import com.s4nderx.dscassandra.model.entities.Department;
import com.s4nderx.dscassandra.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> list = this.service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable UUID uuid) {
        DepartmentDTO dto = this.service.findById(uuid);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
