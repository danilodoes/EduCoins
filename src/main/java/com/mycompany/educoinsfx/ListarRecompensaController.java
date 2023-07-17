
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

import model.Recompensa;



public class ListarRecompensaController implements Initializable{
    
    
    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Recompensa recompensa = null;
    ObservableList<Recompensa> listaRecompensa = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listarrecompensa.fxml"));
    
    
    
    
    @FXML
    private TableColumn<Recompensa, String> NomeParceiro = loader.getController();

    @FXML
    private TableColumn<Recompensa, String> PK_Recompensa = loader.getController();

    @FXML
    private TableColumn<Recompensa, String> Preco = loader.getController();

    @FXML
    private TableView<Recompensa> tb_recompensa = loader.getController();
    
  
    private void carregarLista() {
        listaRecompensa.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_recompensa`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaRecompensa.add(new Recompensa(rs.getString("NomeParceiro"), rs.getString("PK_Recompensa"), rs.getString("Preco")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        
        carregarLista();
        tb_recompensa.setItems(listaRecompensa);
        NomeParceiro.setCellValueFactory(new PropertyValueFactory<>("NomeParceiro"));
        PK_Recompensa.setCellValueFactory(new PropertyValueFactory<>("PK_Recompensa"));
        Preco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
       
     
}
        
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        mostrarLista();
    }

    
}
