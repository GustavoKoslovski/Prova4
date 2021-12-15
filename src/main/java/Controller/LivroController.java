package Controller;

import DAO.LivroDAO;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro) {
        livroDAO.cadastrarLivro(livro);
    }
    public List<Livro> listarLivros() {
        return livroDAO.listarLivros();
    }
    public List<Livro> listarProdutosPorGenero(Long idCategoria) {
        return livroDAO.listarLivrosPorGenero(idCategoria);
    }
    public List<Livro> listarLivroPorBiblioteca(Long idBiblioteca) {
        return livroDAO.listarLivrosPorBiblioteca(idBiblioteca);
    }
    public Livro selecionarProduto(long idProduto) {
        return livroDAO.selecionarLivro(idProduto);
    }
}