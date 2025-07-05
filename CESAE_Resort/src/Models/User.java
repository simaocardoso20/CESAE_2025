package Models;

/**
 * Representa um utilizador com permissões de acesso ao sistema.
 *
 * Um utilizador tem um nome de utilizador, uma palavra-passe e um tipo de acesso.
 *
 * Este modelo é utilizado para validação de login e controlo de permissões.
 */
public class User {

    private String username;
    private String password;
    private String tipoAcesso;

    /**
     *
     * @param username
     * @param password
     * @param tipoAcesso
     */
    public User(String username, String password, String tipoAcesso) {
        this.username = username;
        this.password = password;
        this.tipoAcesso = tipoAcesso;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }
}
