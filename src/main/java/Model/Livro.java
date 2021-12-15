package Model;

public class Livro {

    private long idLivro;
    private String nomeLivro;
    private long idGenero;
    private long idBiblioteca;

    public Livro() {
    }

    public Livro(long idLivro, String nomeLivro, long idGenero, long idBiblioteca) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.idGenero = idGenero;
        this.idBiblioteca = idBiblioteca;
    }

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(long idGenero) {
        this.idGenero = idGenero;
    }

    public long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idProduto=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", idGenero=" + idGenero +
                ", idBiblioteca=" + idBiblioteca +
                '}';
    }
}
