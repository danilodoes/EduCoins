package com.mycompany.educoinsfx;


import dao.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *@author Danilo
 * 14/05/2022 
 */
public class LoginController {
    
    ModalController mc = new ModalController ();
        
    @FXML
    private Button btn_Login;

    @FXML
    private Hyperlink lb_esqueciSenha;

    @FXML
    private MenuButton mn_btn_Opcoes;

    @FXML
    private TextField txt_Mat;

    @FXML
    private PasswordField txt_Senha;

    @FXML
    private RadioButton rb_Admin;

    @FXML
    private RadioButton rb_Aluno;

    @FXML
    private RadioButton rb_Educador;
    
    @FXML
    void logar() throws IOException, Exception {                
       
       
        daoUsuario DAO = new daoUsuario();
        boolean login = DAO.login(getMatricula(), getSenha(), getGrupoValue());
        
        if (login) {
            String menu = getGrupoValue();
            App.setRoot(menu);
        }else {
            mc.ModalDadoNaoEncontrado();
        }       
    }
    
    @FXML
    void irParaLGPD(ActionEvent event) throws IOException {
       App.setRoot("lgpd");
    }
    
    @FXML
    void irParaDescricaoApp(ActionEvent event) throws IOException {
        App.setRoot ("descricaoApp");

    }
    @FXML
    void irParaProblemas(ActionEvent event) throws IOException {
        App.setRoot("problemas");
    }

    @FXML
    void irParaTrocarSenha(ActionEvent event) throws IOException {
        App.setRoot("trocarSenha");

    }
    @FXML
    void irParaEsqueciSenha(ActionEvent event) throws IOException {
        App.setRoot("esqueciSenha");

    }

    public String getMatricula(){
        return txt_Mat.getText();
    }
    
    public String getSenha(){
        return txt_Senha.getText();
    }
    
    public String getGrupoValue(){
        if(rb_Admin.isSelected()){
            return "admin";
             
        }else if(rb_Aluno.isSelected()){
            return "aluno";
            
        }else if(rb_Educador.isSelected()){
            return "educador";
            
        }else{
            return "";
        }  
    }
}
