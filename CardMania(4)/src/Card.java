public class Card {

	private int number;
	private int suit;

	public Card(int number, int suit) {
		//Η κλάση αυτή αντιπροσωπεύει ένα χαρτί. Περίεχει τις ιδιότητες number και suit(αριθμός και χρώμα αντίστοιχα).

		this.number = number;
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}


}
