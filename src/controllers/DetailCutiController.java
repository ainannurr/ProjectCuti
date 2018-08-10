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
        this.detaiilCutiDAO = new DetailCutiDAO(connection);
    }

    /**
     * fungsi save digunakan untuk menyimpan data yang di inputkan ke tabel detailCuti yang dihubungakan dengan detailCutiDAO
     * @param detailCutiId String
     * @param karyawanId String
     * @param cutiId String
     * @param statusCuti String
     * @param lamaCuti String
     * @return true/false
     */
    @Override
    public boolean save(String detailCutiId, String karyawanId, String cutiId, String statusCuti, String lamaCuti) {
        return this.detaiilCutiDAO.insert(new DetailCuti(detailCutiId, karyawanId, cutiId, statusCuti, Integer.parseInt(lamaCuti)));
    }

    /**
     * fungsi edit digunakan untuk mengubah data yang ingin diubah di tabel detailCuti yang dihubungkan dengan detailCutiDAO
     * @param detailCutiId String
     * @param karyawanId String
     * @param cutiId String
     * @param statusCuti String
     * @param lamaCuti String
     * @return true/false
     */
    @Override
    public boolean edit(String detailCutiId, String karyawanId, String cutiId, String statusCuti, String lamaCuti) {
        return this.detaiilCutiDAO.update(new DetailCuti(detailCutiId, karyawanId, cutiId, statusCuti, Integer.parseInt(lamaCuti)));
    }

    /**
     * fungsi drop digunakan untuk mengapus data yang ada di tabel detailCuti dihubungkan dengan detailCutiDAO
     * @param id String
     * @return true/false
     */
    @Override
    public boolean drop(String id) {
        return this.detaiilCutiDAO.delete(id);
    }

    /**
     * fungsi binding digunakan untuk menampilkan semua data yang ada di tabel detailCuti dihubungkan dengan detailCutiDAO
     * @return data List
     */
    @Override
    public List<DetailCuti> binding() {
        return this.detaiilCutiDAO.getAll();
    }

    /**
     * fungsi bindingSort digunakan untuk menampilkan seluruh data yang di tabel detailCuti berdasarkan kategori dan hasil diurutkan (sort asc/desc) yang dihubungkan dengan detailCutiDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<DetailCuti> bindingSort(String category, String sort) {
        return this.detaiilCutiDAO.getAll(category, sort);
    }

    /**
     * fungsi find digunakan untuk pencarian data yang ada di tabel detailCuti berdasarkan kondisi yang dihubungakan dengan detailCutiDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<DetailCuti> find(String category, String data) {
         return this.detaiilCutiDAO.search(category, data);
    }

    /**
     * fungsi findById digunakan untuk pencarian data yang ada di tabel detailCuti berdasarkan id yang dihubungakan dengan datailCutiDAO
     * @param id String
     * @return controller perintah menampilkan data berdasarkan id
     */
    @Override
    public DetailCuti findById(String id) {
        return this.detaiilCutiDAO.getById(id);
   }
 
}
