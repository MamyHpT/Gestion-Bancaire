/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author talex
 */
public class Connexion {

    public static Connection con;
    public static Statement stat;

    public Connexion() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWD);
        stat = con.createStatement();
    }

    public ResultSet execute(String query) throws Exception {
        ResultSet res = stat.executeQuery(query);
        return res;
    }

    public int executeUpdate(String query) throws Exception {
        int res = stat.executeUpdate(query);
        return res;
    }

    public static void close() throws Exception {
        stat.close();
        con.close();
    }
}
