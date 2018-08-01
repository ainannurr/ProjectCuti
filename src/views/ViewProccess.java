/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AINAN-Gaul
 */
public class ViewProccess {
    
    /**
     * fungsi untuk memanggil form tampilan
     * @param desktopPane nama desktop pane
     * @param internalFrame nama internal frame
     */
    public void callForm(JDesktopPane desktopPane, JInternalFrame internalFrame) {
        internalFrame.show();
        desktopPane.add(internalFrame);
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan tabel dan menambahkan tabel
     * @param table nama tabel
     * @param header isi dari header ex: Region ID, Region Name
     * @param datas isi dari tabel
     */
    public void viewTable(JTable table, String[] header, List<Object[]> datas) {
        DefaultTableModel dtm = new DefaultTableModel(header, 0);
        datas.forEach((data) -> {
            dtm.addRow(data);
        });
        table.setModel(dtm);
    }
    
    /**
     * fungsi yang digunakan untuk menambahkan kategori dalam combo box yang akan disimpan pada header
     * @param comboBox nama combo box
     * @param header nama header
     */
    public void loadSearchComboBox(JComboBox comboBox, String[] header) {
        comboBox.removeAllItems();
        for (String string : header) {
            comboBox.addItem(string);
        }
    }
    
    /**
     * fungsi yang digunakan untuk menambahkan kategori berdasarkan index
     * @param comboBox nama combo box
     * @param datas isi dari tabel
     * @param index menambahkan isi combo box pada variable categori[]
     */
    public void loadDetails(JComboBox comboBox, List<Object[]> datas, int index) {
        datas.forEach((data) -> {
            comboBox.addItem(data[index]);
        });
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan kategori yang sudah ditambahkan
     * @param categories
     * @param comboBox
     * @return selected index
     */
    public String getCategory(String[] categories, JComboBox comboBox) {
        return categories[comboBox.getSelectedIndex()];
    }
    
    /**
     * fungsi yang digunakan untuk memanggil fungsi menggunakan key press
     * @param evt
     * @return fungsi yang dipanggil
     */
    public boolean keyPressed(KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan confirm dialog
     * @param component
     * @return yes option
     */
    public boolean dropConfirm(Component component) {
        return JOptionPane.showConfirmDialog(component, "Are you sure to drop data?", "Attention",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan informasi pesan sesuai dengan fungsi
     * @param component
     * @param message pesan yang akan ditampilkan
     */
    public void showInformation(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Notification",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan isi pesan berdasarkan kegunaan pesannya
     * @param action
     * @param flag
     * @return flag
     */
    public String getMessage(String action, boolean flag) {
        if (flag) {
            return "Success to " + action + " data...";
        }
        return "Failed to " + action + " data...";
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan informasi penghapusan data
     * @param component
     * @param flag 
     */
    public void dropData(Component component, boolean flag) {
        this.showInformation(component, this.getMessage("drop", flag));
    }
    
    /**
     * fungsi yang digunakan untuk memilih pesan simpan dan edit
     * @param isSave
     * @return 
     */
    public String getAction(boolean isSave) {
        if (isSave) {
            return "save";
        }
        return "edit";
    }
    
    /**
     * fungsi yang digunakan untuk menampilkan informasi penyimpanan data
     * @param component
     * @param flag
     * @param isSave 
     */
    public void saveData(Component component, boolean flag, boolean isSave) {
        this.showInformation(component, this.getMessage(this.getAction(isSave), flag));
    }

    public void loadData(Component component, JTable table, String[] header, List<Object[]> datas) {
        if (datas!=null) {
            this.viewTable(table, header, datas);
        } else {
            this.showInformation(component, this.getMessage("load", false));
        }
    }    
    
    public String getIdfromComboBox(List<Object[]> datas, int index){
        return datas.get(index)[0].toString();
    }
}
