package gamification.model;

/**
 *
 * @author Elton
 */
public class Usuario {
    private String login;
    private String email;
    private String nome;
    private String senha;
    private int pontos;

    public Usuario(String login, String email, String nome, String senha) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String login, String email, String nome, int pontos) {
        this.login = login;
        this.email = email;
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
