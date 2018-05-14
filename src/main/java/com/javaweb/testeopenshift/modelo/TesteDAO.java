/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.testeopenshift.modelo;

import com.javaweb.testeopenshift.bean.Teste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class TesteDAO {
    private static Connection conn = ConnectionFactory.getConnection();
    private static PreparedStatement stmt;
    
    public static List<Teste> listarTestes (){
        List<Teste> t = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from teste");

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Teste teste = new Teste();
                teste.setCodigo(rs.getInt(1));
                teste.setNome(rs.getString(2));
                teste.setValor(rs.getString(3));
                t.add(teste);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
}
