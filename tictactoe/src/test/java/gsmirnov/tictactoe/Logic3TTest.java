package gsmirnov.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Logic3TTest {
    @Test
    public void whenNoWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertFalse(login.isWin(Figure3T::hasMarkX));
        assertFalse(login.isWin(Figure3T::hasMarkO));
    }

    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.hasGap());
    }

    @Test
    public void whenHasNoGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(false, true), new Figure3T(true, false)},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T(false, true)},
                {new Figure3T(false, true), new Figure3T(true, false), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertFalse(login.hasGap());
    }

    @Test
    public void whenHasXHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkX));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkX));
    }

    @Test
    public void whenHasXDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkX));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkX));
    }

    @Test
    public void whenHasOHorizontalWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(false, true)},
                {new Figure3T(true, false), new Figure3T(), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkO));
    }

    @Test
    public void whenHasOVerticalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(false, true), new Figure3T()},
                {new Figure3T(), new Figure3T(false, true), new Figure3T()},
                {new Figure3T(), new Figure3T(false, true), new Figure3T()},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkO));
    }

    @Test
    public void whenHasODiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(false, true), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(false, true), new Figure3T(false, true)},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkO));
    }

    @Test
    public void whenHasOBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(false, true), new Figure3T(false, true)},
                {new Figure3T(), new Figure3T(false, true), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T(true, false)},
        };
        Logic3T login = new Logic3T(table);
        assertTrue(login.isWin(Figure3T::hasMarkO));
    }
}