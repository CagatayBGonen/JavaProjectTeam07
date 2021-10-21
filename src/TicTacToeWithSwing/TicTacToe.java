package TicTacToeWithSwing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame pencere = new JFrame();
    JPanel baslik_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel texfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setSize(800, 800);
        pencere.getContentPane().setBackground(new Color(50, 50, 50));
        pencere.setLayout(new BorderLayout());
        pencere.setVisible(true);

        texfield.setBackground(new Color(25, 25, 25));
        texfield.setForeground(new Color(25, 255, 0));
        texfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        texfield.setHorizontalAlignment(JLabel.CENTER);
        texfield.setText("Tic-Tac-Toe");
        texfield.setOpaque(true);

        baslik_panel.setLayout(new BorderLayout());
        baslik_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        baslik_panel.add(texfield);
        pencere.add(baslik_panel, BorderLayout.NORTH);
        pencere.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) { // ActionListener implements ettigimiz icin kullanmamiz gereken bir method.
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        texfield.setText("O Turn");
                        check();
                    }

                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        texfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() { // kimin ilk sirada basliyacagini belirleyen method
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            texfield.setText("Player1 Turn \"X\"");
        } else {
            player1_turn = false;
            texfield.setText("Player2 Turn \"O\"");
        }
    }

    public void check() { // kimin kazandigini kontrol ettigmiz bir method. (oyun boyuca check edicek)
        //check X win conditions
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[1].getText() == "X") &&
                        (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[3].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[5].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[3].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
        if (!((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X") ||
                (buttons[3].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[5].getText() == "X") ||
                (buttons[6].getText() == "X") &&
                        (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X") ||
                (buttons[0].getText() == "O") &&
                        (buttons[1].getText() == "O") &&
                        (buttons[2].getText() == "O") ||
                (buttons[3].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[5].getText() == "O") ||
                (buttons[6].getText() == "O") &&
                        (buttons[7].getText() == "O") &&
                        (buttons[8].getText() == "O") ||
                (buttons[0].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[8].getText() == "X") ||
                (buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O") ||
                (buttons[2].getText() == "X") &&
                        (buttons[4].getText() == "X") &&
                        (buttons[6].getText() == "X") ||
                (buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O"))) {

            int count = 0;
            for (int i = 0; i<9; i++){
                    if (buttons[i].getText()==""){

                    } else {
                        count++;
                    }
                }
            if (count==9){
                draw();
            }
        }

    }

    public void xWins(int a, int b, int c) { // kazanan belli olduktan sonra ne olacagını belirleyen methodlar.
        buttons[a].setBackground(new Color(139, 255, 0));
        buttons[b].setBackground(new Color(139, 255, 0));
        buttons[c].setBackground(new Color(139, 255, 0));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        texfield.setText("Player1 Win");
    }

    public void oWins(int a, int b, int c) { // kazanan belli olduktan sonra ne olacagını belirleyen methodlar.
        buttons[a].setBackground(new Color(139, 255, 0));
        buttons[b].setBackground(new Color(139, 255, 0));
        buttons[c].setBackground(new Color(139, 255, 0));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        texfield.setText("Player2 Win");
    }

    public void draw() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        texfield.setText("Draw");
    }
}
