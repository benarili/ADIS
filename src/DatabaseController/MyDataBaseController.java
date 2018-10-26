package DatabaseController;

import DataBase.IRelationalDB;
import Entries.DataBaseUsable;

import java.util.ArrayList;
import java.util.Collection;

public class MyDataBaseController implements DataBaseController  {

    protected IRelationalDB dataBase;
    protected Collection<String> allowedTypes;

    public MyDataBaseController(IRelationalDB toControl){
        this.dataBase=toControl;
        this.allowedTypes=new ArrayList<>();
    }


    @Override
    public void insert(DataBaseUsable entry) throws Exception {
        dataBase.executeSQLCommand(entry.getInsertCommand());
    }

    @Override
    public void delete(DataBaseUsable entry) throws Exception {
        dataBase.executeSQLCommand(entry.getDeleteTableCommand());
    }

}
