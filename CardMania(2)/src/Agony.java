import java.util.ArrayList;

public class Agony {

	private ArrayList<Card> playersHand, computersHand, cardsPlayed;
	private Deck agonyDeck = new Deck();
	private Card currOpenCard;

	public Agony(){
		playersHand = new ArrayList<Card>();
		computersHand = new ArrayList<Card>();
		cardsPlayed = new ArrayList<Card>();
	}

	public void draw(ArrayList<Card>hand){
		//Δέχεται ένα ArrayList τύπου Card και προσθέτει σε αυτό μια κάρτα.
		if(!agonyDeck.isEmpty())
			hand.add(agonyDeck.DrawCard());
	}
	
	public void drawPlayer(){
		playersHand.add(agonyDeck.DrawCard());
	}

	public void createGame(){
		//Δημιουργεί το παιχνίδι δηλαδή μοιράζει από 7 κάρτες στους παίκτες καθώς και ανοίγει μια κάρτα κάτω.
		agonyDeck.NewDeck();
		playersHand.removeAll(playersHand);
		computersHand.removeAll(computersHand);
		cardsPlayed.removeAll(cardsPlayed);
		for(int i=0;i<7;i++){
			draw(playersHand);
			draw(computersHand);
		}
		currOpenCard = agonyDeck.DrawCard();
	}
	
	public void cardPlayed(int number){
		cardsPlayed.add(currOpenCard);
		currOpenCard = playersHand.get(number);
		playersHand.remove(number);
	}
	
	public void reDeck(){
		//Θέτει το ArrayList cardsPlayed ως τη deck.
		agonyDeck.AltDeck(cardsPlayed);
		cardsPlayed.removeAll(cardsPlayed);
	}
	
	public void show(){
		System.out.println("Player's hand");
		for(Card a:playersHand){
			System.out.println("Number:"+ a.getNumber()+"  Suit:"+a.getSuit());
		}
		System.out.println("Computer's hand");
		for(Card a:computersHand){
			System.out.println("Number:"+ a.getNumber()+"  Suit:"+a.getSuit());
		}
		System.out.println("Cards left: "+(agonyDeck.numOfCards()));
		System.out.println("Open Card: "+"Number:"+ currOpenCard.getNumber()+"  Suit:"+currOpenCard.getSuit());
		System.out.println("Player's hand size: "+playersHand.size());
		System.out.println("Computer's hand size: "+computersHand.size());
		System.out.println("Cards Played size: "+cardsPlayed.size());
		System.out.println("----------------------");
	}
}
