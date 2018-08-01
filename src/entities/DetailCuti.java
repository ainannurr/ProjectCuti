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
    private String cutiKhusuId;
    private Date tanggalAwal;
    private Date tanggalAkhir;
    private String alasanCuti;
    private String statusCuti;

    public DetailCuti() {
    }

    public DetailCuti(String detailCutiId, String karyawanId, String cutiId, String cutiKhusuId, Date tanggalAwal, Date tanggalAkhir, String alasanCuti, String statusCuti) {
        this.detailCutiId = detailCutiId;
        this.karyawanId = karyawanId;
        this.cutiId = cutiId;
        this.cutiKhusuId = cutiKhusuId;
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = tanggalAkhir;
        this.alasanCuti = alasanCuti;
        this.statusCuti = statusCuti;
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

    public String getCutiKhusuId() {
        return cutiKhusuId;
    }

    public void setCutiKhusuId(String cutiKhusuId) {
        this.cutiKhusuId = cutiKhusuId;
    }

    public Date getTanggalAwal() {
        return tanggalAwal;
    }

    public void setTanggalAwal(Date tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    public Date getTanggalAkhir() {
        return tanggalAkhir;
    }

    public void setTanggalAkhir(Date tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public String getAlasanCuti() {
        return alasanCuti;
    }

    public void setAlasanCuti(String alasanCuti) {
        this.alasanCuti = alasanCuti;
    }

    public String getStatusCuti() {
        return statusCuti;
    }

    public void setStatusCuti(String statusCuti) {
        this.statusCuti = statusCuti;
    }
   
    
 
}
