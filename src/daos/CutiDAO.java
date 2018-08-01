/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Cuti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simbok_pc
 */
public class CutiDAO implements CutiInterfaceDAO{
    private Connection connection;
    
    public CutiDAO(){
    }
    public CutiDAO(Connection connection){
        this.connection=connection;
    }

    @Override
    public boolean insert(Cuti cuti) {
        boolean flag = false;
        String query = "INSERT INTO Cuti VALUES(?,?,?,?)";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cuti.getCutiId());
            preparedStatement.setInt(2, cuti.getLamaCuti());
            preparedStatement.setInt(3, cuti.getSisaTahunIni());
            preparedStatement.setInt(4, cuti.getSisaTahunLalu());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean update(Cuti cuti) {
        String query = "UPDATE Departments SET lama_cuti=?, sisa_tahun_ini=?, sisa_tahun_lalu=? WHERE cuti_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, cuti.getLamaCuti());
            preparedStatement.setInt(2, cuti.getSisaTahunIni());
            preparedStatement.setInt(3, cuti.getSisaTahunLalu());
            preparedStatement.setString(4, cuti.getCutiId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM Cuti WHERE cuti_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Cuti> getAll() {
       List<Cuti> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Cuti cuti=new Cuti();
                cuti.setCutiId(rs.getString("cuti_id"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("sisa_tahun_ini"));
                cuti.setSisaTahunLalu(rs.getInt("sisa_tahun_lalu"));
                datas.add(cuti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas; 
    }

    @Override
    public List<Cuti> getAllSort(String category, String sort) {
        List<Cuti> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Cuti cuti = new Cuti();
                cuti.setCutiId(rs.getString("cuti_id"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("sisa_tahun_ini"));
                cuti.setSisaTahunLalu(rs.getInt("sisa_tahun_lalu"));
                datas.add(cuti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<Cuti> search(String category, String data) {
        List<Cuti> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Cuti cuti = new Cuti();
                cuti.setCutiId(rs.getString("cuti_id"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("lama_cuti"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                datas.add(cuti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public Cuti getById(String id) {
        Cuti cuti = new Cuti();
        String query="SELECT * FROM Cuti WHERE cuti_id="+id;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                cuti.setCutiId(rs.getString("cuti_id"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("sisa_tahun_ini"));
                cuti.setSisaTahunLalu(rs.getInt("sisa_tahun_lalu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuti;
    }
}
