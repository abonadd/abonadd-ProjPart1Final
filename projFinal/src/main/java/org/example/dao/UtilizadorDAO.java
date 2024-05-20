package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.Utilizador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilizadorDAO {

    private Connection connection;

    public List<Utilizador> listar() {
        String sql = "SELECT * FROM utilizador";
        List<Utilizador> retorno = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Utilizador utilizador = new Utilizador();
                utilizador.setId(resultado.getInt("id"));
                utilizador.setNome(resultado.getString("nome"));
                utilizador.setEmail(resultado.getString("email"));
                utilizador.setPassword(resultado.getString("password"));
                utilizador.setTelefone(resultado.getString("telefone"));
                utilizador.setTipo(Utilizador.tipoUtilizador.valueOf(resultado.getString("tipo")));
                retorno.add(utilizador);
            }
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean inserir(Utilizador utilizador) {
        String sql = "INSERT INTO utilizador (nome, email, password, telefone, tipo) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilizador.getNome());
            stmt.setString(2, utilizador.getEmail());
            stmt.setString(3, utilizador.getPassword());
            stmt.setString(4, utilizador.getTelefone());
            stmt.setString(5, utilizador.getTipo().name());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean atualizar(Utilizador utilizador, Integer id) {
        String sql = "UPDATE utilizador SET nome = ?, email = ?, password = ?, telefone = ?, tipo = ? WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilizador.getNome());
            stmt.setString(2, utilizador.getEmail());
            stmt.setString(3, utilizador.getPassword());
            stmt.setString(4, utilizador.getTelefone());
            stmt.setString(5, utilizador.getTipo().name());
            stmt.setInt(6, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletar(Integer id) {
        String sql = "DELETE FROM utilizador WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
