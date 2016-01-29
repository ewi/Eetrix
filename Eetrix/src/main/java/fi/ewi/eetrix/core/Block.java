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
public class Block {
    
    private BlockShape blockshape;
    private int Xposition;
    private int Yposition;
    
    public Block() {
        this.Yposition = 0;
        this.Xposition = 0;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }
    
    public Block(int x,int y ) {
        this.Yposition = x;
        this.Xposition = y;
        this.blockshape = new BlockShape();
        this.blockshape.squareBlock();
    }

    public int getXposition() {
        return this.Xposition;
    }
    
    public int getYposition() {
        return this.Yposition;
    }
    
    public void moveLeft() {
        this.Xposition -= 1;
    }
    public void moveRight() {
        this.Xposition += 1;
    }
    public void moveUp() {
        this.Yposition += 1;
    }
    public void moveDown() {
        this.Yposition -= 1;
    }
    public boolean Collision() {
        return false;
    }
    public void setX(int x){
        this.Xposition = x;
    }
    public void setY(int y){
        this.Yposition = y;
    }
    
    public char[][] getShape() {
        return this.blockshape.getBlockShape();
    }
    public boolean[][] getblockBoolean() {
        return this.blockshape.getBooleanBlockShape();
    }
}
