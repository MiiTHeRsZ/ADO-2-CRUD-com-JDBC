/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author gusta
 */
public class Computador {

    private int id;
    private static String marca = "GustavoLeme";
    private String hd;
    private String processador;

    public Computador() {

    }

    public Computador(String hd, String processador) {
        this.hd = hd;
        this.processador = processador;
    }

    public Computador(int id, String hd, String processador) {
        this.id = id;
        this.hd = hd;
        this.processador = processador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

}
