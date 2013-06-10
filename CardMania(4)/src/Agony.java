import java.util.ArrayList;
import java.util.Random;

public class Agony {

	private ArrayList<Card> playersHand, computersHand, cardsPlayed, validCards;
	private Deck agonyDeck = new Deck();
	private Card currOpenCard;
	private int currSuit, toPay, ace=-1 , seven=-1, eight=-1, nine=-1, sameNumber=-1;
	private boolean drew, drew1;

	public Agony(){
		/*Η κλάση αυτή δημιουργεί ένα αντικείμενο της κλάσης Deck και χρησιμοποιώντας τις μεθόδους της δημιουργεί
		 * το παιχνίδι της αγωνίας. Μέσα από τις μεθόδους της καθόριζει τους κανονισμούς του παιχνιδιού καθώς επίσης
		 * και τον τρόπο διεξαγωγής του. Περιέχει και μεθόδους ώστε ο υπολόγιστης με βάση κάποιες συνθήκες να είναι σε
		 * θέση να μπορεί να παίξει και αυτός.
		 */
		playersHand = new ArrayList<Card>();
		computersHand = new ArrayList<Card>();
		cardsPlayed = new ArrayList<Card>();
		validCards = new ArrayList<Card>();
	}

	public void draw(ArrayList<Card>hand){
		//Δέχεται ένα ArrayList τύπου Card και προσθέτει σε αυτό μια κάρτα.
		if(!agonyDeck.isEmpty())
			hand.add(agonyDeck.DrawCard());
	}

	public void drawPlayer(){
		//Προσθέτει μία κάρτα στο χέρι του παίκτη.
		draw(playersHand);
	}

	public void drawComputer(){
		//Προσθέτει μία κάρτα στο χέρι του υπολογιστή.
		draw(computersHand);
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
		drew1 = false;
		if(currOpenCard.getNumber()==7)
			toPay = 2;
		else
			toPay = 0;
		drew = false;
		currSuit = currOpenCard.getSuit();
	}

	public void cardPlayed(int number, int suit){
		//Δέχεται δύο νούμερα που υποδηλώνουν τον αριθμό και το χρώμα μιας κάρτας.
		//Αν η κάρτα αυτή υπάρχει στο χέρι του παίκτη τότε ενημερόνοντε οι κατάλληλες μεταβλητές.
		Card clone = currOpenCard;
		int size = playersHand.size();
		for(int i=0;i<size;i++){
			if(number==playersHand.get(i).getNumber() && suit==playersHand.get(i).getSuit()){
				currOpenCard = playersHand.get(i);
				currSuit = playersHand.get(i).getSuit();
				playersHand.remove(i);
				cardsPlayed.add(clone);
				break;
			}
		}
	}
	
	public int points(int who){
		int points = 0;
		int number;
		if(who==1){
			for(Card c:computersHand){
				number = c.getNumber();
				if(number==1)
					points+=11;
				else if(number>1 && number<11)
					points+=number;
				else
					points+=10;
			}
		}
		else{
			for(Card c:playersHand){
				number = c.getNumber();
				if(number==1)
					points+=11;
				else if(number>1 && number<11)
					points+=number;
				else
					points+=10;
			}
		}
		return points;
	}

	public boolean pay(){
		//Η μέθοδος αυτή έχει να κάνει με το αν ο υπολογιστής θα τραβήξει κάρτες δεδομένου ότι ο 
		//παίκτης έχει ρίξει επτά ή θα ρίξει και αυτός επτά.Επιστρέφει true αν ο υπολογιστής έριξε επτά και false
		//αν τράβηξε τον απαιτούμενο αριθμό καρτών.
		if(toPay!=0){
			if(seekCard(7, -1)!=-1){
				playCard(seekCard(7, -1));
				return true;
			}
			else{
				for(int i=0;i<toPay;i++){
					drawComputer();
				}
				toPay = 0;
			}
		}
		return false;
	}

	public void playCard(int i){
		//Η μέθοδος δέχεται τη σείρα μιας κάρτας στο ArrayList computersHand την παίζει και ενημερώνει τις
		//κατάλληλες μεταβλητές.
		if(computersHand.get(i).getNumber()==7)
			toPay+=2;
		cardsPlayed.add(getCurrOpenCard());
		currOpenCard = computersHand.get(i);
		currSuit = computersHand.get(i).getSuit();
		computersHand.remove(i);
	}

