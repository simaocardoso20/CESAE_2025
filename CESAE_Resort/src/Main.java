import Views.LoginView;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Mostra o diretório de trabalho atual
        System.out.println("Working dir: " + System.getProperty("user.dir"));

        LoginView lv = new LoginView();
        lv.mainMenu();

    }
}
