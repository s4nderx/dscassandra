package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.DepartmentDTO;
import com.s4nderx.dscassandra.model.entities.Department;
import com.s4nderx.dscassandra.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
