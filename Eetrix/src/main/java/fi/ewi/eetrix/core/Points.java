package fi.ewi.eetrix.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Pisteiden laskemiseen tehty luokka.
 *
 * @author ewi
 */
public class Points {

    private FileControl filecontrol;
    private int points;
    private ArrayList<PointsContainer> pointslist = new ArrayList<>();

    public Points() {
        this.points = 0;
        filecontrol = new FileControl("eetrixpoints.dat");
    }

    public boolean addPoints() {
        return addPoints(1);
    }
    public boolean addPoints(int p) {
        if (testIntegeroverflow(1))
            return false;
        this.points += p;
        return true;
    }
    
    public void savePoints() {
        ArrayList<String> list = new  ArrayList<>();
        for (PointsContainer x: pointslist)
            list.add(x.toString());
        filecontrol.setFileContents(list);
    }
    
    private boolean testIntegeroverflow(int x) {
        try {
            Math.addExact(this.points, x);
        } catch (ArithmeticException e) {
            return true;
        }
        return false;
    }
    public int getPoints() {
        return this.points;
    }
    private void readPointsfromFile() {
        for (String x : filecontrol.getFileContents())
            pointslist.add(new PointsContainer(x));
    }
    
    public void addPlayerToList(String playername) {
        PointsContainer pc = new PointsContainer();
        pc.setPlayer(playername);
        pc.setPoints(this.points);
        pointslist.add(pc);
    }

    class PointsContainer {

        private int points;
        private String playerName;
        public PointsContainer() {}
        public PointsContainer(String s) {
            fromString(s);
        }

        public void setPoints(int p) {
            this.points = p;
        }

        public void setPlayer(String pl) {
            this.playerName = pl;
        }

        @Override
        public String toString() {
            return (this.playerName + ":" + this.points);
        }

        public void fromString(String s) {
            ArrayList<String> splitted = new ArrayList<>();
            Scanner lukija = new Scanner(s);
            lukija.useDelimiter(":");
            while (lukija.hasNext()) {
                splitted.add(lukija.next());
            }
            if (splitted.size() == 2) {
                this.points = Integer.parseInt(splitted.get(1));
                this.playerName = splitted.get(0);
            }
        }
    }
}
