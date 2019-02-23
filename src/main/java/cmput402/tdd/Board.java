package cmput402.tdd;

import java.util.ArrayList;

public class Board {

	private int currentTotalBlackPieces;
	private int currentTotalRedPieces;
	private Piece[][] board;

	public Board() throws Exception {
		this.currentTotalBlackPieces = 12;
		this.currentTotalRedPieces = 12;
		this.initBoard();
	}

	public void initBoard() throws Exception {
		board = new Piece[8][8];

		for(int oddCol = 1, evenCol = 0; oddCol < 8; oddCol +=2, evenCol +=2) {
			board[0][evenCol] = new Pawn("B", 0, evenCol);
			board[1][oddCol] = new Pawn("B", 1, oddCol);
			board[2][evenCol] = new Pawn("B", 2, evenCol);
			board[5][oddCol] = new Pawn("R", 5, oddCol);
			board[6][evenCol] = new Pawn("R", 6, evenCol);
			board[7][oddCol] = new Pawn("R", 7, oddCol);
		}
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

	public int[] isValidMove(int targetRow, int targetCol, ArrayList<int[]> moves) {

		for(int index =0; index < moves.size(); index++) {
			if(moves.get(index)[0] == targetRow && moves.get(index)[1] == targetCol) {
				return moves.get(index);
			}
		}

		return null;
	}
}
