import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private int top;
	private ArrayList<Card> defaultDeck = new ArrayList<>();

	public Deck(){
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
		defaultDeck.add(TwoOfSpades);
		defaultDeck.add(TwoOfHearts);
		defaultDeck.add(TwoOfDiamonds);
		defaultDeck.add(TwoOfClubs);
		defaultDeck.add(ThreeOfSpades);
		defaultDeck.add(ThreeOfHearts);
		defaultDeck.add(ThreeOfDiamonds);
		defaultDeck.add(ThreeOfClubs);
		defaultDeck.add(FourOfSpades);
		defaultDeck.add(FourOfHearts);
		defaultDeck.add(FourOfDiamonds);
		defaultDeck.add(FourOfClubs);
		defaultDeck.add(FiveOfSpades);
		defaultDeck.add(FiveOfHearts);
		defaultDeck.add(FiveOfDiamonds);
		defaultDeck.add(FiveOfClubs);
		defaultDeck.add(SixOfSpades);
		defaultDeck.add(SixOfHearts);
		defaultDeck.add(SixOfDiamonds);
		defaultDeck.add(SixOfClubs);
		defaultDeck.add(SevenOfSpades);
		defaultDeck.add(SevenOfHearts);
		defaultDeck.add(SevenOfDiamonds);
		defaultDeck.add(SevenOfClubs);
		defaultDeck.add(EightOfSpades);
		defaultDeck.add(EightOfHearts);
		defaultDeck.add(EightOfDiamonds);
		defaultDeck.add(EightOfClubs);
		defaultDeck.add(NineOfSpades);
		defaultDeck.add(NineOfHearts);
		defaultDeck.add(NineOfDiamonds);
		defaultDeck.add(NineOfClubs);
		defaultDeck.add(TenOfSpades);
		defaultDeck.add(TenOfHearts);
		defaultDeck.add(TenOfDiamonds);
		defaultDeck.add(TenOfClubs);
		defaultDeck.add(JackOfSpades);
		defaultDeck.add(JackOfHearts);
		defaultDeck.add(JackOfDiamonds);
		defaultDeck.add(JackOfClubs);
		defaultDeck.add(QueenOfSpades);
		defaultDeck.add(QueenOfHearts);
		defaultDeck.add(QueenOfDiamonds);
		defaultDeck.add(QueenOfClubs);
		defaultDeck.add(KingOfSpades);
		defaultDeck.add(KingOfHearts);
		defaultDeck.add(KingOfDiamonds);
		defaultDeck.add(KingOfClubs);
		defaultDeck.add(AceOfSpades);
		defaultDeck.add(AceOfHearts);
		defaultDeck.add(AceOfDiamonds);
		defaultDeck.add(AceOfClubs);
	}
	public void Shuffle(ArrayList<Card> cards){
		/*� ������� ���� ������� ��� ArrayList ����� Card ��� �� ���������� �����������.
		 * ������� ��� ����� �� ArrayList deck!
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

	public void NewDeck(){
		/* ��� ������� � ���������� ��� ���������.
		 * 2-10 � ������� ���� �������� ���� �������� number ��� card.
		 * 11 ����� � �����, 12 � ����� 13 � ������ 14 � �����.
		 * �� suit(�����) ���� �� ����:
		 * 1-����������, 2-������, 3-����, 4-������.
		 * ��� ������ ��� �� ����� ��� ���� ������ �������� ��� �������.
		 * ������ ������� � top 51;
		 * ����� � �������� deck ������������.
		 */
		top = 51;
		deck.removeAll(deck);
		for(Card a:defaultDeck){
			deck.add(a);
		}
		Shuffle(deck);
	}

	public void AltDeck(ArrayList<Card>playedCards){
		//����� ��� ArrayList ����� Card �� �� deck ��� ���������� �� ������ top.
		top = (playedCards.size()-1);
		Shuffle(playedCards);
		deck.removeAll(deck);
		for(Card a:playedCards){
			deck.add(a);
		}
	}

	public Card DrawCard(){
		//� ������� ���� ���������� �� ��������� Card ��� deck � null �� �� deck ���� ���������.
		if(top<0){
			return null;
		}
		else{
			top--;
			return deck.get(top+1);
		}
	}

	public void PrintDeck(){
		/*��������� �� deck.���������� ��� ���� ����� �����������.��� ������� ��� �� �� ��
		 * ��������� ��� �� ��������.������ ���� �� �������.
		 */
		System.out.println("Cards in Deck: "+ numOfCards());
		for(Card a:deck){
			System.out.println("Number:"+ a.getNumber()+"  Suit:"+a.getSuit());
		}
		System.out.println("--------------------");
	}

	public boolean isEmpty(){
		//���������� true �� �� deck ���� ��������� � false �� ���� ����� ������.
		if(top>=0)
			return false;
		return true;
	}

	public int numOfCards(){
		//���������� ��� ������ ��� ������ ��� �������� ��� deck.
		return top+1;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

}
