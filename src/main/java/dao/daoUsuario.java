
package dao;

import java.sql.*;



public class daoUsuario   {
   
    
    ConnectionFactory factory = new ConnectionFactory();
        
    
    public boolean login (String matricula, String senha, String type) throws Exception {
        
        String tabela = "tb_admin";
        switch (type) {
            case "admin":
                tabela = "tb_admin";
                break;
            case "aluno":
                tabela = "tb_aluno";            
                break;
            case "educador":
                tabela = "tb_educador";
                break;
            default:
                break;
        }
        String sql = "SELECT * FROM " + tabela +" WHERE PK_Matricula = ? AND Senha = ?";
            try (Connection conn = factory.obterConexao()){
            PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, matricula);
             ps.setString(2, senha);
                ResultSet rs = ps.executeQuery();
                    return rs.next();
        } catch (SQLException e){
            e.printStackTrace();
        } return false;        
    }

}

