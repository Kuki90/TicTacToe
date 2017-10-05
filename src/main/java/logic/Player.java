package logic;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> crossedBoxes;
    private String name;
    private Image image;

    public Player(String name, Image image) {
        this.name = name;
        this.image = image;
        this.crossedBoxes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public void addCrossedBoxNumber(int crossedBox) {
        crossedBoxes.add(crossedBox);
    }

    public List<Integer> getCrossedBoxes() {
        return crossedBoxes;
    }


}