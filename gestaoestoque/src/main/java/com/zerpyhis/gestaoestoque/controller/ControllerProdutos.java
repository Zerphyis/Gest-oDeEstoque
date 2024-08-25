package com.zerpyhis.gestaoestoque.controller;


import com.zerpyhis.gestaoestoque.dto.ProdutosDTO;
import com.zerpyhis.gestaoestoque.produtos.AtualizarProdutos;
import com.zerpyhis.gestaoestoque.produtos.Produtos;
import com.zerpyhis.gestaoestoque.produtos.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProdutos {
    @Autowired
    private ProdutosRepository repository;
    @PostMapping
    public ResponseEntity<Produtos> criandoProdutos(@RequestBody ProdutosDTO dados){
        var produto=repository.save(new Produtos(dados));
        return  new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> buscarProdutos(){
        List<Produtos> produs = this.repository.findAll();
        return new ResponseEntity<>(produs, HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public void atualizarProdutos(@RequestBody AtualizarProdutos dados){
        var medico= repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
