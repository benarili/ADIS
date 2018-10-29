package Model;

import Entries.DataBaseUsable;
import javafx.scene.control.Alert;

public interface ModelInit {
    /*boolean createTable(String[] args);
    boolean update(String[]args);
    boolean add(String[]args);
    boolean delete(String[] args);
    */
    Alert getExitMessage();
    Alert getCreateUserMessage(boolean result, String username);
    boolean checkCreateUserParamaters(String userName, String birthDate, String firstName, String lastName, String password);
    boolean insert(DataBaseUsable usable);
}
