package services;

import dtos.LoginInputDto;
import javafx.scene.Scene;
import models.Usuario;
import repositories.UsuarioRepo;
import repositories.impl.UsuarioRepoInMemory;
import util.ScreenUtil;

public class RealizarLoginService {
  public static void handle(LoginInputDto loginInputDto) throws Exception {
    UsuarioRepo usuarioRepo = new UsuarioRepoInMemory();

    if (loginInputDto.getEmail().equals("")) {
      throw new Exception("Campo email é obrigatório");
    }

    if (loginInputDto.getSenha().equals("")) {
      throw new Exception("Campo senha é obrigatório");
    }

    Usuario usuario = usuarioRepo.obterPorEmail(loginInputDto.getEmail());

    if (usuario == null) {
      throw new Exception("Usuário não encontrado");
    }

    if (!usuario.getSenha().equals(loginInputDto.getSenha())) {
      throw new Exception("Senha incorreta");
    }

    Scene homeScene = ScreenUtil.getScene("Home");
    ScreenUtil.setSceneInMainStage(homeScene);
  }
}
