package com.mycompany.educoinsfx;
import java.io.IOException;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class AdminController{
    
    @FXML
    private TextField txt_aluno_senha;

    @FXML
    private TextField txt_admin_cpf;

    @FXML
    private TextField txt_admin_email;

    @FXML
    private TextField txt_admin_matricula;

    @FXML
    private TextField txt_admin_senha;

    @FXML
    private TextField txt_aluno_matricula;

    @FXML
    private TextField txt_aluno_turma;
    
    @FXML
    private TextField txt_aluno_saldo;

    @FXML
    private TextField txt_educador_matricula;

    @FXML
    private TextField txt_educador_rg;

    @FXML
    private TextField txt_educador_senha;

    @FXML
    private TextField txt_educador_setor;

    @FXML
    private TextField txt_educador_turma;

    @FXML
    private TextField txt_parceiro_nome;
    
    @FXML
    private TextField txt_parceiro_nomenovo;

    @FXML
    private TextField txt_recompensa_item;
    
    @FXML
    private TextField txt_recompensa_itemnovo;

    @FXML
    private TextField txt_recompensa_nomeparceiro;

    @FXML
    private TextField txt_recompensa_preco;
    
    @FXML
    private TextField txt_recompensa_preconovo;

    @FXML
    private TextField txt_turma_codigo;  
    
    @FXML
    private TextField txt_turma_codigonovo;
    
    
    

    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");
       
    }
    
    
