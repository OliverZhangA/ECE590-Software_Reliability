/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.duke.xz295.ticTacToe;

import java.util.Scanner;

public class App {
    private final Board board;
    private Integer playerCurrentlyPlayingTheGame; // 1 or 2
    private Boolean gf;

    public App (Integer row, Integer col) {
        this.board = new Board(row, col);
        this.playerCurrentlyPlayingTheGame = 1;
        this.gf = false;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        board.pb();
        while (!gf) {
            System.out.println("Player " + playerCurrentlyPlayingTheGame + ", please enter a position. (e.g., A2)");
            String position = scanner.nextLine();
            while (!board.checkAvailable(position, playerCurrentlyPlayingTheGame, scanner)) {
                System.out.println("Player " + playerCurrentlyPlayingTheGame + ", the position is invalid, please enter again.");
                position = scanner.nextLine();
            }
            board.place(position, playerCurrentlyPlayingTheGame);
            gf = board.check();
            board.printResult();
            playerCurrentlyPlayingTheGame = 3 - playerCurrentlyPlayingTheGame;
        }
        System.out.println("Game finished, player " + (3 - playerCurrentlyPlayingTheGame) + " won!");
    }

    public static void main(String[] args) {
        App theApp = new App(3, 3);
        theApp.startGame();
    }
}
