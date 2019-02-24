package cmput402.tdd;

import java.util.ArrayList;

public class Board {

	private int blackTotalPieces;
	private int redTotalPieces;
	private Piece[][] board;
	private int boardSize = 8;

	public Board() throws Exception {
		this.blackTotalPieces = 12;
		this.redTotalPieces = 12;
		this.initBoard();
	}

	public void initBoard() throws Exception {
		board = new Piece[8][8];
		this.blackTotalPieces = 12;
		this.redTotalPieces = 12;

		for(int oddCol = 1, evenCol = 0; oddCol < 8; oddCol +=2, evenCol +=2) {
			board[0][evenCol] = new Pawn("B", 0, evenCol);
			board[1][oddCol] = new Pawn("B", 1, oddCol);
			board[2][evenCol] = new Pawn("B", 2, evenCol);
			board[5][oddCol] = new Pawn("R", 5, oddCol);
			board[6][evenCol] = new Pawn("R", 6, evenCol);
			board[7][oddCol] = new Pawn("R", 7, oddCol);
		}
	}
	
	public void printBoard(){    
		System.out.println("           Col");
		System.out.println("   0  1  2  3  4  5  6  7");
        for(int i  = 0; i < this.boardSize; i++){
        	if(i == 2) {
        		System.out.print("R ");
        	} else if (i == 3) {
        		System.out.print("o ");
        	} else if (i == 4) {
        		System.out.print("w ");
        	} else {
        		System.out.print("  ");
        	}
        	System.out.print(i);
        	System.out.print("|");
            for(int j = 0 ; j < this.boardSize; j++){
            	if(board[i][j] != null){
            		System.out.print(board[i][j].getName());
            	} else{
            		System.out.print("  ");
            	}
               System.out.print("|");
            }
            System.out.println("\n   -------------------------");
        }
        System.out.print("\n");
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

    public void setPiecePosition(Piece piece, int targetRow, int targetCol) throws Exception {
        if (piece != null) {
            piece.setPosition(targetRow, targetCol);
        }
        board[targetRow][targetCol] = piece;
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

	public boolean playMove(boolean isBlackTurn, int inputRow, int inputCol, int targetRow, int targetCol) throws Exception {
		Piece currentPiece = getPiece(inputRow, inputCol);

		if (currentPiece instanceof Piece) {
			if (isBlackTurn && currentPiece.getColor() == "B" || !isBlackTurn && currentPiece.getColor() == "R") {
				ArrayList<int[]> moves = currentPiece.legalMoves(this);
				int[] moveValidate = isValidMove(targetRow, targetCol, moves);
				if (moveValidate != null) {
					board[inputRow][inputCol] = null;
					if (currentPiece.getColor() == "R" && targetRow == 0) {
						board[targetRow][targetCol] = new King("R", targetRow, targetCol);
					} else if (currentPiece.getColor() == "B" && targetRow == 7) {
						board[targetRow][targetCol] = new King("B", targetRow, targetCol);
					} else {
						board[targetRow][targetCol] = currentPiece;
						currentPiece.setPosition(targetRow, targetCol);
					}
					int isEat = this.isCapture(moveValidate);
					if(isEat != 0) {
						if (currentPiece.getColor() == "R") {
							blackTotalPieces--;
						} else {

							redTotalPieces--;
						}
					}
					switch (isEat) {
						case 1:
							// eat left pawn
							if (currentPiece.getColor() == "R") {
								board[inputRow - 1][inputCol - 1] = null;
							} else {
								board[inputRow + 1][inputCol - 1] = null;
							}
							break;
						case 2:
							// eat right pawn
							if (currentPiece.getColor() == "R") {
								board[inputRow - 1][inputCol + 1] = null;
							} else {
								board[inputRow + 1][inputCol + 1] = null;
							}
							break;
						case 3:
							// eat up left king
							board[inputRow - 1][inputCol - 1] = null;
							break;
						case 4:
							// eat down left king
							board[inputRow + 1][inputCol - 1] = null;
							break;
						case 5:
							// eat up right king
							board[inputRow - 1][inputCol + 1] = null;
							break;
						case 6:
							// eat down right king
							board[inputRow + 1][inputCol + 1] = null;
							break;
					}

				} else {
					System.out.println("Invalid move.");
					return false;
				}

			} else {
				System.out.println("Invalid piece selected");
				return false;
			}
		} else {
			System.out.println("Invalid piece selected");
			return false;
		}
		return true;
    }
}
