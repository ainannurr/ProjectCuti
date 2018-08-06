/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Cuti;
import entities.DetailCuti;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface InterfaceTampilDAO {
    
    public List<DetailCuti> getAll();
    
}
