import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {



    public Player content;


    public Cell(){

    }
    public Player getContent() {
        return content;
    }

    public void setContent(Player content) {
        this.content = content;
    }

    public void paint(Color color){
        this.setText(content.name());
        this.setForeground(color);
    }
    public void clear(){
        content = null;
        this.setText("");
        //this.setForeground(Color.WHITE);
        this.setBackground(Color.WHITE);
    }
}
