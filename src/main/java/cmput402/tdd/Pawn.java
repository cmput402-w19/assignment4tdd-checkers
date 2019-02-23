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
		return null;
	}

	

}
