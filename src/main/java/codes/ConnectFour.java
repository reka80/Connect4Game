package codes;

import java.util.Scanner;

public class ConnectFour {
    private GameState gameState;

    public ConnectFour() {
        gameState = new GameState();
    }

    // Játék kezdése
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameState.isGameOver()) {
            System.out.println(gameState.getBoard());
            System.out.println("Játékos " + gameState.getCurrentPlayer() + ", válassz egy oszlopot (a-g):");

            String input;
            if (gameState.getCurrentPlayer().equals("Red")) {
                input = getComputerMove(); // Gépi játékos lépése
                System.out.println("Gép választotta az oszlopot: " + input);
            } else {
                input = scanner.nextLine().trim();
            }

            if (gameState.isValidMove(input)) {
                gameState.makeMove(input);
                if (gameState.checkWinner()) {
                    System.out.println(gameState.getBoard());
                    System.out.println("A játékos " + gameState.getCurrentPlayer() + " nyert!");
                    break;
                }
                gameState.switchPlayer();
            } else {
                System.out.println("Érvénytelen lépés. Kérlek próbálj újra.");
            }
        }
    }

    // Gépi játékos lépésének kiszámítása
    private String getComputerMove() {
        for (char c = 'a'; c <= 'g'; c++) { // Végigmegyünk az oszlopokon
            String col = String.valueOf(c);
            if (gameState.isValidMove(col)) {
                return col; // Az első érvényes oszlopot választja
            }
        }
        return "a"; // Ha valamilyen hiba történne, mindig legyen fallback
    }

    public GameState getGameState() {
        return gameState; // Getter metódus a gameState eléréséhez
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        game.startGame();
    }
}
