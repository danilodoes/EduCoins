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

import model.Turma;



public class ListarTurmaController implements Initializable{
    
    
    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Turma turma = null;
    ObservableList<Turma> listaTurma = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listarturma.fxml"));
    
    @FXML
    private TableColumn<Turma, String> CodTurma = loader.getController();

   

    @FXML
    private TableView<Turma> tb_turma = loader.getController();
    
  
    private void carregarLista() {
        listaTurma.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_turma`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaTurma.add(new Turma(rs.getString("CodTurma")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        carregarLista();
        tb_turma.setItems(listaTurma);
        CodTurma.setCellValueFactory(new PropertyValueFactory<>("CodTurma"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarLista();
    }
}