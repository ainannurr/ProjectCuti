/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.DetailCuti;
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
public class DetailCutiDAO implements DetailCutiInterfaceDAO{
    
    private Connection connection;

    public DetailCutiDAO() {
    }

    public DetailCutiDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean update(DetailCuti detailCuti) {
        boolean flag = false;
        String query ="UPDATE Dtcuti SET status=? WHERE id_dtcuti=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getStatusCuti());
            preparedStatement.setString(5, detailCuti.getLamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean insert(DetailCuti detailCuti) {
        boolean flag = false;
        String query = "INSERT INTO Dtcuti VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getStatusCuti());
            preparedStatement.setString(5, detailCuti.getLamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM Dtcuti WHERE id_dtcuti=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public List<DetailCuti> getAll() {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getString(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<DetailCuti> getAll(String category, String sort) {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT * FROM Dtcuti ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getString(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<DetailCuti> search(String category, String data) {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT * FROM Dtcuti WHERE " +category+ " LIKE '%" +data+ "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getString(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public DetailCuti getById(String id) {
        DetailCuti detailCuti = new DetailCuti();
        String query = "SELECT * FROM Dtcuti WHERE id_dtcuti= " +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getString(5));
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return detailCuti;
    }
}
