package DataVisualizer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.util.ArrayList;

public class Controller {
    // Fields
    public TableView BestSellingConsoleTableView;
    public TableView BestSellingGameTableView;
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
        BestSellingConsole.read("BestSellingConsoleData");
        BestSelling.describeAll();
    }
}
