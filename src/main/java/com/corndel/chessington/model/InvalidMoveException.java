package com.corndel.chessington.model;

public class InvalidMoveException extends Exception {
  public InvalidMoveException(String message) {
    super(message);
  }
}
