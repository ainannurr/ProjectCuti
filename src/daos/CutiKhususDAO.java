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
    
    /**
     * fungsi untuk memanggil koneksi
     * @param connection Connection
     */
    public CutiKhususDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi ini digunakan untuk insert data pada tabel CutiKhusus
     * @param cutiKhusus Object
     * @return true / false
     */
    @Override
    public boolean insert(CutiKhusus cutiKhusus) {
        boolean flag = false;
        String query = "INSERT INTO Cuti_Khusus VALUES(?,?)";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cutiKhusus.getCutiKhususId());
            preparedStatement.setString(2, cutiKhusus.getNamaCuti());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    /**
     * fungsi ini digunakan mengedit data pada tabel CutiKhusus
     * @param cutiKhusus Object
     * @return true / false
     */
    @Override
    public boolean update(CutiKhusus cutiKhusus) {
        String query = "UPDATE Cuti_Khusus SET nama_cuti=? WHERE ck_id=?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cutiKhusus.getNamaCuti());
            preparedStatement.setString(2, cutiKhusus.getCutiKhususId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * fungsi ini digunakan untuk menghapus data pada tabel CutiKhusus
     * @param id String
     * @return true / false
     */
    @Override
    public boolean delete(String id) {
        String query = "DELETE FROM Cuti_Khusus WHERE ck_id=?";
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

    /**
     * fungsi ini diguakan untuk menggambil/menampilkan data dari Tabel CutiKhusus
     * @return  List
     */
    @Override
    public List<CutiKhusus> getAll() {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti_Khusus";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("ck_id"));
                cutiKhusus.setNamaCuti(rs.getString("nama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas ; 
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel CutiKhusus berdasarkan parameter
     * @param category String parameter kategori yang akan dijadikan acuan mengurutkan data
     * @param sort String mengurutkan data berdasarkan asc/desc
     * @return List
     */
    @Override
    public List<CutiKhusus> getAllSort(String category, String sort) {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti_Khusus ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("ck_id"));
                cutiKhusus.setNamaCuti(rs.getString("nama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan mencari data dari tabel CutiKhusus dengan parameter tertentu
     * @param category parameter katgori yang akan dicari
     * @param data String parameter kata kunci
     * @return List
     */
    @Override
    public List<CutiKhusus> search(String category, String data) {
        List<CutiKhusus> datas = new ArrayList<>();
        String query="SELECT * FROM Cuti_Khusus WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                CutiKhusus cutiKhusus = new CutiKhusus();
                cutiKhusus.setCutiKhususId(rs.getString("ck_id"));
                cutiKhusus.setNamaCuti(rs.getString("nama_cuti"));
                datas.add(cutiKhusus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }

    /**
     * fungsi ini digunakan untuk menampilkan data dari tabel CutiKhusus dengan parameter id
     * @param id Integer
     * @return ID
     */
    @Override
    public CutiKhusus getById(String id) {
        CutiKhusus cutiKhusus = new CutiKhusus();
        String query="SELECT * FROM Cuti_Khusus WHERE ck_id="+id;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                cutiKhusus.setCutiKhususId(rs.getString("ck_id"));
                cutiKhusus.setNamaCuti(rs.getString("nama_cuti"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CutiKhususDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cutiKhusus;
    }
}


    
    

