/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.KaryawanDAO;
import entities.Karyawan;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public class KaryawanController implements KaryawanInterfaceController{
    private KaryawanDAO karyawanDAO;

    public KaryawanController() {
    }

    public KaryawanController(Connection connection) {
        this.karyawanDAO = new KaryawanDAO(connection);
    }

    @Override
    public boolean save(String karyawanId, String jabatanId, String karyawanName, String email, String alamat, int jatahCuti) {
        return this.karyawanDAO.insert(new Karyawan(karyawanId, jabatanId, karyawanName, email, alamat, jatahCuti));
    }

    @Override
    public boolean edit(String karyawanId, String jabatanId, String karyawanName, String email, String alamat, int jatahCuti) {
        return this.karyawanDAO.update(new Karyawan(karyawanId, jabatanId, karyawanName, email, alamat, jatahCuti));
    }

    @Override
    public boolean drop(String id) {
        return this.karyawanDAO.delete(id);
    }

    @Override
    public List<Karyawan> binding() {
        return  this.karyawanDAO.getAll();
    }

    @Override
    public List<Karyawan> binding(String category, String sort) {
        return this.karyawanDAO.getAll(category, sort);
    }

    @Override
    public List<Karyawan> find(String category, String data) {
        return  this.karyawanDAO.search(category, data);
    }

    @Override
    public Karyawan findById(String id) {
        return  this.karyawanDAO.getById(id);
    }
    
    
}
