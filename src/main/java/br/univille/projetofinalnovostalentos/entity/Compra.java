package br.univille.projetofinalnovostalentos.entity;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEntrada;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "compra_id")
    private List<ItemCompra> colItens = 
        new ArrayList<>();
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public List<ItemCompra> getColItens() {
        return colItens;
    }
    public void setColItens(List<ItemCompra> colItens) {
        this.colItens = colItens;
    }
}