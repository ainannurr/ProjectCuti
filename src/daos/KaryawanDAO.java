/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Karyawan;
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
public class KaryawanDAO implements KaryawanInterfaceDAO{
    private Connection connection;

    public KaryawanDAO() {
    }

    public KaryawanDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean update(Karyawan karyawan) {
        String query ="UPDATE KARYAWAN SET nama_karyawan=? WHERE karyawan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, karyawan.getKaryawanId());
            preparedStatement.setString(2, karyawan.getNamaKaryawan());
            preparedStatement.setString(3, karyawan.getEmail());
            preparedStatement.setString(4, karyawan.getJabatanId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean insert(Karyawan karyawan) {
        boolean flag = false;
        String query = "INSERT INTO KARYAWAN VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, karyawan.getKaryawanId());
            preparedStatement.setString(2, karyawan.getNamaKaryawan());
            preparedStatement.setString(3, karyawan.getEmail());
            preparedStatement.setString(4, karyawan.getJabatanId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM KARYAWAN WHERE karyawan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<Karyawan> getAll() {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM KARYAWAN";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString(1));
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(3));
                karyawan.setJabatanId(rs.getString(4));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<Karyawan> getAll(String category, String sort) {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM KARYAWAN ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString(1));
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(3));
                karyawan.setJabatanId(rs.getString(4));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<Karyawan> search(String category, String data) {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM KARYAWAN WHERE " +category+ " LIKE '%" +data+ "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString(1));
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(3));
                karyawan.setJabatanId(rs.getString(4));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public Karyawan getById(String id) {
        Karyawan karyawan = new Karyawan();
        String query = "SELECT * FROM KARYAWAN WHERE REGION_ID= " +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                karyawan.setKaryawanId(rs.getString(1));
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(3));
                karyawan.setJabatanId(rs.getString(4));
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return karyawan;
    }
}
