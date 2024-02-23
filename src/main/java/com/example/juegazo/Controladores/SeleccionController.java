package com.example.juegazo.Controladores;

import com.example.juegazo.HelloApplication;
import com.example.juegazo.Modelos.Personaje;
import com.example.juegazo.Modelos.TocaDiscos;
import javafx.animation.FadeTransition;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SeleccionController implements Initializable {

    @FXML
    private Button btnMute, btnVolver, btnMeliodasPj1, btnDianePj1, btnBanPj1, btnKingPj1, btnGowtherPj1, btnMerlinPj1,
            btnEscanorPj1, btnMeliodasPj2, btnDianePj2, btnBanPj2, btnKingPj2, btnGowtherPj2, btnMerlinPj2, btnEscanorPj2,
            btnPelear, btnSiguiente, btnAnterior;
    @FXML
    private ImageView imgPj1, imgPj2, imagenDeFondo, imgEstadio;
    @FXML
    private AnchorPane fondo;
    private TocaDiscos tocaDiscos;
    private boolean muteado, pj1Select = false, pj2Select = false;
    private Image [] estadios;
    private int pos = 0;
    private ArrayList<Button> pjs1, pjs2;
    private String nomPj1, nomPj2;

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
    public void verPersonaje1 (MouseEvent event){
        Button button = (Button) event.getSource();
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
        scaleTransition.setToY(1.1);
        scaleTransition.setToX(1.1);
        scaleTransition.play();

        if (!this.pj1Select) {
            setImgPj1();
        }
    }

    @FXML
    public void resetImagen1 (MouseEvent event){
        if (!this.pj1Select) {
            this.imgPj1.setImage(null);
            Button button = (Button) event.getSource();
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
            scaleTransition.setToY(1.0);
            scaleTransition.setToX(1.0);
            scaleTransition.play();
        }else {
            embellecedor(this.pjs1);
        }
    }

    @FXML
    public void verPersonaje2 (MouseEvent event){
        Button button = (Button) event.getSource();
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
        scaleTransition.setToY(1.1);
        scaleTransition.setToX(1.1);
        scaleTransition.play();

        if (!this.pj2Select) {
            setImgPj2();
        }
    }

    @FXML
    public void resetImagen2 (MouseEvent event){
        if (!this.pj2Select) {
            this.imgPj2.setImage(null);
            Button button = (Button) event.getSource();
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);
            scaleTransition.setToY(1.0);
            scaleTransition.setToX(1.0);
            scaleTransition.play();
        }else {
            embellecedor(this.pjs2);
        }
    }

    @FXML
    public void selectPj1 (ActionEvent event){
        this.pj1Select = true;

        setImgPj1();

        embellecedor(this.pjs1);

        botonPeleaAparece();
    }

    @FXML
    public void selectPj2 (ActionEvent event){
        this.pj2Select = true;

        setImgPj2();

        embellecedor(this.pjs2);

        botonPeleaAparece();
    }

    private void botonPeleaAparece (){
        if (this.pj1Select && this.pj2Select) {
            this.btnPelear.setVisible(true);

            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), this.btnPelear);
            scaleTransition.setToY(1.1);
            scaleTransition.setToX(1.1);
            scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
            scaleTransition.setAutoReverse(true);

            scaleTransition.play();
        }
    }

    private void embellecedor(ArrayList<Button> arrayBotones) {
        for (Button b : arrayBotones){
            if (!b.isFocused()){
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), b);
                scaleTransition.setToY(1.0);
                scaleTransition.setToX(1.0);
                scaleTransition.play();
            }
        }
    }

    private void setImgPj1 (){
        if (this.btnMeliodasPj1.isHover()) {
            this.imgPj1.setY(168);
            this.imgPj1.setX(100);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesMeliodas/Parado.gif").toExternalForm()));
            this.nomPj1 = "Meliodas";
        } else if (this.btnDianePj1.isHover()) {
            this.imgPj1.setY(163);
            this.imgPj1.setX(92);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesDiane/Parado.gif").toExternalForm()));
            this.nomPj1 = "Diane";
        } else if (this.btnBanPj1.isHover()) {
            this.imgPj1.setY(124);
            this.imgPj1.setX(90);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesBan/Parado.gif").toExternalForm()));
            this.nomPj1 = "Ban";
        } else if (this.btnKingPj1.isHover()) {
            this.imgPj1.setY(167);
            this.imgPj1.setX(100);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesKing/Parado.gif").toExternalForm()));
            this.nomPj1 = "King";
        } else if (this.btnGowtherPj1.isHover()) {
            this.imgPj1.setY(180);
            this.imgPj1.setX(85);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesGowther/Parado.gif").toExternalForm()));
            this.nomPj1 = "Gowther";
        } else if (this.btnMerlinPj1.isHover()) {
            this.imgPj1.setY(105);
            this.imgPj1.setX(100);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesMerlin/Parado.gif").toExternalForm()));
            this.nomPj1 = "Merlin";
        } else if (this.btnEscanorPj1.isHover()) {
            this.imgPj1.setY(0);
            this.imgPj1.setX(45);
            this.imgPj1.setImage(new Image(getClass().getResource("/spritesEscanor/Parado.gif").toExternalForm()));
            this.nomPj1 = "Escanor";
        }

        this.imgPj1.setFitHeight(this.imgPj1.getImage().getHeight());
        this.imgPj1.setFitWidth(this.imgPj1.getImage().getWidth());
    }

    private void setImgPj2 (){
        if (this.btnMeliodasPj2.isHover()) {
            this.imgPj2.setY(168);
            this.imgPj2.setX(-28);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesMeliodas/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Meliodas";
        } else if (this.btnDianePj2.isHover()) {
            this.imgPj2.setY(163);
            this.imgPj2.setX(0);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesDiane/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Diane";
        } else if (this.btnBanPj2.isHover()) {
            this.imgPj2.setY(124);
            this.imgPj2.setX(0);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesBan/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Ban";
        } else if (this.btnKingPj2.isHover()) {
            this.imgPj2.setY(167);
            this.imgPj2.setX(10);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesKing/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "King";
        } else if (this.btnGowtherPj2.isHover()) {
            this.imgPj2.setY(180);
            this.imgPj2.setX(30);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesGowther/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Gowther";
        } else if (this.btnMerlinPj2.isHover()) {
            this.imgPj2.setY(105);
            this.imgPj2.setX(-45);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesMerlin/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Merlin";
        } else if (this.btnEscanorPj2.isHover()) {
            this.imgPj2.setY(0);
            this.imgPj2.setX(-70);
            this.imgPj2.setImage(new Image(getClass().getResource("/spritesEscanor/ParadoR.gif").toExternalForm()));
            this.nomPj2 = "Escanor";
        }

        this.imgPj2.setFitHeight(this.imgPj2.getImage().getHeight());
        this.imgPj2.setFitWidth(this.imgPj2.getImage().getWidth());
    }

    private ImageView cargarImagen(String imagen){
        Image image = new Image(getClass().getResource(imagen).toExternalForm());
        return new ImageView(image);
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

    @FXML
    public void cambiarPantallaPelea (){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PantallaPelea.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
            Stage esteStage = (Stage) this.btnPelear.getScene().getWindow();
            esteStage.close();
            PeleaController controller = fxmlLoader.getController();
            Personaje pj1 = new Personaje(this.nomPj1, true);
            Personaje pj2 = new Personaje(this.nomPj2, false);
            controller.setInicio(this.imgEstadio, pj1, pj2);
            controller.setMuteado(this.muteado);
            this.tocaDiscos.detenerMusica();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void volver(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
            Stage esteStage = (Stage) this.btnVolver.getScene().getWindow();
            esteStage.close();
            MainController controller = fxmlLoader.getController();
            controller.setMuteado(this.muteado);
            this.tocaDiscos.detenerMusica();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void siguienteEstadio (){
        this.pos = (this.pos + 1) % this.estadios.length;
        transicionFundido(this.estadios[this.pos]);
    }

    @FXML
    public void anteriorEstadio (){
        this.pos = (this.pos + 1) % this.estadios.length;
        transicionFundido(this.estadios[this.pos]);
    }

    private void transicionFundido(Image image) {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), this.imgEstadio);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        fadeTransition.setOnFinished(e -> {
            this.imgEstadio.setImage(image);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), this.imgEstadio);
            fadeTransition1.setFromValue(0.0);
            fadeTransition1.setToValue(1.0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(ev -> {
                this.btnSiguiente.setDisable(false);
                this.btnAnterior.setDisable(false);
            });
        });

        fadeTransition.play();
        this.btnSiguiente.setDisable(true);
        this.btnAnterior.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.pjs1 = new ArrayList<>(Arrays.asList(btnMeliodasPj1, btnDianePj1, btnBanPj1, btnKingPj1,
                btnGowtherPj1, btnMerlinPj1, btnEscanorPj1));

        this.pjs2 = new ArrayList<>(Arrays.asList(btnMeliodasPj2, btnDianePj2, btnBanPj2, btnKingPj2,
                btnGowtherPj2, btnMerlinPj2, btnEscanorPj2));

        this.fondo.getStylesheets().add("estilos.css");

        this.imagenDeFondo = cargarImagen("/fondos/FondoSeleccionPersonaje.jpg");

        this.imagenDeFondo.fitWidthProperty().bind(fondo.widthProperty());
        this.imagenDeFondo.fitHeightProperty().bind(fondo.heightProperty());

        this.fondo.getChildren().add(imagenDeFondo);
        this.imagenDeFondo.toBack();

        this.tocaDiscos = new TocaDiscos();
        tocaDiscos.iniciar("src/main/resources/musica/DoraGong4n.wav");

        this.btnVolver.setGraphic(cargarImagen("/botones/flechaVolver.png"));
        this.btnMute.setGraphic(cargarImagen("/botones/SonidoActivo.png"));

        this.btnMeliodasPj1.setGraphic(cargarImagen("/seBusca/seBuscaMeliodasA.png"));
        this.btnDianePj1.setGraphic(cargarImagen("/seBusca/seBuscaDianeA.png"));
        this.btnBanPj1.setGraphic(cargarImagen("/seBusca/seBuscaBanA.png"));
        this.btnKingPj1.setGraphic(cargarImagen("/seBusca/seBuscaKingA.png"));
        this.btnGowtherPj1.setGraphic(cargarImagen("/seBusca/seBuscaGowtherA.png"));
        this.btnMerlinPj1.setGraphic(cargarImagen("/seBusca/seBuscaMerlinA.png"));
        this.btnEscanorPj1.setGraphic(cargarImagen("/seBusca/seBuscaEscanorA.png"));

        this.btnMeliodasPj2.setGraphic(cargarImagen("/seBusca/seBuscaMeliodasA.png"));
        this.btnDianePj2.setGraphic(cargarImagen("/seBusca/seBuscaDianeA.png"));
        this.btnBanPj2.setGraphic(cargarImagen("/seBusca/seBuscaBanA.png"));
        this.btnKingPj2.setGraphic(cargarImagen("/seBusca/seBuscaKingA.png"));
        this.btnGowtherPj2.setGraphic(cargarImagen("/seBusca/seBuscaGowtherA.png"));
        this.btnMerlinPj2.setGraphic(cargarImagen("/seBusca/seBuscaMerlinA.png"));
        this.btnEscanorPj2.setGraphic(cargarImagen("/seBusca/seBuscaEscanorA.png"));

        this.btnPelear.setGraphic(cargarImagen("/botones/peleaboton.png"));
        this.btnPelear.setVisible(false);

        this.estadios = new Image[] {
                new Image(getClass().getResource("/fondos/BoarHat.png").toExternalForm()),
                new Image(getClass().getResource("/fondos/CampoGowther.png").toExternalForm()),
                new Image(getClass().getResource("/fondos/Vaizel.png").toExternalForm()),
        };

        this.btnSiguiente.setGraphic(cargarImagen("/botones/siguiente.png"));
        this.btnAnterior.setGraphic(cargarImagen("/botones/anterior.png"));

        this.imgEstadio.setImage(this.estadios[this.pos]);
    }
}