package Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private long idBiblioteca;
    private String nomeBiblioteca;
    private List<Biblioteca> livrosBiblioteca = new ArrayList<Biblioteca>();

    public Biblioteca() {
    }

    public Biblioteca(long idBiblioteca, String nomeBiblioteca, List<Biblioteca> livrosBiblioteca) {
        this.idBiblioteca = idBiblioteca;
        this.nomeBiblioteca = nomeBiblioteca;
        this.livrosBiblioteca = livrosBiblioteca;
    }

    public long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public List<Biblioteca> getLivrosBiblioteca() {
        return livrosBiblioteca;
    }

    public void setLivrosBiblioteca(List<Biblioteca> livrosBiblioteca) {
        this.livrosBiblioteca = livrosBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", nomeBiblioteca='" + nomeBiblioteca + '\'' +
                ", livrosBiblioteca=" + livrosBiblioteca +
                '}';
    }
}
