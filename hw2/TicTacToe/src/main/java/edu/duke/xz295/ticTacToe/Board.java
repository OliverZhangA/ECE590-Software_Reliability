package edu.duke.xz295.ticTacToe;

import java.util.*;

public class Board {
    private final Integer row;
    private final Integer col;
    private List<List<Integer>> status; // 0 -> empty, 1 -> player1, 2 -> player2

    public Board(Integer row, Integer col) {
        assert Objects.equals(row, col);
        this.row = row;
        this.col = col;
        this.status = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> curRow = new ArrayList<>(Collections.nCopies(col, 0));
            this.status.add(curRow);
        }
    }

    public void pb() {
        System.out.print(" ");
        for (int i = 0; i < col; i++) {
            System.out.print(i);
            if (i != col - 1) {
                System.out.print("|");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            System.out.print((char)('A' + i));
            for (int j = 0; j < col; j++) {
                System.out.print(" ");
                if (j != col - 1) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
    }

    public Boolean checkAvailable(String position, Integer nowPlayer, Scanner scanner) {
        if (position.length() != 2) {
            return false;
        }
        int curRow = position.charAt(0) - 'A';
        int curCol = position.charAt(1) - '0';
        ArrayList<Checker> severalDifferentKindsOfCheckers = new ArrayList<>();
        severalDifferentKindsOfCheckers.add(new InBoundsChecker(status, curRow, curCol));
        severalDifferentKindsOfCheckers.add(new NoCollisionChecker(status, curRow, curCol));
        for (Checker checker : severalDifferentKindsOfCheckers) {
            if (!checker.check()) {
                return false;
            }
        }
        return true;
    }

    public void place(String position, Integer nowPlayer) {
        int curRow = position.charAt(0) - 'A';
        int curCol = position.charAt(1) - '0';
        status.get(curRow).set(curCol, nowPlayer);
    }

    public void changeSize(int newRow, int newCol) {
        assert newRow >= row;
        assert newCol >= col;
        List<List<Integer>> newStatus = new ArrayList<>();
        for (int i = 0; i < newRow; i++) {
            ArrayList<Integer> curRow = new ArrayList<>(Collections.nCopies(newCol, 0));
            newStatus.add(curRow);
        }
        status = newStatus;
    }

    public Boolean check() {
        // check rows
        for (int i = 0; i < row; i++) {
            boolean allOne = true;
            for (int j = 0; j < col; j++) {
                if (status.get(i).get(j) != 1) {
                    allOne = false;
                    break;
                }
            }
            if (allOne) {
                return true;
            }
            boolean allTwo = true;
            for (int j = 0; j < col; j++) {
                if (status.get(i).get(j) != 2) {
                    allTwo = false;
                    break;
                }
            }
            if (allTwo) {
                return true;
            }
        }
        // check cols
        for (int i = 0; i < col; i++) {
            boolean allOne = true;
            for (int j = 0; j < row; j++) {
                if (status.get(j).get(i) != 1) {
                    allOne = false;
                    break;
                }
            }
            if (allOne) {
                return true;
            }
            boolean allTwo = true;
            for (int j = 0; j < row; j++) {
                if (status.get(j).get(i) != 2) {
                    allTwo = false;
                    break;
                }
            }
            if (allTwo) {
                return true;
            }
        }
        // check right diagonal
        boolean allOne = true;
        for (int i = 0; i < col; i++) {
            if (status.get(i).get(i) != 1) {
                allOne = false;
                break;
            }
        }
        if (allOne) {
            return true;
        }
        boolean allTwo = true;
        for (int i = 0; i < col; i++) {
            if (status.get(i).get(i) != 2) {
                allTwo = false;
                break;
            }
        }
        if (allTwo) {
            return true;
        }
        // check left diagonal
        allOne = true;
        for (int i = 0; i < col; i++) {
            if (status.get(i).get(row - i - 1) != 1) {
                allOne = false;
                break;
            }
        }
        if (allOne) {
            return true;
        }
        allTwo = true;
        for (int i = 0; i < col; i++) {
            if (status.get(i).get(row - i - 1) != 2) {
                allTwo = false;
                break;
            }
        }
        if (allTwo) {
            return true;
        }
        return false;
    }

    public void printResult() {
        System.out.print(" ");
        for (int i = 0; i < col; i++) {
            System.out.print(i);
            if (i != col - 1) {
                System.out.print("|");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < row; i++) {
            System.out.print((char)('A' + i));
            for (int j = 0; j < col; j++) {
                System.out.print(status.get(i).get(j) == 0 ? " " : (status.get(i).get(j) == 1 ? "X" : "O"));
                if (j != col - 1) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }
}
