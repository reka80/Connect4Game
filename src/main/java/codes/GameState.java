package codes;

public class GameState {
    private String[][] board;
    private String currentPlayer;
    private int rows = 6;
    private int cols = 7;

    public GameState() {
        board = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
        }
        currentPlayer = "Yellow"; // Sárga kezdi
    }

    // Táblázat kiírása
    public String getBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append("|").append(board[i][j]);
            }
            sb.append("|\n");
        }
        return sb.toString();
    }

    // Ellenőrzi, hogy egy lépés érvényes-e
    public boolean isValidMove(String col) {
        int column = col.charAt(0) - 'a'; // oszlop indexe (a-z)
        return column >= 0 && column < cols && board[0][column].equals(" ");
    }

    // Lépés végrehajtása
    public void makeMove(String col) {
        int column = col.charAt(0) - 'a';
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][column].equals(" ")) {
                board[row][column] = currentPlayer.equals("Yellow") ? "Y" : "R";
                break;
            }
        }
    }

    // Játékos váltás
    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("Yellow") ? "Red" : "Yellow";
    }

    // Játék vége ellenőrzése (nyertes keresés)
    public boolean checkWinner() {
        // Ellenőrizzük a vízszintes, függőleges és átlós nyerő kombinációkat
        // Kód itt, például vízszintes ellenőrzés:
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols - 3; c++) {
                if (board[r][c].equals(currentPlayer) && board[r][c + 1].equals(currentPlayer) &&
                        board[r][c + 2].equals(currentPlayer) && board[r][c + 3].equals(currentPlayer)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Játék vége, ha nincs üres hely
    public boolean isGameOver() {
        for (int c = 0; c < cols; c++) {
            if (board[0][c].equals(" ")) {
                return false;
            }
        }
        return true;
    }

    // Aktuális játékos lekérdezése
    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
