package org.example.repository;

import org.example.model.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
    Optional<Acesso> findByUsuarioAndSenha(String usuario, String senha);
}
