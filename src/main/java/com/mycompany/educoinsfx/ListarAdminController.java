
package com.mycompany.educoinsfx;

import dao.ConnectionFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Administrador;



public class ListarAdminController implements Initializable{
    
    
    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Administrador admin = null;
    ObservableList<Administrador> listaAdministrador = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listaradmin.fxml"));
    
    
    
    
    @FXML
    private TableColumn<Administrador, String> PK_Matricula = loader.getController();

    @FXML
    private TableColumn<Administrador, String> Senha = loader.getController();

    @FXML
    private TableColumn<Administrador, String> CPF = loader.getController();
    
    @FXML
    private TableColumn<Administrador, String> EMAIL = loader.getController();

    @FXML
    private TableView<Administrador> tb_admin = loader.getController();
    
  
    private void carregarLista() {
        listaAdministrador.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_admin`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaAdministrador.add(new Administrador(rs.getString("PK_Matricula"), rs.getString("Senha"), rs.getString("CPF"),rs.getString("EMAIL")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        
        carregarLista();
        tb_admin.setItems(listaAdministrador);
        PK_Matricula.setCellValueFactory(new PropertyValueFactory<>("PK_Matricula"));
        Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
        CPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("EMAIL")); 
     
}
        
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        mostrarLista();
    }

    
}
