package com.zerpyhis.gestaoestoque.produtos;

public record AtualizarProdutos(Long id, String nome, Float valor, TiposProdutos tipoProdutos, Integer quantidadeProd) {
}
