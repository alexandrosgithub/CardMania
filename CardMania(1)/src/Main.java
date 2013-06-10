import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int sth=0;
		//Deck deck1 = new Deck();
		//deck1.NewDeck();
		//deck1.PrintDeck();
		//System.out.println(deck1.DrawCard());
		Black_Jack game = new Black_Jack();
		game.pick_card();
		game.computer_pick();
	}

}
