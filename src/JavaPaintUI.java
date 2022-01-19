/**
 * This class deals with all the graphics
 *
 * All of this code except the "drawSort, onEndSortingPass, onStartSortingPass, Button, and the change counter"
 * are from Stack Overflow https://stackoverflow.com/questions/6118737/how-to-draw-in-jpanel-swing-graphics-java
 */

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class JavaPaintUI extends JFrame implements SortingEventListener {


    private final int tool = 1;
    int currentX, currentY, oldX, oldY;
    private ArrayList<Integer> data;
    private JPanel jPanel;

    private static final int Y_MARGIN_TOP = 10;
    private static final int Y_MARGIN_BOT = 50;
    private static final int X_MARGIN = 20;
    int displayChanges = 0;


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
        this.add(jPanel);
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
            JButton quitButton = new JButton("Quit");
            quitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            this.add(quitButton);
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawSort(g);

        }

    }


    private void drawSort(Graphics g) {

        if (this.data != null) {


            double panelWidth = this.getWidth();

            double barWidth = (panelWidth / this.data.size()) / 2;

            int yRange = this.getHeight() - (Y_MARGIN_BOT + Y_MARGIN_TOP);

            //Counts the number of passes
            Color textColor = new Color(255, 255, 255);
            g.setColor(textColor);
            Font font = new Font("Eurostile", Font.PLAIN, 30);
            g.setFont(font);
            g.drawString("Changes: " + displayChanges, 56, 40);

            for (int i = 0; i < this.data.size(); i++) {


                int stepSize = yRange / this.data.size();
                int space = yRange - (stepSize * this.data.get(i));

                int baseX = new Double(X_MARGIN + (i * (barWidth * 2))).intValue();
                int baseY = Y_MARGIN_TOP + space;

                int width = new Double(barWidth).intValue();
                int height = (this.data.get(i) + 1) * stepSize;

                float r1 = 1.00000F;
                float g1 = 0.83137F;
                float b1 = 0.91765F;

                float r2 = 0.24706F;
                float g2 = 0.78824F;
                float b2 = 0.75294F;
                //declares 2 sets of  sRGB values


                float rDif = r1 - r2;
                float gDif = g1 - g2;
                float bDif = b1 - b2;

                double rScale = rDif / this.data.size();
                double gScale = gDif / this.data.size();
                double bScale = bDif / this.data.size();
                //give a difference for a gradiant


                for (int j = 0; j < this.data.get(i); j++) {
                    r1 -= rScale;
                    b1 -= bScale;
                    g1 -= gScale;
                }
                //gives each of the indexes its own color

                Color gradiantColor = new Color(r1, g1, b1);


                g.setColor(gradiantColor);
                g.fillRoundRect(baseX, baseY, width, height, 15, 15);

            }
        }


    }

    @Override
    public void onStartSortingPass(int pass, ArrayList<Integer> data) {
        this.data = data;
        displayChanges = pass + 1;
        //only runs the first time the first time
        if (pass == 0) {
            this.jPanel.repaint();
        }
    }

    @Override
    public void onEndSortingPass(int pass, ArrayList<Integer> data) {
        //paints every time at the end of the pass
        displayChanges = pass + 1;
        this.jPanel.repaint();
    }
}
