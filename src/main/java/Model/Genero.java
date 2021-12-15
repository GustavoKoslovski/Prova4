package Model;

import java.util.ArrayList;
import java.util.List;

public class Genero {

    private long idGenero;
    private String nomeGenero;
    private List<Livro> produtosCategoria = new ArrayList<Livro>();


    public Genero() {
    }

    public Genero(String nomeGenero, List<Livro> produtosCategoria) {
        this.nomeGenero = nomeGenero;
        this.produtosCategoria = produtosCategoria;
    }

    public Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(long idGenero) {
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idGenero +
                ", nomeCategoria='" + nomeGenero + '\'' +
                ", produtosCategoria=" + produtosCategoria +
                '}';
    }
}