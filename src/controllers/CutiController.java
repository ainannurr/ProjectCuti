/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CutiDAO;
import entities.Cuti;
import java.sql.Connection;
import java.sql.Date;
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

    /**
     * fungsi save digunakan untuk menyimpan data yang di inputkan ke tabel cuti yang dihubungakan dengan cutiDAO
     * @param cutiId String
     * @param ckId String
     * @param tanggalAwal Date
     * @param tanggalAkhir Date
     * @param keterangan String
     * @return true/false
     */
    @Override
    public boolean save(String cutiId, String ckId, Date tanggalAwal, Date tanggalAkhir, String keterangan) {
        return this.cutiDAO.insert(new Cuti(cutiId, ckId, tanggalAwal, tanggalAkhir, keterangan));
    }

    /**
     * fungsi edit digunakan untuk mengubah data yang ingin diubah di tabel cuti yang dihubungkan dengan cutiDAO
     * @param cutiId String
     * @param ckId String
     * @param tanggalAwal Date
     * @param tanggalAkhir Date
     * @param keterangan String
     * @return true/false
     */
    @Override
    public boolean edit(String cutiId, String ckId, Date tanggalAwal, Date tanggalAkhir, String keterangan) {
        return this.cutiDAO.update(new Cuti(cutiId, ckId, tanggalAwal, tanggalAkhir, keterangan));
    }

    /**
     * fungsi drop digunakan untuk mengapus data yang ada di tabel cuti dihubungkan dengan cutiDAO
     * @param id String
     * @return true/false
     */
    @Override
    public boolean drop(String id) {
        return this.cutiDAO.delete(id);
    }

    /**
     * fungsi binding digunakan untuk menampilkan semua data yang ada di tabel cuti dihubungkan dengan cutiDAO
     * @return data List
     */
    @Override
    public List<Cuti> binding() {
        return this.cutiDAO.getAll();
    }

    /**
     * fungsi bindingSort digunakan untuk menampilkan seluruh data yang di tabel cuti berdasarkan kategori dan hasil diurutkan (sort asc/desc) yang dihubungakan dengan cutiDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<Cuti> bindingSort(String category, String sort) {
        return this.cutiDAO.getAllSort(category, sort);
    }

    /**
     * fungsi find digunakan untuk pencarian data yang ada di tabel cuti berdasarkan kondisi yang dihubungakan dengan cutiDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<Cuti> find(String category, String data) {
        return this.cutiDAO.search(category, data);
    }

    /**
     * fungsi findById digunakan untuk pencarian data yang ada di tabel cuti berdasarkan id yang dihubungakan dengan cutiDAO
     * @param id String
     * @return controller perintah menampilkan data berdasarkan id
     */
    @Override
    public Cuti findById(String id) {
        return this.cutiDAO.getById(id);
    }
}
