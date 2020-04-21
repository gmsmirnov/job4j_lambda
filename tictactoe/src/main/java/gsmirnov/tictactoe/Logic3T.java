package gsmirnov.tictactoe;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Logic of application.
 *
 * @author Gregory Smirnov (artress@ngs.ru)
 * @version 1.0
 * @since 20/04/2020
 */
public class Logic3T {
    /**
     * The game board 3x3.
     */
    private final Figure3T[][] table;

    /**
     * Constructor.
     *
     * @param table initial table.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Checks for winning combination in table.
     *
     * @param predicate winning condition (X or O).
     * @param startX X-axis start coordinate.
     * @param startY Y-axis start coordinate.
     * @param deltaX a step value on X-axis.
     * @param deltaY a step value on Y-axis.
     * @return true if there is a winning combination in table rows by the specified predicate condition, false either.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    /**
     * Checks for winning combination in table columns.
     *
     * @param predicate winning condition (X or O).
     * @param startX X-axis start coordinate.
     * @param startY Y-axis start coordinate.
     * @param deltaX a step value on X-axis.
     * @param deltaY a step value on Y-axis.
     * @return true if there is a winning combination in table rows by the specified predicate condition, false either.
     */
    public boolean checkColumns(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = false;
        for (int column = startX; column < this.table.length; column++) {
            if (fillBy(predicate, column, startY, deltaX, deltaY)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks for winning combination in table rows.
     *
     * @param predicate winning condition (X or O).
     * @param startX X-axis start coordinate.
     * @param startY Y-axis start coordinate.
     * @param deltaX a step value on X-axis.
     * @param deltaY a step value on Y-axis.
     * @return true if there is a winning combination in table rows by the specified predicate condition, false either.
     */
    public boolean checkRows(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = false;
        for (int row = startY; row < this.table.length; row++) {
            if (fillBy(predicate, startX, row, deltaX, deltaY)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Checks for winning combination by the specified condition.
     *
     * @param winCondition the specified win condition (for X or for O).
     * @return - true if there is winning combination of O.
     */
    public boolean isWin(Predicate<Figure3T> winCondition) {
        return this.checkRows(winCondition, 0, 0, 1, 0)
                || this.checkColumns(winCondition, 0, 0, 0, 1)
                || this.fillBy(winCondition, 0, 0, 1, 1)
                || this.fillBy(winCondition, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Checks for empty cells on the table.
     *
     * @return true if there is empty cells.
     */
    public boolean hasGap() {
        return Stream.of(this.table).flatMap(Stream::of).anyMatch(x -> !(x.hasMarkX() || x.hasMarkO()));
    }
}