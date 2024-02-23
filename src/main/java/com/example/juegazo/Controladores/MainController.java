package com.example.juegazo.Controladores;

import com.example.juegazo.HelloApplication;
import com.example.juegazo.Modelos.TocaDiscos;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private AnchorPane fondo = new AnchorPane();
    @FXML
    private ImageView imagenDeFondo;
    @FXML
    private Button btnMute, btnPelear;
    private TocaDiscos tocaDiscos;
    private boolean muteado;

    public boolean isMuteado() {
        return muteado;
    }

    public void setMuteado(boolean muteado) {
        this.muteado = muteado;

        if (this.muteado){
            btnMute.setGraphic(cargarImagen("/botones/SonidoDesactivado.png"));
            tocaDiscos.setMuteado(true);
            tocaDiscos.getClip().stop();
        }else {
            btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));
        }
    }

    public TocaDiscos getTocaDiscos() {
        return tocaDiscos;
    }

    public void setTocaDiscos(TocaDiscos tocaDiscos) {
        this.tocaDiscos = tocaDiscos;
    }

    public ImageView cargarImagen(String imagen){
        Image image = new Image(getClass().getResource(imagen).toExternalForm());
        return new ImageView(image);
    }

    @FXML
    public void mute(ActionEvent event){
        if (!muteado){
            btnMute.setGraphic(cargarImagen("/botones/SonidoDesactivado.png"));
            muteado = true;
        }else {
            btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));
            muteado = false;
        }
        tocaDiscos.mutear();
    }

    @FXML
    public void cambiarPantallaSeleccion (){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaSeleccion.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
            Stage esteStage = (Stage) this.btnPelear.getScene().getWindow();
            esteStage.close();
            SeleccionController controller = fxmlLoader.getController();
            controller.setMuteado(muteado);
            tocaDiscos.detenerMusica();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void scaleA (MouseEvent event){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), this.btnPelear);
        scaleTransition.setToY(1.1);
        scaleTransition.setToX(1.1);
        scaleTransition.play();
    }

    @FXML
    public void scaleD (MouseEvent event){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), this.btnPelear);
        scaleTransition.setToY(1.0);
        scaleTransition.setToX(1.0);
        scaleTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imagenDeFondo = cargarImagen("/fondos/fondoNNT.jpg");

        imagenDeFondo.fitWidthProperty().bind(fondo.widthProperty());
        imagenDeFondo.fitHeightProperty().bind(fondo.heightProperty());

        fondo.getChildren().add(imagenDeFondo);
        imagenDeFondo.toBack();

        fondo.getStylesheets().add("estilos.css");

        tocaDiscos = new TocaDiscos();
        tocaDiscos.iniciar("src/main/resources/musica/Howling.wav");
        btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));

        this.btnPelear.setGraphic(cargarImagen("/botones/JoinGame.png"));

    }
}