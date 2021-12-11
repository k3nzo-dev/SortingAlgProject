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

class JavaPaintUI extends JFrame
        implements SortingEventListener {


    private final int tool = 1;
    int currentX, currentY, oldX, oldY;
    private ArrayList<Integer> data;
    private JPanel jPanel;
    private static int Y_MARGIN_TOP = 10;
    private static int Y_MARGIN_BOT = 50;
    private static int X_MARGIN = 20;


    public JavaPaintUI() {
        initComponents();
    }

    private void initComponents() {
        // we want a custom Panel2, not a generic JPanel!
        jPanel = new BarPanel();

        jPanel.setBackground(new java.awt.Color(103, 97, 97));
        jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jPanel2MousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });

        // add the component to the frame to see it!
        this.setContentPane(jPanel);
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

    class BarPanel extends JPanel {

        BarPanel() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(1500, 800));
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            draw(g);

        }

    }

    private void draw(Graphics g) {
        if (this.data != null) {

            int barWidth = this.getWidth() / this.data.size() / 2;
            int yRange = this.getHeight() - (Y_MARGIN_BOT + Y_MARGIN_TOP);


            for (int i = 0; i < this.data.size(); i++) {
                int stepSize = yRange / this.data.size();
                int space = yRange - (stepSize * this.data.get(i));

                int height = (this.data.get(i) + 1) * stepSize;
                int baseX = X_MARGIN + (i * (barWidth * 2));
                int baseY = Y_MARGIN_TOP + space;
                //(725 - Y_MARGIN_BOT) - (this.data.get(i) * 20);
//                if (baseY >= this.getHeight())
//                    baseY = this.getHeight() + Y_MARGIN_BOT;


                g.fillRoundRect(baseX, baseY, barWidth, height, 15, 15);
            }
        }


    }

    @Override
    public void onStartSortingPass(int pass, ArrayList<Integer> data) {
        this.data = data;

        //at the start only the first time
        if (pass == 0) {
            this.jPanel.repaint();
        }
    }

    @Override
    public void onEndSortingPass(int pass, ArrayList<Integer> data) {
        //every time at the end of the pass

        this.jPanel.repaint();
    }
}
