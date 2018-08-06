/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Cuti;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface CutiInterfaceController {
    public boolean save (String cutiId, Date tanggalAwal, Date tanggalAkhir, String keterangan, String idCutiKhusus);
    public boolean edit (String cutiId, Date tanggalAwal, Date tanggalAkhir, String keterangan, String idCutiKhusus);
    public boolean drop (String id);
    public List<Cuti> binding();
    public List<Cuti> bindingSort(String category, String sort);
    public List<Cuti> find(String category, String data);
    public Cuti findById (String id);
}
