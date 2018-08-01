/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Cuti;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface CutiInterfaceDAO {
    public boolean insert(Cuti cuti);
    public boolean update(Cuti cuti);
    public boolean delete(String id);
    public List<Cuti> getAll();
    public List<Cuti> getAllSort(String category, String sort);
    public List<Cuti> search(String category, String data);
    public Cuti getById(String id);
}
