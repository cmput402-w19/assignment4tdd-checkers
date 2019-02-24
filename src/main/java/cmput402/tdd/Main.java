package cmput402.tdd;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboardScanner = new Scanner(System.in);
		try {
			Board board = new Board();
			int inputRow;
			int inputCol;
			int inputTargetRow;
			int inputTargetCol;
			String line;
			Boolean blackTurn = false; //red go first
			board.printBoard();
			while (true) {
				if(board.getBlackTotalPiece() == 0) {
					System.out.println("Red Wins!");
					break;
				} else if(board.getRedTotalPiece() == 0) {
					System.out.println("Black Wins!");
					break;
				}
				try {
					if(blackTurn) {
                		System.out.println("It's black's turn");
                	} else {
                		System.out.println("It's red's turn");
                	}
					System.out.println("Please enter a move below in the format (inputRow, inputColumn, targetRow, targetColumn):");
	                line = keyboardScanner.nextLine();
	                String[] tmp = line.split(",");
                	inputRow = Integer.parseInt(tmp[0]);
                	inputCol = Integer.parseInt(tmp[1]);
                	inputTargetRow = Integer.parseInt(tmp[2]);
                	inputTargetCol = Integer.parseInt(tmp[3]);
                	if(board.playMove(blackTurn, inputRow, inputCol, inputTargetRow, inputTargetCol)) {
                		blackTurn = !blackTurn;
                	}
                	board.printBoard();
				} catch (Exception e){
					System.out.println("Invalid Input, try again");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		keyboardScanner.close();
	}

}
