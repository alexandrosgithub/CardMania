import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class Eikosi_mia_panel extends JFrame{
	private ImagePanel contentPane = new ImagePanel("images/background.jpg");
	private JLabel TwoOfSpades, TwoOfHearts, TwoOfDiamonds, TwoOfClubs, ThreeOfSpades, ThreeOfHearts, ThreeOfDiamonds, ThreeOfClubs,
	FourOfSpades, FourOfHearts, FourOfDiamonds, FourOfClubs, FiveOfSpades, FiveOfHearts, FiveOfDiamonds, FiveOfClubs,
	SixOfSpades, SixOfHearts, SixOfDiamonds, SixOfClubs, SevenOfSpades, SevenOfHearts, SevenOfDiamonds, SevenOfClubs, 
	EightOfSpades, EightOfHearts, EightOfDiamonds, EightOfClubs, NineOfSpades, NineOfHearts, NineOfDiamonds, NineOfClubs, 
	TenOfSpades, TenOfHearts, TenOfDiamonds, TenOfClubs, JackOfSpades, JackOfHearts, JackOfDiamonds, JackOfClubs, 
	QueenOfSpades, QueenOfHearts, QueenOfDiamonds, QueenOfClubs, KingOfSpades, KingOfHearts, KingOfDiamonds, KingOfClubs, 
	AceOfSpades, AceOfHearts, AceOfDiamonds, AceOfClubs, BlueCard, spades, hearts, diamonds, clubs;
	private ArrayList<JLabel> cards = new ArrayList<>();
	private ArrayList<JLabel> suits = new ArrayList<>();
	ArrayList<JLabel> labels = new ArrayList<>();
	private JButton button1,button2,button3;
	private Eikosi_mia black_jack = new Eikosi_mia();
	private Dimension screenSize;
	

	public Eikosi_mia_panel(){
		super("Game with Cards");
		ImageIcon image57 = new ImageIcon("images/pokerimage.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 500, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setIconImage(image57.getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		button1=new JButton("Start Game");
		button1.setPreferredSize(new Dimension(200,200));
		button2=new JButton("Computer's turn");
		button3=new JButton("Play Again");
    	button3.setPreferredSize(new Dimension(200,200));
		listener1 start_game = new listener1();
		listener2 computers_turn = new listener2();
		listener3 play_again= new listener3();
		button1.addActionListener(start_game);
    	button2.addActionListener(computers_turn);
    	button3.addActionListener(play_again);
		ImageIcon image = new ImageIcon("images/AceOfSpades.png");
		ImageIcon image1 = new ImageIcon("images/AceOfHearts.png");
		ImageIcon image2 = new ImageIcon("images/AceOfDiamonds.png");
		ImageIcon image3 = new ImageIcon("images/AceOfClubs.png");
		ImageIcon image4 = new ImageIcon("images/TwoOfSpades.png");
		ImageIcon image5 = new ImageIcon("images/TwoOfHearts.png");
		ImageIcon image6 = new ImageIcon("images/TwoOfDiamonds.png");
		ImageIcon image7 = new ImageIcon("images/TwoOfClubs.png");
		ImageIcon image8 = new ImageIcon("images/ThreeOfSpades.png");
		ImageIcon image9 = new ImageIcon("images/ThreeOfHearts.png");
		ImageIcon image10 = new ImageIcon("images/ThreeOfDiamonds.png");
		ImageIcon image11= new ImageIcon("images/ThreeOfClubs.png");
		ImageIcon image12 = new ImageIcon("images/FourOfSpades.png");
		ImageIcon image13 = new ImageIcon("images/FourOfHearts.png");
		ImageIcon image14 = new ImageIcon("images/FourOfDiamonds.png");
		ImageIcon image15 = new ImageIcon("images/FourOfClubs.png");
		ImageIcon image16 = new ImageIcon("images/FiveOfSpades.png");
		ImageIcon image17 = new ImageIcon("images/FiveOfHearts.png");
		ImageIcon image18 = new ImageIcon("images/FiveOfDiamonds.png");
		ImageIcon image19 = new ImageIcon("images/FiveOfClubs.png");
		ImageIcon image20 = new ImageIcon("images/SixOfSpades.png");
		ImageIcon image21 = new ImageIcon("images/SixOfHearts.png");
		ImageIcon image22 = new ImageIcon("images/SixOfDiamonds.png");
		ImageIcon image23 = new ImageIcon("images/SixOfClubs.png");
		ImageIcon image24 = new ImageIcon("images/SevenOfSpades.png");
		ImageIcon image25 = new ImageIcon("images/SevenOfHearts.png");
		ImageIcon image26 = new ImageIcon("images/SevenOfDiamonds.png");
		ImageIcon image27 = new ImageIcon("images/SevenOfClubs.png");
		ImageIcon image28 = new ImageIcon("images/EightOfSpades.png");
		ImageIcon image29 = new ImageIcon("images/EightOfHearts.png");
		ImageIcon image30 = new ImageIcon("images/EightOfDiamonds.png");
		ImageIcon image31 = new ImageIcon("images/EightOfClubs.png");
		ImageIcon image32 = new ImageIcon("images/NineOfSpades.png");
		ImageIcon image33 = new ImageIcon("images/NineOfHearts.png");
		ImageIcon image34 = new ImageIcon("images/NineOfDiamonds.png");
		ImageIcon image35 = new ImageIcon("images/NineOfClubs.png");
		ImageIcon image36 = new ImageIcon("images/TenOfSpades.png");
		ImageIcon image37 = new ImageIcon("images/TenOfHearts.png");
		ImageIcon image38 = new ImageIcon("images/TenOfDiamonds.png");
		ImageIcon image39 = new ImageIcon("images/TenOfClubs.png");
		ImageIcon image40 = new ImageIcon("images/JackOfSpades.png");
		ImageIcon image41 = new ImageIcon("images/JackOfHearts.png");
		ImageIcon image42 = new ImageIcon("images/JackOfDiamonds.png");
		ImageIcon image43 = new ImageIcon("images/JackOfClubs.png");
		ImageIcon image44 = new ImageIcon("images/QueenOfSpades.png");
		ImageIcon image45 = new ImageIcon("images/QueenOfHearts.png");
		ImageIcon image46 = new ImageIcon("images/QueenOfDiamonds.png");
		ImageIcon image47 = new ImageIcon("images/QueenOfClubs.png");
		ImageIcon image48 = new ImageIcon("images/KingOfSpades.png");
		ImageIcon image49 = new ImageIcon("images/KingOfHearts.png");
		ImageIcon image50 = new ImageIcon("images/KingOfDiamonds.png");
		ImageIcon image51 = new ImageIcon("images/KingOfClubs.png");
		ImageIcon image52 = new ImageIcon("images/blue.png");
		ImageIcon image53 = new ImageIcon("images/spades.png");
		ImageIcon image54 = new ImageIcon("images/hearts.png");
		ImageIcon image55 = new ImageIcon("images/diamonds.png");
		ImageIcon image56 = new ImageIcon("images/clubs.png");
		AceOfSpades = new JLabel(image);
		AceOfHearts = new JLabel(image1);
		AceOfDiamonds = new JLabel(image2);
		AceOfClubs = new JLabel(image3);
		TwoOfSpades = new JLabel(image4);
		TwoOfHearts = new JLabel(image5);
		TwoOfDiamonds = new JLabel(image6);
		TwoOfClubs = new JLabel(image7);
		ThreeOfSpades = new JLabel(image8);
		ThreeOfHearts = new JLabel(image9);
		ThreeOfDiamonds = new JLabel(image10);
		ThreeOfClubs = new JLabel(image11);
		FourOfSpades = new JLabel(image12);
		FourOfHearts = new JLabel(image13);
		FourOfDiamonds = new JLabel(image14);
		FourOfClubs = new JLabel(image15);
		FiveOfSpades = new JLabel(image16);
		FiveOfHearts = new JLabel(image17);
		FiveOfDiamonds = new JLabel(image18);
		FiveOfClubs = new JLabel(image19);
		SixOfSpades = new JLabel(image20);
		SixOfHearts = new JLabel(image21);
		SixOfDiamonds = new JLabel(image22);
		SixOfClubs = new JLabel(image23);
		SevenOfSpades = new JLabel(image24);
		SevenOfHearts = new JLabel(image25);
		SevenOfDiamonds = new JLabel(image26);
		SevenOfClubs  = new JLabel(image27);
		EightOfSpades = new JLabel(image28);
		EightOfHearts = new JLabel(image29);
		EightOfDiamonds = new JLabel(image30);
		EightOfClubs = new JLabel(image31);
		NineOfSpades = new JLabel(image32);
		NineOfHearts = new JLabel(image33);
		NineOfDiamonds = new JLabel(image34);
		NineOfClubs  = new JLabel(image35);
		TenOfSpades = new JLabel(image36);
		TenOfHearts = new JLabel(image37);
		TenOfDiamonds = new JLabel(image38);
		TenOfClubs = new JLabel(image39);
		JackOfSpades = new JLabel(image40);
		JackOfHearts = new JLabel(image41);
		JackOfDiamonds = new JLabel(image42);
		JackOfClubs  = new JLabel(image43);
		QueenOfSpades = new JLabel(image44);
		QueenOfHearts = new JLabel(image45);
		QueenOfDiamonds = new JLabel(image46);
		QueenOfClubs = new JLabel(image47);
		KingOfSpades = new JLabel(image48);
		KingOfHearts = new JLabel(image49);
		KingOfDiamonds = new JLabel(image50);
		KingOfClubs  = new JLabel(image51);
		BlueCard = new JLabel(image52);
		spades = new JLabel(image53);
		hearts = new JLabel(image54);
		diamonds = new JLabel(image55);
		clubs = new JLabel(image56);
		cards.add(AceOfSpades);
		cards.add(AceOfHearts);
		cards.add(AceOfDiamonds);
		cards.add(AceOfClubs);
		cards.add(TwoOfSpades);
		cards.add(TwoOfHearts);
		cards.add(TwoOfDiamonds);
		cards.add(TwoOfClubs);
		cards.add(ThreeOfSpades);
		cards.add(ThreeOfHearts);
		cards.add(ThreeOfDiamonds);
		cards.add(ThreeOfClubs);
		cards.add(FourOfSpades);
		cards.add(FourOfHearts);
		cards.add(FourOfDiamonds);
		cards.add(FourOfClubs);
		cards.add(FiveOfSpades);
		cards.add(FiveOfHearts);
		cards.add(FiveOfDiamonds);
		cards.add(FiveOfClubs);
		cards.add(SixOfSpades);
		cards.add(SixOfHearts);
		cards.add(SixOfDiamonds);
		cards.add(SixOfClubs);
		cards.add(SevenOfSpades);
		cards.add(SevenOfHearts);
		cards.add(SevenOfDiamonds);
		cards.add(SevenOfClubs);
		cards.add(EightOfSpades);
		cards.add(EightOfHearts);
		cards.add(EightOfDiamonds);
		cards.add(EightOfClubs);
		cards.add(NineOfSpades);
		cards.add(NineOfHearts);
		cards.add(NineOfDiamonds);
		cards.add(NineOfClubs);
		cards.add(TenOfSpades);
		cards.add(TenOfHearts);
		cards.add(TenOfDiamonds);
		cards.add(TenOfClubs);
		cards.add(JackOfSpades);
		cards.add(JackOfHearts);
		cards.add(JackOfDiamonds);
		cards.add(JackOfClubs);
		cards.add(QueenOfSpades);
		cards.add(QueenOfHearts);
		cards.add(QueenOfDiamonds);
		cards.add(QueenOfClubs);
		cards.add(KingOfSpades);
		cards.add(KingOfHearts);
		cards.add(KingOfDiamonds);
		cards.add(KingOfClubs);
		suits.add(spades);
		suits.add(hearts);
		suits.add(diamonds);
		suits.add(clubs);
		
		eikosi_mia();
	}
	
	public void eikosi_mia(){
		play_again_button();
		computers_turn_button();
		start_game_button();
		button2.setEnabled(false);
		button3.setEnabled(false);
		deck();
		
	}
	
	
	public void deck(){
		int size = black_jack.numOfCards();
		ArrayList<JLabel> labels = new ArrayList<>();
		for(int i=0;i<(size/5)+1;i++){
			labels.add(new JLabel(BlueCard.getIcon()));
		}
		int startWidth = (screenSize.width-72)/8;
		int height = (screenSize.height-96)/2;
		startWidth = startWidth - ((5-(size/5))*10);
		for(int i=0;i<(size/5)+1;i++){
			labels.get(i).setBounds(startWidth, height, 72, 96);
			contentPane.add(labels.get(i));
			labels.get(i).addMouseListener(new deckListener());
			startWidth-=10;
		}
		repaint();
	}
	
	
	
	
	
	public void players_pick(){
		int size = black_jack.getPlayer1_cards().size();
		int number=0, suit=0, card=0;
		if(size<=10){
		int start = (screenSize.width-((72*size)+(10*(size-1))))/2;
		for(int i=0;i<size;i++){
			number = black_jack.getPlayer1_cards().get(i).getNumber();
			suit = black_jack.getPlayer1_cards().get(i).getSuit();
			card = ((number-1)*4)+(suit-1);
			cards.get(card).setBounds(start, 590, 72, 96);
			contentPane.add(cards.get(card));
			start+=82;
		}
	}
		else{
			int sth = (screenSize.width-((size+1)*36))/2;
			int end = sth +((size+1)*36) - 72;
			for(int i=size-1;i>-1;i--){
				number = black_jack.getPlayer1_cards().get(i).getNumber();
				suit = black_jack.getPlayer1_cards().get(i).getSuit();
				card = ((number-1)*4)+(suit-1);
				cards.get(card).setBounds(end, 590, 72, 96);
				contentPane.add(cards.get(card));
				end-=36;
			}
		}
		repaint();
		
	}
	
	
	
	
	
	public void computers_pick(){
		int size = black_jack.getComputer_cards().size();
		int number=0, suit=0, card=0;
		if(size<=10){
			int start = (screenSize.width-((72*size)+(10*(size-1))))/2;
		for(int i=1;i<size;i++){
			number = black_jack.getComputer_cards().get(i).getNumber();
			suit = black_jack.getComputer_cards().get(i).getSuit();
			card = ((number-1)*4)+(suit-1);
			cards.get(card).setBounds(start, 60, 72, 96);
			contentPane.add(cards.get(card));
			start+=82;
		}
	}
		else{
			int sth = (screenSize.width-((size+1)*36))/2;
			int end = sth +((size+1)*36) - 72;
			for(int i=size-1;i>-1;i--){
				number = black_jack.getComputer_cards().get(i).getNumber();
				suit = black_jack.getComputer_cards().get(i).getSuit();
				card = ((number-1)*4)+(suit-1);
				cards.get(card).setBounds(end, 60, 72, 96);
				contentPane.add(cards.get(card));
				end-=36;
			}
		}
		repaint();
		
	}
	
	
	
	
	public void start_game_button(){
		int x = (screenSize.width-72)/10;
		int y = (screenSize.height-96)/10;
		button1.setBounds(1*x, 2*y, 100, 60);
		contentPane.add(button1);
	}
	
	
	
	
	public void computers_turn_button(){
		int x = (screenSize.width-72)/10;
		int y = (screenSize.height-96)/10;
		button2.setBounds(x, y, 150, 80);
		contentPane.add(button2);
		
	}
	
	public void play_again_button(){
		int x = (screenSize.width-72)/10;
		int y = (screenSize.height-96)/10;
		button3.setBounds(1*x, 7*y, 170, 100);
		contentPane.add(button3);
	}
	
	
	
	public void computer_is_playing(){
		boolean cont=true;
		opened_card();
		
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		computers_pick();
		JFrame frame;
		if((black_jack.getComputer_cards().get(0).getNumber()==1||black_jack.getComputer_cards().get(1).getNumber()==1)&&((black_jack.getComputer_cards().get(0).getNumber()==11||black_jack.getComputer_cards().get(0).getNumber()==12||black_jack.getComputer_cards().get(0).getNumber()==13)||(black_jack.getComputer_cards().get(1).getNumber()==11||black_jack.getComputer_cards().get(1).getNumber()==12||black_jack.getComputer_cards().get(1).getNumber()==13)))
		{computers_pick();
		
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ο υπολογιστής έκανε Black Jack!! ");
			cont=false;
		}
		
		
		while(cont){
		
		if(black_jack.player_sum(black_jack.getComputer_cards())<=16){
			computers_pick();
			
			black_jack.drawComputer();
			
			opened_card();
			
			computers_pick();
			if(black_jack.player_sum(black_jack.getComputer_cards())==21)
				
			{
				computers_pick();
				JOptionPane j = new JOptionPane();
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
					    "Ο υπολογιστής έκανε Black Jack!! ");
				black_jack.result();
				cont=false;
			}
			if(black_jack.player_sum(black_jack.getComputer_cards())>21)
				
			{
				computers_pick();
				JOptionPane j = new JOptionPane();
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
					    "Ο υπολογιστής ξεπέρασε το 21!! ");
				black_jack.result();
				cont=false;
			}
			}
		else if(black_jack.player_sum(black_jack.getComputer_cards())>16){
			computers_pick();
			cont=false;
			black_jack.result();
			
		
		}
		button3.setEnabled(true);
		button2.setEnabled(false);
		}
		
		
	}
	
	
	
	public void hidden_card(){
		
		int number = black_jack.getComputer_cards().get(0).getNumber();
		int suit = black_jack.getComputer_cards().get(0).getSuit();
		int card = ((number-1)*4)+(suit-1);
		labels.add(new JLabel(BlueCard.getIcon()));
		labels.get(0).setBounds(1200, 60, 72, 96);
		contentPane.add(labels.get(0));
		repaint();
	}
	
	
	
	
	public void opened_card(){
		int number = black_jack.getComputer_cards().get(0).getNumber();
		int suit = black_jack.getComputer_cards().get(0).getSuit();
		int card = ((number-1)*4)+(suit-1);
		cards.get(card).setBounds(300,100, 72, 96);
		contentPane.add(cards.get(card));
	}
	
	
	
	public class deckListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			black_jack.drawPlayer();
			players_pick();
			computers_pick();
			hidden_card();
			black_jack.pick_card();
			if(black_jack.player_sum(black_jack.getPlayer1_cards())>=21){
				try {
				    Thread.sleep(1000);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				black_jack.drawComputer();
				computer_is_playing();
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	
	
	public class listener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			button1.setEnabled(false);
			button2.setEnabled(true);
			black_jack.Start_Game();
			deck();
			players_pick();
			hidden_card();
			
		}
		
		
	}
	
	
	
	public class listener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			button2.setEnabled(true);
			opened_card();
			
			computers_pick();
			
			black_jack.drawComputer();
			computer_is_playing();
			//computers_pick();
			//opened_card();
			
		}
	
	}
	
	public class listener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			contentPane.setVisible(false);
			new Eikosi_mia_panel();
		}
	
	}
	
	}