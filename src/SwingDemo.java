import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class SwingDemo {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      JPanel panel = new JPanel();
      JButton btn1 = new JButton("One");
      JButton btn2 = new JButton("Two");
      JButton btn3 = new JButton("Three");
      JButton btn4 = new JButton("Four");
      JButton btn5 = new JButton("Five");
      panel.add(btn1);
      panel.add(btn2);
      panel.add(btn3);
      panel.add(btn4);
      panel.add(btn5);
      panel.setAlignmentX(Component.LEFT_ALIGNMENT);
      panel.setPreferredSize(new Dimension(100, 500));
      panel.setMaximumSize(new Dimension(100, 500));
      panel.setBorder(BorderFactory.createTitledBorder("demo"));
      frame.getContentPane().add(panel);
      frame.setSize(550, 300);
      frame.setVisible(true);
      JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		add(scrollBar);
   }
}