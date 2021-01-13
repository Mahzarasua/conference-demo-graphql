package com.pluralsight.repository;

import com.pluralsight.entity.Sessions;
import org.springframework.data.repository.CrudRepository;


public interface SessionRepository extends CrudRepository<Sessions, Long> {
}
