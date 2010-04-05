package interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class dd extends JFrame {
  public dd() {
    setTitle("CenteredFrame");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
  //      System.exit(0);
        
      }
    });
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    setSize(screenWidth / 2, screenHeight / 2);
    setLocation(screenWidth / 4, screenHeight / 4);
  }

  public static void main(String[] args) {
    JFrame frame = new dd();
    frame.show();
  }
}