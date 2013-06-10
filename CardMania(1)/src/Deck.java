import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck;
	private int top;

	public Deck(){
		
		/* Εδώ γίνεται η δημιουργία της τράπουλας.
		 * 2-10 ο αριθμός πάει κανονικά στην ιδιότητα number της card.
		 * 11 είναι ο βαλές, 12 η ντάμα 13 ο παππάς 14 ο άσσος.
		 * Το suit(χρώμα) πάει ως εξής:
		 * 1-μπαστούνια, 2-κούπες, 3-καρό, 4-σπαθιά.
		 * Έχω γράψει και το όνομα της κάθε κάρτας παρακάτω για ευκολία.
		 */
		deck = new ArrayList<Card>();
		Card TwoOfSpades = new Card(2, 1);
		Card TwoOfHearts = new Card(2, 2);
		Card TwoOfDiamonds = new Card(2, 3);
		Card TwoOfClubs = new Card(2, 4);
		Card ThreeOfSpades = new Card(3, 1);
		Card ThreeOfHearts = new Card(3, 2);
		Card ThreeOfDiamonds = new Card(3, 3);
		Card ThreeOfClubs = new Card(3, 4);
		Card FourOfSpades = new Card(4, 1);
		Card FourOfHearts = new Card(4, 2);
		Card FourOfDiamonds = new Card(4, 3);
		Card FourOfClubs = new Card(4, 4);
		Card FiveOfSpades = new Card(5, 1);
		Card FiveOfHearts = new Card(5, 2);
		Card FiveOfDiamonds = new Card(5, 3);
		Card FiveOfClubs = new Card(5, 4);
		Card SixOfSpades = new Card(6, 1);
		Card SixOfHearts = new Card(6, 2);
		Card SixOfDiamonds = new Card(6, 3);
		Card SixOfClubs = new Card(6, 4);
		Card SevenOfSpades = new Card(7, 1);
		Card SevenOfHearts = new Card(7, 2);
		Card SevenOfDiamonds = new Card(7, 3);
		Card SevenOfClubs = new Card(7, 4);
		Card EightOfSpades = new Card(8, 1);
		Card EightOfHearts = new Card(8, 2);
		Card EightOfDiamonds = new Card(8, 3);
		Card EightOfClubs = new Card(8, 4);
		Card NineOfSpades = new Card(9, 1);
		Card NineOfHearts = new Card(9, 2);
		Card NineOfDiamonds = new Card(9, 3);
		Card NineOfClubs = new Card(9, 4);
		Card TenOfSpades = new Card(10, 1);
		Card TenOfHearts = new Card(10, 2);
		Card TenOfDiamonds = new Card(10, 3);
		Card TenOfClubs = new Card(10, 4);
		Card JackOfSpades = new Card(11, 1);
		Card JackOfHearts = new Card(11, 2);
		Card JackOfDiamonds = new Card(11, 3);
		Card JackOfClubs = new Card(11, 4);
		Card QueenOfSpades = new Card(12, 1);
		Card QueenOfHearts = new Card(12, 2);
		Card QueenOfDiamonds = new Card(12, 3);
		Card QueenOfClubs = new Card(12, 4);
		Card KingOfSpades = new Card(13, 1);
		Card KingOfHearts = new Card(13, 2);
		Card KingOfDiamonds = new Card(13, 3);
		Card KingOfClubs = new Card(13, 4);
		Card AceOfSpades = new Card(14, 1);
		Card AceOfHearts = new Card(14, 2);
		Card AceOfDiamonds = new Card(14, 3);
		Card AceOfClubs = new Card(14, 4);
		deck.add(TwoOfSpades);
		deck.add(TwoOfHearts);
		deck.add(TwoOfDiamonds);
		deck.add(TwoOfClubs);
		deck.add(ThreeOfSpades);
		deck.add(ThreeOfHearts);
		deck.add(ThreeOfDiamonds);
		deck.add(ThreeOfClubs);
		deck.add(FourOfSpades);
		deck.add(FourOfHearts);
		deck.add(FourOfDiamonds);
		deck.add(FourOfClubs);
		deck.add(FiveOfSpades);
		deck.add(FiveOfHearts);
		deck.add(FiveOfDiamonds);
		deck.add(FiveOfClubs);
		deck.add(SixOfSpades);
		deck.add(SixOfHearts);
		deck.add(SixOfDiamonds);
		deck.add(SixOfClubs);
		deck.add(SevenOfSpades);
		deck.add(SevenOfHearts);
		deck.add(SevenOfDiamonds);
		deck.add(SevenOfClubs);
		deck.add(EightOfSpades);
		deck.add(EightOfHearts);
		deck.add(EightOfDiamonds);
		deck.add(EightOfClubs);
		deck.add(NineOfSpades);
		deck.add(NineOfHearts);
		deck.add(NineOfDiamonds);
		deck.add(NineOfClubs);
		deck.add(TenOfSpades);
		deck.add(TenOfHearts);
		deck.add(TenOfDiamonds);
		deck.add(TenOfClubs);
		deck.add(JackOfSpades);
		deck.add(JackOfHearts);
		deck.add(JackOfDiamonds);
		deck.add(JackOfClubs);
		deck.add(QueenOfSpades);
		deck.add(QueenOfHearts);
		deck.add(QueenOfDiamonds);
		deck.add(QueenOfClubs);
		deck.add(KingOfSpades);
		deck.add(KingOfHearts);
		deck.add(KingOfDiamonds);
		deck.add(KingOfClubs);
		deck.add(AceOfSpades);
		deck.add(AceOfHearts);
		deck.add(AceOfDiamonds);
		deck.add(AceOfClubs);
	}

	void Shuffle(ArrayList<Card> cards){
		/*Η μέθοδος αυτή δέχεται ένα ArrayList τύπου Card και το επιστρέφει ανακατομένο.
		 * Προσοχή δεν είναι το ArrayList deck!
		 */
		ArrayList<Card> helpy = new ArrayList<Card>();
		int currentSize = cards.size()-1;
		while(currentSize>0){
			Random randomPosition = new Random();
			int draw = randomPosition.nextInt(currentSize+1);
			helpy.add(cards.get(draw));
			for(int i=draw;i<currentSize;i++){
				cards.set(i, cards.get(i+1));
			}
			currentSize--;
		}
		helpy.add(cards.get(0));
		cards.removeAll(cards);
		for(Card a:helpy){
			cards.add(a);
		}
	}
	
	void NewDeck(){
		//Χρησιμοποιώντας τη μέθοδο Shuffle η μέθοδος αυτή ανακατέβει το deck.
		top = 51;
		Shuffle(deck);
	}
	
	Card DrawCard(){
		//Η μέθοδος αυτή επιστρέφει το τελευταίο Card του deck ή null αν το deck έχει τελειώσει.
		if(top<0){
			return null;
		}
		else{
			top--;
			return deck.get(top+1);
		}
	}
	
	void PrintDeck(){
		/*Εμφάνιζει το deck.Ουσιαστικά δεν έχει καμία χρησιμότητα.Την έφτιαξα για να δω αν
		 * δουλεύουν όλα τα παραπάνω.Λογικά μετά θα σβηστεί.
		 */
		System.out.println(deck.size());
		for(Card a:deck){
			System.out.println("Number:"+ a.getNumber()+"  Suit:"+a.getSuit());
		}
		System.out.println("--------------------");
	}
	
	
	
	
}
