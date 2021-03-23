package com.s4nderx.dscassandra.services;

import com.s4nderx.dscassandra.model.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentDTO> findAll();
}
