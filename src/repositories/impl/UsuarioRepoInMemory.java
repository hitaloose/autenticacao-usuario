package repositories.impl;

import models.Usuario;
import repositories.UsuarioRepo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepoInMemory implements UsuarioRepo {
  static int id = 0;
  static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

  @Override
  public int obterNovoId() {
    id++;
    return id;
  }

  @Override
  public Usuario obterPorEmail(String email) {
    for (int i = 0; i < usuarios.toArray().length; i++) {
      Usuario usuario = usuarios.get(i);

      if (usuario.getEmail().equals(email)) {
        return usuario;
      }
    }

    return null;
  }

  @Override
  public Usuario salvar(Usuario usuario) {
    usuarios.add(usuario);

    return usuario;
  }
}
