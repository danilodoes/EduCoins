package com.mycompany.educoinsfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
/**
 * 21/05/2023
 *
 * @author Danilo
 */
public class TrocarSenhaController  {

   @FXML
    private Button btn_Cancelar;

    @FXML
    private Button btn_OK;

    @FXML
    private TextField txt_ConfirmarSenhaNova;

    @FXML
    private TextField txt_Mat;

    @FXML
    private TextField txt_SenhaAntiga;

    @FXML
    private TextField txt_SenhaNova;

    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");

    }
    
}
