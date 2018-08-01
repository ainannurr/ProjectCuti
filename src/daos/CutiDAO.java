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
    
    /**
     * fungsi untuk memanggil koneksi
     * @param connection 
     */
    public CutiDAO(Connection connection){
        this.connection=connection;
    }

    /**
     * fungsi ini digunakan untuk insert data pada tabel Cuti
     * @param cuti
     * @return true / false
     */
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

    /**
     * fungsi ini digunakan mengedit data pada tabel Cuti
     * @param cuti
     * @return true / false
     */
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

    /**
     * fungsi ini digunakan untuk menghapus data pada tabel Cuti
     * @param id String
     * @return true / false
     */
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

    /**
     * fungsi ini diguakan untuk menggambil/menampilkan data dari Tabel Cuti
     * @return 
     */
    @Override
    public List<Cuti> getAll() {
       List<Cuti> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Cuti cuti=new Cuti();
                cuti.setCutiId(rs.getString("id_cuti"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("sisa_tahunini"));
                cuti.setSisaTahunLalu(rs.getInt("sisa_tahunlalu"));
                datas.add(cuti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas; 
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Cuti berdasarkan parameter
     * @param category String --> parameter kategori yang akan dijadikan acuan mengurutkan data
     * @param sort String --> mengurutkan data berdasarkan asc/desc
     * @return 
     */
    @Override
    public List<Cuti> getAllSort(String category, String sort) {
        List<Cuti> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Cuti cuti = new Cuti();
                cuti.setCutiId(rs.getString("id_cuti"));
                cuti.setLamaCuti(rs.getInt("lama_cuti"));
                cuti.setSisaTahunIni(rs.getInt("sisa_tahunini"));
                cuti.setSisaTahunLalu(rs.getInt("sisa_tahunlalu"));
                datas.add(cuti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan mencari data dari tabel Cuti dengan parameter tertentu
     * @param category String --> parameter katgori yang akan dicari
     * @param data String --> parameter kata kunci
     * @return 
     */
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

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel Cuti dengan parameter id
     * @param id Integer
     * @return 
     */
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
