package Controllers;

import Models.User;
import Repositories.UsersRepo;
import java.io.FileNotFoundException;

/**
 * Controlador responsável por gerenciar a autenticação dos utilizadores.
 * Realiza a validação do login.
 */
public class LoginController {

        private UsersRepo usersRepo;

        public static String utilizadorLogado = null;

        public LoginController() throws FileNotFoundException {
            this.usersRepo = new UsersRepo();
        }

    /**
     * Valida as credenciais de login fornecidas (username e password).
     * Se as credenciais corresponderem a um user existente, define o utilizador como ligado
     * e retorna o tipo de acesso do usuário.
     * Caso contrário, retorna "ERROR".
     *
     * @param usernameInput Nome do utilizador fornecido para login.
     * @param passwordInput Senha fornecida para login.
     * @return Tipo de acesso do utilizador se válido; "ERROR" caso contrário.
     */
        public String validateLogin(String usernameInput, String passwordInput) {

            for(User userAtual : this.usersRepo.getUserArray()){
                if(userAtual.getUsername().equals(usernameInput) && userAtual.getPassword().equals(passwordInput)){
                    // Guardamos o utilizador
                    utilizadorLogado = usernameInput;
                    // Encontramos o match (username e password)
                    return userAtual.getTipoAcesso();
                }
            }

            return "ERROR";

        }
    }

