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

    /**
     * fungsi save digunakan untuk menyimpan data yang di inputkan ke tabel jabatan yang dihubungakan dengan jabatanDAO
     * @param jabatanId String
     * @param jabatanName String
     * @return true/false
     */
    @Override
    public boolean save(String jabatanId, String jabatanName) {
        return this.jabatanDAO.insert(new Jabatan(jabatanId, jabatanName));
    }

    /**
     * fungsi edit digunakan untuk mengubah data yang ingin diubah di tabel jabatan yang dihubungkan dengan jabatanDAO
     * @param jabatanId String
     * @param jabatanName String
     * @return true/false
     */
    @Override
    public boolean edit(String jabatanId, String jabatanName) {
        return this.jabatanDAO.update(new Jabatan(jabatanId, jabatanName));
    }

    /**
     * fungsi drop digunakan untuk mengapus data yang ada di tabel jabatan dihubungkan dengan jabatanDAO
     * @param id String
     * @return true/false
     */
    @Override
    public boolean drop(String id) {
        return this.jabatanDAO.delete(id);
    }

    /**
     * fungsi binding digunakan untuk menampilkan semua data yang ada di tabel jabatan dihubungkan dengan jabatanDAO
     * @return data List
     */
    @Override
    public List<Jabatan> binding() {
        return this.jabatanDAO.getAll();
    }

    /**
     * fungsi bindingSort digunakan untuk menampilkan seluruh data yang di tabel jabatan berdasarkan kategori dan hasil diurutkan (sort asc/desc) yang dihubungkan dengan jabatanDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<Jabatan> bindingSort(String category, String sort) {
        return this.jabatanDAO.getAllSort(category, sort);
    }

    /**
     * fungsi find digunakan untuk pencarian data yang ada di tabel jabatan berdasarkan kondisi yang dihubungakan dengan jabatanDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<Jabatan> find(String category, String data) {
        return this.jabatanDAO.search(category, data);
    }

    /**
     * fungsi findById digunakan untuk pencarian data yang ada di tabel jabatan berdasarkan id yang dihubungakan dengan jabatanDAO
     * @param id String
     * @return controller perintah menampilkan data berdasarkan id
     */
    @Override
    public Jabatan findById(String id) {
        return this.jabatanDAO.getById(id);
    }
}
