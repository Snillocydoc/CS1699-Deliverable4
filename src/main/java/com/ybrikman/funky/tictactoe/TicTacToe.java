package com.ybrikman.funky.tictactoe;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.*;

public class TicTacToe {
  private InputStream in;
  private Scanner scanner;
  public void play(InputStream in) {
      this.in=in;
      scanner=new Scanner(in);
    final GameState finishedGame = Stream
        .iterate(new GameState(), this::turn)
        .filter(GameState::isGameOver)
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Game did not complete!"));

    final Optional<Player> winner = finishedGame.findWinner();

    System.out.println();
    System.out.println(finishedGame);
    System.out.println(winner.map(player -> "Player " + player + " wins!").orElseGet(() -> "It's a tie!"));
  }

  private GameState turn(GameState gameState) {
    System.out.println();
    System.out.println(gameState);
    System.out.print("Player " + gameState.getCurrentPlayer() + ", it's your turn, enter a number: ");

    try {

      final int selection = scanner.nextInt();

      return gameState.makeMove(selection);
    } catch (InputMismatchException e) {
      System.out.println();
      System.out.println("Error: you must enter a number.");
      System.out.println("Please try again!");
      scanner.nextLine();
    } catch (IllegalMoveException e) {
      System.out.println();
      System.out.println("Error: " + e.getMessage());
      System.out.println("Please try again!");
      scanner.nextLine();
    }

    return gameState;
  }

  public static void main(String[] args) {
    new TicTacToe().play(System.in);
  }
}