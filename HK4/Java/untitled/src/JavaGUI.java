import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JavaGUI extends JFrame {
    JavaGUI(){
        super("Java");
        setFrame();
    }
    private void setFrame(){
        ImageIcon logo = new ImageIcon("src/assets/applogo.png");
        this.setIconImage(logo.getImage());
        this.setSize(900, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addGUIComponents();
        this.setLayout(null);
    }

    private void addGUIComponents(){
        JLabel label = new JLabel();
        label.setText("What would you like?");
        ImageIcon img = new ImageIcon("src/assets/img1.png");
        label.setIcon(img);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setIconTextGap(100);
        label.setBackground(new Color(200, 40, 240));
        //create border
        Border border = BorderFactory.createLineBorder(Color.BLUE,5);
        label.setBorder(border);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 250, 250);
        this.add(label);

        JButton button = new JButton();
        button.setText("Click me");
        button.setBounds(300,300,200,100);
        button.addActionListener(e -> {
            System.out.println("Hello");
        });
        button.setFocusable(false);
        this.add(button);
    }
}
