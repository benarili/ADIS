package Model;

import DataBase.DataBase;
import DatabaseController.DataBaseController;
import DatabaseController.MyDataBaseController;
import Entries.DataBaseUsable;
import Entries.User;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Observable;

public class Model extends Observable implements ModelInit {

    private DataBaseController dataBaseController = new MyDataBaseController(new DataBase("Resources/Vacation4U_DB.sqlite"));
    /*@Override
    public boolean createTable(String[] args) {
        return false;
    }

    @Override
    public boolean update(String[] args) {
        return false;
    }

    @Override
    public boolean add(String[] args) {
        return false;
    }

    @Override
    public boolean delete(String[] args) {
        return false;
    }
*/
    public Alert getExitMessage() {
        Alert exit = new Alert(Alert.AlertType.CONFIRMATION);
        exit.setTitle("exit");
        exit.setHeaderText("Are you sure you want to exit?");
        ButtonType yes = new ButtonType("yes");
        ButtonType saveFirst = new ButtonType("yes, but save maze first");
        ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);
        exit.getButtonTypes().setAll(yes,saveFirst,no);
        return exit;
    }

    @Override
    public Alert getCreateUserMessage(boolean result, String userName) {
        Alert alert = result ? succesfullCreationOfUser(userName) : unsuccesfullCreationOfUser(userName);
        return alert;
    }

    @Override
    public boolean checkCreateUserParamaters(String userName, String birthDate, String firstName, String lastName, String password) {
        //try to create user using the values. if succesfull, then values are valid, if not, they aren't
        try {
            User toCheck  = new User(userName, password,birthDate,firstName,lastName);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean insert(DataBaseUsable usable) {
        boolean result =false;
        try {
            result = dataBaseController.insert(usable);
        } catch (Exception e) {
            result =false;
        }
        return result;
    }

    private Alert succesfullCreationOfUser(String userName){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Added Succesfully");
        alert.setContentText("User-" + userName +" added successfully");
        alert.setHeaderText("");
        return alert;
    }

    private Alert unsuccesfullCreationOfUser(String userName){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Unable to create user");
        String username = (userName==null || userName.length()==0) ? "NULL" : userName;
        alert.setContentText("Unable to create user- "+ username);
        alert.setHeaderText("");
        return alert;
    }
}
