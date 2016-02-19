package fi.ewi.eetrix.core;

/**
 * Class for game area operations.
 * @author ewi
 */
public class GameArea {

    private int x, y;
    private int[][] area;
    private Block block;

    /**
     * Pelialue, parametrit pelialueen leveys ja korkeus
     *
     * @param x
     * @param y
     */
    public GameArea(int x, int y) {
        this.x = x;
        this.y = y;
        this.area = new int[x][y];
        initArea(); // Initialize area to false
    }

    /**
     * Occupy cell in game area
     *
     * @param x
     * @param y
     */
    public boolean setCell(int x, int y) {
        int u = x - 1;
        int v = y - 1;
        if (x > this.getX() - 1) {
            return false;
        }
        if (y > this.getY() - 1) {
            return false;
        }

        if (!testCell(x, y)) {
            this.area[x][y] = 1;
        }
        return true;
    }
    /**
     * Test if gamearea cell at position x,y is free.
     * @param x
     * @param y
     * @return true if free
     */
    public boolean testCell(int x, int y) {
        if (area[x][y] == 0) {
            return true;
        }
        return false;
    }

    /**
     * Set areacells to zero, this indicates non occupied cell.
     */
    private void initArea() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.area[i][j] = 0;
            }
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean testCollision(Block bl) {
        int x = bl.getXposition();
        int y = bl.getYposition();
        int z = 0;
        for (int[] t : bl.getShape()) {
            for (int i = 0; i < t.length; i++) {
                if (t[i] == 1 && (x + i) > this.x || (x + i) < 0) {
                    return true;
                }
                if (t[i] == 1 && (y + i) > this.y || (y + i) < 0) {
                    return true;
                }
            }
            z++;
        }
        return false;

    }

    /**
     * Merge block to gameArea.
     * @return 
     */
    public boolean mergeBlock() {
        System.out.println("Pituus : " + this.block.getblockBoolean().length);
        for (int i = 0; i < this.block.getShape().length; i++) {
            for (int j = 0; j < this.block.getShape()[i].length; j++) {
                if (this.block.getShape()[i][j] == 1) {
                    setCell(this.block.getXposition() + i, this.block.getYposition() + j);
                }
            }
        }
        return true;
    }

    /**
     * Initialize new block at center of gamearea.
     *
     * @return
     */
    public boolean newBlock() {
        block = new Block(this.x / 2, 0); // Initial position at middle of playing area 
        // and top of coordinate grid (y=0)
        return true;
    }

    /**
     * Set block variable.
     * @param bl
     */
    public void setBlock(Block bl) {
        this.block = bl;
    }
    
    public Block getBlock() {
        return this.block;
    }

    public int[][] getGameArea() {
        return this.area;
    }
}
