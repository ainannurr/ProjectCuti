/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DetailCutiDAO;
import entities.DetailCuti;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class DetailCutiController implements DetailCutiInterfaceController{
    
    private Connection connection;
    private DetailCutiDAO detaiilCutiDAO;
    public DetailCutiController(){
    }

    public DetailCutiController(Connection connection) {
        this.detailCutiDAO = new DetailCutiDAO(connection);
    }

    @Override
    public boolean save(String detailKhususId, String karyawanId, String cutiId, String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti) {
        DetailCuti detailCuti = new DetailCuti();
        detailCuti.setDetailCutiId(detailCutiId);
        detailCuti.setKaryawanId(karyawanId);
        detailCuti.setCutiId(cutiId);
        detailCuti.setCutiKhusuId(cutiKhususId);
        detailCuti.setTanggalAwal(Date tanggalAwal);
        detailCuti.setTanggalAkhir(Date tanggalAkhir);
        detailCuti.setAlasanCuti(alasanCuti);
        detailCuti.setStatusCuti(statusCuti);
        return this.detaiilCutiDAO.insert(detailCuti);
    }

    @Override
    public boolean edit(String detailKhususId, String karyawanId, String cutiId, String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti) {
        DetailCuti detailCuti = new  DetailCuti();
        detailCuti.setDetailCutiId(detailKhususId);
        detailCuti.setKaryawanId(karyawanId);
        detailCuti.setCutiId(cutiId);
        detailCuti.setCutiKhususId(cutiKhususId);
        detailCuti.setTanggalAwal(Date tanggalAwal));
        detailCuti.setTanggalAkhir(Date tanggalAkhir);
        detailCuti.setAlasanCuti(alasanCuti);
        detailCuti.setStatusCuti(statusCuti));
        detailCuti.getDetailCutiId();
        detailCuti.getKaryawanId();
        detailCuti.getCutiId();
        detailCuti.getCutiKhususId();
        detailCuti.getTanggalAwal();
        detailCuti.getTanggalAkhir();
        detailCuti.getAlasanCuti();
        detailCuti.getStatusCuti();
        return this.detaiilCutiDAO.update(detailCuti);
    }

    @Override
    public boolean drop(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetailCuti> binding() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetailCuti> bindingSort(String category, String sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetailCuti> find(String category, String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetailCuti findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
