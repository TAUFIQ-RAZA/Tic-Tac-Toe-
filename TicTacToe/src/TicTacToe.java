import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    Random random= new Random();
    JFrame frame = new JFrame();
    JPanel title_panel= new JPanel();
    JPanel button_panel= new JPanel();
    JTextField textField= new JTextField();
    JButton[] buttons= new JButton[9];
    boolean player1_turn;

    public TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe Game");
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setLocation(500,30);


        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Times New Roman",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setVisible(true);
        firstTurn();
    }

    public void actionPerformed(ActionEvent ae){
        for (int i=0;i<9;i++){
            if (ae.getSource()==buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText(" '0'-Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("0");
                        player1_turn=true;
                        textField.setText(" 'X'-Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()  {

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            player1_turn=true;
            textField.setText(" 'X' - Turn");
        }else {
            player1_turn=false;
            textField.setText(" '0' - Turn");
        }
    }

    public void check(){
        // condition for X win
        if((buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")){
              xWin(0,1,2);
        }
        if((buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")){
            xWin(3,4,5);
        }

        if((buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWin(6,7,8);
        }

        if((buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWin(0,3,6);
        }

        if((buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")){
            xWin(1,4,7);
        }

        if((buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWin(2,5,8);
        }

        if((buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")){
            xWin(0,4,8);
        }

        if((buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")){
            xWin(2,4,6);
        }

        //condition for 0 win
        if((buttons[0].getText()=="0") &&
                (buttons[1].getText()=="0") &&
                (buttons[2].getText()=="0")){
            oWin(0,1,2);
        }
        if((buttons[3].getText()=="0") &&
                (buttons[4].getText()=="0") &&
                (buttons[5].getText()=="0")){
            oWin(3,4,5);
        }

        if((buttons[6].getText()=="0") &&
                (buttons[7].getText()=="0") &&
                (buttons[8].getText()=="0")){
            oWin(6,7,8);
        }

        if((buttons[0].getText()=="0") &&
                (buttons[3].getText()=="0") &&
                (buttons[6].getText()=="0")){
            oWin(0,3,6);
        }

        if((buttons[1].getText()=="0") &&
                (buttons[4].getText()=="0") &&
                (buttons[7].getText()=="0")){
            oWin(1,4,7);
        }

        if((buttons[2].getText()=="0") &&
                (buttons[5].getText()=="0") &&
                (buttons[8].getText()=="0")){
            oWin(2,5,8);
        }

        if((buttons[0].getText()=="0") &&
                (buttons[4].getText()=="0") &&
                (buttons[8].getText()=="0")){
            oWin(0,4,8);
        }

        if((buttons[2].getText()=="0") &&
                (buttons[4].getText()=="0") &&
                (buttons[6].getText()=="0")){
            oWin(2,4,6);
        }

    }

    public void xWin(int a,int b,int c){
        buttons[a].setBackground(new Color(25,255,0));
        buttons[b].setBackground(new Color(25,255,0));
        buttons[c].setBackground(new Color(25,255,0));

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X Win");
    }

    public void oWin(int a,int b,int c){
        buttons[a].setBackground(new Color(25,255,0));
        buttons[b].setBackground(new Color(25,255,0));
        buttons[c].setBackground(new Color(25,255,0));

        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("0 Win");

    }


}
