package dao;

import java.sql.*;

public class ConnectionFactory {
    
    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "educoins"; 
    
    /* String url = "jdbc:mysql://localhost:3306/educoins?useTimezone=true&serverTimezone=UTC";
    String username = "Alunos";
    String password = "alunos";*/
    
    public Connection obterConexao(){
        try{
           Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd + "?useTimezone=true&serverTimezone=UTC", usuario, senha);
               return c;
             //Connection connection = DriverManager.getConnection(url, username, password);
            // return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
