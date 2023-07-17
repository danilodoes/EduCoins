package model;

import com.mycompany.educoinsfx.AdminController;
import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;




public class Aluno{
    
   private String PK_Matricula, Senha, CodTurma;
   private int Saldo;

    public Aluno(String PK_Matricula, String Senha, String CodTurma, int Saldo) {
        this.PK_Matricula = PK_Matricula;
        this.Senha = Senha;
        this.CodTurma = CodTurma;
        this.Saldo = Saldo;
    }

    public String getPK_Matricula() {
        return PK_Matricula;
    }

    public void setPK_Matricula(String PK_Matricula) {
        this.PK_Matricula = PK_Matricula;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCodTurma() {
        return CodTurma;
    }

    public void setCodTurma(String CodTurma) {
        this.CodTurma = CodTurma;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    


    public void createAluno(String matricula, String senha, String turma, int saldo) {
        ModalController mc = new ModalController ();
        String sql = "INSERT INTO tb_aluno (PK_Matricula, Senha, CodTurma, Saldo) VALUES (?, ?, ?, ?)";
        ConnectionFactory factory = new ConnectionFactory(); 
            try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,matricula);
                    ps.setString(2,senha);
                    ps.setString(3,turma);
                    ps.setDouble(4,saldo);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                }  
    }
    
    public void updateAluno(String matricula, String senha, String turma, int saldo){
        ModalController mc = new ModalController ();
        String sql = "UPDATE tb_aluno SET Senha = ?, CodTurma = ?, Saldo = ? WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1,senha);
                    ps.setString(2,turma);
                    ps.setInt(3,saldo);
                    ps.setString(4,matricula);
                    ps.execute();
                    mc.ModalSucesso();
            }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
            }
    }
    
    public void deleteAluno(String matricula) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_aluno WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                   PreparedStatement ps = c.prepareStatement(sql);
                   ps.setString(1, matricula);
                   ps.execute();
                   mc.ModalSucesso();
            }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
            }
    }
    
    public void readAluno() {
        ModalController mc = new ModalController ();
        mc.ModalListarAluno();
    }
}