package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {

  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);

  }

  @Override
  public Piece.PieceType getType() {
    return PieceType.PAWN;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + PieceType.PAWN.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    if (isInEndingPosition(from)) {
      return allowedMoves;
    }

    if (pieceInFront(from, board)) {
      if (getColour().equals(PlayerColour.WHITE)) {
        allowedMoves.add(new Move(from, from.plus(-1, 0)));
      } else {
        allowedMoves.add(new Move(from, from.plus(1, 0)));
      }
    }
    if (pieceInFront(from, board)) {
      if (isInStartingPosition(from) && pieceInFront2(from, board)) {
        if (getColour().equals(PlayerColour.WHITE)) {
          allowedMoves.add(new Move(from, from.plus(-2, 0)));
        } else {
          allowedMoves.add(new Move(from, from.plus(2, 0)));
        }
      }
    }

    if (isInEndingPositionD(from)) {
      if (!diagonalPieceLeft(from, board)) {
        if (getColour().equals(this.colour)) {
          allowedMoves.add(new Move(from, from.plus(-1, -1)));
        } else {
          allowedMoves.add(new Move(from, from.plus(1, -1)));
        }
      }
    }
    if (isInEndingPositionD(from)) {
      Coordinates leftDiagonal = (colour.equals(PlayerColour.WHITE))
          ? from.plus(-1, -1)
          : from.plus(1, -1);
      if (board.get(leftDiagonal) != null && !board.get(leftDiagonal).getColour().equals(colour)) {
        allowedMoves.add(new Move(from, leftDiagonal));
      }

      // Check right diagonal
      Coordinates rightDiagonal = (colour.equals(PlayerColour.WHITE))
          ? from.plus(-1, 1)
          : from.plus(1, 1);
      if (board.get(rightDiagonal) != null && !board.get(rightDiagonal).getColour().equals(colour)) {
        allowedMoves.add(new Move(from, rightDiagonal));
      }
    }

    // TODO Implement this!
    return allowedMoves;
  }

  private boolean isInStartingPosition(Coordinates from) {
    if (colour.equals(PlayerColour.WHITE)) {
      return from.getRow() == 6;
    } else {
      return from.getRow() == 1;
    }
  }

  private boolean isInEndingPosition(Coordinates from) {
    if (colour.equals(PlayerColour.WHITE) && from.getRow() == 0
        || colour.equals(PlayerColour.BLACK) && from.getRow() == 7) {
      return true;
    } else {
      return false;
    }
  }

  private boolean pieceInFront(Coordinates from, Board board) {
    Coordinates frontCoords;
    if (colour.equals(PlayerColour.WHITE)) {
      frontCoords = from.plus(-1, 0);
    } else {
      frontCoords = from.plus(1, 0);
    }
    return board.get(frontCoords) == null;
  }
  private boolean pieceInFront2(Coordinates from, Board board) {
    Coordinates frontCoords;
    if (colour.equals(PlayerColour.WHITE)) {
      frontCoords = from.plus(-2, 0);
    } else {
      frontCoords = from.plus(2, 0);
    }
    return board.get(frontCoords) == null;
  }

  private boolean diagonalPieceLeft(Coordinates from, Board board) {
    Coordinates coordinates;
    if (colour.equals(PlayerColour.WHITE)) {
      coordinates = from.plus(-1, -1);
    } else {
      coordinates = from.plus(1, -1);
    }
    return board.get(coordinates) == null;
  }

  private boolean isInEndingPositionD(Coordinates from) {
    if (from.getCol() == 0 || from.getCol() == 7) {
      return false;
    } else {
      return true;
    }
  }

}
