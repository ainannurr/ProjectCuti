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
    private String tanggalAwal;
    private String tanggalAkhir;

    public DetailCutiDAO() {
    }

    public DetailCutiDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean update(DetailCuti detailCuti) {
        boolean flag = false;
        String query ="UPDATE DETAIL_CUTI SET status=? WHERE detail_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getCutiKhususId());
            preparedStatement.setDate(5, java.sql.Date.valueOf(tanggalAwal));
            preparedStatement.setDate(6, java.sql.Date.valueOf(tanggalAkhir));
            preparedStatement.setString(7, detailCuti.getStatusCuti());
            preparedStatement.setString(8, detailCuti.getAlasanCuti());
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
        String query = "INSERT INTO DETAIL_CUTI VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getCutiKhususId());
            preparedStatement.setDate(5, java.sql.Date.valueOf(tanggalAwal));
            preparedStatement.setDate(6, java.sql.Date.valueOf(tanggalAkhir));
            preparedStatement.setString(7, detailCuti.getStatusCuti());
            preparedStatement.setString(8, detailCuti.getAlasanCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM DETAIL_CUTI WHERE detail_id=?";
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
        String query = "SELECT * FROM DETAIL_CUTI";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setCutiKhususId(rs.getString(4));
                detailCuti.setTanggalAwal(rs.getDate(5));
                detailCuti.setTanggalAkhir(rs.getDate(6));
                detailCuti.setStatusCuti(rs.getString(7));
                detailCuti.setAlasanCuti(rs.getString(8));
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
        String query = "SELECT * FROM DETAIL_CUTI ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setCutiKhususId(rs.getString(4));
                detailCuti.setTanggalAwal(rs.getDate(5));
                detailCuti.setTanggalAkhir(rs.getDate(6));
                detailCuti.setStatusCuti(rs.getString(7));
                detailCuti.setAlasanCuti(rs.getString(8));
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
        String query = "SELECT * FROM DETAIL_CUTI WHERE " +category+ " LIKE '%" +data+ "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setCutiKhususId(rs.getString(4));
                detailCuti.setTanggalAwal(rs.getDate(5));
                detailCuti.setTanggalAkhir(rs.getDate(6));
                detailCuti.setStatusCuti(rs.getString(7));
                detailCuti.setAlasanCuti(rs.getString(8));
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
        String query = "SELECT * FROM DETAIL_CUTI WHERE DETAIL_ID= " +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setCutiKhususId(rs.getString(4));
                detailCuti.setTanggalAwal(rs.getDate(5));
                detailCuti.setTanggalAkhir(rs.getDate(6));
                detailCuti.setStatusCuti(rs.getString(7));
                detailCuti.setAlasanCuti(rs.getString(8));
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return detailCuti;
    }
}
