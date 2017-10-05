package logic;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class AppService {
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public AppService() {
        playerX = new Player("X", new Image("graphic/valueX.png"));
        playerO = new Player("O", new Image("graphic/valueO.png"));
        currentPlayer = playerO;
    }

    public Player getCurrentPLayer() {
        return currentPlayer;
    }

    public void addValueToPlayer(int crossedBox) {
        if (currentPlayer == playerX) {
            playerX.addCrossedBoxNumber(crossedBox);
        } else {
            playerO.addCrossedBoxNumber(crossedBox);
        }
    }

    public void changeCurrentPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }

    public boolean checkWinner() {
        if (currentPlayer == playerX) {
            return checkIfContainsWhatItTakes(playerX);
        } else if (currentPlayer == playerO) {
            return checkIfContainsWhatItTakes(playerO);
        }
        return false;
    }

    private boolean checkIfContainsWhatItTakes(Player player) {
        List<Integer> crossedBoxes = player.getCrossedBoxes();
        return crossedBoxes.containsAll(Arrays.asList(1, 2, 3)) ||
                crossedBoxes.containsAll(Arrays.asList(4, 5, 6)) ||
                crossedBoxes.containsAll(Arrays.asList(7, 8, 9)) ||
                crossedBoxes.containsAll(Arrays.asList(1, 4, 7)) ||
                crossedBoxes.containsAll(Arrays.asList(2, 5, 8)) ||
                crossedBoxes.containsAll(Arrays.asList(3, 6, 9)) ||
                crossedBoxes.containsAll(Arrays.asList(1, 5, 9)) ||
                crossedBoxes.containsAll(Arrays.asList(3, 5, 7));
    }

    public boolean checkIfDraw() {
        if (playerX.getCrossedBoxes().size() + playerO.getCrossedBoxes().size() == 9) {
            return true;
        } else {
            return false;
        }
    }

    public void resetGame() {
        playerX.getCrossedBoxes().clear();
        playerO.getCrossedBoxes().clear();
    }
}
