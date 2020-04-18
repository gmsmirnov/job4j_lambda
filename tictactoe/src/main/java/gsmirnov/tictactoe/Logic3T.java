package gsmirnov.tictactoe;

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
     * Checks for winning combination of X.
     *
     * @return - true if there is winning combination of X.
     */
    public boolean isWinnerX() {
        return false;
    }

    /**
     * Checks for winning combination of O.
     *
     * @return - true if there is winning combination of O.
     */
    public boolean isWinnerO() {
        return false;
    }

    /**
     * Checks for empty cells on the table.
     *
     * @return true if there is empty cells.
     */
    public boolean hasGap() {
        return true;
    }


}