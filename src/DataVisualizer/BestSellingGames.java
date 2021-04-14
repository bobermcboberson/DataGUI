package DataVisualizer;

import java.io.File;
import java.util.Scanner;

public class BestSellingGames extends BestSelling {

    // Fields
    private String Publisher;
    private String Platform;

    // Constructor
    BestSellingGames(int ranking, String name, int unitSold, String platform, String releaseDate, String creator, String publisher) {
        super(ranking, name, unitSold, releaseDate, creator);
        Platform = platform;
        Publisher = publisher;
    }

    // Getters and Setters
    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
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
}