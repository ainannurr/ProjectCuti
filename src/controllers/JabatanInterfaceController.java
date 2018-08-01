/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Jabatan;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public interface JabatanInterfaceController {
    public boolean save(String jabatanId, String jabatanName);
    public boolean edit(String jabatanId, String jabatanName);
    public boolean drop(String id);
    public List<Jabatan> binding();
    public List<Jabatan> bindingSort(String category, String sort);
    public List<Jabatan> find(String category, String data);
    public Jabatan findById(String id);
}
