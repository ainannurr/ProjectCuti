/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Karyawan;
import java.util.List;

/**
 *
 * @author AINAN-Gaul
 */
public interface KaryawanInterfaceDAO {
    public boolean update(Karyawan karyawan);
    public boolean insert(Karyawan karyawan);
    public boolean delete(String id);
    public List<Karyawan> getAll();
    public List<Karyawan> getAll(String category, String sort);
    public List<Karyawan> search(String category, String data);
    public Karyawan getById(String id);
}
