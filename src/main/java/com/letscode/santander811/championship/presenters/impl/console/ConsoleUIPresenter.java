package com.letscode.santander811.championship.presenters.impl.console;

import com.letscode.santander811.championship.presenters.UIPresenter;
import com.letscode.santander811.championship.usecases.ProcessMatchesResults;

public class ConsoleUIPresenter implements UIPresenter {

    private final ProcessMatchesResults processMatchesResults = new ProcessMatchesResults();

    @Override
    public void startup() {
        System.out.println("ConsoleUIPresenter - Process Matches Results");
        System.out.println("- lista a relação de championships disponiveis");
        System.out.println("- escolhe championship");
        System.out.println("- executa o processamento (...)");
        var brasileirao2022result = processMatchesResults.execute("brasileirao2022");
        System.out.println("Resultado do processamento:");
        System.out.println(brasileirao2022result);
    }
}
