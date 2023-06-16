import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel mainPane;
	private JButton cartButton;
	private JButton breadButton;
	private JLabel titleLabel;

	
	public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 943); 
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("NAOIMISE");
		
		mainPane = new JPanel();	
		mainPane.setOpaque(false);
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.setPreferredSize(new Dimension(700,440));
		mainPane.setMinimumSize(mainPane.getPreferredSize());
		mainPane.setMaximumSize(mainPane.getPreferredSize());

		titleLabel = new JLabel("NAOIMISE");
		titleLabel.setOpaque(false);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("joystix monospace", Font.PLAIN, 50));

		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(Box.createVerticalGlue());
		box.add(mainPane);
		box.add(Box.createVerticalGlue());
		
		Dimension buttonSize = new Dimension(200,50);
		
		cartButton = new CustomButton();
		cartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cartButton.setText("CART");
		cartButton.setPreferredSize(buttonSize);
		cartButton.setMinimumSize(buttonSize);
		cartButton.setMaximumSize(buttonSize);
		
		breadButton = new CustomButton();
		breadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		breadButton.setPreferredSize(new Dimension(200,200));
		breadButton.setMinimumSize(breadButton.getPreferredSize());
		breadButton.setMaximumSize(breadButton.getPreferredSize());
            

		try {

			Image backgroundImage = ImageIO.read(new File("./src/Background.png"));
		    ImageIcon breadIcon = new ImageIcon("./src/Bread.png");
		    ImageIcon chocolateIcon = new ImageIcon("./src/Chocolate.png");

		    
			contentPane = new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(backgroundImage, 0, 0, null);
		        }
			};
			

		    breadButton.setIcon(breadIcon);
		    // Set the chocolate button icon on mouse click
		    breadButton.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            super.mouseClicked(e);
		            breadButton.setIcon(chocolateIcon);
		        }

		        @Override
		        public void mouseExited(MouseEvent e) {
		            super.mouseExited(e);
		            breadButton.setIcon(breadIcon);
		        }
		    });



		} catch (IOException e) {
		    e.printStackTrace();
		    contentPane = new JPanel(new BorderLayout());
		}
		

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		            
    	
		mainPane.add(titleLabel);
		mainPane.add(Box.createRigidArea(new Dimension(0,100)));
		mainPane.add(cartButton);
		mainPane.add(Box.createRigidArea(new Dimension(0,20)));
		mainPane.add(breadButton);
		mainPane.add(Box.createRigidArea(new Dimension(0,20)));
		
		contentPane.add(box, BorderLayout.CENTER);

		setContentPane(contentPane);

	
	}

}
