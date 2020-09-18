package com.example.submissionformtodb;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customers, Integer> {
}
