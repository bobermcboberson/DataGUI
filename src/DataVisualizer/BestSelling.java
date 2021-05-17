package DataVisualizer;

import java.io.*;
import java.util.ArrayList;

public class BestSelling implements Serializable {

    // Fields
    private static ArrayList<BestSelling> sales;
    private String name;
    private int unitSold;
    private String releaseDate;
    private String creator;
    private int ranking;

    // Constructor
    BestSelling(int ranking, String name, int unitSold, String releaseDate, String creator) {
        this.ranking = ranking;
        this.name = name;
        this.unitSold = unitSold;
        this.releaseDate = releaseDate;
        this.creator = creator;

        // Arraylist
        if (sales == null) {
            sales = new ArrayList<>();
        }
        sales.add(this);
    }

    //Getters and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(int unitSold) {
        this.unitSold = unitSold;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    static void describeAll() {
        if (sales != null) {
            sales.forEach(sales -> {
                System.out.println(sales.toString());
            });
        }
    }

    // Methods
    static public boolean restore() {
        // try to read (deserialize) model objects from disk
        File savedModelFile = new File("serializedAllSales");
        if (savedModelFile.exists()) {
            try {
                FileInputStream savedModelFileStream = new FileInputStream(savedModelFile);
                ObjectInputStream in = new ObjectInputStream(savedModelFileStream);
                sales  = (ArrayList<BestSelling>)in.readObject();
                if (!sales.isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    static public void save() {
        // write (serialize) the model objects
        if (sales != null && !sales.isEmpty()) {
            try {
                File savedFile = new File("serializedAllBestSales");
                FileOutputStream savedFileStream = new FileOutputStream(savedFile);
                ObjectOutputStream out = new ObjectOutputStream(savedFileStream);
                out.writeObject(sales);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}