package cmput402.tdd;

import java.util.ArrayList;

public class Board {

	private int blackTotalPieces;
	private int redTotalPieces;
	private Piece[][] board;

	public Board() throws Exception {
		this.blackTotalPieces = 12;
		this.redTotalPieces = 12;
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
		return this.blackTotalPieces;
	}

	public int getRedTotalPiece() {
		return this.redTotalPieces;
	}

	public Piece getPiece(int xCoordinate, int yCoordinate) {
		boolean legalCoords = this.inBounds(xCoordinate, yCoordinate);

		if(!legalCoords) {
			return null;
		} else {
			return this.board[xCoordinate][yCoordinate];
		}
	}

    public void setPiecePosition(Piece piece, int targetRow, int targetCol) {
        board[targetRow][targetCol] = piece;
        if (piece != null) {
            try {
                piece.setPosition(targetRow, targetCol);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean inBounds(int xCoord, int yCoord) {
		boolean isOutOfHorizontalBound = ((xCoord < 0) || (xCoord > 7));
		boolean isOutOfVerticalBound = ((yCoord < 0) || (yCoord > 7));

		return !(isOutOfHorizontalBound || isOutOfVerticalBound);
	}

	public int[] isValidMove(int targetRow, int targetCol, ArrayList<int[]> moves) {

		for (int index = 0; index < moves.size(); index++) {
			if (moves.get(index)[0] == targetRow && moves.get(index)[1] == targetCol) {
				return moves.get(index);
			}
		}

		return null;
	}

	public int isCapture(int[] move) throws Exception {
		if (move.length > 0) {
			if (move[2] == 2) {
				return move[3];
			} else {
				return 0;
			}
		} else {
			throw new Exception("Move length must be greater than 0");
		}
	}

	public boolean playMove(boolean isBlackTurn, int inputRow, int inputCol, int targetRow, int targetCol) {
        return Boolean.parseBoolean(null);
    }
}
