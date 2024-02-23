package com.example.juegazo.Modelos;

import javafx.animation.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Personaje {
    private String nombre, urlSprites;
    private boolean pj1;

    public Personaje (String nombre, boolean pj1){
        this.nombre = nombre.toUpperCase();
        this.pj1 = pj1;
        identificarPj();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlSprites() {
        return urlSprites;
    }

    public void setUrlSprites(String urlSprites) {
        this.urlSprites = urlSprites;
    }

    public boolean isPj1() {
        return pj1;
    }

    public void setPj1(boolean pj1) {
        this.pj1 = pj1;
    }


    private void identificarPj() {
        switch (this.nombre){
            case "MELIODAS":
                this.urlSprites = "/spritesMeliodas/";
                break;

            case "DIANE":
                this.urlSprites = "/spritesDiane/";
                break;

            case "BAN":
                this.urlSprites = "/spritesBan/";
                break;

            case "KING":
                this.urlSprites = "/spritesKing/";
                break;

            case "GOWTHER":
                this.urlSprites = "/spritesGowther/";
                break;

            case "MERLIN":
                this.urlSprites = "/spritesMerlin/";
                break;

            case "ESCANOR":
                this.urlSprites = "/spritesEscanor/";
                break;
        }
    }

    public void enemigoRecibeDaño (ImageView imgPj){
        double tamImg;
        if (this.pj1){
            switch (this.nombre){
                case "MELIODAS":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 540);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "DIANE":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 503);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "BAN":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 502);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "KING":
                    tamImg = imgPj.getFitWidth();
                    imgPj.setImage(new Image(getClass().getResource("/spritesKing/Daño.png").toExternalForm()));
                    imgPj.setFitHeight(imgPj.getImage().getHeight());
                    imgPj.setFitWidth(imgPj.getImage().getWidth());
                    imgPj.setLayoutY(508);
                    setImg(imgPj, "Daño.png", 180, 508);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "GOWTHER":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 528);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "MERLIN":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 503);
                    imgPj.setLayoutX(180 + tamImg - imgPj.getFitWidth());
                    break;

                case "ESCANOR":
                    tamImg = imgPj.getFitWidth();
                    setImg(imgPj, "Daño.png", 180, 459);
                    imgPj.setLayoutX(130 + tamImg - imgPj.getFitWidth());
                    break;

            }
        }else {
            switch (this.nombre){
                case "MELIODAS":
                    setImg(imgPj, "DañoR.png", 1190, 540);
                    break;

                case "DIANE":
                    setImg(imgPj, "DañoR.png", 1227, 503);
                    break;

                case "BAN":
                    setImg(imgPj, "DañoR.png", 1209, 502);
                    break;

                case "KING":
                    setImg(imgPj, "DañoR.png", 1231, 508);
                    break;

                case "GOWTHER":
                    setImg(imgPj, "DañoR.png", 1234, 528);
                    break;

                case "MERLIN":
                    setImg(imgPj, "DañoR.png", 1177, 503);
                    break;

                case "ESCANOR":
                    setImg(imgPj, "DañoR.png", 1140, 459);
                    break;

            }
        }
    }

    public void resetImgPjs (ImageView imgPj){
        if (this.pj1){
            switch (this.nombre){
                case "MELIODAS":
                    setImg(imgPj, "Parado.gif", 180, 497);
                    break;

                case "DIANE":
                    setImg(imgPj, "Parado.gif", 180, 490);
                    break;

                case "BAN":
                    setImg(imgPj, "Parado.gif", 180, 453);
                    break;

                case "KING":
                    setImg(imgPj, "Parado.gif", 180, 497);
                    break;

                case "GOWTHER":
                    setImg(imgPj, "Parado.gif", 180, 509);
                    break;

                case "MERLIN":
                    setImg(imgPj, "Parado.gif", 180, 436);
                    break;

                case "ESCANOR":
                    setImg(imgPj, "Parado.gif", 130, 328);
                    break;
            }
        }else {
            switch (this.nombre){
                case "MELIODAS":
                    setImg(imgPj, "ParadoR.gif", 1190, 497);
                    break;

                case "DIANE":
                    setImg(imgPj, "ParadoR.gif", 1227, 490);
                    break;

                case "BAN":
                    setImg(imgPj, "ParadoR.gif", 1209, 453);
                    break;

                case "KING":
                    setImg(imgPj, "ParadoR.gif", 1231, 497);
                    break;

                case "GOWTHER":
                    setImg(imgPj, "ParadoR.gif", 1234, 509);
                    break;

                case "MERLIN":
                    setImg(imgPj, "ParadoR.gif", 1177, 436);
                    break;

                case "ESCANOR":
                    setImg(imgPj, "ParadoR.gif", 1140, 328);
                    break;
            }
        }
    }

    public void setImg (ImageView img, String nomImg, int x, int y){
        img.setImage(new Image(getClass().getResource(urlSprites + nomImg).toExternalForm()));
        img.setFitHeight(img.getImage().getHeight());
        img.setFitWidth(img.getImage().getWidth());
        img.setLayoutY(y);
        img.setLayoutX(x);
    }

    public void setColor (ProgressBar pb){

        if (pb.getProgress() > 0.75) {
            pb.setStyle("-fx-accent: rgba(0, 255, 0, 1.0);");
        } else if (pb.getProgress() >= 0.5) {
            pb.setStyle("-fx-accent: rgba(255, 255, 0, 1.0);");
        } else if (pb.getProgress() >= 0.25) {
            pb.setStyle("-fx-accent: rgba(255, 165, 0, 1.0);");
        } else {
            pb.setStyle("-fx-accent: rgba(255, 0, 0, 1.0);");
    }

    }

    public void disminuirVida (ProgressBar progressBar, double minDamage, double maxDamage){
        Random random = new Random();

        double c = random.nextDouble(minDamage, maxDamage);
        c = Math.floor((c * 100)) / 100;
        System.out.println("VIDA ANTERIOR: " + progressBar.getProgress() * 100);
        System.out.println("DAÑO CAUSADO: " + c * 100);
        double nuevaVida = progressBar.getProgress() - c;

        if (nuevaVida < 0){
            nuevaVida = 0;
        }

        progressBar.setProgress(nuevaVida);
        setColor(progressBar);

        System.out.println("VIDA ACTUAL: " + progressBar.getProgress() * 100);
    }

    public void sacarImgLanzamiento(ImageView img){
        img.setImage(null);
        img.setLayoutX(-227);
        img.setLayoutY(670);
    }

    /**
     *
     * SET DE ATAQUES DE MELIODAS
     *
     * */

    public int meliodasAtaque1 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Corriendo.gif", 180, 552);

        TranslateTransition transition = new TranslateTransition(Duration.millis(1600), imgPj1);
        transition.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth());
        transition.setOnFinished(e -> {

            setImg(imgPj1, "Ataque1.gif", 180, 528);
            imgPj1.toFront();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));
            pause.setOnFinished(event -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }

                setImg(imgPj1, "VolverAtras.gif", 180, 405);

                TranslateTransition transition1 = new TranslateTransition(Duration.millis(1300), imgPj1);
                transition1.setToX(0);
                transition1.setOnFinished(event1 -> {

                    resetImgPjs(imgPj1);
                });

                transition1.play();

            });

            pause.play();
            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.1, 0.15);

                });
        transition.play();

        return 4500;
    }

    public int meliodasAtaque1R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "CorriendoR.gif", 1190, 552);

        TranslateTransition transition = new TranslateTransition(Duration.millis(1600), imgPj2);
        transition.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth() + (imgPj2.getFitWidth() / 4));
        transition.setOnFinished(e -> {

            setImg(imgPj2, "Ataque1R.gif", 1190, 528);
            imgPj2.setX(imgPj2.getX() - imgPj2.getFitWidth()/2);
            imgPj2.toFront();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));
            pause.setOnFinished(event -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }

                imgPj2.setX(0);
                setImg(imgPj2, "VolverAtrasR.gif", 1190, 405);

                TranslateTransition transition1 = new TranslateTransition(Duration.millis(1300), imgPj2);
                transition1.setToX(0);
                transition1.setOnFinished(event1 -> {

                    resetImgPjs(imgPj2);
                });

                transition1.play();

            });

            pause.play();
            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.1, 0.15);

        });
        transition.play();

        return 4500;
    }

    public int meliodasAtaque2 (ImageView imgPj1, ImageView imgPj2,ImageView imgLanzamientoPj1, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Corriendo.gif", 180, 552);

        TranslateTransition transition = new TranslateTransition(Duration.millis(1600), imgPj1);
        transition.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth());
        transition.setOnFinished(e -> {

            setImg(imgPj1, "Ataque2.gif", 180, 452);
            imgPj1.toFront();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));
            pause.setOnFinished(event -> {

                imgLanzamientoPj1.setImage(new Image(getClass().getResource(urlSprites + "Corte.gif").toExternalForm()));
                imgLanzamientoPj1.setFitWidth(300);
                imgLanzamientoPj1.setFitHeight(296);

                if (imgPj2.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesDiane/DañoR.png") ||
                        imgPj2.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesMerlin/DañoR.png")){
                    imgLanzamientoPj1.setLayoutX(imgPj2.getLayoutX() - 75);
                } else if (imgPj2.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesEscanor/DañoR.png")){
                    imgLanzamientoPj1.setLayoutX(imgPj2.getLayoutX());
                }else {
                    imgLanzamientoPj1.setLayoutX(imgPj2.getLayoutX() - 50);
                }

                imgLanzamientoPj1.setLayoutY(510);
                imgLanzamientoPj1.toFront();

                PauseTransition pause1 = new PauseTransition(Duration.millis(700));
                pause1.setOnFinished(ev -> {

                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }

                    sacarImgLanzamiento(imgLanzamientoPj1);

                    setImg(imgPj1, "VolverAtras.gif", 180, 405);

                    TranslateTransition transition1 = new TranslateTransition(Duration.millis(1300), imgPj1);
                    transition1.setToX(0);
                    transition1.setOnFinished(event1 -> {

                        resetImgPjs(imgPj1);
                    });

                    transition1.play();
                });

                pause1.play();

            });

            pause.play();
            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.05, 0.2);

        });
        transition.play();

        return 5200;
    }

    public int meliodasAtaque2R (ImageView imgPj2, ImageView imgPj1,ImageView imgLanzamientoPj2, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "CorriendoR.gif", 1190, 552);

        TranslateTransition transition = new TranslateTransition(Duration.millis(1600), imgPj2);
        transition.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());
        transition.setOnFinished(e -> {

            setImg(imgPj2, "Ataque2R.gif", 1190, 452);
            imgPj2.toFront();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));
            pause.setOnFinished(event -> {

                imgLanzamientoPj2.setImage(new Image(getClass().getResource(urlSprites + "CorteR.gif").toExternalForm()));
                imgLanzamientoPj2.setFitWidth(300);
                imgLanzamientoPj2.setFitHeight(296);

                if (imgPj1.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesMerlin/Daño.png") ||
                        imgPj1.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesDiane/Daño.png") ||
                        imgPj1.getImage().getUrl().equals("file:/C:/Users/ahmai/IdeaProjects/Juegazo/target/classes/spritesGowther/Daño.png")){
                    imgLanzamientoPj2.setLayoutX(imgPj1.getLayoutX() - 50);
                }else {
                    imgLanzamientoPj2.setLayoutX(imgPj1.getLayoutX() - 25);
                }

                imgLanzamientoPj2.setLayoutY(510);
                imgLanzamientoPj2.toFront();

                PauseTransition pause1 = new PauseTransition(Duration.millis(700));
                pause1.setOnFinished(ev -> {

                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }

                    sacarImgLanzamiento(imgLanzamientoPj2);

                    setImg(imgPj2, "VolverAtrasR.gif", 1190, 405);

                    TranslateTransition transition1 = new TranslateTransition(Duration.millis(1300), imgPj2);
                    transition1.setToX(0);
                    transition1.setOnFinished(event1 -> {

                        resetImgPjs(imgPj2);
                    });

                    transition1.play();
                });

                pause1.play();

            });

            pause.play();
            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.05, 0.2);

        });
        transition.play();

        return 5200;
    }

    public int meliodasSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Super.gif", 0, 140);

        PauseTransition pause = new PauseTransition(Duration.millis(4700));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "Lanzamiento.gif", 270, 450);
            imgLanzamientoPj1.toFront();

            TranslateTransition transition = new TranslateTransition(Duration.millis(1000), imgLanzamientoPj1);
            transition.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);
            transition.setOnFinished(e -> {

                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.2, 0.4);

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });
                pause1.play();

                sacarImgLanzamiento(imgLanzamientoPj1);
                imgLanzamientoPj1.setTranslateX(0);

                setImg(imgPj1, "DesTransformacion.gif", 100,188);

                PauseTransition pause2 = new PauseTransition(Duration.millis(1600));
                pause2.setOnFinished(ev -> {

                    resetImgPjs(imgPj1);
                });

                pause2.play();

            });

            transition.play();
        });

        pause.play();

        return 7300;
    }

    public int meliodasSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "SuperR.gif", 1040, 140);

        PauseTransition pause = new PauseTransition(Duration.millis(4700));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoR.gif", 946, 450);
            imgLanzamientoPj2.toFront();

            TranslateTransition transition = new TranslateTransition(Duration.millis(1000), imgLanzamientoPj2);
            transition.setByX(imgPj1.getLayoutX() + imgPj1.getFitWidth() - imgLanzamientoPj2.getLayoutX() - 50);
            transition.setOnFinished(e -> {

                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.2, 0.4);

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });
                pause1.play();

                sacarImgLanzamiento(imgLanzamientoPj2);
                imgLanzamientoPj2.setTranslateX(0);

                setImg(imgPj2, "DesTransformacionR.gif", 1125, 188);

                PauseTransition pause2 = new PauseTransition(Duration.millis(1600));
                pause2.setOnFinished(ev -> {

                    resetImgPjs(imgPj2);
                });

                pause2.play();

            });

            transition.play();
        });

        pause.play();

        return 7300;
    }

    /**
     *
     *  SET DE ATAQUES DE MERLIN
     *
     */

    public int merlinAtaque1 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Ataque1.gif", 180, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque1.gif", 408,530);
            imgLanzamientoPj1.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(800), imgLanzamientoPj1);
            translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);

            translate.setOnFinished(e -> {

                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.1, 0.15);

                sacarImgLanzamiento(imgLanzamientoPj1);
                imgLanzamientoPj1.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {

                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });

                pause1.play();

            });

            translate.play();

        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(1200));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause.play();
        pause1.play();

        return 1600;
    }

    public int merlinAtaque1R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "Ataque1R.gif", 1132, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque1R.gif", 1037,530);
            imgLanzamientoPj2.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(800), imgLanzamientoPj2);
            translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth() - 50);

            translate.setOnFinished(e -> {

                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.1, 0.15);

                sacarImgLanzamiento(imgLanzamientoPj2);
                imgLanzamientoPj2.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {

                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });

                pause1.play();

            });

            translate.play();

        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(1200));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause.play();
        pause1.play();

        return 1600;
    }

    public int merlinAtaque2 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Ataque2.gif", 180, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque2.gif", 408, 515);
            imgLanzamientoPj1.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1100));
            PauseTransition pause2 = new PauseTransition(Duration.millis(500));

            pause1.setOnFinished(e -> {
                sacarImgLanzamiento(imgLanzamientoPj1);
                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
            });

            pause2.setOnFinished(ev -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.05, 0.15);
            });

            pause1.play();
            pause2.play();

        });

        PauseTransition pause2 = new PauseTransition(Duration.millis(1500));

        pause2.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause.play();
        pause2.play();

        return 1500;
    }

    public int merlinAtaque2R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "Ataque2R.gif", 1132, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque2R.gif", 218, 515);
            imgLanzamientoPj2.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1100));
            PauseTransition pause2 = new PauseTransition(Duration.millis(500));

            pause1.setOnFinished(e -> {
                sacarImgLanzamiento(imgLanzamientoPj2);
                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
            });

            pause2.setOnFinished(ev -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.05, 0.2);
            });

            pause1.play();
            pause2.play();

        });

        PauseTransition pause2 = new PauseTransition(Duration.millis(1500));

        pause2.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause.play();
        pause2.play();

        return 1500;
    }

    public int merlinSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Super.gif", 180, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoSuper.gif", 375, 350);
            imgLanzamientoPj1.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(2200));
            PauseTransition pause2 = new PauseTransition(Duration.millis(500));

            pause1.setOnFinished(e -> {
                sacarImgLanzamiento(imgLanzamientoPj1);
                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
            });

            pause2.setOnFinished(ev -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.2, 0.4);
            });

            pause1.play();
            pause2.play();

        });

        PauseTransition pause2 = new PauseTransition(Duration.millis(2600));

        pause2.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause.play();
        pause2.play();

        return 2600;
    }

    public int merlinSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "SuperR.gif", 1132, 459);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoSuperR.gif", -35, 350);
            imgLanzamientoPj2.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(2200));
            PauseTransition pause2 = new PauseTransition(Duration.millis(500));

            pause1.setOnFinished(e -> {
                sacarImgLanzamiento(imgLanzamientoPj2);
                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
            });

            pause2.setOnFinished(ev -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.2, 0.4);
            });

            pause1.play();
            pause2.play();

        });

        PauseTransition pause2 = new PauseTransition(Duration.millis(2600));

        pause2.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause.play();
        pause2.play();

        return 2600;
    }

    /**
     *
     *  SET DE ATAQUES DE KING
     *
     */

    public int kingAtaque1 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Ataque1.gif", 180, 527);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque1.gif", 65, 460);
            imgLanzamientoPj1.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(800), imgLanzamientoPj1);
            translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);

            translate.setOnFinished(e -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.1, 0.15);
                translate.setToX(0);

                translate.setOnFinished(ev -> {

                    setImg(imgLanzamientoPj1, "Lanza.png", 65, 460);
                });

                translate.play();

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {

                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });

                pause1.play();

            });

            translate.play();

        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(2300));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause.play();
        pause1.play();

        return 2300;
    }

    public int kingAtaque1R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "Ataque1R.gif", 1183, 527);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque1R.gif", 1475, 460);
            imgLanzamientoPj2.setLayoutX(1475 - imgLanzamientoPj2.getFitWidth());
            imgLanzamientoPj2.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(800), imgLanzamientoPj2);
            translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth());

            translate.setOnFinished(e -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.1, 0.15);
                translate.setToX(0);

                translate.setOnFinished(ev -> {

                    setImg(imgLanzamientoPj2, "Lanza.png", 1475, 460);
                    imgLanzamientoPj2.setLayoutX(1475 - imgLanzamientoPj2.getFitWidth());
                });

                translate.play();

                PauseTransition pause1 = new PauseTransition(Duration.millis(500));
                pause1.setOnFinished(ev -> {

                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });

                pause1.play();

            });

            translate.play();

        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(2300));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause.play();
        pause1.play();

        return 2300;
    }

    public int kingAtaque2 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "Ataque2.gif", 180, 527);
        imgLanzamientoPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj1);
        translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() - 100);

        translate.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque2.gif", 65, 460);

            PauseTransition pause = new PauseTransition(Duration.millis(1800));

            pause.setOnFinished(e -> {

                setImg(imgLanzamientoPj1, "Lanza.png", 65, 460);

                TranslateTransition translate1 = new TranslateTransition(Duration.millis(300), imgLanzamientoPj1);
                translate1.setToX(0);

                translate1.play();
            });

            pause.play();

            PauseTransition pause1 = new PauseTransition(Duration.millis(300));

            pause1.setOnFinished(e -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.05, 0.2);

                PauseTransition pause2 = new PauseTransition(Duration.millis(1500));

                pause2.setOnFinished(ev -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }

                });

                pause2.play();

            });

            pause1.play();

        });

        translate.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(3000));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 3000;
    }

    public int kingAtaque2R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "Ataque2R.gif", 1183, 527);
        imgLanzamientoPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj2);
        translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth() + 100);

        translate.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque2R.gif", 1475, 460);
            imgLanzamientoPj2.setLayoutX(1475 - imgLanzamientoPj2.getFitWidth());

            PauseTransition pause = new PauseTransition(Duration.millis(1800));

            pause.setOnFinished(e -> {

                setImg(imgLanzamientoPj2, "Lanza.png", 1475, 460);
                imgLanzamientoPj2.setLayoutX(1475 - imgLanzamientoPj2.getFitWidth());

                TranslateTransition translate1 = new TranslateTransition(Duration.millis(300), imgLanzamientoPj2);
                translate1.setToX(0);

                translate1.play();
            });

            pause.play();

            PauseTransition pause1 = new PauseTransition(Duration.millis(300));

            pause1.setOnFinished(e -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.05, 0.2);

                PauseTransition pause2 = new PauseTransition(Duration.millis(1500));

                pause2.setOnFinished(ev -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }

                });

                pause2.play();

            });

            pause1.play();

        });

        translate.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(3000));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 3000;
    }

    public int kingSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){

        setImg(imgPj1, "AtaqueSuper.gif", 180, 527);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoSuper.gif", 180, 155);
            imgLanzamientoPj1.setLayoutX(imgPj1.getLayoutX() + imgPj1.getFitWidth());
            imgLanzamientoPj1.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1200));

            pause1.setOnFinished(e -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.2, 0.4);
            });

            pause1.play();

            PauseTransition pause2 = new PauseTransition(Duration.millis(2000));

            pause2.setOnFinished(e -> {
                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
            });

            pause2.play();

            PauseTransition pause3 = new PauseTransition(Duration.millis(2500));

            pause3.setOnFinished(e -> {

                setImg(imgLanzamientoPj1, "Lanza.png", 65, 460);
            });

            pause3.play();


        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(3200));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause.play();
        pause1.play();

        return 3200;
    }

    public int kingSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "AtaqueSuperR.gif", 1183, 527);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoSuperR.gif", 180, 155);
            imgLanzamientoPj2.setLayoutX(imgPj1.getLayoutX() + imgPj1.getFitWidth());
            imgLanzamientoPj2.toFront();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1200));

            pause1.setOnFinished(e -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.2, 0.4);
            });

            pause1.play();

            PauseTransition pause2 = new PauseTransition(Duration.millis(2000));

            pause2.setOnFinished(e -> {
                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
            });

            pause2.play();

            PauseTransition pause3 = new PauseTransition(Duration.millis(2500));

            pause3.setOnFinished(e -> {

                setImg(imgLanzamientoPj2, "Lanza.png", 1475, 460);
                imgLanzamientoPj2.setLayoutX(1475 - imgLanzamientoPj2.getFitWidth());
            });

            pause3.play();


        });

        PauseTransition pause1 = new PauseTransition(Duration.millis(3200));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause.play();
        pause1.play();

        return 3200;
    }

    /**
     *
     *  SET DE ATAQUES DE GOWTHER
     *
     */

    public int gowtherAtaque1 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2) {

        setImg(imgPj1, "Ataque1.gif", 180, 509);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque1.png", 406, 600);
            imgLanzamientoPj1.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj1);
            translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);

            translate.setOnFinished(e -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.1, 0.15);

                sacarImgLanzamiento(imgLanzamientoPj1);
                imgLanzamientoPj1.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                pause1.setOnFinished(ev -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });

                pause1.play();
            });

            translate.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));
        pause1.setOnFinished(event -> {

            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 1300;
    }

    public int gowtherAtaque1R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1) {

        setImg(imgPj2, "Ataque1R.gif", 1134, 509);

        PauseTransition pause = new PauseTransition(Duration.millis(400));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque1R.png", 1134, 600);
            imgLanzamientoPj2.setLayoutX(1134 - imgLanzamientoPj2.getFitWidth());
            imgLanzamientoPj2.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj2);
            translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth());

            translate.setOnFinished(e -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.1, 0.15);

                sacarImgLanzamiento(imgLanzamientoPj2);
                imgLanzamientoPj2.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                pause1.setOnFinished(ev -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });

                pause1.play();
            });

            translate.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));
        pause1.setOnFinished(event -> {

            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 1300;
    }

    public int gowtherAtaque2 (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2) {

        setImg(imgPj1, "Ataque2.gif", 180, 461);

        PauseTransition pause = new PauseTransition(Duration.millis(600));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoAtaque2.png", 406, 560);
            imgLanzamientoPj1.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj1);
            translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);

            translate.setOnFinished(e -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.05, 0.2);

                sacarImgLanzamiento(imgLanzamientoPj1);
                imgLanzamientoPj1.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                pause1.setOnFinished(ev -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });

                pause1.play();
            });

            translate.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));
        pause1.setOnFinished(event -> {

            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 1300;
    }

    public int gowtherAtaque2R (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1) {

        setImg(imgPj2, "Ataque2R.gif", 1134, 461);

        PauseTransition pause = new PauseTransition(Duration.millis(600));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoAtaque2R.png", 1134, 560);
            imgLanzamientoPj2.setLayoutX(1134 - imgLanzamientoPj2.getFitWidth());
            imgLanzamientoPj2.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj2);
            translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth());

            translate.setOnFinished(e -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.05, 0.2);

                sacarImgLanzamiento(imgLanzamientoPj2);
                imgLanzamientoPj2.setTranslateX(0);

                PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                pause1.setOnFinished(ev -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });

                pause1.play();
            });

            translate.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));
        pause1.setOnFinished(event -> {

            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 1300;
    }

    public int gowtherSuperAtaque (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2) {

        setImg(imgPj1, "AtaqueSuper.gif", 180, 466);
        imgPj1.toFront();

        PauseTransition pause = new PauseTransition(Duration.millis(700));

        pause.setOnFinished(event -> {

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.2, 0.4);
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));

        pause1.setOnFinished(event -> {

            if (vidaPj2.getProgress() > 0){
                pj2.resetImgPjs(imgPj2);
            }
            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 1300;
    }

    public int gowtherSuperAtaqueR (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1) {

        setImg(imgPj2, "AtaqueSuperR.gif", 180, 466);
        imgPj2.toFront();

        PauseTransition pause = new PauseTransition(Duration.millis(700));

        pause.setOnFinished(event -> {

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.2, 0.4);
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1300));

        pause1.setOnFinished(event -> {

            if (vidaPj1.getProgress() > 0){
                pj1.resetImgPjs(imgPj1);
            }
            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 1300;
    }

    /**
     *
     *  SET DE ATAQUES DE ESCANOR
     *
     */

    public int escanorAtaque1 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 130, 353);
        imgPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(700), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 100);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque1.gif", 130, 466);

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.1, 0.15);

            PauseTransition pause = new PauseTransition(Duration.millis(1100));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 130,246);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1000));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 2800;
    }

    public int escanorAtaque1R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "CorriendoR.gif", 1140, 353);
        imgPj2.setLayoutX(1140 - imgPj1.getFitWidth());
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(700), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {
            setImg(imgPj2, "Ataque1R.gif", 1140, 466);
            imgPj2.setLayoutX(1140 - imgPj1.getFitWidth() - 50);

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.1, 0.15);

            PauseTransition pause = new PauseTransition(Duration.millis(1100));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1140,246);
                imgPj2.setLayoutX(1140 - imgPj1.getFitWidth() + 50);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1000));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 2800;
    }

    public int escanorAtaque2 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 130, 353);
        imgPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(700), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 100);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque2.gif", 130, 466);

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.05, 0.2);

            PauseTransition pause = new PauseTransition(Duration.millis(1100));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 130,246);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1000));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 2800;
    }

    public int escanorAtaque2R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){

        setImg(imgPj2, "CorriendoR.gif", 1140, 353);
        imgPj2.setLayoutX(1140 - imgPj1.getFitWidth());
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(700), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {

            setImg(imgPj2, "Ataque2R.gif", 1140, 466);
            imgPj2.setLayoutX(1140 - imgPj2.getFitWidth() + 50);

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.05, 0.2);

            PauseTransition pause = new PauseTransition(Duration.millis(1100));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1140,246);
                imgPj2.setLayoutX(1140 - imgPj1.getFitWidth() + 50);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1000));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 2800;
    }

    public int escanorSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "SuperAtaque.gif", 130, 452);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj1, "LanzamientoSuperAtaque.gif", 350, 200);
            imgLanzamientoPj1.toFront();

            ScaleTransition scale = new ScaleTransition(Duration.millis(1), imgLanzamientoPj1);
            imgLanzamientoPj1.setVisible(false);
            scale.setToY(0.0);
            scale.setToX(0.0);

            scale.setOnFinished(event1 -> {
                imgLanzamientoPj1.setVisible(true);
                ScaleTransition scale1 = new ScaleTransition(Duration.millis(1000), imgLanzamientoPj1);
                scale1.setToY(1.0);
                scale1.setToX(1.0);

                scale1.setOnFinished(event2 -> {

                    TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj1);
                    translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);
                    translate.setByY(imgPj2.getLayoutY() - imgLanzamientoPj1.getLayoutY());

                    translate.setOnFinished(event3 -> {

                        pj2.enemigoRecibeDaño(imgPj2);
                        disminuirVida(vidaPj2, 0.2, 0.4);

                        sacarImgLanzamiento(imgLanzamientoPj1);
                        imgLanzamientoPj1.setTranslateX(0);
                        imgLanzamientoPj1.setTranslateY(0);

                        PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                        pause1.setOnFinished(ev -> {
                            if (vidaPj2.getProgress() > 0){
                                pj2.resetImgPjs(imgPj2);
                            }
                        });

                        pause1.play();
                    });

                    translate.play();
                });

                scale1.play();
            });


            scale.play();

        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(2000));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 2000;
    }

    public int escanorSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "SuperAtaqueR.gif", 990, 452);

        PauseTransition pause = new PauseTransition(Duration.millis(300));

        pause.setOnFinished(event -> {

            setImg(imgLanzamientoPj2, "LanzamientoSuperAtaque.gif", 1190, 200);
            imgLanzamientoPj2.setLayoutX(1190 - imgLanzamientoPj2.getFitWidth());
            imgLanzamientoPj2.toFront();

            ScaleTransition scale = new ScaleTransition(Duration.millis(1), imgLanzamientoPj2);
            imgLanzamientoPj2.setVisible(false);
            scale.setToY(0.0);
            scale.setToX(0.0);

            scale.setOnFinished(event1 -> {
                imgLanzamientoPj2.setVisible(true);
                ScaleTransition scale1 = new ScaleTransition(Duration.millis(1000), imgLanzamientoPj2);
                scale1.setToY(1.0);
                scale1.setToX(1.0);

                scale1.setOnFinished(event2 -> {

                    TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj2);
                    translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth());
                    translate.setByY(imgPj1.getLayoutY() - imgLanzamientoPj2.getLayoutY());

                    translate.setOnFinished(event3 -> {

                        pj1.enemigoRecibeDaño(imgPj1);
                        disminuirVida(vidaPj1, 0.2, 0.4);

                        sacarImgLanzamiento(imgLanzamientoPj2);
                        imgLanzamientoPj2.setTranslateX(0);
                        imgLanzamientoPj2.setTranslateY(0);

                        PauseTransition pause1 = new PauseTransition(Duration.millis(200));

                        pause1.setOnFinished(ev -> {
                            if (vidaPj1.getProgress() > 0){
                                pj1.resetImgPjs(imgPj1);
                            }
                        });

                        pause1.play();
                    });

                    translate.play();
                });

                scale1.play();
            });


            scale.play();

        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(2000));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 2000;
    }

    /**
     *
     *  SET DE ATAQUES DE BAN
     *
     */

    public int banAtaque1 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 180, 553);
        imgPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 100);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque1.gif", 180, 446);

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.1, 0.15);

            PauseTransition pause = new PauseTransition(Duration.millis(1400));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 180,399);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 3700;
    }

    public int banAtaque1R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "CorriendoR.gif", 1209, 553);
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {
            setImg(imgPj2, "Ataque1R.gif", 1075, 446);

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.1, 0.15);

            PauseTransition pause = new PauseTransition(Duration.millis(1400));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1209,399);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 3700;
    }

    public int banAtaque2 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 180, 553);
        imgPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() - 50);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque2.gif", 130, 446);

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.05, 0.2);

            PauseTransition pause = new PauseTransition(Duration.millis(2500));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 180,399);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 4800;
    }

    public int banAtaque2R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "CorriendoR.gif", 1209, 553);
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {
            setImg(imgPj2, "Ataque2R.gif", 950, 446);

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.05, 0.2);

            PauseTransition pause = new PauseTransition(Duration.millis(2500));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1209,399);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 4800;
    }

    public int banSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Super.gif", 180, 456);

        PauseTransition pause = new PauseTransition(Duration.millis(500));

        pause.setOnFinished(event -> {
            setImg(imgLanzamientoPj1, "Lanzamiento.gif", 350, 520);
            imgLanzamientoPj1.setLayoutX(imgPj1.getLayoutX() + imgPj1.getFitWidth() - imgLanzamientoPj1.getFitWidth());
            imgLanzamientoPj1.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj1);
            translate.setByX(imgPj2.getLayoutX() - imgLanzamientoPj1.getLayoutX() - imgLanzamientoPj1.getFitWidth() + 50);

            translate.setOnFinished(event1 -> {
                sacarImgLanzamiento(imgLanzamientoPj1);
                imgLanzamientoPj1.setTranslateX(0);

                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.2, 0.4);

                pause.setDuration(Duration.millis(300));

                pause.setOnFinished(event2 -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                    resetImgPjs(imgPj1);
                });

                pause.play();
            });

            translate.play();
        });

        pause.play();

        return 1300;
    }

    public int banSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "SuperR.gif", 821, 456);

        PauseTransition pause = new PauseTransition(Duration.millis(500));

        pause.setOnFinished(event -> {
            setImg(imgLanzamientoPj2, "LanzamientoR.gif", 821, 520);
            imgLanzamientoPj2.toFront();

            TranslateTransition translate = new TranslateTransition(Duration.millis(500), imgLanzamientoPj2);
            translate.setByX(imgPj1.getLayoutX() - imgLanzamientoPj2.getLayoutX() + imgPj1.getFitWidth());

            translate.setOnFinished(event1 -> {
                sacarImgLanzamiento(imgLanzamientoPj2);
                imgLanzamientoPj2.setTranslateX(0);

                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.2, 0.4);

                pause.setDuration(Duration.millis(300));

                pause.setOnFinished(event2 -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                    resetImgPjs(imgPj2);
                });

                pause.play();
            });

            translate.play();
        });

        pause.play();

        return 1300;
    }

    /**
     *
     *  SET DE ATAQUES DE DIANE
     *
     */

    public int dianeAtaque1 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 180, 540);
        imgPj1.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 50);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque1.gif", 180, 509);

            pj2.enemigoRecibeDaño(imgPj2);
            disminuirVida(vidaPj2, 0.1, 0.15);


            PauseTransition pause = new PauseTransition(Duration.millis(1800));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 180,447);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 4100;
    }

    public int dianeAtaque1R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "CorriendoR.gif", 1227, 540);
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {
            setImg(imgPj2, "Ataque1R.gif", 1075, 509);

            pj1.enemigoRecibeDaño(imgPj1);
            disminuirVida(vidaPj1, 0.1, 0.15);

            PauseTransition pause = new PauseTransition(Duration.millis(1800));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1227,447);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 4100;
    }

    public int dianeAtaque2 (ImageView imgPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Corriendo.gif", 180, 540);
        imgPj1.toFront();


        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj1);
        translate.setByX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 50);

        translate.setOnFinished(event -> {
            setImg(imgPj1, "Ataque2.gif", 180, 465);

            PauseTransition pause1 = new PauseTransition(Duration.millis(600));

            pause1.setOnFinished(event1 -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.05, 0.2);
            });

            pause1.play();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));

            pause.setOnFinished(event1 -> {

                if (vidaPj2.getProgress() > 0){
                    pj2.resetImgPjs(imgPj2);
                }
                setImg(imgPj1, "VolverAtras.gif", 180,447);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj1);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 3900;
    }

    public int dianeAtaque2R (ImageView imgPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "CorriendoR.gif", 1227, 540);
        imgPj2.toFront();

        TranslateTransition translate = new TranslateTransition(Duration.millis(1000), imgPj2);
        translate.setByX(imgPj1.getLayoutX() - imgPj2.getLayoutX() + imgPj1.getFitWidth());

        translate.setOnFinished(event -> {
            setImg(imgPj2, "Ataque2R.gif", 1075, 465);

            PauseTransition pause1 = new PauseTransition(Duration.millis(600));

            pause1.setOnFinished(event1 -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.05, 0.2);
            });

            pause1.play();

            PauseTransition pause = new PauseTransition(Duration.millis(1600));

            pause.setOnFinished(event1 -> {

                if (vidaPj1.getProgress() > 0){
                    pj1.resetImgPjs(imgPj1);
                }
                setImg(imgPj2, "VolverAtrasR.gif", 1227,447);

                translate.setToX(0);
                translate.setDuration(Duration.millis(1300));

                translate.setOnFinished(event2 -> {
                    resetImgPjs(imgPj2);
                });

                translate.play();
            });

            pause.play();
        });

        translate.play();

        return 3900;
    }

    public int dianeSuperAtaque (ImageView imgPj1, ImageView imgLanzamientoPj1, ImageView imgPj2, ProgressBar vidaPj2, Personaje pj2){
        setImg(imgPj1, "Super.gif", 140, 515);

        PauseTransition pause = new PauseTransition(Duration.millis(500));

        pause.setOnFinished(event -> {
            setImg(imgLanzamientoPj1, "Lanzamiento.gif", 180, 395);
            imgLanzamientoPj1.setLayoutX(imgPj2.getLayoutX() - imgPj1.getLayoutX() - imgPj1.getFitWidth() + 250);

            pause.setDuration(Duration.millis(400));

            pause.setOnFinished(event1 -> {
                pj2.enemigoRecibeDaño(imgPj2);
                disminuirVida(vidaPj2, 0.2, 0.4);

                pause.setDuration(Duration.millis(200));

                pause.setOnFinished(event2 -> {
                    if (vidaPj2.getProgress() > 0){
                        pj2.resetImgPjs(imgPj2);
                    }
                });

                pause.play();
            });

            pause.play();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1000));

            pause1.setOnFinished(event1 -> {
                sacarImgLanzamiento(imgLanzamientoPj1);
            });

            pause1.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1600));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj1);
        });

        pause1.play();

        return 1600;
    }

    public int dianeSuperAtaqueR (ImageView imgPj2, ImageView imgLanzamientoPj2, ImageView imgPj1, ProgressBar vidaPj1, Personaje pj1){
        setImg(imgPj2, "SuperR.gif", 1009, 515);

        PauseTransition pause = new PauseTransition(Duration.millis(500));

        pause.setOnFinished(event -> {
            setImg(imgLanzamientoPj2, "LanzamientoR.gif", 1227, 395);
            imgLanzamientoPj2.setLayoutX(imgPj1.getLayoutX());

            pause.setDuration(Duration.millis(400));

            pause.setOnFinished(event1 -> {
                pj1.enemigoRecibeDaño(imgPj1);
                disminuirVida(vidaPj1, 0.2, 0.4);

                pause.setDuration(Duration.millis(200));

                pause.setOnFinished(event2 -> {
                    if (vidaPj1.getProgress() > 0){
                        pj1.resetImgPjs(imgPj1);
                    }
                });

                pause.play();
            });

            pause.play();

            PauseTransition pause1 = new PauseTransition(Duration.millis(1000));

            pause1.setOnFinished(event1 -> {
                sacarImgLanzamiento(imgLanzamientoPj2);
            });

            pause1.play();
        });

        pause.play();

        PauseTransition pause1 = new PauseTransition(Duration.millis(1600));

        pause1.setOnFinished(event -> {
            resetImgPjs(imgPj2);
        });

        pause1.play();

        return 1600;
    }
}
