package repositories;

import models.Usuario;

public interface UsuarioRepo {
  public int obterNovoId();
  public Usuario obterPorEmail(String email);
  public Usuario salvar(Usuario usuario);
}
