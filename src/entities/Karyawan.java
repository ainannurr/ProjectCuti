/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author AINAN-Gaul
 */
public class Karyawan {
    private String karyawanId;
    private String namaKaryawan;
    private String email;
    private String alamat;
    private int jatahCuti;
    private String jabatanId;

    public Karyawan() {
    }

    public Karyawan(String karyawanId, String namaKaryawan, String email, String alamat, String jabatanId, int jatahCuti) {
        this.karyawanId = karyawanId;
        this.namaKaryawan = namaKaryawan;
        this.email = email;
        this.alamat = alamat;
        this.jabatanId = jabatanId;
        this.jatahCuti = jatahCuti;
    }

    public String getKaryawanId() {
        return karyawanId;
    }

    public void setKaryawanId(String karyawanId) {
        this.karyawanId = karyawanId;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJabatanId() {
        return jabatanId;
    }

    public void setJabatanId(String jabatanId) {
        this.jabatanId = jabatanId;
    }

    public int getJatahCuti() {
        return jatahCuti;
    }

    public void setJatahCuti(int jatahCuti) {
        this.jatahCuti = jatahCuti;
    }
}