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
public class Karyawan {
    private String karyawanId;
    private String namaKaryawan;
    private String email;
    private String jabatanId;

    public Karyawan() {
    }

    public Karyawan(String karyawanId, String namaKaryawan, String email) {
        this.karyawanId = karyawanId;
        this.namaKaryawan = namaKaryawan;
        this.email = email;
    }

    /**
     * @return the karyawanId
     */
    public String getKaryawanId() {
        return karyawanId;
    }

    /**
     * @param karyawanId the karyawanId to set
     */
    public void setKaryawanId(String karyawanId) {
        this.karyawanId = karyawanId;
    }

    /**
     * @return the namaKaryawan
     */
    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    /**
     * @param namaKaryawan the namaKaryawan to set
     */
    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
}
