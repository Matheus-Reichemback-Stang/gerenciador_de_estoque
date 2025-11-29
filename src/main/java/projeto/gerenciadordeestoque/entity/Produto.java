package projeto.gerenciadordeestoque.entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Produto {

    private Long id;

    private String codigo;

    private String nome;

    private String marca;

    private String categoria;

    private Integer quantidade;

    private Double precoUnidade;

    private Double precoTotal;

    public Produto() {

    }

    public Produto(String codigo, String nome, String marca, String categoria, int quantidade, double precoUnidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.precoUnidade = precoUnidade;
        this.precoTotal = precoUnidade * quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(Double precoUnidade) {
        this.precoUnidade = precoUnidade;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoUnidade, Integer quantidade) {
        this.precoTotal = precoUnidade * quantidade;
    }

    public String getPrecoUnidadeFormatado() {
        NumberFormat nf =  NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(this.precoUnidade);
    }

    public String getPrecoTotalFormatado() {
        NumberFormat nf =  NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(this.precoTotal);
    }
}
