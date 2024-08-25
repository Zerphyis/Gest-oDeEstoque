package com.zerpyhis.gestaoestoque.dto;

import com.zerpyhis.gestaoestoque.produtos.Produtos;
import com.zerpyhis.gestaoestoque.produtos.TiposProdutos;

public record ProdutosDTO(Long id, String nome, Float valor, TiposProdutos tipoProdutos, Integer quantidadeProd) {
    public ProdutosDTO(Produtos produtos) {
      this(produtos.getId(), produtos.getNome(), produtos.getValor(), produtos.getTiposProdutos(), produtos.getQuantidadeProd());
  }


}
