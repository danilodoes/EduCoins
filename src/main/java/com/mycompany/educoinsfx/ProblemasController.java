package com.mycompany.educoinsfx;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProblemasController {

    @FXML
    private Button btn_Enviar;

    @FXML
    private Button btn_Voltar;

    @FXML
    private TextField txt_Assunto;

    @FXML
    private TextArea txt_Descricao;

    @FXML
    private TextField txt_Email;

    @FXML
    void irPara(ActionEvent event) throws IOException{
        App.setRoot("login");
    }
}
