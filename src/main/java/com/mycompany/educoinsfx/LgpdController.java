
package com.mycompany.educoinsfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Danilo
 */
public class LgpdController{
    @FXML
    private Button btn_OK;

    @FXML
    private Label lbl_LGPD;
    
    @FXML
    void irPara(ActionEvent event) throws IOException {
        App.setRoot("login");

    }
    
}
