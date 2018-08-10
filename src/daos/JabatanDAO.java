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

    /**
     * fungsi untuk memanggil koneksi
     * @param connection Connection
     */
    public JabatanDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi ini digunakan untuk update data pada tabel Jabatan
     * @param jabatan Object
     * @return true / false
     */
    @Override
    public boolean update(Jabatan jabatan) {
        String query ="UPDATE Jabatan SET nama_jabatan=? WHERE jabatan_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(2, jabatan.getJabatanId());
            preparedStatement.setString(1, jabatan.getNamaJabatan());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    /**
     * fungsi ini digunakan insert data pada tabel Jabatan
     * @param jabatan Object
     * @return true / false
     */
    @Override
    public boolean insert(Jabatan jabatan) {
        boolean flag = false;
        String query = "INSERT INTO Jabatan VALUES (?, ?)";
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

    /**
     * fungsi ini digunakan untuk menghapus data pada tabel Jabatan
     * @param id String
     * @return true / false
     */
    @Override
    public boolean delete(String id) {
        String query ="DELETE FROM Jabatan WHERE jabatan_id=?";
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
    

     /**
     * fungsi ini diguakan untuk menggambil/menampilkan data dari Tabel Jabatan
     * @return List
     */
    @Override
    public List<Jabatan> getAll() {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM Jabatan";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setJabatanId(rs.getString("jabatan_id"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                datas.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }
    

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Jabatan berdasarkan parameter
     * @param category String parameter kategori yang akan dijadikan acuan mengurutkan data
     * @param sort String mengurutkan data berdasarkan asc/desc
     * @return List
     */
    @Override
    public List<Jabatan> getAllSort(String category, String sort) {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM Jabatan ORDER BY " +category+ " " +sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setJabatanId(rs.getString("jabatan_id"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                datas.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(JabatanDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

     /**
     * fungsi ini digunakan mencari data dari tabel Jabatan dengan parameter tertentu
     * @param category String parameter katgori yang akan dicari
     * @param data String parameter kata kunci
     * @return List
     */
    @Override
    public List<Jabatan> search(String category, String data) {
        List<Jabatan> datas = new ArrayList<>();
        String query = "SELECT * FROM Jabatan WHERE " +category+ " LIKE '%" +data+ "%'";
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

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Jabatan dengan parameter id
     * @param id Integer
     * @return id
     */
    @Override
    public Jabatan getById(String id) {
        Jabatan jabatan = new Jabatan();
        String query = "SELECT * FROM Jabatan WHERE JABATAN_ID = '" +id+ "'";
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
