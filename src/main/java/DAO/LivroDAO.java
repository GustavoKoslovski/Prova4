package DAO;

import Factory.ConnectionFactory;
import Model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection;

    public LivroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaLivros() {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "idLivro INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeLivro VARCHAR(50)," +
                "idGenero INT NOT NULL," +
                    "CONSTRAINT fk_idGenero FOREIGN KEY (idGenero)" +
                    "REFERENCES generos(idGenero)" +
                    "ON DELETE CASCADE," +
                "idBiblioteca INT NOT NULL," +
                    "CONSTRAINT fk_idBiblioteca FOREIGN KEY (idBiblioteca)" +
                    "REFERENCES bibliotecas(idBiblioteca)" +
                    "ON DELETE CASCADE " +
                ");";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("\nVoce precisa cadastrar um genero\n");
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros(nomeLivro,idGenero,idBiblioteca) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setLong(2, livro.getIdGenero());
            preparedStatement.setLong(3, livro.getIdBiblioteca());

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                livro.setIdLivro(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public Livro selecionarLivro(Long idLivro) {
        String sql = "SELECT * FROM livros WHERE idLivro = ?";
        Livro livro = new Livro();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idLivro);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livro;
    }


    public List<Livro> listarLivrosPorGenero(Long idGenero){
        String sql = "SELECT livros.nomeLivro, generos.idGenero " +
                "FROM livros " +
                "INNER JOIN generos " +
                "ON livros.idGenero = generos.idGenero " +
                "WHERE generos.idGenero = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            GeneroDAO generoDAO = new GeneroDAO();
            preparedStatement.setLong(1, idGenero);
            generoDAO.selecionarGenero(idGenero);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Livro> listarLivrosPorGenero = new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setNomeLivro(resultSet.getString("nomeLivro"));
                livro.setIdGenero(resultSet.getInt("idGenero"));

                listarLivrosPorGenero.add(livro);
            }
            return listarLivrosPorGenero;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Livro> listarLivros() {
        String sql = "SELECT * FROM livros";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Livro> livros = new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(resultSet.getInt("idLivro"));
                livro.setNomeLivro(resultSet.getString("nomeLivro"));

                livros.add(livro);
            }
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}