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
    public boolean insert(DataBaseUsable entry) throws Exception {
       return dataBase.executeInsertCommand(entry.getValues(),entry.getInsertCommand());
    }

    @Override
    public String read(String username) throws Exception {
        return dataBase.executeSelectCommand( username );
    }

    @Override
    public void delete(String sql) throws Exception {
        dataBase.executeSQLCommand(sql);
    }

    @Override
    public String readPW(String oldUser) {
        return dataBase.executeSelectPWCommand( oldUser );
    }

    @Override
    public void update(String sql) {
        dataBase.executeSQLCommand(sql);
    }

}
