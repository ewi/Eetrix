/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.core;

/**
 *
 * @author ewi
 */
public class Block implements Runnable {

    private BlockShape blockshape;
    private int xPosition;
    private int yPosition;

    public Block() {
        this.yPosition = 0;
        this.xPosition = 0;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }

    public Block(int x, int y) {
        this.yPosition = x;
        this.xPosition = y;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }

    public int getXposition() {
        return this.xPosition;
    }

    public int getYposition() {
        return this.yPosition;
    }

    public void moveLeft() {
        this.xPosition -= 1;
    }

    public void moveRight() {
        this.xPosition += 1;
    }

    public void moveUp() {
        this.yPosition += 1;
    }

    public void moveDown() {
        this.yPosition -= 1;
    }

    public boolean collision() {
        return false;
    }

    public void setX(int x) {
        this.xPosition = x;
    }

    public void setY(int y) {
        this.yPosition = y;
    }

    public char[][] getShape() {
        return this.blockshape.getBlockShape();
    }

    public boolean[][] getblockBoolean() {
        return this.blockshape.getBooleanBlockShape();
    }

    @Override
    public void run() {
        try {

            while (true) {
                moveDown();
                if (collision()) {
                    break;
                }
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {

        }
    }

}
