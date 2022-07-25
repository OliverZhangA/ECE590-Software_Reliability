package edu.duke.xz295.ticTacToe;

import java.util.List;

public class NoCollisionChecker implements Checker {
    private final List<List<Integer>> status;
    private final Integer newRow;
    private final Integer newCol;

    public NoCollisionChecker(List<List<Integer>> status, Integer newRow, Integer newCol) {
        this.status = status;
        this.newRow = newRow;
        this.newCol = newCol;
    }

    public Boolean check() {
        return status.get(newRow).get(newCol) == 0;
    }
}
