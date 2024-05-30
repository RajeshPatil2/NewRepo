package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.model.Result;

@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {

}
