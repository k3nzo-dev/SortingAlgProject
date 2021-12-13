/*
 * Base code from StackOverflow: https://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
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
            setPreferredSize(new Dimension(3000, 1600));
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            draw(g);

        }

    }

    private void draw(Graphics g) {
        if (this.data != null) {

            Graphics2D g2d = (Graphics2D) g;


            double panelWidth = this.getWidth();

            double barWidth = (panelWidth / this.data.size()) / 2;

            int yRange = this.getHeight() - (Y_MARGIN_BOT + Y_MARGIN_TOP);


            for (int i = 0; i < this.data.size(); i++) {

//                double stepSize = (double)yRange / this.data.size();
//                double space = yRange - (stepSize * this.data.get(i));
//
//
//                double baseX = X_MARGIN + (i * (barWidth * 2));
//                double baseY = Y_MARGIN_TOP + space;
//                double height = (this.data.get(i) + 1) * stepSize;
//
//
//
//
//                Rectangle2D r2d = new Rectangle2D.Double(height,barWidth,baseX,baseY);
//                g2d.fill(r2d);

                int stepSize = yRange / this.data.size();
                int space = yRange - (stepSize * this.data.get(i));

                int baseX = new Double(X_MARGIN + (i * (barWidth * 2))).intValue();
                int baseY = Y_MARGIN_TOP + space;

                int width = new Double(barWidth).intValue();
                int height = (this.data.get(i) + 1) * stepSize;

                int r1 = 255;
                int g1 = 0;
                int b1 = 0;

                int r2 = 255;
                int g2 = 171;
                int b2 = 171;

                int redIncrease = (r2 - r1) / this.data.size();
                int greenIncrease = (g2 - g1) / this.data.size();
                int blueIncrease = (b2 - b1) / this.data.size();



                g.setColor(new java.awt.Color(
                        r1 + (redIncrease * this.data.get(i)),
                        g1 + (greenIncrease * this.data.get(i)),
                        b1 + (blueIncrease * this.data.get(i))));

                g.fillRoundRect(baseX, baseY, width, height, 15, 15);
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
