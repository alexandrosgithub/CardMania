import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPanel extends JFrame {
	private JButton button1,button2,button3;
	 private JPanel panel=new JPanel(); 
	private JLabel label1,label2;
	private Font font=new Font("TITLE",Font.ITALIC,48);
	private ImageIcon background;
	private FlowLayout layout = new FlowLayout();
	public MainPanel(){
		background=new ImageIcon("images/panel2.jpg");
		label1=new JLabel(background);
		label2=new JLabel("Card Mania");
		label2.setFont(font);
		label2.setForeground(Color.WHITE);
		button1 = new JButton("Αγωνία");
		button1.setPreferredSize(new Dimension(100,100));
    	listener1 agonia = new listener1();
    	button1.addActionListener(agonia);
		button2 = new JButton("Black Jack");
    	button2.setPreferredSize(new Dimension(100,100));
    	listener2 black_jack = new listener2();
    	button2.addActionListener(black_jack);
    	button3 = new JButton("Ξερή");
    	button3.setPreferredSize(new Dimension(100,100));
    	listener3 kserh = new listener3();
    	button3.addActionListener(kserh);
    	panel.add(label1);
    	panel.add(label2);
    	layout.setHgap(500);
    	layout.setVgap(20);
    	setLayout(layout);
		label1.setLayout(layout);
    	label1.add(label2);
		label1.add(button1);
    	label1.add(button2);
    	label1.add(button3);
    	
    
    	this.setContentPane(panel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	this.setVisible(true);
    	this.setResizable(false);
		this.setSize(800, 600);
		this.setTitle("Card Mania");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	
	public class listener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new mainFrame();
			
		}
		
	}
	
	public class listener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new Eikosi_mia_panel();
			
		}
		
	}
	
	
	public class listener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
}
