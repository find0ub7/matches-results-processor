package com.letscode.santander811.championship.presenters.impl.javafx.controllers;

import com.letscode.santander811.championship.presenters.impl.javafx.converters.ProcessResultFXConverter;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.ChampionshipProcessResultFX;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.MatchResultFX;
import com.letscode.santander811.championship.presenters.impl.javafx.domains.TeamResultsAggregationFX;
import com.letscode.santander811.championship.usecases.ProcessMatchesResults;
import com.sun.javafx.collections.ImmutableObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Collection;
import java.util.List;

public class ChampionshipFxController {

    @FXML
    private TableView<TeamResultsAggregationFX> rankTable;
    @FXML
    private ListView<MatchResultFX> matchesList;

    private ProcessMatchesResults processMatchesResults = new ProcessMatchesResults(); //Usecase que realiza o processamento
    private ProcessResultFXConverter processResultFXConverter = new ProcessResultFXConverter();
    private ChampionshipProcessResultFX championshipProcessResultFX;

    private EventHandler<MouseEvent> mouseEventClickOnRankTable = event -> {
        var teamName = rankTable.getSelectionModel().getSelectedItem().getTeamName();
        Collection<MatchResultFX> matches = championshipProcessResultFX.getMatchesByTeam(teamName);
        matchesList.setItems(new ImmutableObservableList<>(matches.toArray(new MatchResultFX[matches.size()])));
    };

    @FXML
    protected void onProcessMatchesResults() {
        //TODO sugestao de melhoria: obter o identificado do campeonato via UI
        var processResult = processMatchesResults.execute("brasileirao2022");

        championshipProcessResultFX = processResultFXConverter.convert(processResult);
        var teamsResultsAggregationFX = championshipProcessResultFX.getTeamsResultsAggregation();
        var tableItems = teamsResultsAggregationFX.toArray(new TeamResultsAggregationFX[teamsResultsAggregationFX.size()]);

        setupTableRank();
        rankTable.setItems(new ImmutableObservableList<>(tableItems));
        rankTable.removeEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventClickOnRankTable);
        rankTable.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventClickOnRankTable);
    }

    private void setupTableRank() {
        var columnTeam = new TableColumn<TeamResultsAggregationFX, String>("Time");
        var columnTotalScore = new TableColumn<TeamResultsAggregationFX, String>("Pontos");
        var columnVictories = new TableColumn<TeamResultsAggregationFX, Integer>("Vitorias");
        var columnDraws = new TableColumn<TeamResultsAggregationFX, Integer>("Empates");
        var columnDefeats = new TableColumn<TeamResultsAggregationFX, Integer>("Derrotas");

        columnTeam.setCellValueFactory(new PropertyValueFactory("teamName"));
        columnTotalScore.setCellValueFactory(new PropertyValueFactory("totalScore"));
        columnVictories.setCellValueFactory(new PropertyValueFactory("victoriesCount"));
        columnDraws.setCellValueFactory(new PropertyValueFactory("drawsCount"));
        columnDefeats.setCellValueFactory(new PropertyValueFactory("defeatsCount"));

        var tableColumns=
                List.of(
                        columnTeam,
                        columnTotalScore,
                        columnVictories,
                        columnDraws,
                        columnDefeats);

        rankTable.getColumns().setAll(tableColumns);
    }
}
