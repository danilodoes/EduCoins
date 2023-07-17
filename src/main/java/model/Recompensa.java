
package model;

import com.mycompany.educoinsfx.ModalController;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Recompensa {
    
    public String NomeParceiro, PK_Recompensa, Preco;

    public Recompensa(String NomeParceiro, String PK_Recompensa, String Preco) {
        this.NomeParceiro = NomeParceiro;
        this.PK_Recompensa = PK_Recompensa;
        this.Preco = Preco;
    }

    public String getNomeParceiro() {
        return NomeParceiro;
    }

    public void setNomeParceiro(String NomeParceiro) {
        this.NomeParceiro = NomeParceiro;
    }

    public String getPK_Recompensa() {
        return PK_Recompensa;
    }

    public void setPK_Recompensa(String PK_Recompensa) {
        this.PK_Recompensa = PK_Recompensa;
    }

    public String getPreco() {
        return Preco;
    }

    public void setPreco(String Preco) {
        this.Preco = Preco;
    }
    
    

    
    public void createRecompensa(String nomeParceiro, String recompensa, String preco) {
        ModalController mc = new ModalController ();
        String sql = "INSERT INTO tb_recompensa (NomeParceiro, PK_Recompensa, Preco) VALUES (?, ?, ?)";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,nomeParceiro); 
                    ps.setString(2,recompensa);
                    ps.setString(3,preco); 
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                    }    
    }
    public void updateRecompensa(String nomeParceiro, String recompensa, String preco,String novaRecompensa,String novoPreco) {
        ModalController mc = new ModalController ();
        String sql = "UPDATE tb_recompensa SET PK_Recompensa = ?, Preco = ? WHERE PK_Recompensa = ?";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,novaRecompensa); 
                    ps.setString(2,novoPreco);
                    ps.setString(3,recompensa);
                   
                    
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                    }    
    }
    public void deleteRecompensa(String recompensa) {
        ModalController mc = new ModalController ();
        String sql = "DELETE FROM tb_recompensa WHERE PK_Recompensa = ?";
        ConnectionFactory factory = new ConnectionFactory(); 
             try (Connection c = factory.obterConexao()){ 
                    PreparedStatement ps = c.prepareStatement(sql); 
                    ps.setString(1,recompensa);
                    ps.execute();
                    mc.ModalSucesso();
                }catch (Exception e){
                    mc.ModalErro();
                    e.printStackTrace(); 
                    }    
    }
    public void readRecompensa() {
        ModalController mc = new ModalController ();
        mc.ModalListarRecompensa();
    }
    
}
