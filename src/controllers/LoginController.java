package controllers;

import dtos.LoginInputDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import services.RealizarLoginService;
import util.ScreenUtil;
import views.alerts.AlertError;

import java.io.IOException;

public class LoginController {
  private LoginInputDto loginInputDto = new LoginInputDto("", "");

  @FXML
  TextField tfEmail;

  @FXML
  TextField tfSenha;

  @FXML
  public void initialize() {
    this.tfEmail.textProperty().addListener((observable, oldValue, newValue) -> {
      this.loginInputDto.setEmail(newValue);
    });

    this.tfSenha.textProperty().addListener((observable, oldValue, newValue) -> {
      this.loginInputDto.setSenha(newValue);
    });
  }

  public void handleEntrar(ActionEvent event) {
    try {
      RealizarLoginService.handle(this.loginInputDto);
    } catch (Exception e) {
      new AlertError(e.getMessage());
    }
  }

  public void handleRegistrar(ActionEvent event) {
    try {
      Scene registrarScene = ScreenUtil.getScene("Registro");
      ScreenUtil.setSceneInMainStage(registrarScene);
    } catch (IOException e) {
      new AlertError(e.getMessage());
    }
  }
}
