package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenUtil {
  private static Stage mainStage;

  public static void setupMainStage(Stage primaryStage, Scene primaryScene) {
    mainStage = primaryStage;

    mainStage.setTitle("Listas por usuário");
    mainStage.setScene(primaryScene);
    mainStage.show();
  }

  public static void setSceneInMainStage(Scene scene) {
    mainStage.setScene(scene);
  }

  public static Scene getScene(String sceneName) throws IOException {
    Parent root = FXMLLoader.load(ScreenUtil.class.getResource("/views/" + sceneName + ".fxml"));
    Scene scene = new Scene(root);

    return scene;
  }
}
