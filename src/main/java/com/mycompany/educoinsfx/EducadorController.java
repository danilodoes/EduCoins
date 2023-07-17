
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Aluno;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class EducadorController implements Initializable {
    
    
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
    private TableColumn<Aluno, Integer> Saldo = loader.getController();

    @FXML
    private TableView<Aluno> tb_aluno = loader.getController();
    
    @FXML
    private TextField txt_educoins;

    @FXML
    private TextField txt_matricula_educoins;

    @FXML
    private TextField txt_matricula_listagem;
    
    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

   
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
    
    @FXML
    private void Buscar(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
           listaAlunos.clear();
        connection = cf.obterConexao();
        
        try {
            sql = "SELECT * FROM `tb_aluno` WHERE PK_Matricula = " + txt_matricula_listagem.getText();
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
        tb_aluno.setItems(listaAlunos);
        PK_Matricula.setCellValueFactory(new PropertyValueFactory<>("PK_Matricula"));
        Senha.setCellValueFactory(new PropertyValueFactory<>("Senha"));
        CodTurma.setCellValueFactory(new PropertyValueFactory<>("CodTurma"));
        Saldo.setCellValueFactory(new PropertyValueFactory<>("Saldo"));  
    }

    @FXML
    void AdicionarEduCoins(ActionEvent event) {
        String cmdBanco = "UPDATE tb_aluno SET Saldo = Saldo + ? WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(cmdBanco);
                    ps.setInt(1,Integer.parseInt(txt_educoins.getText()));
                    ps.setString(2,txt_matricula_educoins.getText());
                    ps.execute();
            }catch (Exception e){
                    e.printStackTrace();
                }
            mostrarLista();
    }

    @FXML
    void RetirarEduCoins(ActionEvent event) {
        String cmdBanco = "UPDATE tb_aluno SET Saldo = Saldo - ? WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(cmdBanco);
                    ps.setInt(1,Integer.parseInt(txt_educoins.getText()));
                    ps.setString(2,txt_matricula_educoins.getText());
                    ps.execute();
            }catch (Exception e){
                    e.printStackTrace();
                }
            mostrarLista();
    }
    
}
