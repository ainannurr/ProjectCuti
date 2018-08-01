/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.CutiKhusus;
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
public class CutiKhususDAO implements CutiKhususInterfaceDAO {
    private Connection connection;

    public CutiKhususDAO(){
        
    }
    public CutiKhususDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(CutiKhusus cutiKhusus) {
        boolean flag = false;
        String query = "INSERT INTO CutiKhusus VALUES(?,?,?)";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cutiKhusus.getCutiKhususId());
            preparedStatement.setString(2, cutiKhusus.getKeteranganCuti());
            preparedStatement.setInt(3, cutiKhusus.getLamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public boolean update(CutiKhusus cutiKhusus) {
        String query = "UPDATE Departments SET keterangan_cuti=?, lama_cuti=? WHERE cuti_khusus_id=?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cutiKhusus.getKeteranganCuti());
            preparedStatement.setInt(2, cutiKhusus.getLamaCuti());
            preparedStatement.setString(3, cutiKhusus.getCutiKhususId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM CutiKhusus WHERE cuti_khusus_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<CutiKhusus> getAll() {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM CutiKhusus";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("cuti_khusus_id"));
                cutiKhusus.setKeteranganCuti(rs.getString("keterangan_cuti"));
                cutiKhusus.setLamaCuti(rs.getInt("lama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas ; 
    }

    @Override
    public List<CutiKhusus> getAllSort(String category, String sort) {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM CutiKhusus ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("cuti_khusus_id"));
                cutiKhusus.setKeteranganCuti(rs.getString("keterangan_cuti"));
                cutiKhusus.setLamaCuti(rs.getInt("lama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    @Override
    public List<CutiKhusus> search(String category, String data) {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM CutiKhusus WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("cuti_khusus_id"));
                cutiKhusus.setKeteranganCuti(rs.getString("keterangan_cuti"));
                cutiKhusus.setLamaCuti(rs.getInt("lama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }


    @Override
    public CutiKhusus getById(String id) {
        CutiKhusus cutiKhusus = new CutiKhusus();
        String query="SELECT * FROM CutiKhusus WHERE cuti_khusus_id="+id;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                cutiKhusus.setCutiKhususId(rs.getString("cuti_khusus_id"));
                cutiKhusus.setKeteranganCuti(rs.getString("keterangan_cuti"));
                cutiKhusus.setLamaCuti(rs.getInt("lama_cuti"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cutiKhusus;
    }
}


    
    

