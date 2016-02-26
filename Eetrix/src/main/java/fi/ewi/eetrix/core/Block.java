package fi.ewi.eetrix.core;

/**
 * Class for block handling.
 *
 * @author ewi
 */
public class Block implements Runnable {

    private BlockShape blockshape;
    private int xPosition;
    private int yPosition;
    private int colorNumber;

    /**
     * Create a block in position 0,0.
     */
    public Block() {
        this.yPosition = 0;
        this.xPosition = 0;
        this.colorNumber = 1;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }

    /**
     * Create a block in position x,y.
     *
     * @param x x-position.
     * @param y y-position
     */
    public Block(int x, int y) {
        this.yPosition = x;
        this.xPosition = y;       
        this.colorNumber = 1;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }

    public void setBlockColor(int colornum) {
        this.colorNumber = colornum;
    }
    
    public int getColornum() {
        return this.colorNumber;
    }
    /**
     * Get current block x-position.
     *
     * @return x-position
     */
    public int getXposition() {
        return this.xPosition;
    }

    /**
     * Get current block x-position.
     *
     * @return y-position
     */
    public int getYposition() {
        return this.yPosition;
    }

    /**
     * Move block left.
     */
    public void moveLeft() {
        this.xPosition -= 1;
    }

    /**
     * Move block right.
     */
    public void moveRight() {
        this.xPosition += 1;
    }

    /**
     * Move block up.
     */
    public void moveUp() {
        this.yPosition += 1;
    }

    /**
     * Move block down.
     */
    public void moveDown() {
        this.yPosition -= 1;
    }

    /**
     * Set block x-position.
     *
     * @param x x-position integer
     */
    public void setX(int x) {
        this.xPosition = x;
    }

    /**
     * Set block y-position.
     *
     * @param y integer.
     */
    public void setY(int y) {
        this.yPosition = y;
    }

    /**
     * Get block shape matrix as integer array.
     * @return integer array
     */
    public int[][] getShape() {
        return this.blockshape.getBlockShape();
    }

    /**
     * boolean variable for detecting collision. Used in MVC Controller.
     */
    private boolean collisionHappened = false;

    /**
     * Setter for variable collisionHappened.
     */
    public void setCollisionHappened() {
        this.collisionHappened = true;
    }

    /**
     * Set game level. 
     */
    private int gamelevel;
    public void setGamelevel(int level) {
        this.gamelevel = 1000 / level;
    }
    /**
     * Thread run method for moving block down.
     */
    @Override
    public void run() {
        try {

            while (true) {
                moveDown();
                if (this.collisionHappened) {
                    break;
                }
                Thread.sleep(this.gamelevel);
            }
        } catch (InterruptedException e) {

        }
    }

}
