package controllers;

import dtos.RegistrarUsuarioInputDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import services.RegistrarUsuarioService;
import util.ScreenUtil;
import views.alerts.AlertError;

import java.io.IOException;

public class RegistroController {
  @FXML
  private TextField tfSenha;

  @FXML
  private TextField tfEmail;

  @FXML
  private TextField tfNome;

  @FXML
  private TextField tfSenhaConfirmacao;

  private RegistrarUsuarioInputDto registrarUsuarioInputDto = new RegistrarUsuarioInputDto("", "", "", "");

  @FXML
  public void initialize() {
    this.tfNome.textProperty().addListener((observable, oldValue, newValue) -> {
      this.registrarUsuarioInputDto.setNome(newValue);
    });

    this.tfEmail.textProperty().addListener((observable, oldValue, newValue) -> {
      this.registrarUsuarioInputDto.setEmail(newValue);
    });

    this.tfSenha.textProperty().addListener((observable, oldValue, newValue) -> {
      this.registrarUsuarioInputDto.setSenha(newValue);
    });

    this.tfSenhaConfirmacao.textProperty().addListener((observable, oldValue, newValue) -> {
      this.registrarUsuarioInputDto.setSenhaConfirmacao(newValue);
    });
  }

  public void handleVoltar(ActionEvent event) throws IOException {
    Scene loginScene = ScreenUtil.getScene("Login");
    ScreenUtil.setSceneInMainStage(loginScene);
  }

  public void handleRegistrar(ActionEvent event) {
    try {
      RegistrarUsuarioService.handle(this.registrarUsuarioInputDto);
    } catch (Exception e) {
      new AlertError(e.getMessage());
    }
  }
}
