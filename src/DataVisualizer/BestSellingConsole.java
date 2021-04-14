package DataVisualizer;

import java.io.File;
import java.util.Scanner;

public class BestSellingConsole extends BestSelling {

    // Fields
    private String ConsoleName;
    private String BestSellingGame;

    // Getters and Setters
    public String getConsoleName() {
        return ConsoleName;
    }

    public void setConsoleName(String consoleName) {
        ConsoleName = consoleName;
    }

    public String getBestSellingGame() {
        return BestSellingGame;
    }

    public void setBestSellingGame(String bestSellingGame) {
        BestSellingGame = bestSellingGame;
    }

    // Constructor
    public BestSellingConsole(int ranking, String name, int unitSold, String releaseDate, String creator, String consoleName, String bestSellingGame) {
        super(ranking, name, unitSold, releaseDate, creator);
        ConsoleName = consoleName;
        BestSellingGame = bestSellingGame;
    }

    // Methods
    public String toString() {
        String description = "\"" + this.getName();
        description = description + "\" has sold " + this.getUnitSold() + " units.";
        description = description + "\" The console was released " + this.getReleaseDate();
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
            String Consolename = lineScanner.next();
            String Companyname = lineScanner.next();
            int year = lineScanner.nextInt();
            String salenumbers = lineScanner.next();
        }

    }
}


