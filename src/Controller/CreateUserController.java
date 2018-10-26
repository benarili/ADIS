package Controller;

import DataBase.DataBase;
import DatabaseController.DataBaseController;
import DatabaseController.MyDataBaseController;
import Entries.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.format.DateTimeFormatter;

public class CreateUserController {

    DataBaseController dataBaseController;
    private boolean created=false;

    public CreateUserController(){
        DataBase dataBase = new DataBase("Resources/Vacation4U_DB.sqlite");
        dataBaseController = new MyDataBaseController(dataBase);
    }
    public CreateUserController(DataBaseController controller){
        dataBaseController=controller;
    }

    public javafx.scene.control.TextField txtfld_user_name;
    public javafx.scene.control.TextField txtfld_password;
    public javafx.scene.control.TextField txtfld_first_name;
    public javafx.scene.control.TextField txtfld_last_name;
    public javafx.scene.control.DatePicker BD;

    public void createUser(ActionEvent actionEvent) {
        Alert result = null;
        String userName=txtfld_user_name.getText();
        String password=txtfld_password.getText();
        String date=BD.getValue().format( DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String firstName = txtfld_first_name.getText();
        String lastName = txtfld_last_name.getText();
        try {
            User toCreate = new User(userName,password,date,firstName,lastName);
            /*if(!created){
                dataBaseController.addEntryType(toCreate);
            }*/
            dataBaseController.insert(toCreate);
        }
        catch(Exception e){
            Alert unsuccessful = new Alert(Alert.AlertType.ERROR);
            unsuccessful.setHeaderText("Cannot add user with given values");
            result = unsuccessful;
        }
        if(result!=null){
            result = new Alert(Alert.AlertType.NONE);
            result.setHeaderText("User Added Successfully");
            created=true;
        }
        result.showAndWait();
    }
}
