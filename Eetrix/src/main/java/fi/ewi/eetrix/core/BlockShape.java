package fi.ewi.eetrix.core;

/**
 * Class for block shapes.
 * Shapes are decoded as integer array variable blockarray 
 * which describes block shape by defining blocks via integer number.
 * Number indicates block color.
 * Example: height 2 L-shape
 * blockarray[0][] = {1,1,1}";
 * blockarray[1][] = {1,0,0};
 * @author ewi
 */
public class BlockShape {

    private int[][] blockarray;
    private boolean[][] blockarrayboolean;
    private int[] blockboundaries;

    /**
     * Empty constructor because of overload.
     */
    public BlockShape() {
    }

    /**
     * define square block of size 1x1.
     */
    public void squareBlock() {
        blockarray = new int[1][1];
        blockarray[0][0] = 1;
        blockboundaries = new int[]{1, 1};
        blockarrayboolean = setBooleanBlockshape();
    }
    /**
     * Define square block of size 2x2.
     */
    public void bigsquareBlock() {
        blockarray = new int[2][2];
        blockarray[0][0] = 1;
        blockarray[0][1] = 1;
        blockarray[1][0] = 1;
        blockarray[1][1] = 1;
        setBooleanBlockshape();

    }

    /**
     * Get random block shape.
     * @return BlockShape object
     */
    public BlockShape getRandomBlockshape() {
        blockarray = new int[2][2]; // Randomize
        blockarray[0][0] = 1;
        blockarray[0][1] = 1;
        blockarray[1][0] = 1;
        blockarray[1][1] = 1;
        return this;
    }

    /**
     * Get blockshape as integer array.
     * @return integer array of block
     */
    public int[][] getBlockShape() {
        return this.blockarray;
    }

    /**
     * Construct boolean array from blockarray.
     * @return boolean array
     */
    private boolean[][] setBooleanBlockshape() {
        boolean[][] b = new boolean[this.blockboundaries[0]][this.blockboundaries[1]];
        for (int i = 0; i < this.blockarray.length; i++) {
            for (int j = 0; j < this.blockarray[i].length; j++) {
                if (this.blockarray[i][j] == 1) {
                    b[i][j] = true;
                } else {
                    b[i][j] = false;
                }
            }
        }
        return b;

    }
    
    /**
     * Getter for boolean block shape array.
     * @return boolean array
     */
    public boolean[][] getBooleanBlockShape() {
        return this.blockarrayboolean;
    }

    /**
     * Get block maximum boudary box.
     * Return value indicates maximum x and y.
     * @return two integers in array
     */
    public int[] getBlockBoundaries() {
        return this.blockboundaries;
    }
}
