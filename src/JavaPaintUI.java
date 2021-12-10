/*
 * Base code from StackOverflow: https://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

class JavaPaintUI extends JFrame {


    private final int tool = 1;
    int currentX, currentY, oldX, oldY;


    public JavaPaintUI() {
        initComponents();
    }

    private void initComponents() {
        // we want a custom Panel2, not a generic JPanel!
        jPanel2 = new Panel2();

        jPanel2.setBackground(new java.awt.Color(103, 97, 97));
        jPanel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });

        // add the component to the frame to see it!
        this.setContentPane(jPanel2);
        // be nice to testers..
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }// </editor-fold>

    private void jPanel2MouseDragged(MouseEvent evt) {
        if (tool == 1) {
            currentX = evt.getX();
            currentY = evt.getY();
            oldX = currentX;
            oldY = currentY;

        }
    }

    private void jPanel2MousePressed(MouseEvent evt) {
        oldX = evt.getX();
        oldY = evt.getY();
    }


    //mouse released//
    private void jPanel2MouseReleased(MouseEvent evt) {
        if (tool == 2) {
            currentX = evt.getX();
            currentY = evt.getY();
        }
    }

    //set ui visible//
    public static void uiStart() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaPaintUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JPanel jPanel2;
    // End of variables declaration

    // This class name is very confusing, since it is also used as the
    // name of an attribute!
    //class jPanel2 extends JPanel {
    class Panel2 extends JPanel {

        Panel2() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(1500, 800));
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            JavaPaintUI.bubSortDraw(g);

        }

    }

    private static void bubSortDraw(Graphics g) {
        ArrayList<Integer> intArray = Utility.ShuffledIntArray(25);
        System.out.println(intArray);
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < intArray.size() - 1; i++) {
                if (intArray.get(i) > intArray.get(i + 1)) {
                    temp = intArray.get(i);
                    intArray.set(i, intArray.get(i + 1));
                    intArray.set(i + 1, temp);
                    sorted = false;
                }
                g.fillRect(20 + (intArray.get(i) * 55), 725 - (intArray.get(i) * 25), 20, 1500);
            }

        }
    }
}
