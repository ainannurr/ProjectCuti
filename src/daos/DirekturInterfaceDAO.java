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
public interface DirekturInterfaceDAO {
    public boolean insertDetail(DetailCuti detailCuti);
    public boolean insertCuti(Cuti cuti);
    public boolean updateDetail(DetailCuti detailCuti);
    public boolean updateCuti(Cuti cuti);
    public boolean deleteDetail(String idDetail);
    public boolean deleteCuti(String idCuti);
    public List<DetailCuti> getAll();
    public List<DetailCuti> getAllSort(String category, String sort);
    public List<DetailCuti> search(String category, String data);
    public DetailCuti getById(String id);
}
