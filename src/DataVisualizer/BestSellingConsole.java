package DataVisualizer;

import java.io.File;
import java.util.Scanner;

public class BestSellingConsole extends BestSelling {

    // Fields


    public BestSellingConsole(int ranking, String name, int unitSold, String releaseDate, String creator) {
        super(ranking, name, unitSold, releaseDate, creator);
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
            BestSellingConsole console = new BestSellingConsole(ranking, Consolename, year, Companyname, salenumbers);
            System.out.println(console);
        }

    }
}


