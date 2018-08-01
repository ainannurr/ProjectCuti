/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Simbok_pc
 */
public class Jabatan {
     private String jabatanId;
    private String namaJabatan;

    public Jabatan() {
    }

    public Jabatan(String jabatanId, String namaJabatan) {
        this.jabatanId = jabatanId;
        this.namaJabatan = namaJabatan;
    }

    /**
     * @return the jabatanId
     */
    public String getJabatanId() {
        return jabatanId;
    }

    /**
     * @param jabatanId the jabatanId to set
     */
    public void setJabatanId(String jabatanId) {
        this.jabatanId = jabatanId;
    }

    /**
     * @return the namaJabatan
     */
    public String getNamaJabatan() {
        return namaJabatan;
    }

    /**
     * @param namaJabatan the namaJabatan to set
     */
    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }
    
}