	public void validCards(){
		//Η μέθοδος αυτή προσθέτει στο ArrayList valid cards τις κάρτες που μπορεί να παίξει ο υπολογιστής στη
		//σειρά του.
		for(int i=0;i<computersHand.size();i++){
			if(isValid(computersHand.get(i).getNumber(), computersHand.get(i).getSuit(), 2)){
				if(computersHand.get(i).getNumber()==7)
					seven = i;
				else if(computersHand.get(i).getNumber()==8 && computersHand.get(i).getSuit()==currSuit)
					eight  = i;
				else if(computersHand.get(i).getNumber()==9 && computersHand.get(i).getSuit()==currSuit)
					nine  = i;
				else if(computersHand.get(i).getNumber()==1)
					ace  = i;
				else if(computersHand.get(i).getNumber()==currOpenCard.getNumber())
					sameNumber = i;
				else
					validCards.add(computersHand.get(i));
			}
		}
	}

	public int mostSuit(){
		int[] mostSuit = new int[4];
		mostSuit[0]=0;
		mostSuit[1]=0;
		mostSuit[2]=0;
		mostSuit[3]=0;
		for(int i=0;i<computersHand.size();i++){
			if(computersHand.get(i).getNumber()!=1){
				if(computersHand.get(i).getSuit()==1)
					mostSuit[0]++;
				else if(computersHand.get(i).getSuit()==2)
					mostSuit[1]++;
				else if(computersHand.get(i).getSuit()==3)
					mostSuit[2]++;
				else
					mostSuit[3]++;
			}
		}
		int max = mostSuit[0];
		int returnValue = 1;
		for(int i=1;i<4;i++){
			if(max<mostSuit[i]){
				max = mostSuit[i];
				returnValue = i+1;
			}
		}
		return returnValue;
	}

	public int bestCard(){
		validCards();
		if(eight!=-1){
			playCard(eight);
			drew1 = false;
			return 5;
		}
		else if(nine!=-1){
			playCard(nine);
			drew1 = false;
			return 5;
		}
		else if(validCards.size()!=0){
			if(validCards.size()>1){
				Random randomPosition = new Random();
				int position = randomPosition.nextInt(validCards.size());
				int number = validCards.get(position).getNumber();
				int suit = validCards.get(position).getSuit();
				playCard(seekCard(number, suit));
			}
			else{
				playCard(seekCard(validCards.get(0).getNumber(), validCards.get(0).getSuit()));
			}
			drew1 = false;
			return 6;
		}
		else if(seven!=-1){
			playCard(seven);
			drew1 = false;
			return 6;
		}
		else if(sameNumber!=-1){
			int sth = 0;
			drew1 = false;
			if(computersHand.get(sameNumber).getNumber()==8 || computersHand.get(sameNumber).getNumber()==9)
				sth = 1;
			playCard(sameNumber);
			if(sth==1)
				return 5;
			return 6;
		}
		else if(ace!=-1){
			playCard(ace);
			int mostSuit = mostSuit();
			currSuit = mostSuit;
			drew1 = false;
			return currSuit;
		}
		else{
			if(drew1==false){
				drawComputer();
				drew1 = true;
				return 5;
			}
			else{
				drew1 = false;
				return 6;
			}
		}
	}

	public int seekCard(int number, int suit){
		//Η μέθοδος αυτή δέχεται δύο αριθμούς που αντιπροσωπεύουν το νούμερο και το χρώμα μιας κάρτας.
		//Με number από 1-13 και suit -1 ψάχνει και επιστρέφει τη θέση μιας κάρτας με αριθμό number.
		//Με suit από 1-4 και number -1 ψάχνει και επιστρέφει τη θέση μιας κάρτας με χρώμα suit.
		//Με number από 1-13 και suit 1-4 ψάχνει και επιστρέφει τη θέση μιας κάρτας με αριθμό number και χρώματος suit.
		//Σε όλες τις περιπτώσεις επιστρέφει -1 αν δε βρέθηκει κάρτα με τα αντίστοιχα κριτήρια αναζήτησης.
		int size = computersHand.size();
		if(number!=-1 && suit==-1){
			for(int i=0;i<size;i++){
				if(computersHand.get(i).getNumber()==number)
					return i;
			}
		}
		else if(number==-1 && suit!=-1){
			for(int i=0;i<size;i++){
				if(computersHand.get(i).getSuit()==suit)
					return i;
			}
		}
		else{
			for(int i=0;i<size;i++){
				if(computersHand.get(i).getNumber()==number && computersHand.get(i).getSuit()==suit)
					return i;
			}
		}
		return -1;
	}

