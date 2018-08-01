/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Jabatan;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public interface JabatanInterfaceDAO {
    public boolean update(Jabatan jabatan);
    public boolean insert(Jabatan jabatan);
    public boolean delete(String id);
    public List<Jabatan> getAll();
    public List<Jabatan> getAllSort(String category, String sort);
    public List<Jabatan> search(String category, String data);
    public Jabatan getById(String id);
}
