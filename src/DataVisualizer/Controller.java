package DataVisualizer;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

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
        BestSellingGameTableView.setEditable(true);

        GamesRank.setCellValueFactory(new PropertyValueFactory("ranking"));
        GamesRank.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        GamesRank.setOnEditCommit((GameRankEditEvent) -> {
            Integer newValue = GameRankEditEvent.getNewValue();
            BestSellingGames editedRowObject = GameRankEditEvent.getRowValue();
            editedRowObject.setRanking(newValue);
        });

        GameName.setCellValueFactory(new PropertyValueFactory("name"));
        GameName.setCellFactory(TextFieldTableCell.forTableColumn());
        GameName.setOnEditCommit((GameNameEditEvent) -> {
            String newValue = GameNameEditEvent.getNewValue();
            BestSellingGames editedRowObject = GameNameEditEvent.getRowValue();
            editedRowObject.setName(newValue);
        });

        GameSold.setCellValueFactory(new PropertyValueFactory("unitSold"));
        GameSold.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        GameSold.setOnEditCommit((GameSoldEditEvent) -> {
            Integer newValue = GameSoldEditEvent.getNewValue();
            BestSellingGames editedRowObject = GameSoldEditEvent.getRowValue();
            editedRowObject.setUnitSold(newValue);
        });

        GamePlat.setCellValueFactory(new PropertyValueFactory("platform"));
        GamePlat.setCellFactory(TextFieldTableCell.forTableColumn());
        GamePlat.setOnEditCommit((GamePlatEditEvent) -> {
            String newValue = GamePlatEditEvent.getNewValue();
            BestSellingGames editedRowObject = GamePlatEditEvent.getRowValue();
            editedRowObject.setPlatform(newValue);
        });

        GameDate.setCellValueFactory(new PropertyValueFactory("releaseDate"));
        GameDate.setCellFactory(TextFieldTableCell.forTableColumn());
        GameDate.setOnEditCommit((GameDateEditEvent) -> {
            String newValue = GameDateEditEvent.getNewValue();
            BestSellingGames editedRowObject = GameDateEditEvent.getRowValue();
            editedRowObject.setReleaseDate(newValue);
        });

        GamePublish.setCellValueFactory(new PropertyValueFactory("publisher"));
        GamePublish.setCellFactory(TextFieldTableCell.forTableColumn());
        GamePublish.setOnEditCommit((GamePublishEditEvent) -> {
            String newValue = GamePublishEditEvent.getNewValue();
            BestSellingGames editedRowObject = GamePublishEditEvent.getRowValue();
            editedRowObject.setPublisher(newValue);
        });

        GameDev.setCellValueFactory(new PropertyValueFactory("creator"));
        GameDev.setCellFactory(TextFieldTableCell.forTableColumn());
        GameDev.setOnEditCommit((GameDevEditEvent) -> {
            String newValue = GameDevEditEvent.getNewValue();
            BestSellingGames editedRowObject = GameDevEditEvent.getRowValue();
            editedRowObject.setCreator(newValue);
        });

        boolean hasData = this.gameRestore();
        if (hasData) {
            this.updateGameDataUI();
        }

    }

    public boolean gameRestore() {
        boolean BestSellingGamesRestored = BestSellingGames.restore();
        if (BestSellingGamesRestored) {
            BestSelling.describeAll();
            System.out.println("Game Restored");
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
            System.out.println("Game Imported");
        }
    }

    public void gameSave() {
        BestSellingGames.save();
        System.out.println("Game Saved");
    }

    void updateGameDataUI() {
        BestSellingGameTableView.getItems().clear();
        ArrayList<BestSellingGames> allGames = BestSellingGames.getGames();
        if (allGames != null) {
            allGames.forEach(game -> BestSellingGameTableView.getItems().add(game));
        }
    }
}
