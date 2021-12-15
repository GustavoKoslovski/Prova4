package DAO;
import Factory.ConnectionFactory;
import Model.Biblioteca;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private Connection connection;

    public BibliotecaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaBiblioteca() {
        String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeBiblioteca VARCHAR(50)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        String sql = "INSERT INTO bibliotecas (nomeBiblioteca) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Biblioteca selecionarBiblioteca(Long idBiblioteca) {
        String sql = "SELECT * FROM bibliotecas WHERE idBiblioteca = ?";
        Biblioteca biblioteca = new Biblioteca();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idBiblioteca);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biblioteca;
    }
    public List<Biblioteca> listarBiblioteca() {
        String sql = "SELECT * FROM bibliotecas";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Biblioteca> bibliotecas = new ArrayList<>();

            while (resultSet.next()) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));
                bibliotecas.add(biblioteca);
            }
            return bibliotecas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

