package cmput402.tdd;

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
}
