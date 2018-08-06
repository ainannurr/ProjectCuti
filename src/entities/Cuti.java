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
public class Cuti {
    private String cutiId;
    private Date tanggal_awal;
    private Date tanggal_akhir;
    private String keterangan;
    private String idCutiKhusus;

    public Cuti() {
    }

    public Cuti(String cutiId, Date tanggal_awal, Date tanggal_akhir, String keterangan, String idCutiKhusus) {
        this.cutiId = cutiId;
        this.tanggal_awal = tanggal_awal;
        this.tanggal_akhir = tanggal_akhir;
        this.keterangan = keterangan;
        this.idCutiKhusus = idCutiKhusus;
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
     * @return the tanggal_awal
     */
    public Date getTanggal_awal() {
        return tanggal_awal;
    }

    /**
     * @param tanggal_awal the tanggal_awal to set
     */
    public void setTanggal_awal(Date tanggal_awal) {
        this.tanggal_awal = tanggal_awal;
    }

    /**
     * @return the tanggal_akhir
     */
    public Date getTanggal_akhir() {
        return tanggal_akhir;
    }

    /**
     * @param tanggal_akhir the tanggal_akhir to set
     */
    public void setTanggal_akhir(Date tanggal_akhir) {
        this.tanggal_akhir = tanggal_akhir;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the idCutiKhusus
     */
    public String getIdCutiKhusus() {
        return idCutiKhusus;
    }

    /**
     * @param idCutiKhusus the idCutiKhusus to set
     */
    public void setIdCutiKhusus(String idCutiKhusus) {
        this.idCutiKhusus = idCutiKhusus;
    }

}