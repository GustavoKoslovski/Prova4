package Controller;
import DAO.LivroDAO;
import DAO.BibliotecaDAO;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.List;

public class BibliotecaController {

    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    LivroDAO livroDAO = new LivroDAO();
    public List<Biblioteca> listarBibliotecas() {
        return bibliotecaDAO.listarBiblioteca();
    }

    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }

}
