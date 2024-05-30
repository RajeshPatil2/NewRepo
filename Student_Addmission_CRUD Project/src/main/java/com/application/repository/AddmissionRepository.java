package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Addmission;

@Repository
public interface AddmissionRepository extends CrudRepository<Addmission, Long> {

}
