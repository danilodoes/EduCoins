package model;
import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class Administrador {
    
    private String PK_Matricula, Senha, CPF, EMAIL;

    public Administrador(String PK_Matricula, String Senha, String CPF, String EMAIL) {
        this.PK_Matricula = PK_Matricula;
        this.Senha = Senha;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
   
    
    
    
   

    public void createAdministrador(String matricula, String senha, String cpf, String email) {
         ModalController mc = new ModalController();
        String sql = "INSERT INTO tb_admin (PK_Matricula, Senha, CPF, EMAIL) VALUES (?,?,?,?)";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1, matricula);
                    ps.setString(2,senha);
                    ps.setString(3,cpf);
                    ps.setString(4,email);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                        e.printStackTrace(); 
                    }
    }

    public void updateAdministrador(String matricula, String senha, String cpf, String email) {
        ModalController mc = new ModalController();
        String sql = "UPDATE tb_admin SET Senha = ?, CPF = ?, EMAIL = ? WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1, senha);
                    ps.setString(2,cpf);
                    ps.setString(3,email);
                    ps.setString(4,matricula);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                        e.printStackTrace(); 
                    }
    }
    
    public void deleteAdministrador(String matricula) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_admin WHERE PK_Matricula = ?";
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
    
    public void readAdministrador() {
        ModalController mc = new ModalController ();
        mc.ModalListarAdmin();
    }
}