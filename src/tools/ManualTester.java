/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.JabatanController;
import controllers.KaryawanController;
import entities.Jabatan;
import java.sql.Connection;

/**
 *
 * @author AINAN-Gaul
 */
public class ManualTester {
    
    public static void main(String[] args) {
        Connection connection = new MyConnection().getConnection();
        
        KaryawanController karyawanController=new KaryawanController(connection);
        
        System.out.println(karyawanController.binding("jabatan_id", "asc").size());
    }
    
    
  //  JabatanController jabatanController = new JabatanController(connection);
    

//    for (Jabatan jabatan : jabatanController.binding()) {
//        System.out.println(jabatan.getJabatanId()+"-"+jabatan.getNamaJabatan());
//    }
    
    //String[] items = { "item1", "item2" };
//    for (Karyawan karyawan : karyawanController.find(category, data)) {
//            Object[] karyawan1 = {
//                karyawan.getKaryawanId()
//            };
//    JComboBox cb = new JComboBox(karyawan1);
//
//    // Get current value
//    Object obj = cb.getSelectedItem(); 

    
}
