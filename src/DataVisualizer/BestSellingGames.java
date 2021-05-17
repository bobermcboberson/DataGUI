package DataVisualizer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BestSellingGames extends BestSelling implements Serializable {

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
            games = new ArrayList<>();
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

    static public void save() {
        if (games != null && !BestSellingGames.games.isEmpty()) {
            try {
                File saveModelFile = new File("serializedAllBestSellingGames");
                FileOutputStream savedModelFileStream = new FileOutputStream(saveModelFile);
                ObjectOutputStream out = new ObjectOutputStream(savedModelFileStream);
                out.writeObject(games);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static public boolean restore() {
        File savedModelFile = new File("serializedAllBestSellingGames");
        if (savedModelFile.exists()) {
            try {
                FileInputStream savedModelFileStream = new FileInputStream(savedModelFile);
                ObjectInputStream in = new ObjectInputStream(savedModelFileStream);
                games = (ArrayList<BestSellingGames>) in.readObject();
                if (!games.isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}