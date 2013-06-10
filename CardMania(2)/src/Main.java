
public class Main {

	public static void main(String[] args) {
		Agony agonia = new Agony();
		agonia.createGame();
		agonia.show();
		agonia.cardPlayed(0);
		agonia.cardPlayed(0);
		agonia.cardPlayed(0);
		agonia.show();
		agonia.drawPlayer();
		agonia.show();
		agonia.reDeck();
		agonia.drawPlayer();
		agonia.show();
		Eikosi_mia game = new Eikosi_mia();
		game.Start_Game();
		game.pick_card();
		game.amateur_computer_pick();
		game.result();
	
	}

}
