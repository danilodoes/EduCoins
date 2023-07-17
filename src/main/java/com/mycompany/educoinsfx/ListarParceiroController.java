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

import model.Parceiro;



public class ListarParceiroController implements Initializable{
    
    
    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Parceiro parceiro = null;
    ObservableList<Parceiro> listaParceiro = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listarparceiro.fxml"));
    
    @FXML
    private TableColumn<Parceiro, String> PK_Nome = loader.getController();
    
    @FXML
    private TableView<Parceiro> tb_parceiro = loader.getController();
    
  
    private void carregarLista() {
        listaParceiro.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_parceiro`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaParceiro.add(new Parceiro(rs.getString("PK_Nome")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        carregarLista();
        tb_parceiro.setItems(listaParceiro);
        PK_Nome.setCellValueFactory(new PropertyValueFactory<>("PK_Nome"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarLista();
    }
}