package pieces;

import Main.Controller;
import Main.Restrictions;

public class Rook extends Piece {

	@Override
	public Pieces getType() {
		return Pieces.ROOK;
	}

	@Override
	public String possibleMove(int row, int column, Piece chessBoard[][],
			boolean checkKingSafety, Controller controller) { // TURA
		// Piece[][] chessBoard = MainChess.board.getBoard();
		String list = "";
		Piece oldPiece;
		Colors currentColor;
		if (controller.whiteTurn == true) {
			currentColor = Colors.WHITE;
		} else {
			currentColor = Colors.BLACK;
		}
		if (chessBoard[row][column].getColor() == currentColor) {
			for (int i = 0; i < 4; i++) {
				int rowOffset = 0, columnOffset = 0;
				switch (i) {
				case 0:
					rowOffset = 0;
					columnOffset = 1;// move right
					break;
				case 1:
					rowOffset = 0;
					columnOffset = -1;// move left
					break;
				case 2:
					rowOffset = -1;
					columnOffset = 0;// move up
					break;
				case 3:
					rowOffset = 1;
					columnOffset = 0;// move down
					break;
				}
				try {// move
					while (chessBoard[row + rowOffset][column + columnOffset]
							.getType() == Pieces.NOPIECE) {
						oldPiece = chessBoard[row + rowOffset][column
								+ columnOffset];
						chessBoard[row + rowOffset][column + columnOffset] = chessBoard[row][column];
						chessBoard[row][column] = controller.emptySpace;

						if (Restrictions.kingSafety(chessBoard, currentColor,
								controller) == true) {
							list = list + row + column + (row + rowOffset)
									+ (column + columnOffset) + " ";
						}
						chessBoard[row][column] = chessBoard[row + rowOffset][column
								+ columnOffset];
						chessBoard[row + rowOffset][column + columnOffset] = oldPiece;

						switch (i) {
						case 0:
							columnOffset++;
							break;
						case 1:
							columnOffset--;
							break;
						case 2:
							rowOffset--;
							break;
						case 3:
							rowOffset++;
							break;
						}
					}
					if (chessBoard[row + rowOffset][column + columnOffset]
							.getColor() != chessBoard[row][column].getColor()) {
						oldPiece = chessBoard[row + rowOffset][column
								+ columnOffset];
						chessBoard[row + rowOffset][column + columnOffset] = chessBoard[row][column];
						chessBoard[row][column] = controller.emptySpace;

						if (Restrictions.kingSafety(chessBoard, currentColor,
								controller) == true) {
							list = list + row + column + (row + rowOffset)
									+ (column + columnOffset) + "p";
						}
						chessBoard[row][column] = chessBoard[row + rowOffset][column
								+ columnOffset];
						chessBoard[row + rowOffset][column + columnOffset] = oldPiece;

					}
				} catch (Exception e) {
				}
			}
		}
		return list;
	}
}
