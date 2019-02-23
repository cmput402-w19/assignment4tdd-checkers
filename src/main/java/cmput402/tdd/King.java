package cmput402.tdd;

public class King extends Piece {

	public King(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return super.getColor() + "K";
	}
	
	int[] getTargetCoord(Boolean left, Boolean up, int distance) throws Exception {
		if (!(distance == 1 || distance == 2)) {
			throw new Exception("Distance must be 1 or 2");
		}
		
		int[] target = new int[4];
		int xDirection = 1;
		int yDirection = 1;
		if(left) {
			yDirection = -1;
		}
		if(up) {
			xDirection = -1;
		}
		
		
		target[0] = this.getXPosition() + distance * xDirection;
		target[1] = this.getYPosition() + distance * yDirection;
		target[2] = distance;
		
		if ((left == true) && (up == true)) {
			target[3] = 3;
		} else if ((left == true) && (up == false)) {
			target[3] = 4;
		} else if ((left == false) && (up == true)) {
			target[3] = 5;
		} else if ((left == false) && (up == false)) {
			target[3] = 6;
		}

		return target;
	}
}
