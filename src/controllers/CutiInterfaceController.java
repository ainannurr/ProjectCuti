/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Cuti;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface CutiInterfaceController {
    public boolean save (String cutiId, String lamaCuti, String sisaTahunIni, String sisaTahunLalu);
    public boolean edit (String cutiId, String lamaCuti, String sisaTahunIni, String sisaTahunLalu);
    public boolean drop (String id);
    public List<Cuti> binding();
    public List<Cuti> bindingSort(String category, String sort);
    public List<Cuti> find(String category, String data);
    public Cuti findById (String id);
}
