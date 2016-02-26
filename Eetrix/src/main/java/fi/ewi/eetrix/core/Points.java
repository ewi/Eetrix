package fi.ewi.eetrix.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for counting points.
 *
 * @author ewi
 */
public class Points {

    private FileControl filecontrol;
    private int points;
    private ArrayList<PointsContainer> pointslist = new ArrayList<>();

    /**
     * Constructor, sets initial points to zero.
     * Also set file to save points.
     */
    public Points() {
        this.points = 0;
        filecontrol = new FileControl("eetrixpoints.dat");
    }

    /**
     * Add one point.
     * @return true if success
     */
    public boolean addPoints() {
        return addPoints(1);
    }

    /**
     * Add p points.
     * @param p integer number of points to add.
     * @return true if success
     */
    public boolean addPoints(int p) {
        if (testIntegeroverflow(1)) {
            return false;
        }
        this.points += p;
        return true;
    }

    /**
     * Save points to file.
     */
    public void savePoints() {
        ArrayList<String> list = new ArrayList<>();
        for (PointsContainer x : pointslist) {
            list.add(x.toString());
        }
        filecontrol.setFileContents(list);
    }

    /**
     * Test if points variable is going to overflow.
     * @param x integer
     * @return true if no overflow
     */
    private boolean testIntegeroverflow(int x) {
        try {
            Math.addExact(this.points, x);
        } catch (ArithmeticException e) {
            return true;
        }
        return false;
    }
    /**
     * Get points value.
     * @return integer current points
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Read points to array from points savefile.
     */
    private void readPointsfromFile() {
        for (String x : filecontrol.getFileContents()) {
            pointslist.add(new PointsContainer(x));
        }
    }

    /**
     * Add player name with points to pointslist.
     * @param playername name of player.
     */
    public void addPlayerToList(String playername) {
        PointsContainer pc = new PointsContainer();
        pc.setPlayer(playername);
        pc.setPoints(this.points);
        pointslist.add(pc);
    }

    /**
     * Inner class for holding points and associated player.
     */
    class PointsContainer {

        private int points;
        private String playerName;

        /**
         * Empty constructor because overload.
         */
        public PointsContainer() {
        }
        /**
         * Constructor. Sets player name to s.
         * @param s player name
         */
        public PointsContainer(String s) {
            fromString(s);
        }

        /**
         * Set points to value p.
         * @param p integer
         */
        public void setPoints(int p) {
            this.points = p;
        }

        /**
         * Set playername to pl.
         * @param pl name
         */
        public void setPlayer(String pl) {
            this.playerName = pl;
        }

        @Override
        public String toString() {
            return (this.playerName + ":" + this.points);
        }
        
        /**
         * Get values from string.
         * String format: playername:points
         *
         * @param s String in format described above.
         */
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
