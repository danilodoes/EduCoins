
package com.mycompany.educoinsfx;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




/**
 *  27/05/2023
 *
 * @author Danilo
 */
public class ModalController  {
        
    
    public void ModalSucesso (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modal.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("");
                       
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
    }
    
    public void ModalErro (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalerro.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
    }
    
    public void ModalDadoNaoEncontrado (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modaldadonaoencontrado.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    
    public void ModalListarAluno (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listaraluno.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Alunos");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    public void ModalListarEducador (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listareducador.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Educadores");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    public void ModalListarTurma (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarturma.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Turmas");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    public void ModalListarParceiro (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarparceiro.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Parceiros");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    public void ModalListarRecompensa (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarrecompensa.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Recompensas");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    public void ModalListarAdmin (){
        try {
                       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listaradmin.fxml"));
                       Parent root1 = (Parent) fxmlLoader.load();
                       Stage stage = new Stage();
                       stage.initStyle(StageStyle.UTILITY);
                       stage.setTitle("Listagem de Administradores");
                       stage.setScene(new Scene(root1));
                       stage.show();
                 } catch (Exception e) {
                        System.out.println("ERRO");
                 }
        
    }
    
    
}
