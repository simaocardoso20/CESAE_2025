package Repositories;

import Models.User;
import Tools.CSVFileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepo {

        private ArrayList<User> userArray;

        public UsersRepo() throws FileNotFoundException {
            CSVFileReader csvFR = new CSVFileReader();
            this.userArray = csvFR.usersFileReader("Files/logins.csv");

        }

    public ArrayList<User> getUserArray() {
        return userArray;
    }
}

