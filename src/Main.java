import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ScreenUtil;
import views.alerts.AlertError;

import java.io.IOException;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      Scene primaryScene = ScreenUtil.getScene("Login");
      ScreenUtil.setupMainStage(primaryStage, primaryScene);
    } catch (IOException e) {
      new AlertError(e.getMessage());
    }
  }


  public static void main(String[] args) {
    launch(args);
  }
}
