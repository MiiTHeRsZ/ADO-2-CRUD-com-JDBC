/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class ComputadorDAO {

    public static String path = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    public static String lgn = "root";
    public static String pwd = "";

    public static boolean salvar(Computador obj) {

        boolean retorno = false;
        Connection connect = null;

        try {
            Class.forName(path);

            connect = DriverManager.getConnection(url, lgn, pwd);

            PreparedStatement cmdSQL = connect.prepareStatement("INSERT INTO computador(marca, hd, processador) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            cmdSQL.setString(1, obj.getMarca());
            cmdSQL.setString(2, obj.getHd());
            cmdSQL.setString(3, obj.getProcessador());

            int rows = cmdSQL.executeUpdate();
            if (rows > 0) {
                retorno = true;

                ResultSet rs = cmdSQL.getGeneratedKeys();
                if (rs != null) {
                    if (rs.next()) {
                        obj.setId(rs.getInt(1));
                    }
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static ArrayList<Computador> listar() {

        Connection connect = null;
        ArrayList<Computador> lista = new ArrayList<Computador>();

        try {
            Class.forName(path);

            connect = DriverManager.getConnection(url, lgn, pwd);

            PreparedStatement cmdSQL = connect.prepareStatement("select * from computador;");

            ResultSet rs = cmdSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Computador objNew = new Computador();
                    objNew.setId(rs.getInt("id"));
                    objNew.setMarca(rs.getString("marca"));
                    objNew.setHd(rs.getString("hd"));
                    objNew.setProcessador(rs.getString("processador"));

                    lista.add(objNew);
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    public static Computador consultar(int id) {

        Connection connect = null;
        Computador obj = new Computador();

        try {
            Class.forName(path);

            connect = DriverManager.getConnection(url, url, pwd);

            PreparedStatement cmdSQL = connect.prepareStatement("selec * from computador where id = ?;");
            cmdSQL.setInt(1, id);

            ResultSet rs = cmdSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    obj.setId(rs.getInt("id"));
                    obj.setMarca(rs.getString("marca"));
                    obj.setHd(rs.getString("hd"));
                    obj.setProcessador(rs.getString("processador"));
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return obj;
    }

    public static boolean alterar(Computador obj) {
        boolean retorno = false;
        Connection connect = null;

        try {
            Class.forName(path);

            connect = DriverManager.getConnection(url, url, pwd);

            PreparedStatement cmdSQL = connect.prepareStatement("update computador set hd = ?, processador = ? where id = ?;");

            cmdSQL.setString(1, obj.getHd());
            cmdSQL.setString(2, obj.getProcessador());
            cmdSQL.setInt(3, obj.getId());

            int rows = cmdSQL.executeUpdate();
            if (rows > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection connect = null;

        try {
            Class.forName(path);

            connect = DriverManager.getConnection(url, url, pwd);

            PreparedStatement cmdSQL = connect.prepareStatement("delete from computador where id = ?;");

            cmdSQL.setInt(1, id);

            int rows = cmdSQL.executeUpdate();
            if (rows > 0) {
                retorno = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }
}
