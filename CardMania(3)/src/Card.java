public class Card {

	private int number;
	private int suit;

	public Card(int number, int suit) {
		//� ����� ���� �������������� ��� �����. �������� ��� ��������� number ��� suit(������� ��� ����� ����������).

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
