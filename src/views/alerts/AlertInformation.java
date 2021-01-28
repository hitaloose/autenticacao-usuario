package views.alerts;

import javafx.scene.control.Alert;

public class AlertInformation {
  public AlertInformation(String mensagem) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Atenção");
    alert.setContentText(mensagem);
    alert.showAndWait();
  }
}
