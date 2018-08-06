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
    private String namaCuti;
    

    public CutiKhusus() {
    }

    public CutiKhusus(String cutiKhususId, String namaCuti) {
        this.cutiKhususId = cutiKhususId;
        this.namaCuti = namaCuti;
        
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
    public String getNamaCuti() {
        return namaCuti;
    }

    /**
     * @param namaCuti the keteranganCuti to set
     */
    public void setNamaCuti(String namaCuti) {
        this.namaCuti = namaCuti;
    }
 
}
