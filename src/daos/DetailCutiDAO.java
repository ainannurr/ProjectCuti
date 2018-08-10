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

    
    
    /**
     * fungsi untuk memanggil koneksi
     * @param connection Connection
     */
    public DetailCutiDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi ini digunakan untuk update data pada tabel Detail cuti
     * @param detailCuti Object
     * @return true / false
     */
    @Override
    public boolean update(DetailCuti detailCuti) {
        boolean flag = false;
        String query ="UPDATE Dt_Cuti SET status=? WHERE detail_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getStatusCuti());
            preparedStatement.setInt(5, detailCuti.getLamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    /**
     * fungsi ini digunakan insert data pada tabel Detail cuti
     * @return true / false
     */
    @Override
    public boolean insert(DetailCuti detailCuti) {
        boolean flag = false;
        String query = "INSERT INTO Dt_Cuti VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, detailCuti.getDetailCutiId());
            preparedStatement.setString(2, detailCuti.getKaryawanId());
            preparedStatement.setString(3, detailCuti.getCutiId());
            preparedStatement.setString(4, detailCuti.getStatusCuti());
            preparedStatement.setInt(5, detailCuti.getLamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    /**
     * fungsi ini digunakan untuk menghapus data pada tabel Detail cuti
     * @param id String
     * @return true / false
     */
    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM Dt_Cuti WHERE detail_id=?";
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

    /**
     * fungsi ini diguakan untuk menggambil/menampilkan data dari Tabel Detail cuti
     * @return List
     */
    @Override
    public List<DetailCuti> getAll() {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT * FROM Dt_Cuti";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getInt(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Detail cuti berdasarkan parameter
     * @param category String parameter kategori yang akan dijadikan acuan mengurutkan data
     * @param sort String mengurutkan data berdasarkan asc/desc
     * @return List
     */
    @Override
    public List<DetailCuti> getAll(String category, String sort) {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT * FROM Dt_Cuti ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getInt(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan mencari data dari tabel Detail cuti dengan parameter tertentu
     * @param category String parameter katgori yang akan dicari
     * @param data String parameter kata kunci
     * @return List
     */
    @Override
    public List<DetailCuti> search(String category, String data) {
        List<DetailCuti> datas = new ArrayList<>();
        String query = "SELECT * FROM Dt_Cuti WHERE " +category+ " LIKE '%" +data+ "%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getInt(5));
                datas.add(detailCuti);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

     /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Karyawan dengan parameter id
     * @param id Integer
     * @return Id
     */
    @Override
    public DetailCuti getById(String id) {
        DetailCuti detailCuti = new DetailCuti();
        String query = "SELECT * FROM Dt_Cuti WHERE id_dtcuti= " +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setKaryawanId(rs.getString(2));
                detailCuti.setCutiId(rs.getString(3));
                detailCuti.setStatusCuti(rs.getString(4));
                detailCuti.setLamaCuti(rs.getInt(5));
            }
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return detailCuti;
    }
}
