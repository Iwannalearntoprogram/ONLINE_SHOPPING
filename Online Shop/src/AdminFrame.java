import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AdminFrame extends MainFrame{
    public AdminFrame() {
        super("Admin Frame");
        setTitle("Admin Frame");
        setSize(1100, 943);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Set the background image
        try {
            String imagePath = "Background.png"; // Replace with the actual path to your background image
            Image backgroundImage = ImageIO.read(new File(imagePath));
            BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
            setContentPane(backgroundPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a label for the title
        JLabel titleLabel = new JLabel("Welcome Master");
        titleLabel.setBounds(0, 20, getWidth(), 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("joystix monospace", Font.BOLD, 50));
        add(titleLabel);

        // Create three buttons with custom font and shape
        int buttonWidth = 250;
        int buttonHeight = 50;
        int spacing = 20;
        int totalHeight = (buttonHeight + spacing) * 3;

        // Calculate the center position for the buttons
        int centerX = (getWidth() - buttonWidth) / 2;
        int centerY = (getHeight() - totalHeight) / 2;

        JButton button1 = new JButton("EDIT DETAILS");
        button1.setFont(new Font("joystix monospace", Font.PLAIN, 18));
        button1.setBounds(centerX, centerY, buttonWidth, buttonHeight);
        add(button1);

        JButton button2 = new JButton("EDIT PRICE");
        button2.setFont(new Font("joystix monospace", Font.PLAIN, 18));
        button2.setBounds(centerX, centerY + buttonHeight + spacing, buttonWidth, buttonHeight);
        add(button2);

        JButton button3 = new JButton("ADD PRODUCTS");
        button3.setFont(new Font("joystix monospace", Font.PLAIN, 18));
        button3.setBounds(centerX, centerY + 2 * (buttonHeight + spacing), buttonWidth, buttonHeight);
        add(button3);


        JButton button4 = new JButton("ORDERS");
        button1.setFont(new Font("joystix monospace", Font.PLAIN, 18));
        button1.setBounds(centerX, centerY, buttonWidth, buttonHeight);
        add(button4);

        // Set the layout manager for the window
        setLayout(null);
    }

    // Custom JPanel to set the background image
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
