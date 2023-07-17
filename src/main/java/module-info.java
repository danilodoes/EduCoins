
module com.mycompany.educoinsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.mycompany.educoinsfx to javafx.fxml;
    opens model to javafx.base;
    exports com.mycompany.educoinsfx;
}
