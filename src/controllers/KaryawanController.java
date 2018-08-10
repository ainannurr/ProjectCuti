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

    /**
     * fungsi save digunakan untuk menyimpan data yang di inputkan ke tabel karyawan yang dihubungakan dengan karyawanDAO
     * @param karyawanId String
     * @param jabatanId String
     * @param karyawanName String
     * @param email String
     * @param alamat String
     * @param jatahCuti integer
     * @return true/false
     */
    @Override
    public boolean save(String karyawanId, String jabatanId, String karyawanName, String email, String alamat, int jatahCuti) {
        return this.karyawanDAO.insert(new Karyawan(karyawanId, jabatanId, karyawanName, email, alamat, jatahCuti));
    }

    /**
     * fungsi edit digunakan untuk mengubah data yang ingin diubah di tabel karyawan yang dihubungkan dengan karyawanDAO
     * @param karyawanId String
     * @param jabatanId String
     * @param karyawanName String
     * @param email String
     * @param alamat String
     * @param jatahCuti integer
     * @return  true/false
     */
    @Override
    public boolean edit(String karyawanId, String jabatanId, String karyawanName, String email, String alamat, int jatahCuti) {
        return this.karyawanDAO.update(new Karyawan(karyawanId, jabatanId, karyawanName, email, alamat, jatahCuti));
    }

    /**
     * fungsi drop digunakan untuk mengapus data yang ada di tabel karyawan dihubungkan dengan karyawanDAO
     * @param id String
     * @return true/false
     */
    @Override
    public boolean drop(String id) {
        return this.karyawanDAO.delete(id);
    }

    /**
     * fungsi binding digunakan untuk menampilkan semua data yang ada di tabel karyawan dihubungkan dengan karyawanDAO
     * @return data List
     */
    @Override
    public List<Karyawan> binding() {
        return  this.karyawanDAO.getAll();
    }

    /**
     * fungsi bindingSort digunakan untuk menampilkan seluruh data yang di tabel karyawan berdasarkan kategori dan hasil diurutkan (sort asc/desc) yang dihubungkan dengan karyawanDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<Karyawan> binding(String category, String sort) {
        return this.karyawanDAO.getAll(category, sort);
    }

    /**
     * fungsi find digunakan untuk pencarian data yang ada di tabel karyawan berdasarkan kondisi yang dihubungakan dengan karyawanDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<Karyawan> find(String category, String data) {
        return  this.karyawanDAO.search(category, data);
    }

    /**
     * fungsi findById digunakan untuk pencarian data yang ada di tabel karyawan berdasarkan id yang dihubungakan dengan karyawanDAO
     * @param id String
     * @return controller perintah menampilkan data berdasarkan id
     */
    @Override
    public Karyawan findById(String id) {
        return  this.karyawanDAO.getById(id);
    }
    
    
}
