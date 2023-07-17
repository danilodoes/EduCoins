package com.mycompany.educoinsfx;
import dao.ConnectionFactory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aluno;

public class AlunoController implements Initializable{
 
    @FXML
    void irParaLogin(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    void irParaParceiros(ActionEvent event) {
        ModalController mc = new ModalController();
        mc.ModalListarParceiro();
    }

    @FXML
    void irParaRecompensas(ActionEvent event) {
        ModalController mc = new ModalController();
        mc.ModalListarRecompensa();
    }

    String sql = null;
    Connection connection = null;
    ConnectionFactory cf = new ConnectionFactory();
    ResultSet rs = null;
    PreparedStatement pst = null;
    Aluno aluno = null;
    ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("listaraluno.fxml"));
    
    
    
    
    @FXML
    private TableColumn<Aluno, String> PK_Matricula = loader.getController();

    @FXML
    private TableColumn<Aluno, String> Senha = loader.getController();

    @FXML
    private TableColumn<Aluno, String> CodTurma = loader.getController();
    
    @FXML
    private TableColumn<Aluno, String> Saldo = loader.getController();

    @FXML
    private TableView<Aluno> tb_aluno = loader.getController();
    
  
    private void carregarLista() {
        listaAlunos.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_aluno`";
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){   
            listaAlunos.add(new Aluno(rs.getString("PK_Matricula"), rs.getString("Senha"), rs.getString("CodTurma"),rs.getInt("Saldo")));
            }
        } catch (Exception e) {
            System.out.println("PROBLEMAS CONEXÃO !");
            e.printStackTrace(); 
        }
        
    }
    
    public void mostrarLista() {
        
        carregarLista();
        tb_aluno.setItems(listaAlunos);
        PK_Matricula.setCellValueFactory(new PropertyValueFactory<>("PK_Matricula"));
        Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
        CodTurma.setCellValueFactory(new PropertyValueFactory<>("CodTurma"));
        Saldo.setCellValueFactory(new PropertyValueFactory<>("Saldo")); 
     
}
        
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        mostrarLista();
    }
  
    
    
}
