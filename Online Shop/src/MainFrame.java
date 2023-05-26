import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    private JButton addButton;
    private JButton subtractButton;
    private JButton cart;
    MainFrame(){


        //Image icon
        ImageIcon bg= new ImageIcon("Background.gif");
        //Adds background label 
        JLabel bglabel = new JLabel();
        //Set background Icon
        bglabel.setIcon(bg);

       addButton = new JButton();
        addButton = new JButton("+");
        // addButton.addActionListener(this);
        addButton.setIcon(new ImageIcon("rock.png"));
        addButton.setBounds(getBounds());
        addButton.setSize(25, 25);
        addButton.setBounds(50,50,50,50);
        addButton.setFont(new Font("Comic Sans", Font.BOLD,25));
        addButton.setHorizontalTextPosition(JButton.CENTER);
        addButton.setVerticalTextPosition(JButton.BOTTOM);
        addButton.setBorder(BorderFactory.createEtchedBorder());
        addButton.setFocusable(false);
        this.add(addButton);

        subtractButton = new JButton();
        subtractButton = new JButton("-");
        // subtractButton.addActionListener();
        subtractButton.setIcon(new ImageIcon("rock.png"));
        subtractButton.setBounds(getBounds());
        subtractButton.setSize(25, 25);
        subtractButton.setBounds(50,50,50,50);
        subtractButton.setFont(new Font("Comic Sans", Font.BOLD,25));
        subtractButton.setHorizontalTextPosition(JButton.CENTER);
        subtractButton.setVerticalTextPosition(JButton.BOTTOM);
        subtractButton.setBorder(BorderFactory.createEtchedBorder());
        subtractButton.setFocusable(false);
        this.add(subtractButton);

        cart = new JButton();
        cart = new JButton("Cart");
        // cart.addActionListener(this);
        cart.setIcon(new ImageIcon("rock.png"));
        cart.setBounds(getBounds());
        cart.setSize(25, 25);
        cart.setBounds(50,50,50,50);
        cart.setFont(new Font("Comic Sans", Font.BOLD,25));
        cart.setHorizontalTextPosition(JButton.CENTER);
        cart.setVerticalTextPosition(JButton.BOTTOM);
        cart.setBorder(BorderFactory.createEtchedBorder());
        cart.setFocusable(false);
        this.add(cart);

        
        //Adds the properties
        this.add(bglabel);
        this.setLayout(new FlowLayout());
        this.setTitle("NAOIMISE");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#F8E8EE"));


        


    
    // }public void actionPerformed(){

    //     if (e.getSource() == addButton) {

            




    //     }



    }

        
            }
        
        
