/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Jabatan;
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
 * @author AINAN-Gaul
 */
public class JabatanDAO implements JabatanInterfaceDAO{
    
    private Connection connection;

    public JabatanDAO() {
    }

    public JabatanDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean update(Jabatan jabatan) {
        String query ="UPDATE JABATAN SET nama_jabatan=? WHERE jabatan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, jabatan.getJabatanId());
            preparedStatement.setString(2, jabatan.getNamaJabatan());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean insert(Jabatan jabatan) {
        boolean flag = false;
        String query = "INSERT INTO JABATAN VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, jabatan.getJabatanId());
            preparedStatement.setString(2, jabatan.getNamaJabatan());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM JABATAN WHERE jabatan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Jabatan> getAll() {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM JABATAN";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setJabatanId(rs.getString(1));
                jabatan.setNamaJabatan(rs.getString(2));
                datas.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<Jabatan> getAllSort(String category, String sort) {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM JABATAN ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setJabatanId(rs.getString(1));
                jabatan.setNamaJabatan(rs.getString(2));
                datas.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<Jabatan> search(String category, String data) {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM JABATAN WHERE " +category+ " LIKE '%" +data+ "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setJabatanId(rs.getString(1));
                jabatan.setNamaJabatan(rs.getString(2));
                datas.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public Jabatan getById(String id) {
        Jabatan jabatan = new Jabatan();
        String query = "SELECT * FROM JABATAN WHERE JABATAN_ID = '"+id+"'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                jabatan.setJabatanId(rs.getString(1));
                jabatan.setNamaJabatan(rs.getString(2));
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return jabatan;
    }
}
