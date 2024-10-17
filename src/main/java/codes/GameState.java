package codes;

public class GameState {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '.';

    private char[][] board;  // A játék táblája
    private Player player1;  // Az első játékos
    private Player player2;  // A második játékos
    private Player currentPlayer;  // Az aktuális játékos

    public GameState(Player player1, Player player2) {
        this.board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;  // Az első játékos kezd
    }

    // Tábla kirajzolása
    public void printBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("a b c d e f g");  // Oszlop jelölések
    }

    // Lépés elvégzése egy adott oszlopban
    public boolean dropPiece(int column) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY) {
                board[row][column] = currentPlayer.getDisc();
                return true;
            }
        }
        return false;  // Ha az oszlop tele van
    }

    // Ellenőrizzük a győzelmet
    public boolean checkWin() {
        char disc = currentPlayer.getDisc();
        return checkHorizontalWin(disc) || checkVerticalWin(disc) || checkDiagonalWin(disc);
    }

    private boolean checkHorizontalWin(char disc) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c <= COLUMNS - 4; c++) {
                if (board[r][c] == disc && board[r][c + 1] == disc &&
                        board[r][c + 2] == disc && board[r][c + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(char disc) {
        for (int c = 0; c < COLUMNS; c++) {
            for (int r = 0; r <= ROWS - 4; r++) {
                if (board[r][c] == disc && board[r + 1][c] == disc &&
                        board[r + 2][c] == disc && board[r + 3][c] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char disc) {
        // Balra le átló ellenőrzése
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int c = 0; c <= COLUMNS - 4; c++) {
                if (board[r][c] == disc && board[r + 1][c + 1] == disc &&
                        board[r + 2][c + 2] == disc && board[r + 3][c + 3] == disc) {
                    return true;
                }
            }
        }
        // Jobbra le átló ellenőrzése
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int c = 3; c < COLUMNS; c++) {
                if (board[r][c] == disc && board[r + 1][c - 1] == disc &&
                        board[r + 2][c - 2] == disc && board[r + 3][c - 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    // Ellenőrizzük, hogy a tábla tele van-e
    public boolean isBoardFull() {
        for (int c = 0; c < COLUMNS; c++) {
            if (board[0][c] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    // Játékos váltása
    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Aktuális játékos visszaadása
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
