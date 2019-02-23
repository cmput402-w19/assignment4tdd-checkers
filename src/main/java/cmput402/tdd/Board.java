package cmput402.tdd;

public class Board {

	private int currentTotalBlackPieces;

	public Board() {
		this.currentTotalBlackPieces = 12;
	}

	public int getBlackTotalPiece() {
		return this.currentTotalBlackPieces;
	}

	public int getRedTotalPiece() {
		return (Integer) null;
	}
}
