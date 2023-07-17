package model;
import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Parceiro {
    
    private String PK_Nome;

    public Parceiro(String PK_Nome) {
        this.PK_Nome = PK_Nome;
    }

    public String getPK_Nome() {
        return PK_Nome;
    }

    public void setPK_Nome(String PK_Nome) {
        this.PK_Nome = PK_Nome;
    }
    
    
 
    
    public void createParceiro(String nome) {
        ModalController mc = new ModalController ();
        String sql = "INSERT INTO tb_parceiro (PK_Nome) VALUES (?)";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,nome);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                    }    
    }

    public void updateParceiro(String nome, String novoNome) {
        ModalController mc = new ModalController ();
        String sql = "UPDATE tb_parceiro SET PK_Nome = ? WHERE PK_Nome = ?";
        ConnectionFactory factory = new ConnectionFactory();
                try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1,novoNome); 
                    ps.setString(2,nome);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
                    }
    }

    public void deleteParceiro(String nome) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_parceiro WHERE PK_Nome = ?";
        ConnectionFactory factory = new ConnectionFactory();
                try (Connection c = factory.obterConexao()){
                    PreparedStatement ps = c.prepareStatement(sql);
                    ps.setString(1,nome);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace();
                    }
    }

    public void readParceiro() {
        ModalController mc = new ModalController ();
        mc.ModalListarParceiro();
    }
}