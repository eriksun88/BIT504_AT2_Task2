import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    public Player content;

    public Player getContent() {
        return content;
    }

    public void setContent(Player content) {
        this.content = content;
    }

    public void paint(Color color) {
        this.setText(content.name());
        this.setForeground(color);
    }

    //clear all the button to initial state
    public void clear() {
        content = null;
        this.setText("");
        this.setBackground(Color.WHITE);
    }
}
