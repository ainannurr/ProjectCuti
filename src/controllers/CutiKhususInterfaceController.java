/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CutiKhusus;
import java.util.List;

/**
 *
 * @author Simbok_pc
 */
public interface CutiKhususInterfaceController {
    public boolean save (String cutiKhususId, String namaCuti);
    public boolean edit (String cutiKhususId, String namaCuti);
    public boolean drop (String id);
    public List<CutiKhusus> binding();
    public List<CutiKhusus> bindingSort(String category, String sort);
    public List<CutiKhusus> find(String category, String data);
    public CutiKhusus findById (String id);
}
