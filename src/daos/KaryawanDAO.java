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

    /**
     * fungsi untuk memanggil koneksi
     * @param connection Connection
     */
    public KaryawanDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi ini digunakan untuk update data pada tabel Karyawan
     * @param karyawan Object
     * @return true / false
     */
    @Override
    public boolean update(Karyawan karyawan) {
        String query ="UPDATE Karyawan SET nama_karyawan=?, email=?, alamat=?, jatah_cuti=?, jabatan_id=? WHERE karyawan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(6, karyawan.getKaryawanId());
            preparedStatement.setString(1, karyawan.getNamaKaryawan());
            preparedStatement.setString(2, karyawan.getEmail());
            preparedStatement.setString(3, karyawan.getAlamat());
            preparedStatement.setInt(4, karyawan.getJatahCuti());
             preparedStatement.setString(5, karyawan.getJabatanId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * fungsi ini digunakan insert data pada tabel Karyawan
     * @param karyawan Object
     * @return true / false
     */
    @Override
    public boolean insert(Karyawan karyawan) {
        boolean flag = false;
        String query = "INSERT INTO Karyawan VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, karyawan.getKaryawanId());
            preparedStatement.setString(2, karyawan.getJabatanId());
            preparedStatement.setString(3, karyawan.getNamaKaryawan());
            preparedStatement.setString(4, karyawan.getEmail());
            preparedStatement.setString(5, karyawan.getAlamat());
            preparedStatement.setInt(6, karyawan.getJatahCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return flag;
    }

    /**
     * fungsi ini digunakan untuk menghapus data pada tabel Karyawan
     * @param id String
     * @return true / false
     */
    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM Karyawan WHERE karyawan_id=?";
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

    /**
     * fungsi ini diguakan untuk menggambil/menampilkan data dari Tabel Karyawan
     * @return List
     */
    @Override
    public List<Karyawan> getAll() {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM Karyawan";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString(1));
                karyawan.setJabatanId(rs.getString(2));
                karyawan.setNamaKaryawan(rs.getString(3));
                karyawan.setEmail(rs.getString(4));
                karyawan.setAlamat(rs.getString(5));
                karyawan.setJatahCuti(rs.getInt(6));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Karyawan berdasarkan parameter
     * @param category String parameter kategori yang akan dijadikan acuan mengurutkan data
     * @param sort String mengurutkan data berdasarkan asc/desc
     * @return List
     */
    @Override
    public List<Karyawan> getAll(String category, String sort) {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM Karyawan ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString("karyawan_id"));
                karyawan.setJabatanId(rs.getString("jabatan_id"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setEmail(rs.getString("email"));
                karyawan.setAlamat(rs.getString("alamat"));
                karyawan.setJatahCuti(rs.getInt("jatah_cuti"));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan mencari data dari tabel Karyawan dengan parameter tertentu
     * @param category String parameter katgori yang akan dicari
     * @param data String parameter kata kunci
     * @return List
     */
    @Override
    public List<Karyawan> search(String category, String data) {
        List<Karyawan> datas = new ArrayList<>();
        String query = "SELECT * FROM Karyawan WHERE REGEXP_LIKE(" +category+ ", '" +data+ "', 'i')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Karyawan karyawan = new Karyawan();
                karyawan.setKaryawanId(rs.getString("karyawan_id"));
                karyawan.setJabatanId(rs.getString("jabatan_id"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setEmail(rs.getString("email"));
                karyawan.setAlamat(rs.getString("alamat"));
                karyawan.setJatahCuti(rs.getInt("jatah_cuti"));
                datas.add(karyawan);
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Karyawan dengan parameter id
     * @param id Integer
     * @return id
     */
    @Override
    public Karyawan getById(String id) {
        Karyawan karyawan = new Karyawan();
        String query = "SELECT * FROM Karyawan WHERE karyawan_id= " +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                karyawan.setKaryawanId(rs.getString("karyawan_id"));
                karyawan.setJabatanId(rs.getString("jabatan_id"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setEmail(rs.getString("email"));
                karyawan.setAlamat(rs.getString("alamat"));
                karyawan.setJatahCuti(rs.getInt("jatah_cuti"));
            }
        } catch (SQLException e) {
            Logger.getLogger(KaryawanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return karyawan;
    }
}
