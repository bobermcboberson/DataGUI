package DataVisualizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BestSellingConsole extends BestSelling {

    // Fields
static Controller MyControl;
static ArrayList<BestSellingConsole> AllConsole;

    public static ArrayList<BestSellingConsole> getAllConsole() {
        return AllConsole;
    }

    public static void setAllConsole(ArrayList<BestSellingConsole> allConsole) {
        AllConsole = allConsole;
    }

    public static Controller getMyControl() {
        return MyControl;
    }

    public static void setMyControl(Controller myControl) {
        MyControl = myControl;
    }

    public BestSellingConsole(int ranking, String name, int unitSold, String releaseDate, String creator) {
        super(ranking, name, unitSold, releaseDate, creator);
        if (AllConsole == null) {
            AllConsole = new ArrayList<BestSellingConsole>();
        }
        AllConsole.add(this);
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
            String year = lineScanner.next();
            int salenumbers = lineScanner.nextInt();
            BestSellingConsole console = new BestSellingConsole(ranking, Consolename, salenumbers, year, Companyname);
            System.out.println(console);

        }
    }
       static void initialize() {
       read("BestSellingConsoleData");
       MyControl.updateConsoleDataUI();
        }
    }



