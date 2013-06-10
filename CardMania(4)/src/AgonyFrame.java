import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class AgonyFrame extends JFrame{
	/*Η κλάση γραφικών. Είναι κοινή και για τα τρία παιχνίδια. Φορτώνει τις απαραίτητες εικόνες από έναν φάκελο
	 * και με τη χρήση κατάλληλων μεθόδων τις τοποθετεί στην οθόνη.
	 */

	private ImagePanel contentPane = new ImagePanel("images/background.jpg");
	private JLabel TwoOfSpades, TwoOfHearts, TwoOfDiamonds, TwoOfClubs, ThreeOfSpades, ThreeOfHearts, ThreeOfDiamonds, ThreeOfClubs,
	FourOfSpades, FourOfHearts, FourOfDiamonds, FourOfClubs, FiveOfSpades, FiveOfHearts, FiveOfDiamonds, FiveOfClubs,
	SixOfSpades, SixOfHearts, SixOfDiamonds, SixOfClubs, SevenOfSpades, SevenOfHearts, SevenOfDiamonds, SevenOfClubs, 
	EightOfSpades, EightOfHearts, EightOfDiamonds, EightOfClubs, NineOfSpades, NineOfHearts, NineOfDiamonds, NineOfClubs, 
	TenOfSpades, TenOfHearts, TenOfDiamonds, TenOfClubs, JackOfSpades, JackOfHearts, JackOfDiamonds, JackOfClubs, 
	QueenOfSpades, QueenOfHearts, QueenOfDiamonds, QueenOfClubs, KingOfSpades, KingOfHearts, KingOfDiamonds, KingOfClubs, 
	AceOfSpades, AceOfHearts, AceOfDiamonds, AceOfClubs, BlueCard, spades, hearts, diamonds, clubs, player, computer,
	playerPoints, computerPoints;
	private ArrayList<JLabel> cards = new ArrayList<>();
	private ArrayList<JLabel> suits = new ArrayList<>();
	private Agony agonia = new Agony();
	private Dimension screenSize;
	private JButton fold, reset, back;
	private boolean enabled = true;
	private boolean suitBadge = false;
	private int playersPoints, computersPoints, first=2;

	public AgonyFrame(){
		super("Αγωνία");
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
		player = new JLabel("Player");
		computer = new JLabel("Computer");
		playerPoints = new JLabel();
		computerPoints = new JLabel();
		fold = new JButton("Fold");
		reset = new JButton("New Game");
		back = new JButton("<");
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
		AceOfSpades.addMouseListener(new cardListener());
		AceOfHearts.addMouseListener(new cardListener());
		AceOfDiamonds.addMouseListener(new cardListener());
		AceOfClubs.addMouseListener(new cardListener());
		TwoOfSpades.addMouseListener(new cardListener());
		TwoOfHearts.addMouseListener(new cardListener());
		TwoOfDiamonds.addMouseListener(new cardListener());
		TwoOfClubs.addMouseListener(new cardListener());
		ThreeOfSpades.addMouseListener(new cardListener());
		ThreeOfHearts.addMouseListener(new cardListener());
		ThreeOfDiamonds.addMouseListener(new cardListener());
		ThreeOfClubs.addMouseListener(new cardListener());
		FourOfSpades.addMouseListener(new cardListener());
		FourOfHearts.addMouseListener(new cardListener());
		FourOfDiamonds.addMouseListener(new cardListener());
		FourOfClubs.addMouseListener(new cardListener());
		FiveOfSpades.addMouseListener(new cardListener());
		FiveOfHearts.addMouseListener(new cardListener());
		FiveOfDiamonds.addMouseListener(new cardListener());
		FiveOfClubs.addMouseListener(new cardListener());
		SixOfSpades.addMouseListener(new cardListener());
		SixOfHearts.addMouseListener(new cardListener());
		SixOfDiamonds.addMouseListener(new cardListener());
		SixOfClubs.addMouseListener(new cardListener());
		SevenOfSpades.addMouseListener(new cardListener());
		SevenOfHearts.addMouseListener(new cardListener());
		SevenOfDiamonds.addMouseListener(new cardListener());
		SevenOfClubs.addMouseListener(new cardListener());
		EightOfSpades.addMouseListener(new cardListener());
		EightOfHearts.addMouseListener(new cardListener());
		EightOfDiamonds.addMouseListener(new cardListener());
		EightOfClubs.addMouseListener(new cardListener());
		NineOfSpades.addMouseListener(new cardListener());
		NineOfHearts.addMouseListener(new cardListener());
		NineOfDiamonds.addMouseListener(new cardListener());
		NineOfClubs.addMouseListener(new cardListener());
		TenOfSpades.addMouseListener(new cardListener());
		TenOfHearts.addMouseListener(new cardListener());
		TenOfDiamonds.addMouseListener(new cardListener());
		TenOfClubs.addMouseListener(new cardListener());
		JackOfSpades.addMouseListener(new cardListener());
		JackOfHearts.addMouseListener(new cardListener());
		JackOfDiamonds.addMouseListener(new cardListener());
		JackOfClubs.addMouseListener(new cardListener());
		QueenOfSpades.addMouseListener(new cardListener());
		QueenOfHearts.addMouseListener(new cardListener());
		QueenOfDiamonds.addMouseListener(new cardListener());
		QueenOfClubs.addMouseListener(new cardListener());
		KingOfSpades.addMouseListener(new cardListener());
		KingOfHearts.addMouseListener(new cardListener());
		KingOfDiamonds.addMouseListener(new cardListener());
		KingOfClubs.addMouseListener(new cardListener());
		spades.addMouseListener(new suitListener());
		hearts.addMouseListener(new suitListener());
		diamonds.addMouseListener(new suitListener());
		clubs.addMouseListener(new suitListener());
		fold.addActionListener(new foldListener());
		reset.addActionListener(new resetListener());
		back.addActionListener(new backListener());
		agony();
	}

	public void agony(){
		contentPane.removeAll();
		agonia.createGame();
		fold.setEnabled(false);
		currOpenCard();
		deck();
		playersHand();
		computersHand();
		foldButton();
		labels_buttons();
		if(first==2)
			first = 1;
		else
			first = 2;
		setTurn(first);
	}

	public void labels_buttons(){
		player.setBounds((6*(screenSize.width)/8), (screenSize.height)/4, 200, 200);
		player.setFont(new Font("Serif", Font.PLAIN, 30));
		player.setForeground(Color.BLACK);
		contentPane.add(player);
		playerPoints.setText(Integer.toString(playersPoints));
		playerPoints.setBounds((6*(screenSize.width)/8)+25, ((screenSize.height)/4)+40, 200, 200);
		playerPoints.setFont(new Font("Serif", Font.PLAIN, 30));
		playerPoints.setForeground(Color.BLACK);
		contentPane.add(playerPoints);
		computer.setBounds((7*(screenSize.width)/8), (screenSize.height)/4, 200, 200);
		computer.setFont(new Font("Serif", Font.PLAIN, 30));
		computer.setForeground(Color.BLUE);
		contentPane.add(computer);
		computerPoints.setText(Integer.toString(computersPoints));
		computerPoints.setBounds((7*(screenSize.width)/8)+50, ((screenSize.height)/4)+40, 200, 200);
		computerPoints.setFont(new Font("Serif", Font.PLAIN, 30));
		computerPoints.setForeground(Color.BLUE);
		contentPane.add(computerPoints);
		reset.setBounds((6*(screenSize.width)/8)+105, ((screenSize.height)/4)+200, 100, 40);
		contentPane.add(reset);
		back.setBounds((6*(screenSize.width)/8)+55, ((screenSize.height)/4)+200, 50, 40);
		contentPane.add(back);
		repaint();
	}

	public void newGame(){
		playersPoints=0;
		computersPoints=0;
		first=2;
		agony();
	}

	public void playersHand(){
		//Εμφανίζει στην οθόνη τις κάρτες του παίκτη.
		int size = agonia.getPlayersHand().size();
		int number=0, suit=0, card=0;
		if(size<=10){
			int start = (screenSize.width-((72*size)+(10*(size-1))))/2;
			for(int i=0;i<size;i++){
				number = agonia.getPlayersHand().get(i).getNumber();
				suit = agonia.getPlayersHand().get(i).getSuit();
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
				number = agonia.getPlayersHand().get(i).getNumber();
				suit = agonia.getPlayersHand().get(i).getSuit();
				card = ((number-1)*4)+(suit-1);
				cards.get(card).setBounds(end, 590, 72, 96);
				contentPane.add(cards.get(card));
				end-=36;
			}
		}
		repaint();
	}

	public void computersHand(){
		int size = agonia.getComputersHand().size();
		ArrayList<JLabel> labels = new ArrayList<>();
		for(int i=0;i<size;i++){
			labels.add(new JLabel(BlueCard.getIcon()));
		}
		if(size<=10){
			int start = (screenSize.width-((72*size)+(10*(size-1))))/2;
			for(int i=0;i<size;i++){
				labels.get(i).setBounds(start, 60, 72, 96);
				contentPane.add(labels.get(i));
				start+=82;
			}
		}
		else{
			int sth = (screenSize.width-((size+1)*36))/2;
			int end = sth +((size+1)*36) - 72;
			for(int i=size-1;i>-1;i--){
				labels.get(i).setBounds(end, 60, 72, 96);
				contentPane.add(labels.get(i));
				end-=36;
			}
		}
		repaint();
		labels.removeAll(labels);
	}

	public void currOpenCard(){
		//Εμφανίζει στην οθόνη την κάρτα που βρίσκεται στη μέση.
		int number = agonia.getCurrOpenCard().getNumber();
		int suit = agonia.getCurrOpenCard().getSuit();
		int card = ((number-1)*4)+(suit-1);
		cards.get(card).setBounds((screenSize.width-72)/2, (screenSize.height-96)/2, 72, 96);
		if(number==1 && suitBadge){
			suits.get(agonia.getCurrSuit()-1).setBounds((screenSize.width-72)/2, (screenSize.height-96)/2, 72, 96);
			contentPane.add(suits.get(agonia.getCurrSuit()-1));
		}
		else
			contentPane.add(cards.get(card));
	}

	public void deck(){
		//Εμφανίζει στην οθόνη την τράπουλα.
		int size = agonia.numOfCards();
		if(size!=0){
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
		}
		else{
			if(agonia.getCardsPlayed().size()!=0){
				agonia.reDeck();
				contentPane.removeAll();
				deck();
				playersHand();
				computersHand();
				currOpenCard();
				foldButton();
				labels_buttons();
			}
		}
		repaint();
	}

	public void foldButton(){
		//Εμφανίζει στην οθόνη το κουμπί fold.
		int x = (screenSize.width-72)/10;
		int y = (screenSize.height-96)/10;
		fold.setBounds(9*x, 8*y, 80, 40);
		contentPane.add(fold);
	}

	public void setTurn(int turn){
		//Δέχεται έναν ακέραιο 1-2 και καθορίζει ποιος θα παίξει.
		int isFinished = isFinished();
		if(isFinished==3){
			if(turn==1){
				enabled = true;
				agonia.setDrew(false);
				fold.setEnabled(false);
			}
			else{
				enabled = false;
				fold.setEnabled(false);
				int bestCard;
				agonia.deleteValues();
				if(!agonia.pay()){
					bestCard = agonia.bestCard();
					if(bestCard>0 && bestCard<5)
						suitBadge = true;
					contentPane.removeAll();
					currOpenCard();
					deck();
					playersHand();
					computersHand();
					foldButton();
					labels_buttons();
					if(bestCard==5)
						setTurn(2);
					else
						setTurn(1);
				}
				else{
					contentPane.removeAll();
					currOpenCard();
					deck();
					playersHand();
					computersHand();
					foldButton();
					labels_buttons();
					setTurn(1);
				}
			}
		}
		else if(isFinished==1){
			computersPoints+=agonia.points(1);
			if(computersPoints<100)
				agony();
			JOptionPane.showMessageDialog (null, "Νικήσατε την παρτίδα!", "Αγωνία", 
					JOptionPane.INFORMATION_MESSAGE);
			if(computersPoints>=100){
				JOptionPane.showMessageDialog (null, "Νικήσατε!!!", "Αγωνία", 
						JOptionPane.INFORMATION_MESSAGE);
				newGame();
			}
		}
		else{
			playersPoints+=agonia.points(2);
			if(playersPoints<100)
				agony();
			JOptionPane.showMessageDialog (null, "Χάσατε την παρτίδα :(", "Αγωνία", 
					JOptionPane.INFORMATION_MESSAGE);
			if(playersPoints>=100){
				JOptionPane.showMessageDialog (null, "Χάσατε...", "Αγωνία", 
						JOptionPane.INFORMATION_MESSAGE);
				newGame();
			}
		}
	}

	public int isFinished(){
		//Ελέγχει αν έληξε η παρτίδα. Επιστρέφει 1 αν νίκησε ο παίκτης, 2 αν νίκησε ο υπολογιστής και 3 αν η
		//παρτίδα δεν τελείωσε ακόμα.
		if(agonia.getPlayersHand().size()==0)
			if(agonia.getCurrOpenCard().getNumber()!=8)
				return 1;
		if(agonia.getComputersHand().size()==0)
			if(agonia.getCurrOpenCard().getNumber()!=8)
				return 2;
		return 3;
	}

	public class cardListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(enabled){
				for(int i=0;i<52;i++){
					if(e.getSource()==cards.get(i)){
						int number = i/4+1;
						int suit = i%4+1;
						if(agonia.isValid(number, suit, 1)){
							suitBadge = false;
							agonia.cardPlayed(number, suit);
							contentPane.removeAll();
							if(number==1){
								enabled = false;
								fold.setEnabled(false);
								int start = (screenSize.width-((72*4)+(10*(4-1))))/2;
								for(int a=0;a<4;a++){
									suits.get(a).setBounds(start, 490, 72, 96);
									contentPane.add(suits.get(a));
									start+=82;
								}
							}
							if(number==7 && agonia.getToPay()==0)
								agonia.setToPay(2);
							computersHand();
							playersHand();
							currOpenCard();
							labels_buttons();
							if(agonia.numOfCards()!=0)
								deck();
							foldButton();
							if(number==8 || number==9)
								setTurn(1);
							else if(number!=1)
								setTurn(2);
						}
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class deckListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(enabled){
				if(agonia.getToPay()!=0){
					agonia.drawPlayer();
					agonia.setToPay(agonia.getToPay()-1);
					contentPane.removeAll();
					deck();
					playersHand();
					computersHand();
					currOpenCard();
					foldButton();
					labels_buttons();
				}
				else if(!agonia.isDrew()){
					agonia.drawPlayer();
					agonia.setDrew(true);
					fold.setEnabled(true);
					contentPane.removeAll();
					deck();
					playersHand();
					computersHand();
					currOpenCard();
					foldButton();
					labels_buttons();
				}
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

	public class suitListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			for(int i=0;i<4;i++){
				if(arg0.getSource()==suits.get(i)){
					enabled = true;
					suitBadge = true;
					contentPane.removeAll();
					agonia.setCurrSuit(i+1);
					currOpenCard();
					deck();
					playersHand();
					computersHand();
					foldButton();
					labels_buttons();
					setTurn(2);
				}
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

	public class foldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			fold.setEnabled(false);
			agonia.setDrew(false);
			setTurn(2);
		}
	}

	public class resetListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			int n = JOptionPane.showConfirmDialog(
					null, "Είστε σίγουρος/σίγουρη;",
					"Αγωνία",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				newGame();
			}
		}
	}
	
	public class backListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			int n = JOptionPane.showConfirmDialog(
					null, "Έξοδος και επιστροφή στο menu;",
					"Αγωνία",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				setVisible(false);
				dispose();
				new Menu();
			}
		}
	}
}
