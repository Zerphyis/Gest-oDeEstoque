package com.zerpyhis.gestaoestoque.produtos;

import com.zerpyhis.gestaoestoque.dto.ProdutosDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Produtos")
@NoArgsConstructor
@Table(name = "Produtos")
@EqualsAndHashCode(of="id")
public class Produtos {
@Column(unique = true)
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
    private Long id;
    private Float valor;
    private Integer quantidadeProd;

    private String nome;

@Enumerated(EnumType.STRING)
    private TiposProdutos tiposProdutos;

    public Produtos(ProdutosDTO dados){
        this.id= dados.id();
        this.nome= dados.nome();
        this.valor= dados.valor();
        this.tiposProdutos=dados.tipoProdutos();
        this.quantidadeProd=dados.quantidadeProd();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeProd() {
        return quantidadeProd;
    }

    public void setQuantidadeProd(Integer quantidadeProd) {
        this.quantidadeProd = quantidadeProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TiposProdutos getTiposProdutos() {
        return tiposProdutos;
    }

    public void setTiposProdutos(TiposProdutos tiposProdutos) {
        this.tiposProdutos = tiposProdutos;
    }

    public void atualizarInformacoes(AtualizarProdutos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();

        }
        if (dados.quantidadeProd() != null) {
            this.quantidadeProd = dados.quantidadeProd();

        }
        if (dados.id() != null) {
            this.id = dados.id();

        }
        if (dados.tipoProdutos() != null) {
            this.tiposProdutos = dados.tipoProdutos();

        }

    }

}
