package Controller;
import DAO.GeneroDAO;
import Model.Genero;
import java.util.List;

public class GeneroController {

    GeneroDAO generoDAO = new GeneroDAO();

    public void cadastrarGenero(Genero genero) {
        generoDAO.cadastrarGenero(genero);
    }
    public List<Genero> listarGeneros() {
        return generoDAO.listarGeneros();
    }

    public Genero selecionarGenero(long idGenero) {
        return generoDAO.selecionarGenero(idGenero);
    }
    public void editarGenero(Genero genero) {
        generoDAO.editarGenero(genero);
    }
}