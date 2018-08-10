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
public class CutiKhusus {
    private String cutiKhususId;
    private String namaCuti;

    public CutiKhusus() {
    }

    public CutiKhusus(String cutiKhususId, String namaCuti) {
        this.cutiKhususId = cutiKhususId;
        this.namaCuti = namaCuti;
    }

    public String getCutiKhususId() {
        return cutiKhususId;
    }

    public void setCutiKhususId(String cutiKhususId) {
        this.cutiKhususId = cutiKhususId;
    }

    public String getNamaCuti() {
        return namaCuti;
    }

    public void setNamaCuti(String namaCuti) {
        this.namaCuti = namaCuti;
    }
}
