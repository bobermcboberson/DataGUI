package DataVisualizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BestSellingGames extends BestSelling {

    // Fields
    private static Controller myController;
    private String Publisher;
    private String Platform;
    private static ArrayList<BestSellingGames> games;

    // Constructor
    BestSellingGames(int ranking, String name, int unitSold, String platform, String releaseDate, String creator, String publisher) {
        super(ranking, name, unitSold, releaseDate, creator);
        Platform = platform;
        Publisher = publisher;

        // Arraylist
        if (games == null) {
            games = new ArrayList<BestSellingGames>();
        }
        games.add(this);
    }

    // Getters and Setters
    public static Controller getMyController() {
        return myController;
    }

    public static void setMyController(Controller myController) {
        BestSellingGames.myController = myController;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public static ArrayList<BestSellingGames> getGames() {
        return games;
    }

    public static void setGames(ArrayList<BestSellingGames> games) {
        BestSellingGames.games = games;
    }

    // Methods
    public String toString() {
        String description = "The number " + this.getRanking() + " game, ";
        description = description + "\"" + this.getName();
        description = description + "\" has sold " + this.getUnitSold() + " units.";
        description = description + "\" The game was released " + this.getReleaseDate();
        description = description + "\" by " + this.getCreator();
        return description;
    }

    static void read(String dataFilePath) {
        // creates new scanner
        Scanner scanner = null;
        try {
            File file = new File(dataFilePath);
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem opening file: " + dataFilePath);
        }
        if (scanner == null) {
            return;
        }

        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            Scanner lineScanner = new Scanner(next);
            lineScanner.useDelimiter("\t");

            // the tokens
            int ranking = lineScanner.nextInt();
            String title = lineScanner.next();
            int sales = lineScanner.nextInt();
            String platform = lineScanner.next();
            String releaseDate = lineScanner.next();
            String developer = lineScanner.next();
            String publisher = lineScanner.next();

            BestSellingGames bestSellingGame = new BestSellingGames(ranking, title, sales, platform, releaseDate, developer, publisher);
        }

    }

    static void initialize() {
        read("BestSellingGamesData");
        getMyController().updateGameDataUI();
    }
}