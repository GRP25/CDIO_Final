package Funclayer.implementation;

import static Datalayer.PropertiesLoader.isMain;
import static Datalayer.PropertiesLoader.updateDatabaseURL;

public class DatabaseService {
    public void change(){
        updateDatabaseURL();
    }
    public boolean checkIfDBisMain(){
        return isMain();
    }
}
