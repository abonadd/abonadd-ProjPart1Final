package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    private Connection connection;
// listar admin
    public List<Admin> listar() {
        String sql = "SELECT * FROM admin";
        List<Admin> retorno = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Admin admin = new Admin();
                admin.setId(resultado.getInt("id"));
                admin.setNome(resultado.getString("nome"));
                admin.setPassword(resultado.getString("password"));
                retorno.add(admin);
            }
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//inserir admin
    public boolean inserir(Admin admin) {
        String sql = "INSERT INTO admin (nome, password) VALUES (?, ?)";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getPassword());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//atualizar
    public boolean atualizar(Admin admin, Integer id) {
        String sql = "UPDATE admin SET nome = ?, password = ? WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getPassword());
            stmt.setInt(3, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//remover pelo id
    public boolean deletar(Integer id) {
        String sql = "DELETE FROM admin WHERE id = ?";
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

