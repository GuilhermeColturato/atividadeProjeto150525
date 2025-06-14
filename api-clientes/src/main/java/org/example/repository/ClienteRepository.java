package org.example.repository;

import org.example.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
