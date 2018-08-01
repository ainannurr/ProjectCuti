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
public interface DetailCutiInterfaceController {
    public boolean save (String detailKhususId, String karyawanId, String cutiId, 
            String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti);
    public boolean edit (String detailKhususId, String karyawanId, String cutiId, 
            String cutiKhususId, String tanggalAwal, String tanggalAkhir, String alasanCuti, String statusCuti);
    public boolean drop (String id);
    public List<DetailCuti> binding();
    public List<DetailCuti> bindingSort(String category, String sort);
    public List<DetailCuti> find(String category, String data);
    public DetailCuti findById (String id);
}
