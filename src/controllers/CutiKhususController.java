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
    
    /**
     * fungsi save digunakan untuk menyimpan data yang di inputkan ke tabel CutiKhusus yang dihubungakan dengan cutiKhususDAO
     * @param cutiKhususId String
     * @param namaCuti String
     * @return true/false
     */
    @Override
    public boolean save(String cutiKhususId, String namaCuti) {
        return this.cutiKhususDAO.insert(new CutiKhusus(cutiKhususId, namaCuti));
    }

    /**
     * fungsi edit digunakan untuk mengubah data yang ingin diubah di tabel cutiKhusus yang dihubungkan dengan cutiKhususDAO
     * @param cutiKhususId String
     * @param namaCuti String
     * @return true/false
     */
    @Override
    public boolean edit(String cutiKhususId, String namaCuti) {
        return this.cutiKhususDAO.update(new CutiKhusus(cutiKhususId, namaCuti));
    }

    /**
     * fungsi drop digunakan untuk mengapus data yang ada di tabel cutiKhusus dihubungkan dengan cutiKhususDAO
     * @param id String
     * @return true/false
     */
    @Override
    public boolean drop(String id) {
        return this.cutiKhususDAO.delete(id);
    }

    /**
     * fungsi binding digunakan untuk menampilkan semua data yang ada di tabel cutiKhusus dihubungkan dengan cutiKhususDAO
     * @return data List
     */
    @Override
    public List<CutiKhusus> binding() {
        return this.cutiKhususDAO.getAll();
    }

    /**
     * fungsi bindingSort digunakan untuk menampilkan seluruh data yang di tabel cutiKhusus berdasarkan kategori dan hasil diurutkan (sort asc/desc) yang dihubungkan dengan cutiKhususDAO
     * @param category String
     * @param sort String
     * @return controller perintah tampil berdasarkan parameter
     */
    @Override
    public List<CutiKhusus> bindingSort(String category, String sort) {
        return this.cutiKhususDAO.getAllSort(category, sort);
    }

    /**
     * fungsi find digunakan untuk pencarian data yang ada di tabel cutiKhusus berdasarkan kondisi yang dihubungakan dengan cutiKhususDAO
     * @param category String
     * @param data String
     * @return controller perintah cari
     */
    @Override
    public List<CutiKhusus> find(String category, String data) {
        return this.cutiKhususDAO.search(category, data);
    }

    /**
     * fungsi findById digunakan untuk pencarian data yang ada di tabel cutiKhusus berdasarkan id yang dihubungakan dengan cutiKhususDAO
     * @param id String
     * @return controller perintah menampilkan data berdasarkan id
     */
    @Override
    public CutiKhusus findById(String id) {
        return this.cutiKhususDAO.getById(id); }
    
    
}
