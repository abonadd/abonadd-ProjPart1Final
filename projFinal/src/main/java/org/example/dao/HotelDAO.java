package org.example.dao;

import org.example.connection.DBConnection;
import org.example.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

        private Connection connection;
//obter registos do hotel
        public List<Hotel> listar(){
            String sql = "SELECT * FROM hotel";
            List<Hotel> retorno = new ArrayList<>();
            try {
                connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                while (resultado.next()){
                    Hotel hotel = new Hotel();
                    hotel.setId(resultado.getInt("id"));
                    hotel.setNome(resultado.getString("nome"));
                    hotel.setLocalizacao(resultado.getString("localizacao"));
                    retorno.add(hotel);
                }
                return retorno;
            } catch (SQLException e) {
                throw new RuntimeException(e);
                //System.out.println("Error na connect");
            }
        }
//adicionar registo de hotel
        public boolean inserir(Hotel hotel){
            String sql = "INSERT INTO hotel (nome,localizacao) values(?,?)";
            try {
                connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1,hotel.getNome());
                stmt.setString(2, hotel.getLocalizacao());

                stmt.execute();
                return true;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//atualizar registo de hotel
        public boolean atualizar(Hotel hotel, Integer id){
            String sql = "UPDATE hotel SET nome=?,localizacao=? Where id=?";
            try {
                connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1,hotel.getNome());
                stmt.setString(2, hotel.getLocalizacao());
                stmt.setInt(3,id);
                stmt.execute();
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//remover registo de hotel pelo id
        public boolean deletar(Integer id){
            String sql = "DELETE FROM hotel WHERE id=?";
            try {
                connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1,id);
                stmt.execute();
                System.out.println("olla");
                return true;
            } catch (SQLException e) {
                System.out.println("erro aqui");
                return false;
            }
        }
    }


