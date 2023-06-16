import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
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
        // Using absolute positioning
        productPanel.setLayout(null);
        // Transparent panel
        productPanel.setOpaque(false);
        productPanel.setBounds(100, 200, getWidth() - 200, getHeight() - 300);
        backgroundLabel.add(productPanel);

        // Create and customize the buttons
        deliverButton = new JButton("Deliver");
        deliverButton.setBounds(20, 100, 200, 50);
        backgroundLabel.add(deliverButton);

        // Create a regular button for search
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

        // Set the position and size of the components
        int buttonWidth = 270;
        int buttonHeight = 220;
        int buttonSpacing = 10;
        int productPanelWidth = productPanel.getWidth();
        int productPanelHeight = productPanel.getHeight();
        int startX = (productPanelWidth - buttonWidth) / 2;
        int startY = (productPanelHeight - (3 * buttonHeight + 2 * buttonSpacing)) / 2;
        int currentY = startY;

        breadLabel.setBounds(startX, currentY, buttonWidth, buttonHeight);
        breadMinusButton.setBounds(startX + buttonWidth + buttonSpacing, currentY, 70, buttonHeight);
        breadPlusButton.setBounds(startX + buttonWidth + buttonSpacing + 60 + buttonSpacing, currentY, 70, buttonHeight);
        productPanel.add(breadLabel);
        productPanel.add(breadMinusButton);
        productPanel.add(breadPlusButton);

        currentY += buttonHeight + buttonSpacing;

        chocolateLabel.setBounds(startX, currentY, buttonWidth, buttonHeight);
        chocolateMinusButton.setBounds(startX + buttonWidth + buttonSpacing, currentY, 70, buttonHeight);
        chocolatePlusButton.setBounds(startX + buttonWidth + buttonSpacing + 60 + buttonSpacing, currentY, 70, buttonHeight);
        productPanel.add(chocolateLabel);
        productPanel.add(chocolateMinusButton);
        productPanel.add(chocolatePlusButton);

        currentY += buttonHeight + buttonSpacing;

        ramenLabel.setBounds(startX, currentY, buttonWidth, buttonHeight);
        ramenMinusButton.setBounds(startX + buttonWidth + buttonSpacing, currentY, 70, buttonHeight);
        ramenPlusButton.setBounds(startX + buttonWidth + buttonSpacing + 60 + buttonSpacing, currentY, 70, buttonHeight);
        productPanel.add(ramenLabel);
        productPanel.add(ramenMinusButton);
        productPanel.add(ramenPlusButton);

        setVisible(true);
    }

    private void customizeProductButton(JLabel productLabel, JButton minusButton, JButton plusButton) {
        productLabel.setPreferredSize(new Dimension(200, 200));
        minusButton.setPreferredSize(new Dimension(50, 50));
        plusButton.setPreferredSize(new Dimension(50, 50));
        productLabel.setFont(new Font("joystix monospace", Font.BOLD, 50));
        minusButton.setFont(new Font("joystix monospace", Font.BOLD, 50));
        plusButton.setFont(new Font("joystix monospace", Font.BOLD, 50));
        Color buttonColor = new Color(255, 255, 255);
        minusButton.setBackground(buttonColor);
        plusButton.setBackground(buttonColor);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
