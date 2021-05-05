package DataVisualizer;

import java.util.ArrayList;

public class BestSelling {

    // Fields
    private static ArrayList<BestSelling> sales;
    private String name;
    private int unitSold;
    private String releaseDate;
    private String creator;
    private int ranking;

    // Constructor
    BestSelling(int ranking, String name, int unitSold, String releaseDate, String creator) {
        this.name = name;
        this.unitSold = unitSold;
        this.releaseDate = releaseDate;
        this.creator = creator;
        this.ranking = ranking;

        if (sales == null) {
            sales = new ArrayList<BestSelling>();
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
        sales.forEach(sales -> {
            System.out.println(sales.toString());
        });
    }
}