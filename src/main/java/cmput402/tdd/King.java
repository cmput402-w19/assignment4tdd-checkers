package cmput402.tdd;

import java.util.ArrayList;

public class King extends Piece {
	
	public King(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return super.getColor() + "K";
	}
	
	/**
     * return the 4 different diagonal coordinate of distance 1 or 2 
     * output encoding: [targetRow, targetCol, distance, direction] 
     * where direction:3 is up left, direction:4 is down left, 
     * direction:5 is up right, direction:6 is down right
     * @throws Exception 
     */
	int[] getTargetCoord(Boolean left, Boolean up, int distance) throws Exception {
		if (!(distance == 1 || distance == 2)) {
			throw new Exception("Distance must be 1 or 2");
		}
		
		int[] target = new int[4];
		int rowDirection = 1;
		int colDirection = 1;
		if(left) {
			colDirection = -1;
		}
		if(up) {
			rowDirection = -1;
		}
		
		target[0] = this.getXPosition() + distance * rowDirection;
		target[1] = this.getYPosition() + distance * colDirection;
		target[2] = distance;
		
		if (left && up) {
			target[3] = 3;
		} else if (left && !up) {
			target[3] = 4;
		} else if (!left && up) {
			target[3] = 5;
		} else if (!left && !up) {
			target[3] = 6;
		}

		return target;
	}
	
	
	public ArrayList<int[]> legalMoves(Board board) throws Exception {
		ArrayList<int[]> moves = new ArrayList<int[]>();

		Boolean left;
		Boolean up;
		int[] move;
		for (int i = 0; i < 2; i++) {
			left = (i % 2) == 0;
			for (int j = 0; j < 2; j++) {
				up = (j % 2) == 0;
				move = this.getTargetCoord(left, up, 1);
				if(board.inBounds(move[0], move[1])){
					int[] move2 = this.getTargetCoord(left, up, 2);
					if(this.isEnemyPiece(board.getPiece(move[0], move[1])) && 
							board.inBounds(move2[0], move2[1]) && 
							board.getPiece(move2[0], move2[1]) == null) {
						moves.add(move2);
					} else {
						if(board.inBounds(move[0], move[1]) && board.getPiece(move[0],move[1]) == null) {
							moves.add(move);
						}
					}
					
				}
			}
		}		
		return moves;
	}
	
}
