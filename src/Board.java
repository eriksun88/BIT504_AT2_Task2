import javax.swing.*;
import java.awt.*;



public class Board extends JPanel{
    Player winner = null;

    private final Cell[] cells = new Cell[9];
    private final int size;

    public Board(int size,GameMain game){
        this.size = size;
        for(int i=0;i<size*size;i++){
            Cell cell = new Cell();
            cell.setFont(new Font("font",Font.BOLD,100));
            cell.setBackground(Color.WHITE);
            cell.setFocusable(false);
            cell.addActionListener(game);
            cells[i] = cell;
            this.add(cell);
        }
    }
    public boolean isDraw(){
        boolean allFilled = true;
        for(int i=0;i<getCells().length;i++){
            if (getCells()[i].getContent() == null){
                allFilled = false;
                break;
            }
        }
        return allFilled && winner == null;
    }
    public Player hasWon(Player isPlaying){
        int[][] nums = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        winner = null;
        for (int[] num : nums) {
            if (getCells()[num[0]].getContent() !=null
                    &&getCells()[num[0]].getContent() == getCells()[num[1]].getContent()
                    && getCells()[num[1]].getContent() == getCells()[num[2]].getContent()) {
                getCells()[num[0]].setBackground(Color.gray);
                getCells()[num[1]].setBackground(Color.gray);
                getCells()[num[2]].setBackground(Color.gray);
                winner = isPlaying;
            }
        }
        return winner;
    }

    public void paint(){
        this.setLayout(new GridLayout(size,size));
        this.setBackground(new Color(150, 108, 108));
    }

    public Cell[] getCells() {
        return cells;
    }
}
