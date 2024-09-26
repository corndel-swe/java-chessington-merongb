package com.corndel.chessington.model;

import static com.corndel.chessington.model.pieces.Piece.PieceType.PAWN;
import static com.corndel.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

import com.corndel.chessington.model.pieces.Piece;
import org.junit.jupiter.api.Test;

public class BoardTest {
  @Test
  public void newBoardHasWhitePiecesAtBottom() {
    // Arrange
    Board board = Board.forNewGame();

    // Act
    Piece piece = board.get(new Coordinates(7, 0));

    // Assert
    assertThat(piece).isColour(PlayerColour.WHITE);
  }

  @Test
  public void newBoardHasBlackPiecesAtTop() {
    // Arrange
    Board board = Board.forNewGame();

    // Act
    Piece piece = board.get(new Coordinates(0, 0));

    // Assert
    assertThat(piece).isColour(PlayerColour.BLACK);
  }

  @Test
  public void canMovePiecesOnBoard() {
    // Arrange
    Board board = Board.forNewGame();

    Coordinates from = new Coordinates(6, 0);
    Coordinates to = new Coordinates(4, 4);

    // Act
    board.move(from, to);

    // Assert
    assertThat(board.get(from)).isNull();
    assertThat(board.get(to)).isColour(PlayerColour.WHITE).isPiece(PAWN);
  }
}
