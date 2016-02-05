/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ewi.eetrix.ui;

import fi.ewi.eetrix.core.GameControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ewi
 */
public class EetrixUI extends JFrame implements KeyListener {

    static private GameControl gc = new GameControl();
    //Canvas canvas = new Canvas();
    DrawComponent dc = new DrawComponent();
    DrawBlock bl;
    public EetrixUI() {
        //DrawBlock db = new DrawBlock(10,10);
        
        //this.setLayout(new GridLayout(1,2));
        this.setLayout(new FlowLayout());
//        this.add(new JButton());
//        this.add(new JButton());
        ab(15, 40);
        
        //this.add(db);
        pack();
        //db.addActionListener(keyPressAction);

    }
    private void ab(double x,double y) {
        bl = new DrawBlock(x,y);
        this.addKeyListener(this);
        this.add(bl);
        
        Thread t = new Thread(bl);
        t.start();
//        try {
//        bl.gameloop();
//        } catch(Exception e ) {
//            
//        }

    }

    private static void gui() {
        JFrame ui = new EetrixUI();
        ui.setTitle("Eetrix");
        //ui.pack();
        ui.setSize(300, 300);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui();
            }
        });
    }
    
        @Override
     public void keyPressed(KeyEvent e) {
         // System.out.println(e.getKeyCode() + "KEY PRESSED: ");
         if (e.getKeyCode() == 39) {
             bl.moveRight(); 
         }
         if (e.getKeyCode() == 37) {
             bl.moveLeft();
             
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
                 //System.out.println(e.getKeyCode() + "KEY RELEASED: ");

    }
    @Override
    public void keyTyped(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
                 //System.out.println(e.getKeyCode() + "KEY Typed: ");

    }

}
