package view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.AppService;
import logic.Player;

import java.util.List;

public class AppController {
    private AppService appService;

    @FXML
    private void initialize() {
        appService = new AppService();
    }

    @FXML
    ImageView box1;

    @FXML
    ImageView box2;

    @FXML
    ImageView box3;

    @FXML
    ImageView box4;

    @FXML
    ImageView box5;

    @FXML
    ImageView box6;

    @FXML
    ImageView box7;

    @FXML
    ImageView box8;

    @FXML
    ImageView box9;

    @FXML
    ImageView resetButton;

    @FXML
    ImageView drawResult;

    @FXML
    ImageView winResult;

    @FXML
    AnchorPane anchorPane;

    @FXML
    public void resetEntered() {
        resetButton.setEffect(new Glow(0.4));
    }

    @FXML
    public void resetExited() {
        resetButton.setEffect(new Glow(0));
    }

    @FXML
    public void resetGame() {
        appService.resetGame();
        List<Node> imageButtons = collectAllImageButtons();
        resetAllBoxes(imageButtons);
        winResult.setOpacity(0);
        drawResult.setOpacity(0);
    }

    @FXML
    public void onMouseClicked(MouseEvent event) {
        Player currentPLayer = appService.getCurrentPLayer();
        ImageView clickedBox = (ImageView) event.getPickResult().getIntersectedNode();
        changeImageOnBox(currentPLayer, clickedBox);
        addChosenBoxToPlayer(clickedBox);
        monitorResult(currentPLayer);
    }

    private void resetAllBoxes(List<Node> imageButtons) {
        for (Node imageButton : imageButtons) {
            imageButton.setDisable(false);
            imageButton.setOpacity(0.01);
        }
    }

    private List<Node> collectAllImageButtons() {
        return anchorPane.getChildren().filtered(node -> node.getId().startsWith("box"));
    }

    private void changeImageOnBox(Player currentPLayer, ImageView clickedBox) {
        clickedBox.setImage(currentPLayer.getImage());
        clickedBox.setOpacity(1);
        clickedBox.setDisable(true);
    }

    private void addChosenBoxToPlayer(ImageView clickedBox) {
        appService.addValueToPlayer(Integer.valueOf(clickedBox.getId().replace("box", "")));
    }

    private void monitorResult(Player currentPLayer) {
        if (appService.checkWinner()) {
            winResult.setOpacity(1);
            collectAllImageButtons().forEach(imgBut -> imgBut.setDisable(true));
        } else if (appService.checkIfDraw()) {
            drawResult.setOpacity(1);
        }
        appService.changeCurrentPlayer();
    }
}