package cmput402.tdd;

import java.util.ArrayList;

public class Pawn extends Piece{
	
	public Pawn(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
	}

	public String getName() {
		return super.getColor() + "P";
	}

	public int[] getTargetCoords(boolean isLeft, int moveDistance) throws Exception {
		if (!(moveDistance == 1 || moveDistance == 2)) {
			throw new Exception("invalid move distance");
		}
		
		int[] newPos = new int[4];
		int rowDirection = 1;
		int columnDirection = 1;
		
		if(isLeft) {
			columnDirection = -1;
		}
		if(this.getColor() == "R") {
			rowDirection = -1;
		}
		newPos[0] = this.getXPosition() + moveDistance * rowDirection;
		newPos[1] = this.getYPosition() + moveDistance * columnDirection;
		newPos[2] = moveDistance;
		
		// left is 1
		if (isLeft) {
			newPos[3] = 1;
		}
		else {
			newPos[3] = 2;
		}
		// TODO Auto-generated method stub
		return newPos;
	}
	
	public ArrayList<int[]> legalMoves(Board board) throws Exception {
		ArrayList<int[]> moves = new ArrayList<int[]>();

		int[] leftMove = this.getTargetCoords(true, 1);
		if(board.inBounds(leftMove[0], leftMove[1])){
			int[] leftMove2 = this.getTargetCoords(true, 2);
			if(this.isEnemyPiece(board.getPiece(leftMove[0], leftMove[1])) && 
					board.inBounds(leftMove2[0], leftMove2[1]) && 
					board.getPiece(leftMove2[0], leftMove2[1]) == null) {
				moves.add(leftMove2);
			} else {
				if(board.inBounds(leftMove[0], leftMove[1]) && board.getPiece(leftMove[0],leftMove[1]) == null) {
					moves.add(leftMove);
				}
			}
			
		}
		
		int[] rightMove = this.getTargetCoords(false, 1);
		if(board.inBounds(rightMove[0], rightMove[1])){
			int[] rightMove2 = this.getTargetCoords(false, 2);
			if(this.isEnemyPiece(board.getPiece(rightMove[0],rightMove[1])) && 
					board.inBounds(rightMove2[0], rightMove2[1]) && 
					board.getPiece(rightMove2[0], rightMove2[1]) == null) {
				moves.add(rightMove2);
			} else {
				if(board.inBounds(rightMove[0], rightMove[1]) && board.getPiece(rightMove[0], rightMove[1]) == null) {

					moves.add(rightMove);
				}
			}
		}
	
		return moves;
	}

	

}
