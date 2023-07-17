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

import model.Educador;



public class ListarEducadorController implements Initializable{
    
    
    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Educador educador = null;
    ObservableList<Educador> listaEducador = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listareducador.fxml"));
    
    
    
    
    @FXML
    private TableColumn<Educador, String> PK_Matricula = loader.getController();

    @FXML
    private TableColumn<Educador, String> Senha = loader.getController();
    
    @FXML
    private TableColumn<Educador, String> Setor = loader.getController();
    
    @FXML
    private TableColumn<Educador, String> RG = loader.getController();

    @FXML
    private TableColumn<Educador, String> CodTurma = loader.getController();

    @FXML
    private TableView<Educador> tb_educador = loader.getController();
    
   
 
    private void carregarLista() {
        listaEducador.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_educador`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaEducador.add(new Educador(rs.getString("PK_Matricula"), rs.getString("Senha"), rs.getString("Setor"),rs.getString("RG"), rs.getString("CodTurma")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        
        carregarLista();
        tb_educador.setItems(listaEducador);
        PK_Matricula.setCellValueFactory(new PropertyValueFactory<>("PK_Matricula"));
        Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
        Setor.setCellValueFactory(new PropertyValueFactory<>("Setor"));
        RG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        CodTurma.setCellValueFactory(new PropertyValueFactory<>("CodTurma"));
       
     
}
        
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        mostrarLista();
    }

    
}
