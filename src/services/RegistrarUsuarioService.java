package services;

import dtos.RegistrarUsuarioInputDto;
import javafx.scene.Scene;
import models.Usuario;
import repositories.UsuarioRepo;
import repositories.impl.UsuarioRepoInMemory;
import util.ScreenUtil;
import views.alerts.AlertInformation;

public class RegistrarUsuarioService {
  public static void handle(RegistrarUsuarioInputDto registrarUsuarioInputDto) throws Exception {
    UsuarioRepo usuarioRepo = new UsuarioRepoInMemory();

    if (registrarUsuarioInputDto.getNome().equals("")) {
      throw new Exception("Campo nome é obrigatório");
    }

    if (registrarUsuarioInputDto.getEmail().equals("")) {
      throw new Exception("Campo e-mail é obrigatório");
    }

    if (registrarUsuarioInputDto.getSenha().equals("")) {
      throw new Exception("Campo senha é obrigatório");
    }

    if (registrarUsuarioInputDto.getSenhaConfirmacao().equals("")) {
      throw new Exception("Campo confirmação de senha é obrigatório");
    }

    if (!registrarUsuarioInputDto.getSenha().equals(registrarUsuarioInputDto.getSenhaConfirmacao())) {
      throw new Exception("Senha e confirmação não batem");
    }

    Usuario usuarioValidacaoEmail = usuarioRepo.obterPorEmail(registrarUsuarioInputDto.getEmail());

    if (!(usuarioValidacaoEmail == null)) {
      throw new Exception("E-mail já cadastrado");
    }

    Usuario novoUsuario = new Usuario();
    novoUsuario.setId(usuarioRepo.obterNovoId());
    novoUsuario.setNome(registrarUsuarioInputDto.getNome());
    novoUsuario.setEmail(registrarUsuarioInputDto.getEmail());
    novoUsuario.setSenha(registrarUsuarioInputDto.getSenha());

    usuarioRepo.salvar(novoUsuario);

    new AlertInformation("Usuário cadastrado com sucesso!!!");

    Scene loginScene = ScreenUtil.getScene("Login");
    ScreenUtil.setSceneInMainStage(loginScene);
  }
}
