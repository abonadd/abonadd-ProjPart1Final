package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private Connection connection;
//obter registo de reserva
    public List<Reserva> listar() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> reservas = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(resultado.getInt("id"));
                reserva.setCliente_id(resultado.getInt("cliente_id"));
                reserva.setAcomodacao_id(resultado.getInt("acomodacao_id"));
                reserva.setData_inicio(resultado.getString("data_inicio"));
                reserva.setData_fim(resultado.getString("data_fim"));
                reserva.setValor_total(resultado.getString("valor_total"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar reservas: " + e.getMessage());
        }
        return reservas;
    }
//inserir registro de reserva
    public boolean inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (cliente_id, acomodacao_id, data_inicio, data_fim, valor_total) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, reserva.getCliente_id());
            stmt.setInt(2, reserva.getAcomodacao_id());
            stmt.setString(3, reserva.getData_inicio());
            stmt.setString(4, reserva.getData_fim());
            stmt.setString(5, reserva.getValor_total());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir reserva: " + e.getMessage());
        }
    }
//atualiza registro de reserva
    public boolean atualizar(Reserva reserva, Integer id) {
        String sql = "UPDATE reserva SET cliente_id = ?, acomodacao_id = ?, data_inicio = ?, data_fim = ?, valor_total = ? WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, reserva.getCliente_id());
            stmt.setInt(2, reserva.getAcomodacao_id());
            stmt.setString(3, reserva.getData_inicio());
            stmt.setString(4, reserva.getData_fim());
            stmt.setString(5, reserva.getValor_total());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar reserva: " + e.getMessage());
        }
    }
//remover registo de reserva
    public boolean deletar(Integer id) {
        String sql = "DELETE FROM reserva WHERE id = ?";
        try {
            connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar reserva: " + e.getMessage());
        }
    }
}