/**
* INÍCIO CRUD (CREATE - READ - UPDATE - DELETE)
*
*/
   
    
    public String getAlunoMatricula (){
       return txt_aluno_matricula.getText();
    }    
    public String getAlunoSenha (){
       return txt_aluno_senha.getText();
    }
    public String getAlunoTurma(){
       return txt_aluno_turma.getText();
    }
     public int getAlunoSaldo(){
       return Integer.parseInt(txt_aluno_saldo.getText());
    }
     

 
    
    public String getEducadorMatricula(){
        return txt_educador_matricula.getText();
    }
    public String getEducadorSenha(){
         return txt_educador_senha.getText();      
    }
    public String getEducadorSetor(){
         return txt_educador_setor.getText();
    }
    public String getEducadorRG(){
         return txt_educador_rg.getText();
    }
    public String getEducadorTurma(){
         return txt_educador_turma.getText();
    }
     
     
     
    public String getTurmaCodTurma(){
         return txt_turma_codigo.getText();
     }
    public String getTurmaNovoCodTurma(){
         return txt_turma_codigonovo.getText();
     }
     
     
     
    public String getParceiroNome(){
        return txt_parceiro_nome.getText();
    }
    public String getParceiroNovoNome(){
         return txt_parceiro_nomenovo.getText();
     }
     
     
     
    public String getRecompensaNomeParceiro(){
        return txt_recompensa_nomeparceiro.getText();
    }
    public String getRecompensaItem(){
        return txt_recompensa_item.getText();
    }
    public String getRecompensaPreco(){
        return txt_recompensa_preco.getText();
    }
     public String getRecompensaNovoPreco(){
        return txt_recompensa_preconovo.getText();
    }
     public String getRecompensaNovaRecompensa(){
        return txt_recompensa_itemnovo.getText();
    }
     
     
     
    public String getAdminMatricula(){
        return txt_admin_matricula.getText();
    }
    public String getAdminSenha(){
        return txt_admin_senha.getText();
    }
    public String getAdminCPF(){
        return txt_admin_cpf.getText();
    }
    public String getAdminEmail(){
        return txt_admin_email.getText();
    }
    
     //CREATE 
    
    @FXML
    void createAluno() throws IOException {
        Aluno aluno = new Aluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(),getAlunoSaldo());
        aluno.createAluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(),getAlunoSaldo());
    }
    
    @FXML
    void createEducador() throws IOException { 
        Educador educador = new Educador(getEducadorMatricula(), getEducadorSenha(), getEducadorSetor(), getEducadorRG(), getEducadorTurma());
        educador.createEducador(getEducadorMatricula(), getEducadorSenha(), getEducadorSetor(), getEducadorRG(), getEducadorTurma());
    }
    
    @FXML
    void createTurma() throws IOException { 
        Turma turma = new Turma(getTurmaCodTurma());
        turma.createTurma(getTurmaCodTurma());
    } 
    
    @FXML
    void createParceiro() throws IOException { 
        Parceiro parceiro = new Parceiro(getParceiroNome());
        parceiro.createParceiro(getParceiroNome());
    } 
    
    @FXML
    void createRecompensa() throws IOException { 
        Recompensa recompensa = new Recompensa(getParceiroNome(),getRecompensaItem(),getRecompensaPreco());
        recompensa.createRecompensa(getRecompensaNomeParceiro(), getRecompensaItem(), getRecompensaPreco());
    }
    
    @FXML
    void createAdmin() throws IOException { 
        Administrador admin = new Administrador(getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
        admin.createAdministrador (getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
    }
     
    
    //UPDATE
    
     @FXML
    void updateAluno() throws IOException {
        Aluno aluno = new Aluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(), getAlunoSaldo());
        aluno.updateAluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(),getAlunoSaldo());
    }
    
    @FXML
    void updateEducador() throws IOException { 
        Educador educador = new Educador(getEducadorMatricula(), getEducadorSenha(), getEducadorSetor(), getEducadorRG(), getEducadorTurma());
        educador.updateEducador(getEducadorMatricula(), getEducadorSenha(), getEducadorSetor(), getEducadorRG(), getEducadorTurma());
    }
    
    @FXML
    void updateTurma() throws IOException { 
        Turma turma = new Turma(getTurmaCodTurma());
        turma.updateTurma(getTurmaCodTurma(), getTurmaNovoCodTurma());
    } 
    
    @FXML
    void updateParceiro() throws IOException { 
        Parceiro parceiro = new Parceiro(getParceiroNome());
        parceiro.updateParceiro(getParceiroNome(),getParceiroNovoNome());
    } 
    
    
    @FXML
    void updateRecompensa() throws IOException { 
        Recompensa recompensa = new Recompensa(getParceiroNome(),getRecompensaItem(),getRecompensaPreco());
        recompensa.updateRecompensa(getRecompensaNomeParceiro(), getRecompensaItem(), getRecompensaPreco(),getRecompensaNovaRecompensa(), getRecompensaNovoPreco());
    }
    
    @FXML
    void updateAdmin() throws IOException { 
        Administrador admin = new Administrador(getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
        admin.updateAdministrador (getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
    }
    
    //DELETE
    
    @FXML
    void deleteAluno() throws IOException {
        Aluno aluno = new Aluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(),1);
        aluno.deleteAluno(getAlunoMatricula());
    }
    
    @FXML
    void deleteEducador() throws IOException { 
        Educador educador = new Educador(getEducadorMatricula(), getEducadorSenha(), getEducadorSetor(), getEducadorRG(), getEducadorTurma());
        educador.deleteEducador(getEducadorMatricula());
    }
    
    @FXML
    void deleteTurma() throws IOException { 
        Turma turma = new Turma(getTurmaCodTurma());
        turma.deleteTurma(getTurmaCodTurma());
    } 
    
    @FXML
    void deleteParceiro() throws IOException { 
        Parceiro parceiro = new Parceiro(getParceiroNome());
        parceiro.deleteParceiro(getParceiroNome());
    } 
    
   
    @FXML
    void deleteRecompensa() throws IOException { 
        Recompensa recompensa = new Recompensa(getParceiroNome(),getRecompensaItem(),getRecompensaPreco());
        recompensa.deleteRecompensa(getRecompensaItem());
    }
    
    @FXML
    void deleteAdmin() throws IOException { 
        Administrador admin = new Administrador(getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
        admin.deleteAdministrador (getAdminMatricula());
    }
    
    //READ
    
      
    @FXML
    void readAluno() throws IOException {
        Aluno aluno = new Aluno(getAlunoMatricula(),getAlunoSenha(),getAlunoTurma(),1);
        aluno.readAluno();
    }
    
    
    @FXML
    void readEducador() throws IOException { 
        Educador educador = new Educador(getEducadorMatricula(), null, null, null, null);
        educador.readEducador();
    }
    

    @FXML
    void readTurma() throws IOException { 
        Turma turma = new Turma(getTurmaCodTurma());
        turma.readTurma();
    } 
   
    @FXML
    void readParceiro() throws IOException { 
        Parceiro parceiro = new Parceiro(getParceiroNome());
        parceiro.readParceiro();
    } 
    
    
    
    @FXML
    void readRecompensa() throws IOException { 
        Recompensa recompensa = new Recompensa(getParceiroNome(),getRecompensaItem(),getRecompensaPreco());
        recompensa.readRecompensa();
    }
    
    
    @FXML
    void readAdmin() throws IOException { 
        Administrador admin = new Administrador(getAdminMatricula(), getAdminSenha(), getAdminCPF(), getAdminEmail());
        admin.readAdministrador();
    }
    
    
     
}