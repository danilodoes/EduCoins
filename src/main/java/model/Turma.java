package model;
import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Turma {
    
    private String CodTurma;

    public Turma(String CodTurma) {
        this.CodTurma = CodTurma;
    }

    public String getCodTurma() {
        return CodTurma;
    }

    public void setCodTurma(String CodTurma) {
        this.CodTurma = CodTurma;
    }
    
   

    public void createTurma(String codturma) {
        ModalController mc = new ModalController();
        String sql = "INSERT INTO tb_turma (CodTurma) VALUES (?)";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,codturma);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                        e.printStackTrace(); 
                    }    
    }
    
    public void updateTurma(String codturma, String novocodturma ){
        ModalController mc = new ModalController ();
        String sql = "UPDATE tb_turma SET CodTurma = ? WHERE CodTurma = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obterConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,novocodturma); 
        ps.setString(2,codturma);
        ps.execute();
        mc.ModalSucesso();
        }
        catch (Exception e){
          mc.ModalErro();
            e.printStackTrace();
        }
    }
  
    public void deleteTurma(String codturma) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_turma WHERE CodTurma = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obterConexao()){
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,codturma);
        ps.execute();
        mc.ModalSucesso();
        }
        catch (Exception e){
          mc.ModalErro();
            e.printStackTrace();
        }
        
    }
    
    public void readTurma() {
        ModalController mc = new ModalController ();
        mc.ModalListarTurma();
    }

   
}