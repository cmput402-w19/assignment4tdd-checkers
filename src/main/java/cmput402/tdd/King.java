package cmput402.tdd;

public class King extends Piece {

	public King(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return super.getColor() + "K";
	}
	
	int[] getTargetCoord(Boolean left, Boolean up, int distance) {
		
		return null;
	}
}
