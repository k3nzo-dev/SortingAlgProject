import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

class JavaPaintUI extends JFrame {



    private int tool = 1;
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
            for (int i = 0; i < 25; i++) {
                g.fillRect(20 + (i * 55), 725 - (i * 25), 20, 1500);

            }
//
//            Integer[] intArray = Utility.ShuffledIntArray();
//
//            boolean sorted = false;
//            int temp;
//            while (!sorted) {
//                sorted = true;
//                for (int i = 0; i < intArray.length - 1; i++) {
//                    if (intArray[i] > intArray[i + 1]) {
//                        temp = intArray[i];
//                        intArray[i] = intArray[i + 1];
//                        intArray[i + 1] = temp;
//                        sorted = false;
//
//                    }
//                    g.fillRect(20 + (intArray[i] * 55), 725 - (intArray[i] * 25), 20, 1500);
//                }
//
//            }


        }



    }
}
