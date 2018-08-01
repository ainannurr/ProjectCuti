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
public class Cuti {
    private String cutiId;
    private int lamaCuti;
    private int sisaTahunIni;
    private int sisaTahunLalu;

    public Cuti() {
    }

    public Cuti(String cutiId, int lamaCuti, int sisaTahunIni, int sisaTahunLalu) {
        this.cutiId = cutiId;
        this.lamaCuti = lamaCuti;
        this.sisaTahunIni = sisaTahunIni;
        this.sisaTahunLalu = sisaTahunLalu;
    }

    /**
     * @return the cutiId
     */
    public String getCutiId() {
        return cutiId;
    }

    /**
     * @param cutiId the cutiId to set
     */
    public void setCutiId(String cutiId) {
        this.cutiId = cutiId;
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

    /**
     * @return the sisaTahunIni
     */
    public int getSisaTahunIni() {
        return sisaTahunIni;
    }

    /**
     * @param sisaTahunIni the sisaTahunIni to set
     */
    public void setSisaTahunIni(int sisaTahunIni) {
        this.sisaTahunIni = sisaTahunIni;
    }

    /**
     * @return the sisaTahunLalu
     */
    public int getSisaTahunLalu() {
        return sisaTahunLalu;
    }

    /**
     * @param sisaTahunLalu the sisaTahunLalu to set
     */
    public void setSisaTahunLalu(int sisaTahunLalu) {
        this.sisaTahunLalu = sisaTahunLalu;
    }
    
    
}