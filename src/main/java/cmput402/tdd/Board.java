package cmput402.tdd;

public class Board {

	private int currentTotalBlackPieces;
	private int currentTotalRedPieces;

	public Board() {
		this.currentTotalBlackPieces = 12;
		this.currentTotalRedPieces = 12;
	}

	public Piece getPiece(int x, int y) {
		return null;
	}

	public int getBlackTotalPiece() {
		return this.currentTotalBlackPieces;
	}

	public int getRedTotalPiece() {
		return this.currentTotalRedPieces;
	}
}
