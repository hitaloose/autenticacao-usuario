package views.alerts;

import javafx.scene.control.Alert;

public class AlertError {
  public AlertError(String mensagem) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erro!!!");
    alert.setContentText(mensagem);
    alert.showAndWait();
  }
}
