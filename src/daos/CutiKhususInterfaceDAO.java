/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.CutiKhusus;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface CutiKhususInterfaceDAO {
    public boolean insert(CutiKhusus cutiKhusus);
    public boolean update(CutiKhusus cutiKhusus);
    public boolean delete(String id);
    public List<CutiKhusus> getAll();
    public List<CutiKhusus> getAllSort(String category, String sort);
    public List<CutiKhusus> search(String category, String data);
    public CutiKhusus getById(String id);
}
