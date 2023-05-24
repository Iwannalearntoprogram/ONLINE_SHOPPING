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

    MainFrame(){


        //Image icon
        ImageIcon bg= new ImageIcon("giphy.gif");
        //Adds background label 
        JLabel bglabel = new JLabel();

        bglabel.setIcon(bg);


        this.add(bglabel);
        this.setLayout(new FlowLayout());
        this.setTitle("NAOIMISE");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1300, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#F8E8EE"));


        


    
    }

        
            }
        
