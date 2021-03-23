package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.DepartmentDTO;
import com.s4nderx.dscassandra.model.entities.Department;
import com.s4nderx.dscassandra.repositories.DepartmentRepository;
import com.s4nderx.dscassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> list = repository.findAll();
        return list.stream().map(DepartmentDTO::new).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO findById(UUID id) {
        Optional<Department> result = repository.findById(id);
        Department entity = result.orElseThrow(() -> new ResourceNotFoundException("Id nao encontrado: " + id));
        return new DepartmentDTO(entity);
    }

    @Override
    public DepartmentDTO insert(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DepartmentDTO(entity);
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }
}
