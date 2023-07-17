/**
 * 21/05/2023
 * @author Danilo
 */
package com.mycompany.educoinsfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EsqueciSenhaController {

    @FXML
    private Button btn_Cancelar;

    @FXML
    private Button btn_OK;

    @FXML
    private TextField txt_Mat;

    @FXML
    private TextField txt_Nome;

    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

}
