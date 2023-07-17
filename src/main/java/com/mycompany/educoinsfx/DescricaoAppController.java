
package com.mycompany.educoinsfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class DescricaoAppController{
    
    @FXML
    private Button btn_Voltar;

    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
}
