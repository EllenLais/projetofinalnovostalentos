package br.univille.projetofinalnovostalentos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private float valorCompra;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Produto produto;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }    
    public float getValorFinal(){
        return this.getValorCompra() * this.getQuantidade();
    }
}