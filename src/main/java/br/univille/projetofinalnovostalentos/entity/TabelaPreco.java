package br.univille.projetofinalnovostalentos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TabelaPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float valCompra;
    private float precentual;
    
    public float getValCompra() {
        return valCompra;
    }
    public void setValCompra(float valCompra) {
        this.valCompra = valCompra;
    }
    public float getPrecentual() {
        return precentual;
    }
    public void setPrecentual(float precentual) {
        this.precentual = precentual;
    }
    public float getcalcValVenda(){
        return this.getValCompra() + this.getPrecentual();
    }
    public float getValorVenda(){
        return this.getValCompra() + this.getPrecentual();
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
