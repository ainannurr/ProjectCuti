/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TampilDAO;
import entities.Cuti;
import entities.DetailCuti;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public class TampilController implements TampilInterfaceController{

    private TampilDAO tampilDAO;

    public TampilController(TampilDAO tampilDAO) {
        this.tampilDAO = tampilDAO;
    }

    @Override
    public List<DetailCuti> binding() {
    
        return this.tampilDAO.getAll();
    }
    
}
