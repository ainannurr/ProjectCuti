/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JabatanDAO;
import entities.Jabatan;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public class JabatanController implements JabatanInterfaceController{
    private JabatanDAO jabatanDAO;

    public JabatanController() {
    }
    
    public JabatanController(Connection connection) {
         this.jabatanDAO = new JabatanDAO(connection);
    }

    @Override
    public boolean save(String jabatanId, String jabatanName) {
        return this.jabatanDAO.insert(new Jabatan(jabatanId, jabatanName));
    }

    @Override
    public boolean edit(String jabatanId, String jabatanName) {
        return this.jabatanDAO.update(new Jabatan(jabatanId, jabatanName));
    }

    @Override
    public boolean drop(String id) {
        return this.jabatanDAO.delete(id);
    }

    @Override
    public List<Jabatan> binding() {
        return this.jabatanDAO.getAll();
    }

    @Override
    public List<Jabatan> bindingSort(String category, String sort) {
        return this.jabatanDAO.getAllSort(category, sort);
    }

    @Override
    public List<Jabatan> find(String category, String data) {
        return this.jabatanDAO.search(category, data);
    }

    @Override
    public Jabatan findById(String id) {
        return this.jabatanDAO.getById(id);
    }
}
