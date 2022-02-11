package com.letscode.santander811.championship.presenters.impl.javafx;

import com.letscode.santander811.championship.presenters.UIPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXUIPresenter extends Application implements UIPresenter {

    @Override
    public void start(final Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXUIPresenter.class.getResource("/javafx/championships.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Process Championship Matches Result!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void startup() {
        launch();
    } //launch: metodo que exibe a aplicacao FX
}
