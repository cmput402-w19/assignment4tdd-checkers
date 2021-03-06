package cmput402.tdd;

import java.util.ArrayList;

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
	
	public int getXPosition() {
		return this.xPosition;
	}
	
	public int getYPosition() {
		return this.yPosition;
	}
	
	public void setPosition(int x, int y) throws Exception {
		if(x < this.minValidSize || x > this.maxValidSize) {
			throw new Exception("invalid x");
		}
		if(y < this.minValidSize || y > this.maxValidSize) {
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
	
	public abstract String getName();
	
	public abstract ArrayList<int[]> legalMoves(Board board) throws Exception;
}
