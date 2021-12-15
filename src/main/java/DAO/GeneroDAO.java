package DAO;

import Factory.ConnectionFactory;
import Model.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private Connection connection;

    public GeneroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaGenero() {
        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "idGenero INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeGenero VARCHAR(50)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cadastrarGenero(Genero genero) {
        String sql = "INSERT INTO generos (nomeGenero) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                genero.setIdGenero(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarGenero(Genero genero) {
        String sql = "UPDATE generos SET nomeGenero = ? WHERE idGenero = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setLong(2, genero.getIdGenero());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\n Genero editado ID: " + genero.getIdGenero() +
                    " | Nome do produto: " + genero.getNomeGenero());
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Genero selecionarGenero(Long idGenero) {
        String sql = "SELECT * FROM generos WHERE idGenero = ?";
        Genero genero = new Genero();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idGenero);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genero;
    }


    public List<Genero> listarGeneros() {
        String sql = "SELECT * FROM generos";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Genero> generos = new ArrayList<>();

            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));
                generos.add(genero);
            }
            return generos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

