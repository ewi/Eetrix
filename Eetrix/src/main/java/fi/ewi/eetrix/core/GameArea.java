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
public class GameArea {

    private int x, y;
    private boolean[][] area;
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
        this.area = new boolean[x][y];
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
        if (x > this.getX()-1)
            return false;
        if (y > this.getY()-1)
            return false;
        
        if (!testCell(x, y)) {
            this.area[x][y] = true;
        }
        return this.area[x][y];
    }

    public boolean testCell(int x, int y) {
        return area[x][y];
    }

    /**
     * Set areacells to falss, this indicates non occupied cell.
     */
    private void initArea() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.area[i][j] = false;
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
        for (char[] t : bl.getShape()) {
            for (int i = 0; i < t.length; i++) {
                if (t[i] == '1' && (x + i) > this.x || (x + i) < 0) {
                    return true;
                }
                if (t[i] == '1' && (y + i) > this.y || (y + i) < 0) {
                    return true;
                }
            }
            z++;
        }
        return false;

    }
    
    /**
     * Merge gameblock to gamearea
     * @return 
     */
    public boolean mergeBlock() {
        System.out.println("Pituus : " + this.block.getblockBoolean().length);
        for (int i = 0;i < this.block.getblockBoolean().length; i++) {
            for (int j = 0; j < this.block.getblockBoolean()[i].length;j++) {
                if (this.block.getblockBoolean()[i][j] == true) {
                    setCell(this.block.getXposition()+i,this.block.getYposition()+j);
                }
            }
        }
        return true;
    }
    
    public boolean newBlock() {
        block = new Block(this.x/2,0); // Initial position at middle of playing area 
        // and top of coordinate grid (y=0)
        return true;
    }
    public void setBlock(Block bl) {
        this.block = bl;
    }
    
    public boolean[][] getGameArea() {
        return this.area;
    }
}
