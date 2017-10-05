import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage primaryStage) throws Exception {
        Parent sceneGraph = createSceneGraph();
        Scene scene = new Scene(sceneGraph);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Parent createSceneGraph() throws IOException {
        return FXMLLoader.load(getClass().getResource("gameWindow.fxml"));
    }


}
