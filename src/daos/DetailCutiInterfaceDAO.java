/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.DetailCuti;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public interface DetailCutiInterfaceDAO {
    public boolean update(DetailCuti detailCuti);
    public boolean insert(DetailCuti detailCuti);
    public boolean delete(String id);
    public List<DetailCuti> getAll();
    public List<DetailCuti> getAll(String category, String sort);
    public List<DetailCuti> search(String category, String data);
    public DetailCuti getById(String id);
}
