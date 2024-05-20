package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.QuartoSimples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartoSimplesDAO {

    private Connection connection;

    public List<QuartoSimples> listar() {
        String sql = "SELECT * FROM quarto_simples";
        List<QuartoSimples> retorno = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                QuartoSimples quarto = new QuartoSimples();
                quarto.setId(resultado.getInt("id"));
                quarto.setHote_id(resultado.getInt("hotel_id"));
                quarto.setTipo(resultado.getString("tipo"));
                quarto.setPreco_base(resultado.getString("preco_base"));
                quarto.setQuantidadeDeLeitos(resultado.getString("quantidade_de_leitos"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setReservado(resultado.getBoolean("reservado"));
                retorno.add(quarto);
            }
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean inserir(QuartoSimples quarto) {
        String sql = "INSERT INTO quarto_simples (hotel_id, tipo, preco_base, quantidade_de_leitos, descricao, reservado) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, quarto.getHote_id());
            stmt.setString(2, quarto.getTipo());
            stmt.setString(3, quarto.getPreco_base());
            stmt.setString(4, quarto.getQuantidadeDeLeitos());
            stmt.setString(5, quarto.getDescricao());
            stmt.setBoolean(6, quarto.isReservado());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean atualizar(QuartoSimples quarto, Integer id) {
        String sql = "UPDATE quarto_simples SET hotel_id = ?, tipo = ?, preco_base = ?, quantidade_de_leitos = ?, descricao = ?, reservado = ? WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, quarto.getHote_id());
            stmt.setString(2, quarto.getTipo());
            stmt.setString(3, quarto.getPreco_base());
            stmt.setString(4, quarto.getQuantidadeDeLeitos());
            stmt.setString(5, quarto.getDescricao());
            stmt.setBoolean(6, quarto.isReservado());
            stmt.setInt(7, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deletar(Integer id) {
        String sql = "DELETE FROM quarto_simples WHERE id = ?";
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
