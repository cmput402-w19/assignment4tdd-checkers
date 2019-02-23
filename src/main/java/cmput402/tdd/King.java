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

		int[] leftUpMove = this.getTargetCoord(true, true, 1);
		
		if(board.inBounds(leftUpMove[0], leftUpMove[1])){
			int[] leftUpMove2 = this.getTargetCoord(true, true, 2);
			if(this.isEnemyPiece(board.getPiece(leftUpMove[0], leftUpMove[1])) && 
					board.inBounds(leftUpMove2[0], leftUpMove2[1]) && 
					board.getPiece(leftUpMove2[0], leftUpMove2[1]) == null) {
				moves.add(leftUpMove2);
			} else {
				if(board.inBounds(leftUpMove[0], leftUpMove[1]) && board.getPiece(leftUpMove[0],leftUpMove[1]) == null) {
					moves.add(leftUpMove);
				}
			}
			
		}
		
		int[] leftDownMove = this.getTargetCoord(true, false, 1);
		
		if(board.inBounds(leftDownMove[0], leftDownMove[1])){
			int[] leftDownMove2 = this.getTargetCoord(true, false, 2);
			if(this.isEnemyPiece(board.getPiece(leftDownMove[0], leftDownMove[1])) && 
					board.inBounds(leftDownMove2[0], leftDownMove2[1]) && 
					board.getPiece(leftDownMove2[0], leftDownMove2[1]) == null) {
				moves.add(leftDownMove2);
			} else {
				if(board.inBounds(leftDownMove[0], leftDownMove[1]) && board.getPiece(leftDownMove[0],leftDownMove[1]) == null) {
					moves.add(leftDownMove);
				}
			}
			
		}
		
		int[] rightUpMove = this.getTargetCoord(false, true, 1);
		if(board.inBounds(rightUpMove[0], rightUpMove[1])){
			int[] rightUpMove2 = this.getTargetCoord(false, true, 2);
			if(this.isEnemyPiece(board.getPiece(rightUpMove[0],rightUpMove[1])) && 
					board.inBounds(rightUpMove2[0], rightUpMove2[1]) && 
					board.getPiece(rightUpMove2[0], rightUpMove2[1]) == null) {
				moves.add(rightUpMove2);
			} else {
				if(board.inBounds(rightUpMove[0], rightUpMove[1]) && board.getPiece(rightUpMove[0], rightUpMove[1]) == null) {

					moves.add(rightUpMove);
				}
			}
		}
		
		int[] rightDownMove = this.getTargetCoord(false, false, 1);
		if(board.inBounds(rightDownMove[0], rightDownMove[1])){
			int[] rightDownMove2 = this.getTargetCoord(false, false, 2);
			if(this.isEnemyPiece(board.getPiece(rightDownMove[0],rightDownMove[1])) && 
					board.inBounds(rightDownMove2[0], rightDownMove2[1]) && 
					board.getPiece(rightDownMove2[0], rightDownMove2[1]) == null) {
				moves.add(rightDownMove2);
			} else {
				if(board.inBounds(rightDownMove[0], rightDownMove[1]) && board.getPiece(rightDownMove[0], rightDownMove[1]) == null) {

					moves.add(rightDownMove);
				}
			}
		}
		return moves;
	}
	
}
