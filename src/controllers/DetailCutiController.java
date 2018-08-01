/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DetailCutiDAO;
import entities.DetailCuti;
import java.sql.Connection;
import java.sql.Date;
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
        this.detaiilCutiDAO = new DetailCutiDAO(connection);
    }

    @Override
    public boolean save(String detailCutiId, String karyawanId, String cutiId, String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti) {
        return this.detaiilCutiDAO.insert(new DetailCuti(detailCutiId, karyawanId, cutiId, cutiKhususId, java.sql.Date.valueOf(tanggalAwal), java.sql.Date.valueOf(tanggalAkhir), alasanCuti, statusCuti));
    }

    @Override
    public boolean edit(String detailCutiId, String karyawanId, String cutiId, String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti) {
        return this.detaiilCutiDAO.update(new DetailCuti(detailCutiId, karyawanId, cutiId, cutiKhususId, java.sql.Date.valueOf(tanggalAwal), java.sql.Date.valueOf(tanggalAkhir), alasanCuti, statusCuti));
    }

    @Override
    public boolean drop(String id) {
        return this.detaiilCutiDAO.delete(id);
    }

    @Override
    public List<DetailCuti> binding() {
        return this.detaiilCutiDAO.getAll();
    }

    @Override
    public List<DetailCuti> bindingSort(String category, String sort) {
        return this.detaiilCutiDAO.getAll(category, sort);
    }

    @Override
    public List<DetailCuti> find(String category, String data) {
         return this.detaiilCutiDAO.search(category, data);
    }

    @Override
    public DetailCuti findById(String id) {
        return this.detaiilCutiDAO.getById(id);
   }
 
}
