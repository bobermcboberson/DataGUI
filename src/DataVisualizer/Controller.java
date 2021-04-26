package DataVisualizer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controller {
    // Fields
    public TableView BestSellingConsoleTableView;
    public TableView<BestSellingGames> BestSellingGameTableView;
    public TableColumn<BestSellingGames, Integer> GamesRank;
    public TableColumn<BestSellingGames, String> GameName;
    public TableColumn<BestSellingGames, Integer> GameSold;
    public TableColumn<BestSellingGames, String> GamePlat;
    public TableColumn<BestSellingGames, String> GameDate;
    public TableColumn<BestSellingGames, String> GamePublish;
    public TableColumn<BestSellingGames, String> GameDev;
    public TableView BestSellingData;

    // Methods
    public void initialize() {
        BestSellingGames.setMyController(this);

        GamesRank.setCellValueFactory(new PropertyValueFactory<>("Rank"));
        GameName.setCellValueFactory(new PropertyValueFactory<>("Game"));
        GameSold.setCellValueFactory(new PropertyValueFactory<>("Unit Sold"));
        GamePlat.setCellValueFactory(new PropertyValueFactory<>("Platform"));
        GameDate.setCellValueFactory(new PropertyValueFactory<>("Release Date"));
        GamePublish.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
        GameDev.setCellValueFactory(new PropertyValueFactory<>("Developer"));

        BestSellingGames.initialize();
    }

    void updateGameDataUI() {
        BestSellingGameTableView.getItems().clear();
        ArrayList<BestSellingGames> allGames = BestSellingGames.getGames();
        if (allGames != null) {
            allGames.forEach(game -> {
                BestSellingGameTableView.getItems().add(game);
            });
        }
    }
}
