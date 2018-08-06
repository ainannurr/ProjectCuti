/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DirekturDAO;
import entities.Cuti;
import entities.DetailCuti;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class DirekturController implements DirekturInterfaceController{
    private DirekturDAO direkturDAO;

    public DirekturController() {
    }
    
    public DirekturController(Connection connection) {
         this.direkturDAO = new DirekturDAO(connection);
    }

    @Override
    public boolean save(String idDtcuti, String namaKaryawan, String namaJabatan, 
            String email, String tanggalAwal, String tanggalAkhir, 
            String lamaCuti, String keterangan, String status) {
//        return this.direkturDAO.insertCuti(new Cuti(email, tanggal_awal, tanggal_akhir, keterangan, idDtcuti));
    return true;
    }

    @Override
    public boolean edit(String idDtcuti, String namaKaryawan, String namaJabatan, String email, String tanggalAwal, String tanggalAkhir, String lamaCuti, String keterangan, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean drop(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetailCuti> binding() {
        return this.direkturDAO.getAll();
    }

    @Override
    public List<DetailCuti> bindingSort(String category, String sort) {
        return this.direkturDAO.getAllSort(category, sort);
    }

    @Override
    public List<DetailCuti> find(String category, String data) {
        return this.direkturDAO.search(category, data);
    }

    @Override
    public DetailCuti findById(String id) {
        return this.direkturDAO.getById(id);
    }
}