	public boolean isValid(int number, int suit, int who){
		//Δέχεται τον αριθμό και το χρώμα μιας κάρτας και μια μεταβλήτη που δηλώνει αν την κάρτα αυτή θέλει να την παίξει
		//ο παίκτης ή ο υπολογιστής. Επιστρέφει true αν η κάρτα μπόρει να παιχθεί με βάση τους κανόνες του παιχνιδιού
		//ή false σε αντίθετη περίπτωση.
		int size;
		if(toPay==0){
			if(number==1){
				if(who==1)
					size = playersHand.size();
				else
					size = computersHand.size();
				if(size!=1)
					if(currOpenCard.getNumber()!=1)
						return true;
			}
			else{
				if(suit==currSuit)
					return true;
				if(number==currOpenCard.getNumber())
					return true;
			}
		}
		else{
			if(number==7){
				toPay+=2;
				return true;
			}
		}
		return false;
	}

	public void reDeck(){
		//Θέτει το ArrayList cardsPlayed ως τη deck.
		agonyDeck.AltDeck(cardsPlayed);
		cardsPlayed.removeAll(cardsPlayed);
	}

	public void deleteValues(){
		validCards.removeAll(validCards);
		ace = -1;
		seven = -1;
		eight = -1;
		nine = -1;
		sameNumber = -1;
	}

	public void show(){
		//Εμφανίζει κάποιες μεταβλητές στην κονσόλα.
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

	public ArrayList<Card> getPlayersHand() {
		return playersHand;
	}

	public void setPlayersHand(ArrayList<Card> playersHand) {
		this.playersHand = playersHand;
	}

	public ArrayList<Card> getComputersHand() {
		return computersHand;
	}

	public void setComputersHand(ArrayList<Card> computersHand) {
		this.computersHand = computersHand;
	}

	public Card getCurrOpenCard() {
		return currOpenCard;
	}

	public void setCurrOpenCard(Card currOpenCard) {
		this.currOpenCard = currOpenCard;
	}

	public int numOfCards(){
		return agonyDeck.numOfCards();
	}

	public boolean isEmpty(){
		return agonyDeck.isEmpty();
	}

	public ArrayList<Card> getCardsPlayed() {
		return cardsPlayed;
	}

	public void setCardsPlayed(ArrayList<Card> cardsPlayed) {
		this.cardsPlayed = cardsPlayed;
	}

	public int getToPay() {
		return toPay;
	}

	public void setToPay(int toPay) {
		this.toPay = toPay;
	}

	public boolean isDrew() {
		return drew;
	}

	public void setDrew(boolean drew) {
		this.drew = drew;
	}

	public ArrayList<Card> getValidCards() {
		return validCards;
	}

	public void setValidCards(ArrayList<Card> validCards) {
		this.validCards = validCards;
	}

	public int getCurrSuit() {
		return currSuit;
	}

	public void setCurrSuit(int currSuit) {
		this.currSuit = currSuit;
	}

	public int getAce() {
		return ace;
	}

	public void setAce(int ace) {
		this.ace = ace;
	}

	public int getSeven() {
		return seven;
	}

	public void setSeven(int seven) {
		this.seven = seven;
	}

	public int getEight() {
		return eight;
	}

	public void setEight(int eight) {
		this.eight = eight;
	}

	public int getNine() {
		return nine;
	}

	public void setNine(int nine) {
		this.nine = nine;
	}

	public int getSameNumber() {
		return sameNumber;
	}

	public void setSameNumber(int sameNumber) {
		this.sameNumber = sameNumber;
	}
}
