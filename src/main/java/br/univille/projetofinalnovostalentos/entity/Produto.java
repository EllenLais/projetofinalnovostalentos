package br.univille.projetofinalnovostalentos.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3000)
    private String nome;
    @Column(length = 1000)
    private float quantidadeMin;
    @Column(length = 1000)
    private float quantidadeMax;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datadeCriacao;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Categoria categoria;
    @ManyToOne(cascade = {CascadeType.ALL})
    private TabelaPreco valVenda = new TabelaPreco();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getQuantidadeMin() {
        return quantidadeMin;
    }
    public void setQuantidadeMin(float quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }
    public float getQuantidadeMax() {
        return quantidadeMax;
    }
    public void setQuantidadeMax(float quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
    }
    public Date getDatadeCriacao() {
        return datadeCriacao;
    }
    public void setDatadeCriacao(Date datadeCriacao) {
        this.datadeCriacao = datadeCriacao;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public TabelaPreco getValVenda() {
        return valVenda;
    }
    public void setValVenda(TabelaPreco valVenda) {
        this.valVenda = valVenda;
    }
   
}
