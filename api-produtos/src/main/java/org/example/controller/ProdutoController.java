package org.example.controller;

import org.example.repository.ProdutoRepository;
import org.example.model.Produto;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private AuthService authService;

    @PostMapping("/adicionar")
    public Object adicionarProduto(@RequestHeader("usuario") String usuario,
                                   @RequestHeader("senha") String senha,
                                   @RequestBody Produto produto) {
        if (!authService.autenticar(usuario, senha)) {
            return "Acesso negado: login inválido.";
        }

        produto.setDataCadastro(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    @GetMapping("/listar")
    public Object listarProdutos(@RequestHeader("usuario") String usuario,
                                 @RequestHeader("senha") String senha) {
        if (!authService.autenticar(usuario, senha)) {
            return "Acesso negado: login inválido.";
        }

        return produtoRepository.findAll();
    }
}
