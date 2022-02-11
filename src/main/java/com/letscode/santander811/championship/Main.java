package com.letscode.santander811.championship;

import com.letscode.santander811.championship.presenters.impl.console.ConsoleUIPresenter;
import com.letscode.santander811.championship.presenters.impl.javafx.JavaFXUIPresenter;

public class Main {

    public static void main(String[] args) {
//        new ConsoleUIPresenter().startup();
        new JavaFXUIPresenter().startup();
    }
}
