/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.testeopenshift.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * fabrica de conexão - padrão factory
 */
public class ConnectionFactory {
    
    //singleton
    private static ConnectionFactory instance = new ConnectionFactory();
    
    //constante e static - para usar sempre a mesma referência
    public static final String URL = "jdbc:mysql://teste-mysql:3306/testeopenshift";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver"; 
    
    //construtor privado - padrão singleton - garantir unica instancia para todo o aplicativo
    private ConnectionFactory() {
        try {
            //registra o driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("SUCESSO: Banco de Dados conectado!");
        } catch (SQLException e) {
            System.out.println("ERRO: Erro na conexão com o banco de dados");
        }
        return connection;
    }   
    
    
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
}
