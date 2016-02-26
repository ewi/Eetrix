package fi.ewi.eetrix.core;

/**
 * Class for game area operations.
 *
 * @author ewi
 */
public class GameArea {

    private int x, y;
    private int[][] area;
    private Block block;

    /**
     * Game area constructor for width of x and height of y.
     *
     * @param x width
     * @param y height
     */
    public GameArea(int x, int y) {
        this.x = x;
        this.y = y;
        this.area = new int[x][y];
        initArea(); // Initialize area to 0
    }

    /**
     * Occupy cell x,y in game area. Tests if cell is already occupied.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param cellvalue cell value integer
     * @return true if success
     */
    public boolean setCell(int x, int y, int cellvalue) {
        int u = x - 1;
        int v = y - 1;
        if (x > this.getWidth() - 1) {
            return false;
        }
        if (y > this.getHeight() - 1) {
            return false;
        }

        if (!testCell(x, y)) {
            this.area[x][y] = cellvalue;
        }
        return true;
    }

    /**
     * Test if gamearea cell at position x,y is free.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return true if free
     */
    public boolean testCell(int x, int y) {
        if (area[x][y] == 0) {
            return true;
        }
        return false;
    }

    /**
     * Init area to zero, this indicates non occupied cell.
     */
    private void initArea() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.area[i][j] = 0;
            }
        }
    }

    /**
     * Get row as Integer array.
     * @param rowNumber row to get
     * @return integer array
     */
    public int[] getRow(int rowNumber) {
        return this.area[rowNumber];
    }
    
    /**
     * Get game area width.
     *
     * @return integer
     */
    public int getWidth() {
        return this.x;
    }

    /**
     * Get gamearea height.
     *
     * @return integer
     */
    public int getHeight() {
        return this.y;
    }

    /**
     * Test if block will collide with existing game area occupied cells.
     *
     * @return true if collision will happen
     */
    public boolean testCollision() {
        int x = block.getXposition();
        int y = block.getYposition() - 1; // next position.
        int z = 0;
        for (int[] t : block.getShape()) {
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
     *
     * @return true if merge succeeded
     */
    public boolean mergeBlock() {
        for (int i = 0; i < this.block.getShape().length; i++) {
            for (int j = 0; j < this.block.getShape()[i].length; j++) {
                if (this.block.getShape()[i][j] == 1) {
                    setCell(this.block.getXposition() + i, 
                            this.block.getYposition() + j, 
                            this.block.getColornum());
                }
            }
        }
        return true;
    }

    /**
     * Initialize new block at center of gamearea.
     *
     */
    public void newBlock() {
        block = new Block(this.x / 2, 0); // Initial position at middle of playing area 
        // and top of coordinate grid (y=0)
    }

    /**
     * Set block variable.
     *
     * @param bl Block object
     */
    public void setBlock(Block bl) {
        this.block = bl;
    }

    /**
     * Get block object.
     * @return Block object
     */
    public Block getBlock() {
        return this.block;
    }

    /**
     * Return game area array.
     * @return  integer array
     */
    public int[][] getGameArea() {
        return this.area;
    }
}
