package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {

  public Knight(PlayerColour colour) {
    super(PieceType.KNIGHT, colour);
  }

  @Override
  public Piece.PieceType getType() {
    return PieceType.KNIGHT;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + PieceType.KNIGHT.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    // TODO Implement this!
    allowedMoves.add(new Move(from, from.plus(-2, -1)));
    allowedMoves.add(new Move(from, from.plus(-2, 1)));
    allowedMoves.add(new Move(from, from.plus(2, -1)));
    allowedMoves.add(new Move(from, from.plus(2, 1)));
    allowedMoves.add(new Move(from, from.plus(-1, 2)));
    allowedMoves.add(new Move(from, from.plus(1, 2)));
    allowedMoves.add(new Move(from, from.plus(-1, -2)));
    allowedMoves.add(new Move(from, from.plus(1, -2)));

    allowedMoves.removeIf(move -> leavingBoard(move.getTo(), board) || sameColourPiece(move.getTo(), board));

    return allowedMoves;
  }

  private boolean leavingBoard(Coordinates to, Board board) {

    int x = to.getCol();
    int y = to.getRow();

    return x < 0 || x > 7 || y < 0 || y > 7;

  }
  private boolean sameColourPiece(Coordinates to, Board board) {
    var pieceAtDestination = board.get(to);

    if (pieceAtDestination != null) {
      return pieceAtDestination.getColour().equals(this.colour);
    }

    return false;
  }

}
