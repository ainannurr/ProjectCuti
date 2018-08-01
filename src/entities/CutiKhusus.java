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
public class CutiKhusus {
    private String cutiKhususId;
    private String keteranganCuti;
    private int lamaCuti;

    public CutiKhusus() {
    }

    public CutiKhusus(String cutiKhususId, String keteranganCuti, int lamaCuti) {
        this.cutiKhususId = cutiKhususId;
        this.keteranganCuti = keteranganCuti;
        this.lamaCuti = lamaCuti;
    }
   
    /**
     * @return the cutiKhususId
     */
    public String getCutiKhususId() {
        return cutiKhususId;
    }

    /**
     * @param cutiKhususId the cutiKhususId to set
     */
    public void setCutiKhususId(String cutiKhususId) {
        this.cutiKhususId = cutiKhususId;
    }

    /**
     * @return the keteranganCuti
     */
    public String getKeteranganCuti() {
        return keteranganCuti;
    }

    /**
     * @param keteranganCuti the keteranganCuti to set
     */
    public void setKeteranganCuti(String keteranganCuti) {
        this.keteranganCuti = keteranganCuti;
    }

    /**
     * @return the lamaCuti
     */
    public int getLamaCuti() {
        return lamaCuti;
    }

    /**
     * @param lamaCuti the lamaCuti to set
     */
    public void setLamaCuti(int lamaCuti) {
        this.lamaCuti = lamaCuti;
    }
    
}
