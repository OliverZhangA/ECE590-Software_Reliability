package edu.duke.xz295.ticTacToe;

import java.util.List;

public class InBoundsChecker implements Checker {
    private final List<List<Integer>> status;
    private final Integer newRow;
    private final Integer newCol;

    public InBoundsChecker(List<List<Integer>> status, Integer newRow, Integer newCol) {
        this.status = status;
        this.newRow = newRow;
        this.newCol = newCol;
    }

    public Boolean check() {
        int row = status.size();
        int col = status.get(0).size();
        if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
            return false;
        }
        return true;
    }
}
