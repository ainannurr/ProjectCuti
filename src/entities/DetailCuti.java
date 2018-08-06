/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Simbok_pc
 */
public class DetailCuti {
    private String detailCutiId;
    private String karyawanId;
    private String cutiId;
    private String statusCuti;
    private String lamaCuti;

    public DetailCuti() {
    }

    public DetailCuti(String detailCutiId, String karyawanId, String cutiId, String statusCuti, String lamaCuti) {
        this.detailCutiId = detailCutiId;
        this.karyawanId = karyawanId;
        this.cutiId = cutiId;
        this.statusCuti = statusCuti;
        this.lamaCuti = lamaCuti;
    }

    public String getDetailCutiId() {
        return detailCutiId;
    }

    public void setDetailCutiId(String detailCutiId) {
        this.detailCutiId = detailCutiId;
    }

    public String getKaryawanId() {
        return karyawanId;
    }

    public void setKaryawanId(String karyawanId) {
        this.karyawanId = karyawanId;
    }

    public String getCutiId() {
        return cutiId;
    }

    public void setCutiId(String cutiId) {
        this.cutiId = cutiId;
    }

    public String getStatusCuti() {
        return statusCuti;
    }

    public void setStatusCuti(String statusCuti) {
        this.statusCuti = statusCuti;
    }
    
    public String getLamaCuti() {
        return lamaCuti;
    }

    public void setLamaCuti(String lamaCuti) {
        this.lamaCuti = lamaCuti;
    }
}
