import java.util.ArrayList;
import java.util.Scanner;




public class Black_Jack{
	private int player_1=1;
	private int player_2=2;
	private ArrayList<Card> player1_cards;
	private ArrayList<Card> player2_cards;
	public Black_Jack(){
	
	player1_cards= new ArrayList<Card>();
	player2_cards= new ArrayList<Card>();

	}
	
	public int player1_sum(ArrayList<Card> a){
		int sum=0;
		for(int i=0;i<a.size();i++){
			if(a.get(i).getNumber()==11||a.get(i).getNumber()==12||a.get(i).getNumber()==12||a.get(i).getNumber()==13)
				sum=sum+10;
			else if(a.get(i).getNumber()==14)
				sum=sum+21;
			else
				sum=sum+a.get(i).getNumber();
		}
		return sum;
	}
	
	
	public void pick_card(){
		Deck black_jack_deck = new Deck();
		String answer="YES";
		int p =0;
		int k=0;
		black_jack_deck.NewDeck();
		
		while(answer.contains("YES")){
		player1_cards.add(black_jack_deck.DrawCard());
		System.out.println("You picked: "+player1_cards.get(p++).getNumber()+"   "+player1_cards.get(k++).getSuit());
		if(player1_sum(player1_cards)<21){
			System.out.println("Your current sum is: "+player1_sum(player1_cards));
			System.out.println("Do you want another card?");
			Scanner x = new Scanner(System.in);
			System.out.println("YES or NO?");
			answer = x.next();}
			else if(player1_sum(player1_cards)==21)
				System.out.println("Your final sum is: 21");
			else{
				System.out.println("Now you have sum: "+player1_sum(player1_cards));
				System.out.println("GAME OVER,You overpassed the limit of 21");
				answer="NO";
			}
		}
		System.out.println("Your current sum is: "+player1_sum(player1_cards));
	}
	
	
	public void computer_pick(){
		
		
		
		
		
	}
	
	
	
	
}
