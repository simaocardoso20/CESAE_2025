package Controllers;

import Models.User;
import Repositories.UsersRepo;

import java.io.FileNotFoundException;

public class LoginController {

    private UsersRepo usersRepo;

    public LoginController() throws FileNotFoundException {
        this.usersRepo = new UsersRepo();
    }

    public String validateLogin(String usernameInput, String passwordInput){

        for(User userAtual : this.usersRepo.getUserArray()){
            if(userAtual.getUsername().equals(usernameInput) && userAtual.getPassword().equals(passwordInput)){
                // Encontramos o match (username e password)
                return userAtual.getTipoConta();
            }
        }

        return "ERROR";

    }
}

