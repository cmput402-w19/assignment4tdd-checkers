package cmput402.tdd;

public abstract class Piece {
	private int xPosition;
	private int yPosition;
	private String color;
	
	public Piece(String color, int xPosition, int yPosition) throws Exception{
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
	
	public String getColor() {
		return this.color;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setPosition(int x, int y) throws Exception {
		if(x < 0 || x >= 8) {
			throw new Exception("invalid x");
		}
		if(y < 0 || y >= 8) {
			throw new Exception("invalid y");
		}
		this.xPosition = x;
		this.yPosition = y;
	}
	
	protected Boolean isEnemyPiece(Piece targetPiece) {
		if(targetPiece == null) {
			return false;
		}
		if(this.getColor() == "B" && targetPiece.getColor() == "R") {
			return true;
		}
		if(this.getColor() == "R" && targetPiece.getColor() == "B") {
			return true;
		}
		return false;
	}
}
