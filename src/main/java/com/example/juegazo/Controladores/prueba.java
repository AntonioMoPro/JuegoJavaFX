package com.example.juegazo.Controladores;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class prueba implements Initializable {

    @FXML
    private ImageView imageView;

    private Image[] images;
    private int currentIndex;
    private TranslateTransition outTransition;
    private TranslateTransition inTransition;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        images = new Image[]{
                new Image("seBuscaMeliodas.png"),
                new Image("seBuscaBan.png"),
                new Image("seBuscaEscanor.png")
        };
        currentIndex = 0;

        imageView.setImage(images[currentIndex]);

        outTransition = new TranslateTransition(Duration.seconds(1), imageView);

        inTransition = new TranslateTransition(Duration.seconds(1), imageView);
    }

    @FXML
    public void handleNextImage(ActionEvent event) {
        showNextImage();
    }

    @FXML
    public void handlePreviousImage(ActionEvent event) {
        showPreviousImage();
    }

    @FXML
    private void handleReset(ActionEvent event) {
        currentIndex = 0;
        showCurrentImage();
    }

    private void showNextImage() {
        outTransition = new TranslateTransition(Duration.seconds(1), imageView);
        outTransition.setFromY(0);
        outTransition.setToY(-imageView.getFitHeight());

        inTransition.setFromY(imageView.getFitHeight());
        inTransition.setToY(0);

        outTransition.setOnFinished(e -> {
            currentIndex = (currentIndex + 1) % images.length;
            showCurrentImage();
        });
        outTransition.play();
    }

    private void showPreviousImage() {
        outTransition.setFromY(0);
        outTransition.setToY(imageView.getFitHeight());

        inTransition.setFromY(-imageView.getFitHeight());
        inTransition.setToY(0);

        outTransition.setOnFinished(e -> {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            showCurrentImage();
        });
        outTransition.play();
    }

    private void showCurrentImage() {
        imageView.setImage(images[currentIndex]);
        inTransition.play();
    }
}
