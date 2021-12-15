package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;

public class BibliotecaController {

    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    public List<Biblioteca> listarBibliotecas() {
        return bibliotecaDAO.listarBiblioteca();
    }
    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }

}
