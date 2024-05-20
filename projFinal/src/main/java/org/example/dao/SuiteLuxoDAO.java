package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.Hotel;
import org.example.model.SuiteLuxo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuiteLuxoDAO {

    private Connection connection;

    public List<SuiteLuxo> listar() {
        String sql = "SELECT * FROM suite_luxo";
        List<SuiteLuxo> retorno = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                SuiteLuxo suite = new SuiteLuxo();
                suite.setId(resultado.getInt("id"));
                suite.setHote_id(resultado.getInt("hotel_id"));
                suite.setTipo(resultado.getString("tipo"));
                suite.setPreco_base(resultado.getString("preco_base"));
                suite.setQuantidadeDeLeitos(resultado.getString("quantidade_de_leitos"));
                suite.setDescricao(resultado.getString("descricao"));
                suite.setReservado(resultado.getBoolean("reservado"));
                retorno.add(suite);
            }
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean inserir(SuiteLuxo suite) {
        String sql = "INSERT INTO suite_luxo (hotel_id, tipo, preco_base, quantidade_de_leitos, descricao, reservado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, suite.getHote_id());
            stmt.setString(2, suite.getTipo());
            stmt.setString(3, suite.getPreco_base());
            stmt.setString(4, suite.getQuantidadeDeLeitos());
            stmt.setString(5, suite.getDescricao());
            stmt.setBoolean(6, suite.isReservado());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean atualizar(SuiteLuxo suite, Integer id) {
        String sql = "UPDATE suite_luxo SET hotel_id = ?, tipo = ?, preco_base = ?, quantidade_de_leitos = ?, descricao = ?, reservado = ? WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, suite.getHote_id());
            stmt.setString(2, suite.getTipo());
            stmt.setString(3, suite.getPreco_base());
            stmt.setString(4, suite.getQuantidadeDeLeitos());
            stmt.setString(5, suite.getDescricao());
            stmt.setBoolean(6, suite.isReservado());
            stmt.setInt(7, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletar(Integer id) {
        String sql = "DELETE FROM suite_luxo WHERE id = ?";
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
