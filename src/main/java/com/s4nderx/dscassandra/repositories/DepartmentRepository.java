package com.s4nderx.dscassandra.repositories;

import com.s4nderx.dscassandra.model.entities.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
