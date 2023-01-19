import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameMain extends JFrame implements ActionListener{
    JFrame canvas = new JFrame();
    JPanel statusTitle = new JPanel();
    Board board;
    JLabel text = new JLabel();
    Boolean x_turn;
    Player isPlaying = Player.X;

    Boolean gameFinish = false;

    public GameMain(Boolean x_turn){
        this.x_turn = x_turn;
    }

    public void startGame(){
        createCanvas();




        statusTitle.setLayout(new BorderLayout());
        statusTitle.setBounds(0,0,800,100);

        board = new Board(3, this);
        board.paint();

        statusTitle.add(text);
        canvas.add(statusTitle, BorderLayout.SOUTH);
        canvas.add(board);
        initTextField();
    }

    public void createCanvas(){
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setSize(800,800);
        canvas.getContentPane().setBackground(new Color(255,255,255));
        canvas.setLayout(new BorderLayout());
        canvas.setVisible(true);
    }

    public Player switchPlayer(Player currentPlayer){
        return currentPlayer.equals(Player.X)? Player.O : Player.X;
    }

    public Color getColor(Player isPlaying){
        return isPlaying.equals(Player.X)?new Color(255,0,0):new Color(0, 0, 255);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameFinish){
            for(int i = 0; i<9;i++){
                board.getCells()[i].clear();
            }
            isPlaying = Player.X;
            gameFinish = false;
            initTextField();
        }
        else{
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == board.getCells()[i]) {
                    if (board.getCells()[i].getContent() == null) {
                        board.getCells()[i].setContent(isPlaying);
                        board.getCells()[i].paint(getColor(isPlaying));
                        Player winner = board.hasWon(isPlaying);
                        isPlaying = switchPlayer(isPlaying);
                        if (winner != null) {
                            updateGame(winner.name() + " win");
                        }
                        if(board.isDraw()){
                            updateGame("Draw");
                        }
                    }
                }
            }
        }
    }


    public void updateGame(String result){
        text.setText(result);
        gameFinish = true;
    }
    public void initTextField(){
        text.setText("X always begins the game");
        text.setBackground(new Color(255, 255, 25));
        text.setForeground(new Color(7, 6, 6));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setOpaque(true);
        text.setFont(new Font("Font",Font.PLAIN, 50));
    }
    public static void main(String[] args) {
        GameMain game = new GameMain(true);
        game.startGame();
    }

}