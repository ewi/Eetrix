package fi.ewi.eetrix.core;

/**
 * Class for block handling.
 * @author ewi
 */
public class Block implements Runnable {

    private BlockShape blockshape;
    private int xPosition;
    private int yPosition;

    /**
     * Create a block in position 0,0.
     */
    public Block() {
        this.yPosition = 0;
        this.xPosition = 0;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }
    /**
     * Create a block in position x,y.
     * @param x
     * @param y 
     */
    public Block(int x, int y) {
        this.yPosition = x;
        this.xPosition = y;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }
    
    /**
     * Get current block x-position.
     * @return x-position
     */
    public int getXposition() {
        return this.xPosition;
    }
    /**
     * Get current block x-position.
     * @return 
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

    public void moveUp() {
        this.yPosition += 1;
    }

    public void moveDown() {
        this.yPosition -= 1;
    }

    public void setX(int x) {
        this.xPosition = x;
    }

    public void setY(int y) {
        this.yPosition = y;
    }

    public int[][] getShape() {
        return this.blockshape.getBlockShape();
    }

    public boolean[][] getblockBoolean() {
        return this.blockshape.getBooleanBlockShape();
    }
    
    private boolean collisionHappened = false;
    
    public void setCollisionHappened() {
        this.collisionHappened = true;
    }
    @Override
    public void run() {
        try {

            while (true) {
                moveDown();
                if (this.collisionHappened) {
                    break;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }
    }

}
