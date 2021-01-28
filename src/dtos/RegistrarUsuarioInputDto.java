package dtos;

public class RegistrarUsuarioInputDto {
  public RegistrarUsuarioInputDto(String email, String nome, String senha, String senhaConfirmacao) {
    this.email = email;
    this.nome = nome;
    this.senha = senha;
    this.senhaConfirmacao = senhaConfirmacao;
  }

  private String email;
  private String nome;
  private String senha;
  private String senhaConfirmacao;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getSenhaConfirmacao() {
    return senhaConfirmacao;
  }

  public void setSenhaConfirmacao(String senhaConfirmacao) {
    this.senhaConfirmacao = senhaConfirmacao;
  }
}
