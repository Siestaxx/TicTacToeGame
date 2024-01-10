/* Ran Cheng (Net ID: rcheng9 & URID: 31729772) and Yiwei Han (Net ID: yhan32 & URID: 31826174) collaborate on this
TicTacToe project.
   Everything in this program works very well, the functions and criterias all meet.
   Ran Cheng first developed the general program, but it has several bugs. Yiwei Han and Ran Cheng correct these bugs
and it works very well now.
   The first bug is that the layout is very messy. The buttons correspond to each grid is placed somewhere else instead
of in the grid. Yiwei Han corrected this bug.
   The second bug is that when someone wins or the game is a draw, the score indicator does not show anything. Yiwei Han
corrected this bug.
   The third bug is that when you place a X or an O, that place can still be placed with new X or O. Yiwei Han corrected
this bug.
   The fourth bug is when there is a winner, people can still put X or Os on the blank grids. Ran Cheng corrected this
bug.
   The fifth bug is that the when program starts, it always indicates that "This is X's turn", but O starts first. Yiwei
Han corrected this bug and also add a "finished" each time the round is finished.
   The sixth bug is that the grid has gaps between each grid, Yiwei Han fixed this bug.
   The program shows below.

 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;


public class TTTGame extends JFrame implements ActionListener {
    private JTextArea result;
    private JButton newGame;
    private JTextArea winnerState;
    private JTextArea indicator;
    private boolean state = true;
    private JButton B11;
    private JButton B12;
    private JButton B13;
    private JButton B21;
    private JButton B22;
    private JButton B23;
    private JButton B31;
    private JButton B32;
    private JButton B33;
    private int count = 0;
    private int f11 = 2;
    private int f12 = 2;
    private int f13 = 2;
    private int f21 = 2;
    private int f22 = 2;
    private int f23 = 2;
    private int f31 = 2;
    private int f32 = 2;
    private int f33 = 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private int numDraw = 0;
    private Graphics h=null; //set the private within the TTTGame


    TTTGame() {
        GridBagConstraints layoutConst = null; //set layout to null

        setTitle("Welcome to TTT");

        winnerState = new JTextArea(); //The score indicator
        winnerState.setEditable(false);
        winnerState.setText("Player X wins: " + scoreP1 + "\r\n"
                +"Player O wins: " + scoreP2 + "\r\n"+"draw: " + numDraw);
        winnerState.setBorder(new LineBorder(Color.BLACK));

        newGame = new JButton("new game"); //The new game button
        newGame.addActionListener(this);

        indicator = new JTextArea(); //The indicator that indicate who plays next
        indicator.setText("O goes first");
        indicator.setEditable(false);
        indicator.setBorder(new LineBorder(Color.BLACK));

        Font f = new Font(Font.DIALOG, Font.BOLD, 20);

        B11 = new JButton(); //set the bottons which players can click and put the X and Os
        B11.setFont(f);
        B11.setPreferredSize(new Dimension(110,110));
        B11.setBorder(new LineBorder(Color.BLACK));//B11.setBorder(null);
        B11.setContentAreaFilled(false);
        B11.addActionListener(this);
        B12 = new JButton();
        B12.setFont(f);
        B12.setPreferredSize(new Dimension(110, 110));
        B12.setBorder(new LineBorder(Color.BLACK));//B12.setBorder(null);
        B12.setContentAreaFilled(false);
        B12.addActionListener(this);
        B13 = new JButton();
        B13.setFont(f);
        B13.setPreferredSize(new Dimension(110, 110));
        B13.setBorder(new LineBorder(Color.BLACK));//B13.setBorder(null);
        B13.setContentAreaFilled(false);
        B13.addActionListener(this);
        B21 = new JButton();
        B21.setFont(f);
        B21.setPreferredSize(new Dimension(110, 110));
        B21.setBorder(new LineBorder(Color.BLACK));//B21.setBorder(null);
        B21.setContentAreaFilled(false);
        B21.addActionListener(this);
        B22 = new JButton();
        B22.setFont(f);
        B22.setPreferredSize(new Dimension(110, 110));
        B22.setBorder(new LineBorder(Color.BLACK));//B22.setBorder(null);
        B22.setContentAreaFilled(false);
        B22.addActionListener(this);
        B23 = new JButton();
        B23.setFont(f);
        B23.setPreferredSize(new Dimension(110, 110));
        B23.setBorder(new LineBorder(Color.BLACK));//B23.setBorder(null);
        B23.setContentAreaFilled(false);
        B23.addActionListener(this);
        B31 = new JButton();
        B31.setFont(f);
        B31.setPreferredSize(new Dimension(110, 110));
        B31.setBorder(new LineBorder(Color.BLACK));//B31.setBorder(null);
        B31.setContentAreaFilled(false);
        B31.addActionListener(this);
        B32 = new JButton();
        B32.setFont(f);
        B32.setPreferredSize(new Dimension(110, 110));
        B32.setBorder(new LineBorder(Color.BLACK));//B32.setBorder(null);
        B32.setContentAreaFilled(false);
        B32.addActionListener(this);
        B33 = new JButton();
        B33.setFont(f);
        B33.setPreferredSize(new Dimension(110, 110));
        B33.setBorder(new LineBorder(Color.BLACK));//B33.setBorder(null);
        B33.setContentAreaFilled(false);
        B33.addActionListener(this);


        setLayout(new GridBagLayout()); //put the buttons on the layout in appropriate position
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 0, 10, 0);
        //layoutConst.fill = GridBagConstraints.BOTH;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(newGame, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 0, 10, 0);
        //layoutConst.fill = GridBagConstraints.BOTH;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(indicator, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 0, 10, 0);
        //layoutConst.fill = GridBagConstraints.BOTH;
        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        add(winnerState, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 0;
        layoutConst.gridy = 15;
        add(B11, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 1;
        layoutConst.gridy = 15;
        add(B12, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 2;
        layoutConst.gridy = 15;
        add(B13, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 0;
        layoutConst.gridy = 30;
        add(B21, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 1;
        layoutConst.gridy = 30;
        add(B22, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 2;
        layoutConst.gridy = 30;
        add(B23, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 0;
        layoutConst.gridy = 45;
        add(B31, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 1;
        layoutConst.gridy = 45;
        add(B32, layoutConst);

        //setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 0, 0, 0);
        layoutConst.gridx = 2;
        layoutConst.gridy = 45;
        add(B33, layoutConst);


    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (!state && !(e.getSource() == newGame)) { //when end a game but still press the emtpy grid.
            JOptionPane.showMessageDialog(this, "Please start a new game.");
        }
        else{
            if (e.getSource() == B11) { //indicator, put X and Os
                if(!"".equals(B11.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B11.setText("X");
                    f11 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B11.setText("O");
                    f11 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B12) {
                if(!"".equals(B12.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B12.setText("X");
                    f12 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B12.setText("O");
                    f12 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B13) {
                if(!"".equals(B13.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B13.setText("X");
                    f13 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B13.setText("O");
                    f13 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B21) {
                if(!"".equals(B21.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B21.setText("X");
                    f21 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B21.setText("O");
                    f21 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B22) {
                if(!"".equals(B22.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B22.setText("X");
                    f22 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B22.setText("O");
                    f22 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B23) {
                if(!"".equals(B23.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B23.setText("X");
                    f23 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B23.setText("O");
                    f23 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B31) {
                if(!"".equals(B31.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B31.setText("X");
                    f31 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B31.setText("O");
                    f31 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B32) {
                if(!"".equals(B32.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B32.setText("X");
                    f32 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B32.setText("O");
                    f32 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == B33) {
                if(!"".equals(B33.getText())){
                    return;
                }
                count++;
                if (count % 2 == 0) {
                    B33.setText("X");
                    f33 = 1;
                    this.indicator.setText(" O's turn");
                } else {
                    B33.setText("O");
                    f33 = 0;
                    this.indicator.setText(" X's turn");
                }
                //Graphics g = getGraphics();
            }
            if (e.getSource() == newGame) { //when start a new game
                count = 0;
                B11.setText("");
                B12.setText("");
                B13.setText("");
                B21.setText("");
                B22.setText("");
                B23.setText("");
                B31.setText("");
                B32.setText("");
                B33.setText("");
                f11 = 2;
                f12 = 2;
                f13 = 2;
                f21 = 2;
                f22 = 2;
                f23 = 2;
                f31 = 2;
                f32 = 2;
                f33 = 2;
                state = true;
                indicator.setText("O goes first");
            }
            if (f11 == 1 && f12 == 1 && f13 == 1) { //check the winner, when 3 in a row, colume or diagonal is the same, then X or O wins
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 == 0 && f12 == 0 && f13 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f21 == 1 && f22 == 1 && f23 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f21 == 0 && f22 == 0 && f23 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f31 == 1 && f32 == 1 && f33 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f31 == 0 && f32 == 0 && f33 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 == 1 && f21 == 1 && f31 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 == 0 && f21 == 0 && f31 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f12 == 1 && f22 == 1 && f32 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f12 == 0 && f22 == 0 && f32 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f13 == 1 && f23 == 1 && f33 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f13 == 0 && f23 == 0 && f33 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f31 == 1 && f22 == 1 && f13 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f31 == 0 && f22 == 0 && f13 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 == 1 && f22 == 1 && f33 == 1) {
                JOptionPane.showMessageDialog(this, "X wins!");
                scoreP1++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 == 0 && f22 == 0 && f33 == 0) {
                JOptionPane.showMessageDialog(this, "O wins!");
                scoreP2++;
                state = false;
                indicator.setText("Finished");
            } else if (f11 != 2 && f12 != 2 && f13 != 2 && f21 != 2 && f22 != 2 && f23 != 2 && f31 != 2 && f32 != 2 && f33 != 2) {
                JOptionPane.showMessageDialog(this, "it's a draw");
                numDraw++;
                state = false;
                indicator.setText("Finished");
            }
            winnerState.setText("Player X wins: " + scoreP1 + "\r\n"
                    +"Player O wins: " + scoreP2 + "\r\n"+"draw: " + numDraw);
        }
    }

    public static void main(String[] args) {
        TTTGame mygame = new TTTGame();
        mygame.setSize(480, 580); //the outter frame of the game
        Graphics g = mygame.getGraphics();
        mygame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mygame.pack();
        mygame.setVisible(true);
    }
}
