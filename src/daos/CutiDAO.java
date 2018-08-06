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
    private String tanggalAwal;
    private String tanggalAkhir;
    
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
        String query = "INSERT INTO Cuti VALUES(?,?,?,?,?)";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cuti.getCutiId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(tanggalAwal));
            preparedStatement.setDate(3, java.sql.Date.valueOf(tanggalAkhir));
            preparedStatement.setString(4, cuti.getKeterangan());
            preparedStatement.setString(5, cuti.getIdCutiKhusus());
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
        String query = "UPDATE Cuti SET tanggal_awal=?, tanggal_akhir=?, keterangan=?, id_cuti_khusus=? WHERE id_cuti=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, java.sql.Date.valueOf(tanggalAwal));
            preparedStatement.setDate(2, java.sql.Date.valueOf(tanggalAkhir));
            preparedStatement.setString(3, cuti.getKeterangan());
            preparedStatement.setString(4, cuti.getIdCutiKhusus());
            preparedStatement.setString(5, cuti.getCutiId());
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
        String query = "DELETE FROM Cuti WHERE id_cuti=?";
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
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                cuti.setIdCutiKhusus(rs.getString("id_cuti_khusus"));
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
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                cuti.setIdCutiKhusus(rs.getString("id_cuti_khusus"));
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
                cuti.setCutiId(rs.getString("id_cuti"));
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                cuti.setIdCutiKhusus(rs.getString("id_cuti_khusus"));
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
        String query="SELECT * FROM Cuti WHERE id_cuti= '" +id+ "'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                cuti.setCutiId(rs.getString("id_cuti"));
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                cuti.setIdCutiKhusus(rs.getString("id_cuti_khusus"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuti;
    }
}
