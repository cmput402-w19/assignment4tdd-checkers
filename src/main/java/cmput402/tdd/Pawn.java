package cmput402.tdd;

public class Pawn extends Piece{
	
	public Pawn(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
	}

	public String getName() {
		return super.getColor() + "P";
	}

	public int[] getTargetCoords(boolean isLeft, int moveDistance) {
		// TODO Auto-generated method stub
		return null;
	}

}
