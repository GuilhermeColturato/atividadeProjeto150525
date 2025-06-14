package org.example.repository;

import org.example.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
