/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Cuti;
import entities.DetailCuti;
import entities.Jabatan;
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
 * @author Simbok_pc
 */
public class DirekturDAO implements DirekturInterfaceDAO{
    
    private Connection connection;
    private String tanggalAwal;
    private String tanggalAkhir;

    public DirekturDAO() {
    }
    
    public DirekturDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public boolean insertDetail(DetailCuti detailCuti) {
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
    public boolean insertCuti(Cuti cuti) {
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

    @Override
    public boolean updateDetail(DetailCuti detailCuti) {
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
    public boolean updateCuti(Cuti cuti) {
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

    @Override
    public boolean deleteDetail(String idDetail) {
        String query ="DELETE FROM Dtcuti WHERE id_dtcuti=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idDetail);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DetailCutiDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean deleteCuti(String idCuti) {
        String query = "DELETE FROM Cuti WHERE id_cuti=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idCuti);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CutiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<DetailCuti> getAll() {
        List<DetailCuti> datas = new ArrayList<>();
        List<Cuti> datas1 = new ArrayList<>();
        List<Karyawan> datas2 = new ArrayList<>();
        List<Jabatan> datas3 = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setStatusCuti(rs.getString(9));
                detailCuti.setLamaCuti(rs.getString(7));
                datas.add(detailCuti);
                
                Cuti cuti=new Cuti();
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                datas1.add(cuti);
                
                Karyawan karyawan = new Karyawan();
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(4));
                datas2.add(karyawan);
                
                Jabatan jabatan = new Jabatan();
                jabatan.setNamaJabatan(rs.getString(3));
                datas3.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(DirekturDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<DetailCuti> getAllSort(String category, String sort) {
        List<DetailCuti> datas = new ArrayList<>();
        List<Cuti> datas1 = new ArrayList<>();
        List<Karyawan> datas2 = new ArrayList<>();
        List<Jabatan> datas3 = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan ORDER BY "+category+" "+sort;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setStatusCuti(rs.getString(9));
                detailCuti.setLamaCuti(rs.getString(7));
                datas.add(detailCuti);
                
                Cuti cuti=new Cuti();
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                datas1.add(cuti);
                
                Karyawan karyawan = new Karyawan();
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(4));
                datas2.add(karyawan);
                
                Jabatan jabatan = new Jabatan();
                jabatan.setNamaJabatan(rs.getString(3));
                datas3.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(DirekturDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
    }

    @Override
    public List<DetailCuti> search(String category, String data) {
        List<DetailCuti> datas = new ArrayList<>();
        List<Cuti> datas1 = new ArrayList<>();
        List<Karyawan> datas2 = new ArrayList<>();
        List<Jabatan> datas3 = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, "
                + "d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti "
                + "JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan WHERE "+category+" LIKE '%"+data+"%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setStatusCuti(rs.getString(9));
                detailCuti.setLamaCuti(rs.getString(7));
                datas.add(detailCuti);
                
                Cuti cuti=new Cuti();
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                datas1.add(cuti);
                
                Karyawan karyawan = new Karyawan();
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(4));
                datas2.add(karyawan);
                
                Jabatan jabatan = new Jabatan();
                jabatan.setNamaJabatan(rs.getString(3));
                datas3.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(DirekturDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return datas;
        
    }

    @Override
    public DetailCuti getById(String id) {
        List<DetailCuti> datas = new ArrayList<>();
        List<Cuti> datas1 = new ArrayList<>();
        List<Karyawan> datas2 = new ArrayList<>();
        List<Jabatan> datas3 = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, "
                + "d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti "
                + "JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan WHERE id_dtcuti= '" +id+ "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DetailCuti detailCuti = new DetailCuti();
                detailCuti.setDetailCutiId(rs.getString(1));
                detailCuti.setStatusCuti(rs.getString(9));
                detailCuti.setLamaCuti(rs.getString(7));
                datas.add(detailCuti);
                
                Cuti cuti=new Cuti();
                cuti.setTanggal_awal(rs.getDate("tanggal_awal"));
                cuti.setTanggal_akhir(rs.getDate("tanggal_akhir"));
                cuti.setKeterangan(rs.getString("keterangan"));
                datas1.add(cuti);
                
                Karyawan karyawan = new Karyawan();
                karyawan.setNamaKaryawan(rs.getString(2));
                karyawan.setEmail(rs.getString(4));
                datas2.add(karyawan);
                
                Jabatan jabatan = new Jabatan();
                jabatan.setNamaJabatan(rs.getString(3));
                datas3.add(jabatan);
            }
        } catch (SQLException e) {
            Logger.getLogger(DirekturDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return (DetailCuti) datas;
    }

}
