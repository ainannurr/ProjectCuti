/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.DetailCuti;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface DirekturInterfaceController {
    public boolean save (String idDtcuti, String namaKaryawan, String namaJabatan, String email, String tanggalAwal, String tanggalAkhir, String lamaCuti, String keterangan, String status);
    public boolean edit (String idDtcuti, String namaKaryawan, String namaJabatan, String email, String tanggalAwal, String tanggalAkhir, String lamaCuti, String keterangan, String status);
    public boolean drop (String id);
    public List<DetailCuti> binding();
    public List<DetailCuti> bindingSort(String category, String sort);
    public List<DetailCuti> find(String category, String data);
    public DetailCuti findById (String id);
}
