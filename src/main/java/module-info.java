module com.example.juegazo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.juegazo to javafx.fxml;
    exports com.example.juegazo;
    exports com.example.juegazo.Controladores;
    opens com.example.juegazo.Controladores to javafx.fxml;
}