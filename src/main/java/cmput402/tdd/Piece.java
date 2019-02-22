package cmput402.tdd;

public abstract class Piece {
	
	private int xPosition;
	private int yPosition;
	private String color;
	
	public Piece(String color, int xPosition, int yPosition) throws Exception {
		if(color == "R" || color == "B") {
			this.color = color;
		} else {
			throw new Exception("invalid color");
		}
		
		if(xPosition < 0 || xPosition >= 8) {
			throw new Exception("invalid xPosition");
		} else {
			this.xPosition = xPosition;
		}
		
		if(yPosition < 0 || yPosition >= 8) {
			throw new Exception("invalid yPosition");
		} else {
			this.yPosition = yPosition;
		}
    }
}
