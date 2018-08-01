/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Karyawan;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public interface KaryawanInterfaceController {
    public boolean save(String karyawanId, String karyawanName, String email, String jabatanId);
    public boolean edit(String karyawanId, String karyawanName,String email, String jabatanId);
    public boolean drop(String id);
    public List<Karyawan> binding();
    public List<Karyawan> binding(String category, String sort);
    public List<Karyawan> find(String category, String data);
    public Karyawan findById(String id);
}
