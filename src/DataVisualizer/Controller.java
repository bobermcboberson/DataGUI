package DataVisualizer;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Controller {
    // Fields
    public Stage myStage;
    public TableView<BestSellingConsole> BestSellingConsoleTableView;
    public TableView<BestSellingGames> BestSellingGameTableView;
    public TableColumn<BestSellingGames, Integer> GamesRank;
    public TableColumn<BestSellingGames, String> GameName;
    public TableColumn<BestSellingGames, Integer> GameSold;
    public TableColumn<BestSellingGames, String> GamePlat;
    public TableColumn<BestSellingGames, String> GameDate;
    public TableColumn<BestSellingGames, String> GamePublish;
    public TableColumn<BestSellingGames, String> GameDev;
    public Button gameSaveButton;
    public Button gameImportButton;
    public Button gameRestoreButton;
    public TableView<BestSelling> BestSellingData;

    // Setters and Getters
    public Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage mystage) {
        this.myStage = mystage;
    }

    // Methods
    public void initialize() {
        BestSellingGames.setMyController(this);

        GamesRank.setCellValueFactory(new PropertyValueFactory<>("ranking"));
        GameName.setCellValueFactory(new PropertyValueFactory<>("name"));
        GameSold.setCellValueFactory(new PropertyValueFactory<>("unitSold"));
        GamePlat.setCellValueFactory(new PropertyValueFactory<>("platform"));
        GameDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        GamePublish.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        GameDev.setCellValueFactory(new PropertyValueFactory<>("creator"));

        //BestSellingGames.initialize();

        boolean hasData = gameRestore();
        if (hasData) {
            updateGameDataUI();
        }
    }

    public boolean gameRestore() {
        boolean BestSellingGamesRestored = BestSellingGames.restore();
        if (BestSellingGamesRestored) {
            BestSelling.describeAll();
            return true;
        }
        return false;
    }

    public void gameImport() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(myStage);
        if (selectedFile != null && selectedFile.exists()) {
            BestSellingGames.read(selectedFile.getPath());
            updateGameDataUI();
        }
    }

    public void gameSave() {
        BestSellingGames.save();
    }

    void updateGameDataUI() {
        BestSellingGameTableView.getItems().clear();
        ArrayList<BestSellingGames> allGames = BestSellingGames.getGames();
        if (allGames != null) {
            allGames.forEach(game -> BestSellingGameTableView.getItems().add(game));
        }
    }
}
