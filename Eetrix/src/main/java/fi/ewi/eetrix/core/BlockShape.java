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
public class BlockShape {

    // blockarray describes block shape by defining blocks via binary 
    // code. Example: height 2 L-shape
    // blockarray[0][0-2] = "111";
    // blockarray[1][0-2] = "100";
    private char[][] blockarray;
    private boolean[][] blockarrayboolean;
    private int[] blockboundaries;

    public BlockShape() {
    }

    public void squareBlock() {
        blockarray = new char[1][1];
        blockarray[0][0] = '1';
        blockboundaries = new int[]{1, 1};
        blockarrayboolean = setBooleanBlockshape();
    }

    public void bigsquareBlock() {
        blockarray = new char[2][2];
        blockarray[0][0] = '1';
        blockarray[0][1] = '1';
        blockarray[1][0] = '1';
        blockarray[1][1] = '1';
        setBooleanBlockshape();

    }

    public BlockShape getRandomBlockshape() {
        blockarray = new char[2][2]; // Randomize
        blockarray[0][0] = '1';
        blockarray[0][1] = '1';
        blockarray[1][0] = '1';
        blockarray[1][1] = '1';
        setBooleanBlockshape();
        return this;
    }

    public char[][] getBlockShape() {
        return this.blockarray;
    }

    private boolean[][] setBooleanBlockshape() {
        boolean[][] b = new boolean[this.blockboundaries[0]][this.blockboundaries[1]];
        for (int i = 0; i < this.blockarray.length; i++) {
            for (int j = 0; j < this.blockarray[i].length; j++) {
                if (this.blockarray[i][j] == '1') {
                    b[i][j] = true;
                } else {
                    b[i][j] = false;
                }
            }
        }
        return b;

    }
    public boolean[][] getBooleanBlockShape() {
        return this.blockarrayboolean;
    }

    public int[] getBlockBoundaries() {
        return this.blockboundaries;
    }

}
