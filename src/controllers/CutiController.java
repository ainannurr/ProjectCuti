/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CutiDAO;
import entities.Cuti;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class CutiController implements CutiInterfaceController{
    private Connection connection;
    private CutiDAO cutiDAO;
    public CutiController(){
    }

    public CutiController(Connection connection) {
        this.cutiDAO = new CutiDAO(connection);
    }

    @Override
    public boolean save(String cutiId, String lamaCuti, String sisaTahunIni, String sisaTahunLalu) {
        return this.cutiDAO.insert(new Cuti(cutiId, Integer.parseInt(lamaCuti), Integer.parseInt(sisaTahunIni), Integer.parseInt(sisaTahunLalu)));
    }

    @Override
    public boolean edit(String cutiId, String lamaCuti, String sisaTahunIni, String sisaTahunLalu) {
        return this.cutiDAO.update(new Cuti(cutiId, Integer.parseInt(lamaCuti), Integer.parseInt(sisaTahunIni), Integer.parseInt(sisaTahunLalu)));
    }

    @Override
    public boolean drop(String id) {
        return this.cutiDAO.delete(id);
    }

    @Override
    public List<Cuti> binding() {
        return this.cutiDAO.getAll();
    }

    @Override
    public List<Cuti> bindingSort(String category, String sort) {
        return this.cutiDAO.getAllSort(category, sort);
    }

    @Override
    public List<Cuti> find(String category, String data) {
        return this.cutiDAO.search(category, data);
    }

    @Override
    public Cuti findById(String id) {
        return this.cutiDAO.getById(id);
    }
    
    
}
