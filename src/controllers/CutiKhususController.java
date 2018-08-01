/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CutiKhususDAO;
import entities.CutiKhusus;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class CutiKhususController implements CutiKhususInterfaceController{
    private Connection connection;
    private CutiKhususDAO cutiKhususDAO;
    public CutiKhususController(){
        
    }

    public CutiKhususController(Connection connection) {
        this.cutiKhususDAO = new CutiKhususDAO(connection);
    }

    @Override
    public boolean save(String cutiKhususId, String keteranganCuti, String lamaCuti) {
        CutiKhusus cutiKhusus = new CutiKhusus();
        cutiKhusus.setCutiKhususId(cutiKhususId);
        cutiKhusus.setKeteranganCuti(keteranganCuti);
        cutiKhusus.setLamaCuti(Integer.parseInt(lamaCuti));
        return this.cutiKhususDAO.insert(cutiKhusus);
    }

    @Override
    public boolean edit(String cutiKhususId, String keteranganCuti, String lamaCuti) {
        CutiKhusus cutiKhusus = new CutiKhusus();
        cutiKhusus.setCutiKhususId(cutiKhususId);
        cutiKhusus.setKeteranganCuti(keteranganCuti);
        cutiKhusus.setLamaCuti(Integer.parseInt(lamaCuti));
        cutiKhusus.getCutiKhususId();
        cutiKhusus.getKeteranganCuti();
        cutiKhusus.getLamaCuti();
        return this.cutiKhususDAO.update(cutiKhusus);}

    @Override
    public boolean drop(String id) {
        return this.cutiKhususDAO.delete(id);
    }

    @Override
    public List<CutiKhusus> binding() {
        return this.cutiKhususDAO.getAll();
    }

    @Override
    public List<CutiKhusus> bindingSort(String category, String sort) {
        return this.cutiKhususDAO.getAllSort(category, sort);
    }

    @Override
    public List<CutiKhusus> find(String category, String data) {
        return this.cutiKhususDAO.search(category, data);
    }

    @Override
    public CutiKhusus findById(String id) {
        return this.cutiKhususDAO.getById(id); }
    
    
}
