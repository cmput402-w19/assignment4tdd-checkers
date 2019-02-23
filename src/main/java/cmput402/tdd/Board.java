package cmput402.tdd;

public class Board {

	private int currentTotalBlackPieces;
	private int currentTotalRedPieces;

	public Board() {
		this.currentTotalBlackPieces = 12;
		this.currentTotalRedPieces = 12;
	}

	public int getBlackTotalPiece() {
		return this.currentTotalBlackPieces;
	}

	public int getRedTotalPiece() {
		return this.currentTotalRedPieces;
	}

	public Piece getBoardPiece(int xCoordinate, int yCoordinate) {
		return null;
	}

	public boolean pieceInLegalBound(int xCoord, int yCoord) {
		boolean isOutOfHorizontalBound = ((xCoord < 0) || (xCoord > 7));
		boolean isOutOfVerticalBound = ((yCoord < 0) || (yCoord > 7));

		return !(isOutOfHorizontalBound || isOutOfVerticalBound);
	}
}
