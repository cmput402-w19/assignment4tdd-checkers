package cmput402.tdd;

public abstract class Piece {
	
	private int xPosition;
	private int yPosition;
	private String color;
	private int minValidSize = 0;
	private int maxValidSize = 7;
	
	public Piece(String color, int xPosition, int yPosition) throws Exception {
		if(color == "R" || color == "B") {
			this.color = color;
		} else {
			throw new Exception("invalid color");
		}
		
		if(xPosition < minValidSize || xPosition > maxValidSize) {
			throw new Exception("invalid xPosition");
		} else {
			this.xPosition = xPosition;
		}
		
		if(yPosition < minValidSize || yPosition > maxValidSize) {
			throw new Exception("invalid yPosition");
		} else {
			this.yPosition = yPosition;
		}
    }
	
	public String getColor() {
		return this.color;
	}
	
	public int getYPosition() {
		return this.yPosition;
	}
}
