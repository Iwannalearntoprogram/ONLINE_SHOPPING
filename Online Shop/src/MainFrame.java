import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class MainFrame extends JFrame {
    private JPanel productPanel;
    private JButton deliverButton;
    private JButton searchButton;
    private JButton cartButton;
    private JLabel breadLabel;
    private JButton breadMinusButton;
    private JButton breadPlusButton;
    private JLabel chocolateLabel;
    private JButton chocolateMinusButton;
    private JButton chocolatePlusButton;
    private JLabel ramenLabel;
    private JButton ramenMinusButton;
    private JButton ramenPlusButton;

    public MainFrame() {
        setTitle("NAOIMISE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 943);
        setResizable(false);
        setLayout(null);

        // Create a background label with the specified image
        ImageIcon backgroundImage = new ImageIcon("Background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Create and customize the title label
        JLabel titleLabel = new JLabel("NAOIMISE");
        titleLabel.setBounds(0, 20, getWidth(), 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("joystix monospace", Font.BOLD, 50));
        backgroundLabel.add(titleLabel);

        // Create the product panel and set its properties
        productPanel = new JPanel();
        productPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Set FlowLayout for horizontal and centered positioning
        productPanel.setOpaque(false);
        productPanel.setBounds(100, 200, getWidth() - 200, getHeight() - 300);
        backgroundLabel.add(productPanel);

        // Create and customize the buttons
        deliverButton = new JButton("Deliver");
        deliverButton.setBounds(20, 100, 200, 50);
        backgroundLabel.add(deliverButton);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(getWidth() - 220, 100, 200, 50);
        searchButton.setFont(new Font("joystix monospace", Font.BOLD, 20));
        backgroundLabel.add(searchButton);

        cartButton = new JButton("Cart");
        cartButton.setBounds(getWidth() - 220, 160, 200, 50);
        backgroundLabel.add(cartButton);

        breadLabel = new JLabel(new ImageIcon("Bread.png"));
        breadMinusButton = new JButton("-");
        breadPlusButton = new JButton("+");
        customizeProductButton(breadLabel, breadMinusButton, breadPlusButton);

        chocolateLabel = new JLabel(new ImageIcon("Chocolate.png"));
        chocolateMinusButton = new JButton("-");
        chocolatePlusButton = new JButton("+");
        customizeProductButton(chocolateLabel, chocolateMinusButton, chocolatePlusButton);

        ramenLabel = new JLabel(new ImageIcon("Ramen.png"));
        ramenMinusButton = new JButton("-");
        ramenPlusButton = new JButton("+");
        customizeProductButton(ramenLabel, ramenMinusButton, ramenPlusButton);

        // Adjust dimensions and positions for the product elements
        int labelWidth = 220;
        int labelHeight = 180;
        int buttonWidth = 60;
        int buttonHeight = 50;

        breadLabel.setPreferredSize(new Dimension(labelWidth, labelHeight));
        breadMinusButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        breadPlusButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        chocolateLabel.setPreferredSize(new Dimension(labelWidth, labelHeight));
        chocolateMinusButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        chocolatePlusButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        // Create separate panels for bread and chocolate labels along with their buttons
        JPanel breadPanel = new JPanel();
        breadPanel.setOpaque(false);
        breadPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        breadPanel.add(breadLabel);
        breadPanel.add(breadMinusButton);
        breadPanel.add(breadPlusButton);

        JPanel chocolatePanel = new JPanel();
        chocolatePanel.setOpaque(false);
        chocolatePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        chocolatePanel.add(chocolateLabel);
        chocolatePanel.add(chocolateMinusButton);
        chocolatePanel.add(chocolatePlusButton);

        // Create a separate panel for the ramen label and its buttons
        JPanel ramenPanel = new JPanel();
        ramenPanel.setOpaque(false);
        ramenPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        ramenPanel.add(ramenLabel);
        ramenPanel.add(ramenMinusButton);
        ramenPanel.add(ramenPlusButton);

        // Add the product elements to the product panel
        productPanel.add(breadPanel);
        productPanel.add(chocolatePanel);
        productPanel.add(ramenPanel);

        setVisible(true);
    }

    private void customizeProductButton(JLabel productLabel, JButton minusButton, JButton plusButton) {
    productLabel.setFont(new Font("joystix monospace", Font.BOLD, 40));
    minusButton.setFont(new Font("joystix monospace", Font.BOLD, 30)); // Adjusted font size
    plusButton.setFont(new Font("joystix monospace", Font.BOLD, 30)); // Adjusted font size
    Color buttonColor = new Color(255, 255, 255);
    minusButton.setBackground(buttonColor);
    plusButton.setBackground(buttonColor);
    minusButton.setPreferredSize(new Dimension(60, 50)); // Fixed button size
    plusButton.setPreferredSize(new Dimension(60, 50)); // Fixed button size
}

    public static void main(String[] args) {
        new MainFrame();
    }
}

