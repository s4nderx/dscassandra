package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.DepartmentDTO;
import com.s4nderx.dscassandra.model.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    List<DepartmentDTO> findAll();
    DepartmentDTO findById(UUID id);
}
