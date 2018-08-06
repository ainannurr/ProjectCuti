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
public class TampilDAO implements InterfaceTampilDAO{

    private Connection connection;

    public TampilDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<DetailCuti> getAll() {
    
         List<DetailCuti> datas = new ArrayList<>();
        List<Cuti> datas1 = new ArrayList<>();
        List<Karyawan> datas2 = new ArrayList<>();
        List<Jabatan> datas3 = new ArrayList<>();
        String query = "SELECT d.id_dtcuti, k.nama_karyawan, j.nama_jabatan, k.email, c.tanggal_awal, c.tanggal_akhir, d.lama_cuti, c.keterangan, d.status FROM Dtcuti d JOIN Cuti c ON d.id_cuti=c.id_cuti JOIN Karyawan k ON d.id_karyawan=k.id_karyawan JOIN Jabatan j ON k.id_jabatan=j.id_jabatan ORDER BY ASC ";
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

}
