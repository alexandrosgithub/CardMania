
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class Eikosi_mia{
	private Deck black_jack_deck = new Deck();
	private int counter_1=0;
	private int counter_2=0;
	private ArrayList<Card> player1_cards;
	private ArrayList<Card> computer_cards;
	
	public Eikosi_mia(){
	
	player1_cards= new ArrayList<Card>();
	computer_cards= new ArrayList<Card>();

	}
	
	public int player_sum(ArrayList<Card> a){
		int sum=0;
		for(int i=0;i<a.size();i++){
			if(a.get(i).getNumber()==11||a.get(i).getNumber()==12||a.get(i).getNumber()==12||a.get(i).getNumber()==13)
				sum=sum+10;
			else if(a.get(i).getNumber()==1)
				sum=sum+1;
			else
				sum=sum+a.get(i).getNumber();
		}
		return sum;
	}
	
	
	public void Start_Game(){
		black_jack_deck.NewDeck();
		player1_cards.add(black_jack_deck.DrawCard());
		player1_cards.add(black_jack_deck.DrawCard());
		computer_cards.add(black_jack_deck.DrawCard());
		JFrame frame;
		if((player1_cards.get(0).getNumber()==1||player1_cards.get(1).getNumber()==1)&&((player1_cards.get(0).getNumber()==11||player1_cards.get(0).getNumber()==12||player1_cards.get(0).getNumber()==13)||(player1_cards.get(1).getNumber()==11||player1_cards.get(1).getNumber()==12||player1_cards.get(1).getNumber()==13)))
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Black Jack!! Κερδίσατε το παιχνίδι");
		}
		/*System.out.println("Your first two cards are :"+"  "+player1_cards.get(counter_1=0).getNumber()+"  "+player1_cards.get(counter_2=0).getSuit());
		System.out.println("and "+player1_cards.get(counter_1=1).getNumber()+"  "+player1_cards.get(counter_2=1).getSuit());
		if((player1_cards.get(0).getNumber()==14||player1_cards.get(1).getNumber()==14)&&((player1_cards.get(0).getNumber()==11||player1_cards.get(0).getNumber()==12||player1_cards.get(0).getNumber()==13)||(player1_cards.get(1).getNumber()==11||player1_cards.get(1).getNumber()==12||player1_cards.get(1).getNumber()==13)))
			{System.out.println("Black Jack! Your final sum is 21");}
		System.out.println("Dealer's first card is :"+"  "+computer_cards.get(counter_1=0).getNumber()+"  "+computer_cards.get(counter_2=0).getSuit());
		computer_cards.add(black_jack_deck.DrawCard());
		*/
	}
	
	
	public void pick_card(){
		JFrame frame;
		if(player_sum(player1_cards)>21)
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ξεπεράσατε το 21!!Σειρά του υπολογιστή");
			
		}
		else if(player_sum(player1_cards)==21)
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Black Jack!!Σειρά του υπολογιστή");
			
		}
		/*String answer="YES";
		counter_1=2;
		counter_2=2;
		if(player_sum(player1_cards)<=21){
		System.out.println("Do you want another card?");
		Scanner y = new Scanner(System.in);
		System.out.println("YES or NO?");
		answer = y.next();
		while(answer.contains("YES")){
		player1_cards.add(black_jack_deck.DrawCard());
		System.out.println("You picked: "+player1_cards.get(counter_1++).getNumber()+"   "+player1_cards.get(counter_2++).getSuit());
		if(player_sum(player1_cards)<21){
			System.out.println("Your current sum is: "+player_sum(player1_cards));
			System.out.println("Do you want another card?");
			Scanner x = new Scanner(System.in);
			System.out.println("YES or NO?");
			answer = x.next();}
			else if(player_sum(player1_cards)==21)
				System.out.println("Your final sum is: 21");
			else{
				System.out.println("Now you have sum: "+player_sum(player1_cards));
				System.out.println("GAME OVER,You overpassed the limit of 21");
				answer="NO";
			}
		}
		if(player_sum(player1_cards)<21)
		System.out.println("Your current sum is: "+player_sum(player1_cards));
		}*/
	}
	
	
	public void amateur_computer_pick(){
		int w=2;
		int q=2;
		boolean cont=true;
		System.out.println("Dealer's second card finally is: "+"   "+computer_cards.get(1).getNumber()+"   "+computer_cards.get(1).getSuit());
		System.out.println("Dealer's sum is :"+"  "+player_sum(computer_cards));
		if((computer_cards.get(0).getNumber()==1||computer_cards.get(1).getNumber()==1)&&((computer_cards.get(0).getNumber()==11||computer_cards.get(0).getNumber()==12||computer_cards.get(0).getNumber()==13)||(computer_cards.get(1).getNumber()==11||computer_cards.get(1).getNumber()==12||computer_cards.get(1).getNumber()==13)))
		{System.out.println("Black Jack! Dealer's final sum is 21");}
		while(cont){
		
		if(player_sum(computer_cards)<=16){
			if(secret_counting(computer_cards)+secret_counting(player1_cards)>20)
			{//edw bainei to card counting
				
				
				
				
				
				
			}
			computer_cards.add(black_jack_deck.DrawCard());
			System.out.println("Computer's pick is: "+computer_cards.get(w++).getNumber()+"   "+computer_cards.get(q++).getSuit());
			System.out.println("Dealer's sum is :"+"  "+player_sum(computer_cards));
			if(player_sum(computer_cards)>21)
				cont=false;
			}
		else if(player_sum(computer_cards)>16){
		System.out.println("Dealer's final sum is :"+"  "+player_sum(computer_cards));
		cont=false;
		}
		}
		System.out.println("Dealer's final sum is :"+"  "+player_sum(computer_cards));
		if(player_sum(computer_cards)>21)
			System.out.println("GAME OVER for dealer!!Dealer overpassed the limit of 21");
			
	}
	
	
	public void smart_computer_pick(){
	/*	int w=2;
		int q=2;
		
		System.out.println("Dealer's second card finally is: "+"   "+computer_cards.get(1).getNumber()+"   "+computer_cards.get(1).getSuit());
		System.out.println("Dealer's sum is :"+"  "+player_sum(computer_cards));*/
		JFrame frame;
		if((computer_cards.get(0).getNumber()==1||computer_cards.get(1).getNumber()==1)&&((computer_cards.get(0).getNumber()==11||computer_cards.get(0).getNumber()==12||computer_cards.get(0).getNumber()==13)||(computer_cards.get(1).getNumber()==11||computer_cards.get(1).getNumber()==12||computer_cards.get(1).getNumber()==13)))
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ο υπολογιστής έκανε Black Jack!! ");
		}
		boolean cont=true;
		while(cont){
		
		if(player_sum(computer_cards)<=16){
			computer_cards.add(black_jack_deck.DrawCard());
		//	System.out.println("Computer's pick is: "+computer_cards.get(w++).getNumber()+"   "+computer_cards.get(q++).getSuit());
			System.out.println("Dealer's sum is :"+"  "+player_sum(computer_cards));
			if(player_sum(computer_cards)>21)
				
			{
				JOptionPane j = new JOptionPane();
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
					    "Ο υπολογιστής ξεπέρασε το 21!! ");
				cont=false;
			}
			}
		else if(player_sum(computer_cards)>16){
			result();
		System.out.println("Dealer's final sum is :"+"  "+player_sum(computer_cards));
		cont=false;
		}
		}
		System.out.println("Dealer's final sum is :"+"  "+player_sum(computer_cards));
		if(player_sum(computer_cards)>21)
			System.out.println("GAME OVER for dealer!!Dealer overpassed the limit of 21");
			
		
	}
	
	
	public void result(){
		JFrame frame; 
		if((player_sum(computer_cards)>player_sum(player1_cards))&&player_sum(computer_cards)<=21)
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ο υπολογιστής κέρδισε!! ");
		}
		if ((player_sum(computer_cards)>21&&player_sum(player1_cards)<=21)){
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Κέρδισες το παιχνίδι!! ");
			
		}
		if(player_sum(player1_cards)>21&&player_sum(computer_cards)<=21){
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ο υπολογιστής κέρδισε!! ");
		}
		else if((player_sum(player1_cards)>player_sum(computer_cards))&&player_sum(player1_cards)<=21)
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Κέρδισες το παιχνίδι!! ");
		}
		else if((player_sum(computer_cards)==player_sum(player1_cards))&&((player_sum(computer_cards)<=21)&&(player_sum(player1_cards)<=21)))
		{
			JOptionPane j = new JOptionPane();
			frame = new JFrame();
			JOptionPane.showMessageDialog(frame,
				    "Ισοπαλία!! ");
		}
			else if(player_sum(computer_cards)>21&&player_sum(player1_cards)>21)
			{
				JOptionPane j = new JOptionPane();
				frame = new JFrame();
				JOptionPane.showMessageDialog(frame,
					    "Κανείς δεν κέρδισε το παιχνίδι!! ");
			}
	
	}
	
	public int secret_counting(ArrayList<Card> x){
		int secret_counter=0;
		for(int i=0;i<x.size();i++){
			if(x.get(i).getNumber()==2||x.get(i).getNumber()==3||x.get(i).getNumber()==4||x.get(i).getNumber()==5||x.get(i).getNumber()==6)
				secret_counter=secret_counter+1;
			else if(x.get(i).getNumber()==7||x.get(i).getNumber()==8||x.get(i).getNumber()==9)
				secret_counter=secret_counter+0;
			else
				secret_counter=secret_counter-1;
		}
		return secret_counter;
		
	}

	public void newDeck(){
		black_jack_deck = new Deck();
	}
	public ArrayList<Card> getPlayer1_cards() {
		return player1_cards;
	}

	public void setPlayer1_cards(ArrayList<Card> player1_cards) {
		this.player1_cards = player1_cards;
	}

	public ArrayList<Card> getComputer_cards() {
		return computer_cards;
	}

	public void setComputer_cards(ArrayList<Card> computer_cards) {
		this.computer_cards = computer_cards;
	}
	
	public int numOfCards(){
		return black_jack_deck.numOfCards();
	}
	
	public boolean isEmpty(){
		return black_jack_deck.isEmpty();
	}
	
	
	public void draw(ArrayList<Card>hand){
		
		if(!black_jack_deck.isEmpty())
			hand.add(black_jack_deck.DrawCard());
	}
	public void drawPlayer(){
		draw(player1_cards);
	}
	
	public void drawComputer(){
		draw(computer_cards);
	}
	
	
}
