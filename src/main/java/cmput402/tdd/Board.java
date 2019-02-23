package cmput402.tdd;

public class Board {

	private int currentTotalBlackPieces;
	private int currentTotalRedPieces;
	private Piece[][] board;

	public Board() throws Exception {
		this.currentTotalBlackPieces = 12;
		this.currentTotalRedPieces = 12;
		board = new Piece[8][8];
		board[1][1] = new Pawn("B", 1, 1);
	}

	public int getBlackTotalPiece() {
		return this.currentTotalBlackPieces;
	}

	public int getRedTotalPiece() {
		return this.currentTotalRedPieces;
	}

	public Piece getBoardPiece(int xCoordinate, int yCoordinate) {
		boolean legalCoords = this.pieceInLegalBound(xCoordinate, yCoordinate);

		if(!legalCoords) {
			return null;
		} else {
			return this.board[xCoordinate][yCoordinate];
		}
	}

	public boolean pieceInLegalBound(int xCoord, int yCoord) {
		boolean isOutOfHorizontalBound = ((xCoord < 0) || (xCoord > 7));
		boolean isOutOfVerticalBound = ((yCoord < 0) || (yCoord > 7));

		return !(isOutOfHorizontalBound || isOutOfVerticalBound);
	}
}
