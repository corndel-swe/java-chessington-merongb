package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {

  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }

  @Override
  public Piece.PieceType getType() {
    return PieceType.ROOK;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + PieceType.ROOK.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    for (int[] direction : directions) {
      int rowDelta = direction[0];
      int colDelta = direction[1];
      int newRow = from.getRow() + rowDelta;
      int newCol = from.getCol() + colDelta;

      while (newRow >= 0 && newRow < Board.BOARD_SIZE && newCol >= 0 && newCol < Board.BOARD_SIZE) {
        Piece targetPiece = board.get(new Coordinates(newRow, newCol));

        if (targetPiece == null) {
          allowedMoves.add(new Move(from, new Coordinates(newRow, newCol)));
        } else if (targetPiece.getColour() != this.colour) {
          allowedMoves.add(new Move(from, new Coordinates(newRow, newCol)));
          break;
        }
        // If there is a piece of the same color - stop
        else {
          break;
        }

        // Continue moving in the same direction by updating coordinates
        newRow += rowDelta;
        newCol += colDelta;
      }
    }

    return allowedMoves;
  }


}
