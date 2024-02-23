package com.example.juegazo.Controladores;

import com.example.juegazo.HelloApplication;
import com.example.juegazo.Modelos.Personaje;
import com.example.juegazo.Modelos.TocaDiscos;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class PeleaController implements Initializable {

    @FXML
    private ImageView imgFondo, imgPj1, imgPj2, imgLanzamientoPj1, imgLanzamientoPj2;
    @FXML
    private AnchorPane fondo;
    @FXML
    private ProgressBar vidaPj1, vidaPj2, cargaPj1, cargaPj2;
    @FXML
    private Text nomPj1, nomPj2;
    @FXML
    private Button btnVolver, btnSuperPj1, btnSuperPj2, btnAtaque1Pj1, btnAtaque1Pj2, btnAtaque2Pj1, btnAtaque2Pj2, btnMute;
    @FXML
    private Rectangle negro;
    private Personaje pj1, pj2;
    private TocaDiscos tocaDiscos;
    private boolean muteado;

    public void setMuteado(boolean muteado) {
        this.muteado = muteado;

        if (this.muteado){
            this.btnMute.setGraphic(cargarImagen("/botones/SonidoDesactivado.png"));
            this.tocaDiscos.setMuteado(true);
            this.tocaDiscos.getClip().stop();
        }else {
            this.btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));
        }
    }

    @FXML
    public void mute(ActionEvent event){
        if (!this.muteado){
            this.btnMute.setGraphic(cargarImagen("/botones/SonidoDesactivado.png"));
            this.muteado = true;
        }else {
            this.btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));
            this.muteado = false;
        }
        this.tocaDiscos.mutear();
    }

    public void setInicio (ImageView img, Personaje pj1, Personaje pj2){
        imgFondo.setImage(img.getImage());

        this.pj1 = pj1;
        this.nomPj1.setText(pj1.getNombre());
        this.pj1.resetImgPjs(imgPj1);

        if (this.pj1.getNombre().equals("KING")){
            this.pj1.setImg(imgLanzamientoPj1, "Lanza.png", 65, 460);

        }

        this.pj2 = pj2;
        this.nomPj2.setText(pj2.getNombre());
        this.pj2.resetImgPjs(imgPj2);

        if (this.pj2.getNombre().equals("KING")){
            this.pj2.setImg(imgLanzamientoPj2, "Lanza.png", 1475, 460);
            this.imgLanzamientoPj2.setLayoutX(1475 - this.imgLanzamientoPj2.getFitWidth());
        }
    }

    private ImageView cargarImagen(String imagen){
        Image image = new Image(getClass().getResource(imagen).toExternalForm());
        return new ImageView(image);
    }

    public void inicioRandom (){
        Random random = new Random();
        int r = random.nextInt(1, 3);
        if (r == 1){
            this.btnAtaque1Pj2.setDisable(true);
            this.btnAtaque2Pj2.setDisable(true);
        }else {
            this.btnAtaque1Pj1.setDisable(true);
            this.btnAtaque2Pj1.setDisable(true);
        }
    }

    public void btnPj1Disable (boolean b){
        this.btnAtaque1Pj1.setDisable(b);
        this.btnAtaque2Pj1.setDisable(b);

        if (cargaPj1.getProgress() >= 1){
            this.btnSuperPj1.setDisable(b);
        }
    }

    public void btnPj2Disable (boolean b){
        this.btnAtaque1Pj2.setDisable(b);
        this.btnAtaque2Pj2.setDisable(b);

        if (cargaPj2.getProgress() >= 1){
            this.btnSuperPj2.setDisable(b);
        }
    }

    public void fundidoNegro (){
        if (this.vidaPj1.getProgress() == 0 || vidaPj2.getProgress() == 0) {
            this.negro.setWidth(1540);
            this.negro.setHeight(845);

            this.negro.setFill(Color.BLACK);
            this.negro.setOpacity(0);

            this.negro.setLayoutX(0);
            this.negro.setLayoutY(0);
            this.negro.toFront();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), this.negro);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1);

            fadeTransition.setOnFinished(event -> {
                obtenerGanador();
                volver();
            });

            fadeTransition.play();
        }
    }

    public void obtenerGanador (){
        System.out.println("");
        if (this.vidaPj1.getProgress() == 0){
            System.out.println("*****EL GANADOR ES PJ2: " + this.pj2.getNombre() + "*****");
        } else if (this.vidaPj2.getProgress() == 0){
            System.out.println("*****EL GANADOR ES PJ1: " + this.pj1.getNombre() + "*****");
        }
    }

    @FXML
    public void ataque1 (){
        btnPj1Disable(true);
        int p = 0;

        switch (this.pj1.getNombre()){
            case "MELIODAS":
                p = this.pj1.meliodasAtaque1(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "DIANE":
                p = this.pj1.dianeAtaque1(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "BAN":
                p = this.pj1.banAtaque1(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "KING":
                p = this.pj1.kingAtaque1(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "GOWTHER":
                p = this.pj1.gowtherAtaque1(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "MERLIN":
                p = this.pj1.merlinAtaque1(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "ESCANOR":
                p = this.pj1.escanorAtaque1(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;
        }

        this.cargaPj1.setProgress(this.cargaPj1.getProgress() + 0.34);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj2Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void ataque1R (){
        btnPj2Disable(true);
        int p = 0;

        switch (this.pj2.getNombre()){
            case "MELIODAS":
                p = this.pj2.meliodasAtaque1R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "DIANE":
                p = this.pj2.dianeAtaque1R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "BAN":
                p = this.pj2.banAtaque1R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "KING":
                p = this.pj2.kingAtaque1R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "GOWTHER":
                p = this.pj2.gowtherAtaque1R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "MERLIN":
                p = this.pj2.merlinAtaque1R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "ESCANOR":
                p = this.pj2.escanorAtaque1R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;
        }

        this.cargaPj2.setProgress(this.cargaPj2.getProgress() + 0.34);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj1Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void ataque2 (){
        btnPj1Disable(true);
        int p = 0;

        switch (this.pj1.getNombre()){
            case "MELIODAS":
                p = this.pj1.meliodasAtaque2(this.imgPj1, this.imgPj2, this.imgLanzamientoPj1, this.vidaPj2, this.pj2);
                break;

            case "DIANE":
                p = this.pj1.dianeAtaque2(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "BAN":
                p = this.pj1.banAtaque2(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "KING":
                p = this.pj1.kingAtaque2(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "GOWTHER":
                p = this.pj1.gowtherAtaque2(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "MERLIN":
                p = this.pj1.merlinAtaque2(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;

            case "ESCANOR":
                p = this.pj1.escanorAtaque2(this.imgPj1, this.imgPj2, this.vidaPj2, this.pj2);
                break;
        }

        this.cargaPj1.setProgress(this.cargaPj1.getProgress() + 0.34);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj2Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void ataque2R (){
        btnPj2Disable(true);
        int p = 0;

        switch (this.pj2.getNombre()){
            case "MELIODAS":
                p = this.pj2.meliodasAtaque2R(this.imgPj2, this.imgPj1, this.imgLanzamientoPj2, this.vidaPj1, this.pj1);
                break;

            case "DIANE":
                p = this.pj2.dianeAtaque2R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "BAN":
                p = this.pj2.banAtaque2R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "KING":
                p = this.pj2.kingAtaque2R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "GOWTHER":
                p = this.pj2.gowtherAtaque2R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "MERLIN":
                p = this.pj2.merlinAtaque2R(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "ESCANOR":
                p = this.pj2.escanorAtaque2R(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;
        }

        this.cargaPj2.setProgress(this.cargaPj2.getProgress() + 0.34);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj1Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void superAtaque (){
        btnPj1Disable(true);
        int p = 0;

        switch (pj1.getNombre()){
            case "MELIODAS":
                p = this.pj1.meliodasSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "DIANE":
                p = this.pj1.dianeSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "BAN":
                p = this.pj1.banSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "KING":
                p = this.pj1.kingSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "GOWTHER":
                p = this.pj1.gowtherSuperAtaque(this.imgPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "MERLIN":
                p = this.pj1.merlinSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;

            case "ESCANOR":
                p = pj1.escanorSuperAtaque(this.imgPj1, this.imgLanzamientoPj1, this.imgPj2, this.vidaPj2, pj2);
                break;
        }

        this.cargaPj1.setProgress(0);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj2Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void superAtaqueR (){
        btnPj2Disable(true);
        int p = 0;

        switch (pj2.getNombre()){
            case "MELIODAS":
                p = this.pj2.meliodasSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, pj1);
                break;

            case "DIANE":
                p = this.pj2.dianeSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, pj1);
                break;

            case "BAN":
                p = this.pj2.banSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, pj1);
                break;

            case "KING":
                p = this.pj2.kingSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "GOWTHER":
                p = this.pj2.gowtherSuperAtaqueR(this.imgPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "MERLIN":
                p = this.pj2.merlinSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;

            case "ESCANOR":
                p = this.pj2.escanorSuperAtaqueR(this.imgPj2, this.imgLanzamientoPj2, this.imgPj1, this.vidaPj1, this.pj1);
                break;
        }


        this.cargaPj2.setProgress(0);

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(p));

        pauseTransition.setOnFinished(event -> {
            btnPj1Disable(false);

            fundidoNegro();
        });

        pauseTransition.play();
    }

    @FXML
    public void volver(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaSeleccion.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
            Stage esteStage = (Stage) this.btnVolver.getScene().getWindow();
            esteStage.close();
            SeleccionController controller = fxmlLoader.getController();
            controller.setMuteado(this.muteado);
            this.tocaDiscos.detenerMusica();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.imgFondo = cargarImagen("/fondos/BoarHat.png");

        this.imgFondo.fitWidthProperty().bind(this.fondo.widthProperty());
        this.imgFondo.fitHeightProperty().bind(this.fondo.heightProperty());

        this.fondo.getChildren().add(this.imgFondo);
        this.imgFondo.toBack();

        this.vidaPj1.setProgress(1);

        this.vidaPj2.setProgress(1);
        this.vidaPj2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        this.cargaPj2.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        this.fondo.getStylesheets().add("estilos.css");

        this.tocaDiscos = new TocaDiscos();
        tocaDiscos.iniciar("src/main/resources/musica/PerfectTime.wav");

        this.btnVolver.setGraphic(cargarImagen("/botones/flechaVolver.png"));
        this.btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));

        this.btnSuperPj1.setDisable(true);
        this.btnSuperPj2.setDisable(true);

        inicioRandom();
    }
}
