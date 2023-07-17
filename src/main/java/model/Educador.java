package model;
import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;



public class Educador  {
    
    private String PK_Matricula, Senha, Setor, RG, CodTurma;

    public Educador(String PK_Matricula, String Senha, String Setor, String RG, String CodTurma) {
        this.PK_Matricula = PK_Matricula;
        this.Senha = Senha;
        this.Setor = Setor;
        this.RG = RG;
        this.CodTurma = CodTurma;
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

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCodTurma() {
        return CodTurma;
    }

    public void setCodTurma(String CodTurma) {
        this.CodTurma = CodTurma;
    }
    
    

    public void createEducador(String matricula, String senha, String setor, String rg, String turma) {
        ModalController mc = new ModalController ();
        String sql = "INSERT INTO tb_educador (PK_Matricula, Senha, Setor, RG, CodTurma) VALUES (?, ?, ?, ?, ?)";
        ConnectionFactory factory = new ConnectionFactory(); 
            try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,matricula); 
                    ps.setString(2,senha);
                    ps.setString(3,setor);
                    ps.setString(4,rg);
                    ps.setString(5,turma);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                    }    
    }
    
    public void updateEducador(String matricula, String senha, String setor, String rg, String turma) {
        ModalController mc = new ModalController ();
        String sql = "UPDATE tb_educador SET Senha = ?, Setor = ? , RG = ?, CodTurma = ? WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1,senha);
                    ps.setString(2,setor);
                    ps.setString(3,rg);
                    ps.setString(4,turma);
                    ps.setString(5,matricula);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
                }
    }
    
    public void deleteEducador(String matricula) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_educador WHERE PK_Matricula = ?";
        ConnectionFactory factory = new ConnectionFactory();
            try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1,matricula);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
                }
    }

  
    public void readEducador() {
        ModalController mc = new ModalController ();
        mc.ModalListarEducador();
    }

}