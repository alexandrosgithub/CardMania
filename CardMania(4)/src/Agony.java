import java.util.ArrayList;
import java.util.Random;

public class Agony {

	private ArrayList<Card> playersHand, computersHand, cardsPlayed, validCards;
	private Deck agonyDeck = new Deck();
	private Card currOpenCard;
	private int currSuit, toPay, ace=-1 , seven=-1, eight=-1, nine=-1, sameNumber=-1;
	private boolean drew, drew1;

	public Agony(){
		/*� ����� ���� ���������� ��� ����������� ��� ������ Deck ��� ��������������� ��� �������� ��� ����������
		 * �� �������� ��� �������. ���� ��� ��� �������� ��� ��������� ���� ����������� ��� ���������� ����� ������
		 * ��� ��� ����� ���������� ���. �������� ��� �������� ���� � ����������� �� ���� ������� �������� �� ����� ��
		 * ���� �� ������ �� ������ ��� �����.
		 */
		playersHand = new ArrayList<Card>();
		computersHand = new ArrayList<Card>();
		cardsPlayed = new ArrayList<Card>();
		validCards = new ArrayList<Card>();
	}

	public void draw(ArrayList<Card>hand){
		//������� ��� ArrayList ����� Card ��� ��������� �� ���� ��� �����.
		if(!agonyDeck.isEmpty())
			hand.add(agonyDeck.DrawCard());
	}

	public void drawPlayer(){
		//��������� ��� ����� ��� ���� ��� ������.
		draw(playersHand);
	}

	public void drawComputer(){
		//��������� ��� ����� ��� ���� ��� ����������.
		draw(computersHand);
	}

	public void createGame(){
		//���������� �� �������� ������ �������� ��� 7 ������ ����� ������� ����� ��� ������� ��� ����� ����.
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
		//������� ��� ������� ��� ����������� ��� ������ ��� �� ����� ���� ������.
		//�� � ����� ���� ������� ��� ���� ��� ������ ���� ������������ �� ���������� ����������.
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
		//� ������� ���� ���� �� ����� �� �� �� � ����������� �� �������� ������ ��������� ��� � 
		//������� ���� ����� ���� � �� ����� ��� ����� ����.���������� true �� � ����������� ����� ���� ��� false
		//�� ������� ��� ����������� ������ ������.
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
		//� ������� ������� �� ����� ���� ������ ��� ArrayList computersHand ��� ������ ��� ���������� ���
		//���������� ����������.
		if(computersHand.get(i).getNumber()==7)
			toPay+=2;
		cardsPlayed.add(getCurrOpenCard());
		currOpenCard = computersHand.get(i);
		currSuit = computersHand.get(i).getSuit();
		computersHand.remove(i);
	}

	public void validCards(){
		//� ������� ���� ��������� ��� ArrayList valid cards ��� ������ ��� ������ �� ������ � ����������� ���
		//����� ���.
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
		//� ������� ���� ������� ��� �������� ��� ��������������� �� ������� ��� �� ����� ���� ������.
		//�� number ��� 1-13 ��� suit -1 ������ ��� ���������� �� ���� ���� ������ �� ������ number.
		//�� suit ��� 1-4 ��� number -1 ������ ��� ���������� �� ���� ���� ������ �� ����� suit.
		//�� number ��� 1-13 ��� suit 1-4 ������ ��� ���������� �� ���� ���� ������ �� ������ number ��� �������� suit.
		//�� ���� ��� ����������� ���������� -1 �� �� �������� ����� �� �� ���������� �������� ����������.
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
		//������� ��� ������ ��� �� ����� ���� ������ ��� ��� ��������� ��� ������� �� ��� ����� ���� ����� �� ��� ������
		//� ������� � � �����������. ���������� true �� � ����� ������ �� ������� �� ���� ���� ������� ��� ����������
		//� false �� �������� ���������.
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
		//����� �� ArrayList cardsPlayed �� �� deck.
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
		//��������� ������� ���������� ���� �������.
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
